import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int sum = 1;
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        bfs(maps);
        int row = maps.length - 1, column = maps[0].length - 1;
        if (visited[row][column] == 0) return -1;
        return visited[row][column];
    }
    
    public static void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                
                if (nr >= 0 && nc >= 0 && nr < visited.length && nc < visited[0].length) {
                    if (maps[nr][nc] == 1 && visited[nr][nc] == 0) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = visited[current[0]][current[1]] + 1;
                    }
                }
            }
        }
        
    }
    
   
}