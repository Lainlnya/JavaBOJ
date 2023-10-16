import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int comNum; // 컴퓨터의 수
    static int lineNum; // 연결할 수 있는 선의 수
    static List<Computer> comList; // 컴퓨터 배열
    static int[] parent; // 부모 배열
    static class Computer {
        int x, y, weight;

        Computer(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 초기화 및 입력
        comNum = Integer.parseInt(br.readLine());
        lineNum = Integer.parseInt(br.readLine());
        comList = new ArrayList<>();
        parent = new int[comNum + 1];

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            comList.add(new Computer(start, end, weight));
        }

        // 오름차순, 작은 것부터 뽑으려고
        Collections.sort(comList, new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.weight - o2.weight;
            }
        });

        // 부모 초기화
        makeSet();

        int ans = 0;
        int pick = 0;

        for (int i = 0; i < lineNum; i++) {
            // 부모 찾기
            int px = findSet(comList.get(i).x);
            int py = findSet(comList.get(i).y);

            // 부모가 다르면
            if (px != py) {
                // 부모는 같게 만들어주고
                union(px, py);
                // 비용 더해주기
                ans += comList.get(i).weight;
                // 선택했으니까 pick++;
                pick++;
            }

            // 다골랐으면 break
            if (pick == comNum - 1) break;
        }
        // 최소비용 출력
        System.out.println(ans);
    }

    // 초기화
    public static void makeSet() {
        for (int i = 1; i <= comNum; i++) {
            parent[i] = i;
        }
    }

    public static int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }

        return parent[x];
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }
}
