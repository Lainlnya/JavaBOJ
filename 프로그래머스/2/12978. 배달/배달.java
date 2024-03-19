import java.util.*;

class Solution {
    
    static class Node {
        int idx, cost;
        
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
    int answer = 0;
    
    ArrayList<ArrayList<Node>>graph = new ArrayList<>();
    
    for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<Node>());
    }
        
    for (int i = 0; i < road.length; i++) {
        graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
        graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
    }
        
    int[] distance = new int[N + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    pq.add(new Node(1, 0));
    distance[1] = 0; 

    while (!pq.isEmpty()) {
        Node current = pq.poll();
        if (distance[current.idx] < current.cost) continue;

        for (int i = 0; i < graph.get(current.idx).size(); i++) {
            Node next = graph.get(current.idx).get(i);

            if (distance[next.idx] > current.cost + next.cost) {
                distance[next.idx] = current.cost + next.cost;
                pq.add(new Node(next.idx, distance[next.idx]));
            }
        }
    }
    
    for (int i = 1; i < distance.length; i++) {
        if (distance[i] <= K) answer++;
    }
    
    return answer;
    }
}