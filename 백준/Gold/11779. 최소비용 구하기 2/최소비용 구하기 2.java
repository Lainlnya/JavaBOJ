import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 데이크스트라
public class Main {
    static int cityNum; // 도시의 개수
    static int busNum; // 버스 개수
    static ArrayList<ArrayList<Bus>> busStop; // 버스 노선들
    static int startCity; // 시작 도시
    static int endCity; // 끝 도시
    // 버스 클래스
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

        busStop = new ArrayList<ArrayList<Bus>>(); // 초기화

        for (int i = 0; i < cityNum + 1; i++) {
            busStop.add(new ArrayList<>());
        }

        // 그래프 만들기
        for (int i = 0; i < busNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busStop.get(start).add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());

        // 최소 비용 구할 배열 초기화
        int[] distance = new int[cityNum + 1];
        // 이전 도시를 저장할 배열 초기화
        int[] prevCity = new int[cityNum + 1];
        for (int i = 0; i < cityNum + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            prevCity[i] = -1;
        }

        // 비용을 기준으로 우선순위 큐 정렬
        PriorityQueue<Bus> pq = new PriorityQueue<Bus>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        // 어차피 시작 노드는 최소비용이 0이기 때문에
        pq.add(new Bus(startCity, 0));
        distance[startCity] = 0;

        while (!pq.isEmpty()) {
            Bus curBus = pq.poll();

            if (curBus.idx == endCity) {

                ArrayList<Integer> path = new ArrayList<>();
                int currentCity = endCity;

                while (currentCity != -1) {
                    path.add(currentCity);
                    currentCity = prevCity[currentCity];
                }

                StringBuilder pathBuilder = new StringBuilder();

                for (int j = path.size() - 1; j >= 0; j--) {
                    pathBuilder.append(path.get(j) + " ");
                }

                System.out.println(distance[curBus.idx]);
                System.out.println(path.size());
                System.out.println(pathBuilder);
                return;
            }

            if (distance[curBus.idx] < curBus.cost) {
                continue;
            }

            for (int i = 0; i < busStop.get(curBus.idx).size(); i++) {
                Bus nextBus = busStop.get(curBus.idx).get(i);

                if (distance[nextBus.idx] > curBus.cost + nextBus.cost) {
                    distance[nextBus.idx] = curBus.cost + nextBus.cost;

                    // 이전 도시의 정보를 업데이트
                    prevCity[nextBus.idx] = curBus.idx;

                    pq.add(new Bus(nextBus.idx, distance[nextBus.idx]));
                }
            }
        }
    }
}
