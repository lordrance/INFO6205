package midterm;
import java.util.PriorityQueue;

public class problem4 {
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distances = new int[m][n]; 
        for (int[] row : distances) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> a[2] - b[2] 
        );
        queue.offer(new int[]{start[0], start[1], 0});
        
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            if (s[0] == destination[0] && s[1] == destination[1]) {
                return s[2];
            }
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
               
                x -= dir[0];
                y -= dir[1];
                if (distances[s[0]][s[1]] + count < distances[x][y]) {
                    distances[x][y] = distances[s[0]][s[1]] + count;
                    queue.offer(new int[]{x, y, distances[x][y]});
                }
            }
        }
        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        problem4 solver = new problem4();
        
        int[][] maze1 = {
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {1,1,0,1,1},
            {0,0,0,0,0}
        };
        int[] start1 = {0, 4};
        int[] destination1 = {4, 4};
        System.out.println("Example 1:");
        System.out.println("Output: " + solver.shortestDistance(maze1, start1, destination1));
        
    
    }
}


