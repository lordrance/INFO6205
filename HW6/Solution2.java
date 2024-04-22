/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 12:16:45
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 12:56:48
 * @FilePath: \INFO6205\HW6\Solution2.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package HW6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    
    // Pairs of strobogrammatic numbers
    private static final char[][] PAIRS = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int finalLength) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        
        List<String> list = helper(n - 2, finalLength);
        List<String> result = new ArrayList<>();

        for (String s : list) {
            for (char[] pair : PAIRS) {
                // Don't add numbers with leading zero
                if (pair[0] == '0' && n == finalLength) continue;
                result.add(pair[0] + s + pair[1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<String> result = solution.findStrobogrammatic(2);
        System.out.println(result);
        result = solution.findStrobogrammatic(1);
        System.out.println(result);
    }
}
