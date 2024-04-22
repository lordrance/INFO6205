/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 13:09:34
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 13:10:07
 * @FilePath: \INFO6205\HW5\GraphPathFinder.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package HW5;

import java.util.ArrayList;
import java.util.List;

public class GraphPathFinder {

    static class Graph {
        private final List<List<Integer>> adjList;

        public Graph(int vertices) {
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since the graph is bidirectional
        }

        public boolean hasPath(int source, int destination) {
            boolean[] visited = new boolean[adjList.size()];
            return dfs(source, destination, visited);
        }

        private boolean dfs(int source, int destination, boolean[] visited) {
            if (source == destination) {
                return true;
            }

            visited[source] = true;

            for (int neighbor : adjList.get(source)) {
                if (!visited[neighbor] && dfs(neighbor, destination, visited)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);

        System.out.println("Is there a path from 0 to 2: " + graph.hasPath(0, 2));

        Graph anotherGraph = new Graph(6);
        anotherGraph.addEdge(0, 1);
        anotherGraph.addEdge(0, 2);
        anotherGraph.addEdge(3, 5);
        anotherGraph.addEdge(5, 4);
        anotherGraph.addEdge(4, 3);

        System.out.println("Is there a path from 0 to 5: " + anotherGraph.hasPath(0, 5));
    }
}
