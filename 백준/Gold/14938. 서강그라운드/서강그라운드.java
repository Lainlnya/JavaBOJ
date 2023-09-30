import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int areaSize, findSize, roadSize; // 지역의 개수, 수색 범위, 길의 개수
    static int[] items; // 아이템 개수
    static ArrayList<ArrayList<Node>> graph;
    static int answer;
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
        areaSize = Integer.parseInt(st.nextToken());
        findSize = Integer.parseInt(st.nextToken());
        roadSize = Integer.parseInt(st.nextToken());
        answer = 0;
        items = new int[areaSize + 1];
        graph = new ArrayList<ArrayList<Node>>();

        // 아이템 개수 저장하기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= areaSize; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 그래프 초기화
        for (int i = 0; i < areaSize + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roadSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 무향그래프이기 때문에 2개 다 넣기
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }


        for (int i = 1; i <= areaSize; i++) {
            int[] distance = new int[areaSize + 1]; // 비용 저장할 배열
            // 가장 처음은 큰 값으로 초기화
            for (int j = 0; j < distance.length; j++) {
                distance[j] = Integer.MAX_VALUE;
            }

            // 비용을 기준으로 한 priority queue 선언
            PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            pq.offer(new Node(i, 0));
            distance[i] = 0;

            while (!pq.isEmpty()) {

                Node curNode = pq.poll();
                if (distance[curNode.idx] < curNode.cost) continue;

                for (int j = 0; j < graph.get(curNode.idx).size(); j++) {
                    Node nxtNode = graph.get(curNode.idx).get(j);

                    if (distance[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                        distance[nxtNode.idx] = curNode.cost + nxtNode.cost;
                        pq.offer(new Node(nxtNode.idx, distance[nxtNode.idx]));
                    }
                }
            }

            int count = 0;
            for (int j = 1; j <= areaSize; j++) {
                if (distance[j] <= findSize) {
                    count += items[j];
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
