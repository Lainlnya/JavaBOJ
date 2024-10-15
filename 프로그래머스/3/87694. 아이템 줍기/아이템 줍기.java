import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new boolean[102][102];
        
        for (int i = 0; i < rectangle.length; i++) {
            int[] now = rectangle[i];
            for (int j = 0; j <now.length; j++) {
                now[j] *= 2;
            }
            makeLine(now);
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    private static void makeLine(int[] target) {
        for (int i = target[0]; i <= target[2]; i++) {
            for (int j = target[1]; j <= target[3]; j++) {
                if ((i == target[0] || i == target[2] 
                    || j == target[1] || j == target[3]) && map[i][j] != 2) {
                    map[i][j] = 1;
                } else map[i][j] = 2;
            }
        }
    }
    
    private static int bfs(int x, int y, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[0] == itemX && current[1] == itemY) {
                return current[2] / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                
                if (nr >= 0 && nr < 102 && nc >= 0 && nc < 102) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, current[2] + 1});
                    }
                }
            }
        }
        return 0;
    }
}