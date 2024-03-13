import java.util.*;
import java.io.*;
public class Main {
    static int nodeNum, lineNum, startPoint;
    static ArrayList<ArrayList<Node>> arr;
    static int[] distance;
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
        arr = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i <= nodeNum; i++) {
            arr.add(new ArrayList<>());
        }

        startPoint = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.get(start).add(new Node(end, cost));
        }

        distance = new int[nodeNum + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->Integer.compare( o1.cost,o2.cost));
        pq.add(new Node(startPoint, 0));
        distance[startPoint] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (distance[current.idx] < current.cost) continue;

            for (int i = 0; i < arr.get(current.idx).size(); i++) {
                Node nxtNode = arr.get(current.idx).get(i);

                if (distance[nxtNode.idx] > current.cost + nxtNode.cost) {
                    distance[nxtNode.idx] = current.cost + nxtNode.cost;
                    pq.add(new Node(nxtNode.idx, distance[nxtNode.idx]));
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
