/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 16:44:39
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 16:45:06
 * @FilePath: \INFO6205\Finalterm\Solution1.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package Finalterm;

// Mock the Relation class which contains the knows API.
// This is a simulation and would be provided in the actual LeetCode environment.
class Relation {
    boolean knows(int a, int b) {
        // In LeetCode, this method would be implemented for you.
        // Here is a dummy implementation for simulation.
        // You'll replace this with your actual matrix of who knows whom.
        int[][] graph = {
            {1, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        return graph[a][b] == 1;
    }
}

// The actual Solution class extends from Relation and uses the knows API.
public class Solution1 extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (candidate != i && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        
        // Assuming n is the number of people at the party
        int n = 3;
        
        // The candidate returned by findCelebrity method
        int candidate = solution.findCelebrity(n);
        
        // Output the result
        System.out.println(candidate);
    }
}
