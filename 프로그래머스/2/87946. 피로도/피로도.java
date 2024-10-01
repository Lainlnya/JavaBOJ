// 현재 피로도 80
// [최소 필요 피로도, 소모 피로도]
// [80, 20] => 60
// [30, 10] => 50
// [50, 40] => 10
// 1. 조합 계산
import java.util.*;

class Solution {
    static ArrayList<int[][]> arr;
    static int[][] combi;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int max = Integer.MIN_VALUE;
        arr = new ArrayList<>();
        combi = new int[dungeons.length][1];
        visited = new boolean[dungeons.length];
        dfs(0, dungeons);
        
        int size = arr.size();
        
        for (int[][] dungeon : arr) {
            int limit = k;
            int count = 0;
            aa: for (int j = 0; j < dungeons.length; j++) {
                if (limit >= dungeon[j][0]) {
                    limit -= dungeon[j][1];
                    count++;
                } else break aa;
            }
            System.out.println(count);
            max = Math.max(count, max);
        }
        
        return max;
    }
    
    public static void dfs(int depth, int[][] dungeons) {
        if (dungeons.length == depth) {
            int[][] dungeon = new int[depth][1];
            
            for (int i = 0; i < depth; i++) {
                dungeon[i] = combi[i];
            }
            arr.add(dungeon);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi[depth] = dungeons[i];    
                dfs(depth + 1, dungeons);
                visited[i] = false;
            }

        }
        
    }
}