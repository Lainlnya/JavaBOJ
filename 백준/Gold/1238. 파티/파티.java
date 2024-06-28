import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int studentNum;
    static int lineNum;
    static int startPoint;
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<int[]> distances;
    static class Node {
        int idx, cost;
        Node (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        studentNum = Integer.parseInt(st.nextToken());
        lineNum = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Node>>();
        distances = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i < studentNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 유향 그래프
            graph.get(start).add(new Node(end, cost));
        }


        for (int j = 1; j < graph.size(); j++) {
            int[] distance = new int[studentNum + 1];

            // 가장 처음은 MAX_VALUE로 초기화
            for (int i = 0; i < distance.length; i++) {
                distance[i] = Integer.MAX_VALUE;
            }

            PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            pq.offer(new Node(j, 0));
            distance[j] = 0;

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
            distances.add(distance);
        }

        int[] answer = distances.get(startPoint - 1);
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i < distances.size(); i++) {
            if (i != startPoint - 1) {
                answer[i + 1] += distances.get(i)[startPoint];
                maxDistance = Math.max(answer[i + 1], maxDistance);
            }
        }

        System.out.println(maxDistance);

    }
}
