import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> network;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        network = new ArrayList<>();
        visited = new boolean[n + 1];
        
        int count = 0;
        
        // 초기화
        for (int i = 0; i <= n; i++) {
            network.add(new ArrayList<Integer>());
        }
        
        // 연결 시킬 노드들 넣어주기
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i - 1][j] == 1 && ((j + 1) != i)) {
                    network.get(i).add(j + 1);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                BFS(i);
            }
        }
        
        return count;
    }
    
    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        
        while (!queue.isEmpty()) {
            int turn = queue.poll();
            ArrayList<Integer> arr = network.get(turn);
            
            for (int ar : arr) {
                if (!visited[ar]) {
                    visited[ar] = true;
                    queue.add(ar);
                }
            }
        }
    }
}