package HW6;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            charIndexMap.put(c, end);

            if (charIndexMap.size() > 2) {
                // Find the character with the leftmost (smallest) index
                int leftMost = s.length();
                for (int index : charIndexMap.values()) {
                    leftMost = Math.min(leftMost, index);
                }

                // Remove the leftmost character
                charIndexMap.remove(s.charAt(leftMost));

                // Move the start next to the position of the removed character
                start = leftMost + 1;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        // Example 1
        String s1 = "eceba";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.lengthOfLongestSubstringTwoDistinct(s1));

        // Example 2
        String s2 = "ccaabbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.lengthOfLongestSubstringTwoDistinct(s2));
    }
}
