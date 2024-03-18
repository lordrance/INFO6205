
package HW4;
public class SubarrayCounter {
    
    // Counts the subarrays where the number of 1's is greater than the number of 0's
    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int ones = 0, zeros = 0;
            for (int end = start; end < nums.length; end++) {
                // Increment count of ones or zeros based on the value
                if (nums[end] == 1) ones++;
                else zeros++;
                
                // If ones are more than zeros, increment the subarray count
                if (ones > zeros) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1, 0, 1};
        int[] nums2 = {0};
        int[] nums3 = {1};

        System.out.println(countSubarrays(nums1)); // Should output 9
        System.out.println(countSubarrays(nums2)); // Should output 0
        System.out.println(countSubarrays(nums3)); // Should output 1
    }
}
