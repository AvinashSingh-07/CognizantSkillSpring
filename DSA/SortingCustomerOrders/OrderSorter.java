public class OrderSorter {

    // --- BUBBLE SORT IMPLEMENTATION ---
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // To sort by high-value first (descending), swap if next is greater
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: If no two elements were swapped in the inner loop, break
            if (!swapped) break;
        }
    }

    // --- QUICK SORT IMPLEMENTATION ---
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        // Choosing the last element as the pivot
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            // Sorting descending: target elements larger than the pivot
            if (orders[j].getTotalPrice() > pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap the pivot element with the correct position
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}