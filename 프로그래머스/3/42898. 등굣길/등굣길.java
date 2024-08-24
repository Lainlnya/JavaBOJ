import java.util.*;

class Solution {
    static int[][] area;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    
    public int solution(int m, int n, int[][] puddles) {
        area = new int[n + 1][m + 1];
        
        for (int[] puddle: puddles) {
            area[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        return dfs(0, 0, m, n);
    }
    
    public static int dfs(int x, int y, int m, int n) { // m이 y랑 관련
        // 목적지 도달했을 때 1
        if (x == (n - 1) && y == (m - 1)) return 1;
        
        // 물웅덩이는 못지나가니까 0
        if (area[x][y] == -1) return 0;
        
        // 이미 계산한 것에 대해서는 이전 값 적용
        if (area[x][y] > 0) return area[x][y];
        
        int count = 0;
        
        for (int i = 0; i < 2; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];
            
            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                count += dfs(nr, nc, m, n);
                count %= 1000000007;
            }
        }
        
        area[x][y] = count;
        
        return area[x][y];
    }
}