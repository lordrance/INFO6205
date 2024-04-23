/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 16:59:38
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 17:00:41
 * @FilePath: \INFO6205\Finalterm\Solution3.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package Finalterm;

class Solution3 {
    public void reverseWords(char[] s) {
        // Reverse each word in the array.
        int start = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }

        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        
        char[] input1 = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        solution.reverseWords(input1);
        System.out.println(input1);
        
    }
}

