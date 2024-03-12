package HW3;
public class RotatedArraySearch {

    public static void main(String[] args) {
        int[] rotatedArray = {6, 7, 8, 2, 3, 4, 5};
        System.out.println("Target 8 = " + findIndex(rotatedArray, 8)); // Should return 2
        System.out.println("Target 9 = " + findIndex(rotatedArray, 9)); // Should return -1
    }

    public static int findIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // The right half must be sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1; // Target not found
    }
}

