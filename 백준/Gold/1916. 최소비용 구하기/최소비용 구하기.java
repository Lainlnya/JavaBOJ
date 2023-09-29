import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int cityNum; // 도시의 개수
    static int busNum; // 버스의 개수
    static ArrayList<ArrayList<Bus>> busInfo;
    static int startCity; // 시작 도시
    static int endCity; // 도착 도시

    static class Bus {
        int idx, cost;
        Bus(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        cityNum = Integer.parseInt(br.readLine());
        busNum = Integer.parseInt(br.readLine());
        busInfo = new ArrayList<ArrayList<Bus>>();

        for (int i = 0; i < cityNum + 1; i++) {
            busInfo.add(new ArrayList<>());
        }

        // 유향 그래프로 만들어주기
        for (int i = 0; i < busNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busInfo.get(start).add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());

        // distance 배열 선언
        int[] distance = new int[cityNum + 1]; // 최소 비용을 저장할 배열
        for (int i = 0; i < cityNum + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 비용을 기준으로 하는 PriorityQueue 선언
        PriorityQueue<Bus> pq = new PriorityQueue<Bus>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        // 시작 노드에서 시작 노드로 가는 값이 초기에 가장 짧은 비용을 갖는 노드이며, 해당 노드를 선택했기 때문에 0으로 갱신
        pq.offer(new Bus(startCity, 0));
        distance[startCity] = 0;

        while (!pq.isEmpty()) {
            Bus curBus = pq.poll();

            if (curBus.idx == endCity) {
                System.out.println(distance[curBus.idx]);
                return;
            }

            if (distance[curBus.idx] < curBus.cost) {
                continue;
            }

            for (int i = 0; i < busInfo.get(curBus.idx).size(); i++) {
                Bus nextBus = busInfo.get(curBus.idx).get(i);

                if (distance[nextBus.idx] > curBus.cost + nextBus.cost) {
                    distance[nextBus.idx] = curBus.cost + nextBus.cost;

                    pq.offer(new Bus(nextBus.idx, distance[nextBus.idx]));
                }
            }
        }
    }
}
