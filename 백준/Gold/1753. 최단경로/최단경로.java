import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int nodeNum, lineNum, startPoint;
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        nodeNum = Integer.parseInt(st.nextToken());
        lineNum = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Node>>();

        // 초기화
        for (int i = 0; i < nodeNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 유향 그래프, 단방향 그래프
            graph.get(start).add(new Node(end, cost));
        }

        // 최단 경로 비용 저장
        int[] distance = new int[nodeNum + 1];
        // 최대값으로 초기화
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(startPoint, 0));
        distance[startPoint] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (distance[curNode.idx] < curNode.cost) continue;

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nxtNode = graph.get(curNode.idx).get(i);

                if (distance[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    distance[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    pq.offer(new Node(nxtNode.idx, distance[nxtNode.idx]));
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else sb.append(distance[i] + "\n");
        }

        System.out.println(sb);
    }
}
