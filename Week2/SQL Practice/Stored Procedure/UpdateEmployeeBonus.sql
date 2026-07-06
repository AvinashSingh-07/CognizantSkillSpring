
CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept VARCHAR(50),
    IN bonusPercent DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = dept;
END //

