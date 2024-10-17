import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
        boolean[] visited;
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            node.add(new ArrayList<>());
        }
        
        // 양방향 그래프 만들어주기
        for (int[] wire: wires) {
            node.get(wire[0]).add(wire[1]);
            node.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire: wires) {
            int count = 1;
            visited = new boolean[n + 1];
            // wire[0] 돌기
            Queue<Integer> queue = new LinkedList<>();
            queue.add(wire[0]);
            visited[wire[0]] = true;
            visited[wire[1]] = true;
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                int size = node.get(current).size();
                for (int i = 0; i < size; i++) {
                    if (!visited[node.get(current).get(i)]) {
                        visited[node.get(current).get(i)] = true;
                        queue.add(node.get(current).get(i));
                        count++;
                    }
                }
            }
            
            answer = Math.min(Math.abs((n - count) - count), answer);
        }
        
        return answer;
    }
}