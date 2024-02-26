
public class BinarySearch1 {

    // Method to find the first occurrence of a target element
    private static int findFirstOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int result = -1; // Default value if target is not found

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                result = mid;
                end = mid - 1; // Move towards the start to find the first occurrence
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

// Method to find the last occurrence of a target element
private static int findLastOccurrence(int[] arr, int target) {
    int start = 0, end = arr.length - 1;
    int result = -1; // Default value if target is not found

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            result = mid;
            start = mid + 1; // Move towards the end to find the last occurrence
        } else if (target < arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return result;
}


    // Main method to test the occurrence count functionality
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};

        // Example usages
        printOccurrences(arr, 4);
        printOccurrences(arr, 2);
        printOccurrences(arr, 5);
    }

    // Utility method to print the occurrences of a target element
    private static void printOccurrences(int[] arr, int target) {
        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);

        if (firstOccurrence == -1 || lastOccurrence == -1) {
            System.out.println("Target " + target + " = 0 Occurrences");
        } else {
            int count = lastOccurrence - firstOccurrence + 1;
            System.out.println("Target " + target + " = " + count + " Occurrences");
        }
    }
}
