
public class SearchComparison {

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, array is sorted
            if (!swapped) break;
        }
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search (array must be sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int size = 100000;
        int[] arr = new int[size];

        // Fill array with numbers in reverse order for worst case sorting
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        // Sort the array (Bubble Sort)
        System.out.println("Sorting array...");
        long sortStart = System.nanoTime();
        bubbleSort(arr);
        long sortEnd = System.nanoTime();
        System.out.println("Sorting completed in " + (sortEnd - sortStart) / 1_000_000.0 + " ms");

        int target = size / 2; // element to search

        // Linear Search timing
        long linearStart = System.nanoTime();
        int linearIndex = linearSearch(arr, target);
        long linearEnd = System.nanoTime();
        System.out.println("Linear Search: found at index " + linearIndex + " in " +
                (linearEnd - linearStart) / 1_000_000.0 + " ms");

        // Binary Search timing
        long binaryStart = System.nanoTime();
        int binaryIndex = binarySearch(arr, target);
        long binaryEnd = System.nanoTime();
        System.out.println("Binary Search: found at index " + binaryIndex + " in " +
                (binaryEnd - binaryStart) / 1_000_000.0 + " ms");
    }
}
