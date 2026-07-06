
CREATE PROCEDURE TransferFunds(
    IN fromAccount INT,
    IN toAccount INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE sourceBalance DECIMAL(10,2);

    -- Get balance of source account
    SELECT Balance
    INTO sourceBalance
    FROM Accounts
    WHERE AccountID = fromAccount;

    -- Check sufficient balance
    IF sourceBalance >= amount THEN

        -- Deduct amount from source account
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAccount;

        -- Add amount to destination account       
        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAccount;

        SELECT 'Transfer Successful' AS Message;

    ELSE
        SELECT 'Insufficient Balance' AS Message;
    END IF;

END //

