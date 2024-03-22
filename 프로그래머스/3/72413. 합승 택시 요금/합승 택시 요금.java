import java.util.*;

class Solution {
    static ArrayList<ArrayList<Node>> fareGraph;
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int[] common, aDistance, bDistance;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        fareGraph = new ArrayList<ArrayList<Node>>();
        // 입력
        for (int i = 0; i <= n; i++) {
            fareGraph.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            fareGraph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            fareGraph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }
        
        common = new int[n + 1];
        aDistance = new int[n + 1];
        bDistance = new int[n + 1];
        Arrays.fill(common, Integer.MAX_VALUE);
        Arrays.fill(aDistance, Integer.MAX_VALUE);
        Arrays.fill(bDistance, Integer.MAX_VALUE);
        
        dijkstra(s, common);
        dijkstra(a, aDistance);
        dijkstra(b, bDistance);
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, common[i] + aDistance[i] + bDistance[i]);
        }
        
        return answer;
    }
    
    public static void dijkstra(int start, int[] target){
        target[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if ( target[current.idx] < current.cost ) continue;
            
            for (int i = 0; i < fareGraph.get(current.idx).size(); i++) {
                Node next = fareGraph.get(current.idx).get(i);
                if (target[next.idx] > current.cost + next.cost) {
                    target[next.idx] = current.cost + next.cost;
                    pq.add(new Node(next.idx, target[next.idx]));
                }
            }
        }
        
    }
}