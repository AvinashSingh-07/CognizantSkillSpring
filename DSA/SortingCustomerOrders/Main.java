import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Sample setup data
        Order[] ordersForBubble = {
            new Order("O001", "Avinash", 250.50),
            new Order("O002", "BobbyDeol", 89.99),
            new Order("O003", "CharliePuth", 1200.00),
            new Order("O004", "DavidBekcham", 450.00)
        };

        // Clone the array to ensure both algorithms sort identical raw datasets
        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("=== Original Orders ===");
        Arrays.stream(ordersForBubble).forEach(System.out::println);

        // Test Bubble Sort
        OrderSorter.bubbleSort(ordersForBubble);
        System.out.println("\n=== Sorted via Bubble Sort (High Value First) ===");
        Arrays.stream(ordersForBubble).forEach(System.out::println);

        // Test Quick Sort
        OrderSorter.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        System.out.println("\n=== Sorted via Quick Sort (High Value First) ===");
        Arrays.stream(ordersForQuick).forEach(System.out::println);
    }
}