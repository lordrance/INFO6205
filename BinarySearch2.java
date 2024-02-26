
public class BinarySearch2 {

    // Main method to test the binary search in a rotated sorted array
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 2, 3, 4, 5};
        
        System.out.println("Target 8 = " + findInRotatedArray(arr, 8));
        System.out.println("Target 9 = " + findInRotatedArray(arr, 9));
    }

    // This method performs a binary search in a rotated sorted array
    public static int findInRotatedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                // Target found
                return mid;
            }
            
            // Determine which part of the array is properly sorted
            if (arr[start] <= arr[mid]) {
                // If the start to mid is sorted
                if (target >= arr[start] && target < arr[mid]) {
                    // If the target is in the left half
                    end = mid - 1;
                } else {
                    // If the target is in the right half
                    start = mid + 1;
                }
            } else {
                // If the mid to end is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    // If the target is in the right half
                    start = mid + 1;
                } else {
                    // If the target is in the left half
                    end = mid - 1;
                }
            }
        }
        
        // Target not found
        return -1;
    }
}
