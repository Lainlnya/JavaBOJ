// 현재 피로도 80
// [최소 필요 피로도, 소모 피로도]
// [80, 20] => 60
// [30, 10] => 50
// [50, 40] => 10
// 1. 조합 계산
import java.util.*;

class Solution {
    static int[][] combi;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public int solution(int k, int[][] dungeons) {
        combi = new int[dungeons.length][1];
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        
        return max;
    }
    
    public static void dfs(int depth, int[][] dungeons, int k) {
        if (dungeons.length == depth) {
            int limit = k;
            int count = 0;
            for (int[] dungeon: combi) {
                if (limit >= dungeon[0]) {
                    limit -= dungeon[1];
                    count++;
                } else break;
            }
            
            max = Math.max(count, max);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi[depth] = dungeons[i];    
                dfs(depth + 1, dungeons, k);
                visited[i] = false;
            }

        }
        
    }
}