import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] mine = new int[land.length][land[0].length];
        
        // 어차피 첫 줄은 채워져야 함
        mine[0] = land[0];
        for (int i = 1; i < land.length; i++) {
            
            mine[i][0] = Math.max(mine[i][0], land[i][0] + mine[i - 1][1]);
            mine[i][0] = Math.max(mine[i][0], land[i][0] + mine[i - 1][2]);
            mine[i][0] = Math.max(mine[i][0], land[i][0] + mine[i - 1][3]);
            
            mine[i][1] = Math.max(mine[i][1], land[i][1] + mine[i - 1][0]);
            mine[i][1] = Math.max(mine[i][1], land[i][1] + mine[i - 1][2]);
            mine[i][1] = Math.max(mine[i][1], land[i][1] + mine[i - 1][3]);
            
            mine[i][2] = Math.max(mine[i][2], land[i][2] + mine[i - 1][0]);
            mine[i][2] = Math.max(mine[i][2], land[i][2] + mine[i - 1][1]);
            mine[i][2] = Math.max(mine[i][2], land[i][2] + mine[i - 1][3]);
            
            mine[i][3] = Math.max(mine[i][3], land[i][3] + mine[i - 1][0]);
            mine[i][3] = Math.max(mine[i][3], land[i][3] + mine[i - 1][1]);
            mine[i][3] = Math.max(mine[i][3], land[i][3] + mine[i - 1][2]);     
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, mine[land.length - 1][i]);    
        }

        return max;
    }
}