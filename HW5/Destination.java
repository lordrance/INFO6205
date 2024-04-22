/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 16:14:53
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 16:19:48
 * @FilePath: \INFO6205\HW5\Destination.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package HW5;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int destination;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        this.graph = new ArrayList<>();
        this.visited = new boolean[n];
        this.destination = destination;
        
     
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        return dfs(source);
    }

    private boolean dfs(int node) {
     
        if (graph.get(node).isEmpty()) {
            return node == destination;
        }
   
        if (visited[node]) {
            return false;
        }
        
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        visited[node] = false;
        
        return true;
    }
    
    public static void main(String[] args) {
        Destination solution = new Destination();
        int[][] edges1 = {{0, 1}, {0, 2}};
        System.out.println(solution.leadsToDestination(3, edges1, 0, 2)); // 输出：false
        
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(solution.leadsToDestination(4, edges2, 0, 3)); // 输出：true
    }
}
