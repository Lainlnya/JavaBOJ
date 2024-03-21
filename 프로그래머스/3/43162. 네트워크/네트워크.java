import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int count;
    public int solution(int n, int[][] computers) {
        arr = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n];
        count = 0;
        
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        
        // 입력 끝
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    arr.get(i).add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }   
        }
        return count;
    }
    
    public static void dfs(int idx) {
        visited[idx] = true;
        
        for (int next : arr.get(idx)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}