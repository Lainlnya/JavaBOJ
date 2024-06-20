import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph; // 그래프
    static boolean[] visited; // 방문여부
    static int allVisited; // 방문여부 확인을 위한 플래그
    static int connectedNum; // 연결 요소를 위한 답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int lineNum = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[nodeNum + 1]; // 0부터 6까지
        allVisited = 0;
        connectedNum = 0;

        // 초기화
        for (int i = 0; i <= nodeNum; i++) { // 0부터 6까지
            graph.add(new ArrayList<>());
        }

        // 방향이 없는 그래프 => 양방향
        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                connectedNum++;
                dfs(i);
            }
        }
        System.out.println(connectedNum);
    }

    private static void dfs(int point) {
        visited[point] = true;
        // 언제 빠져나올 수 있게 할까
        allVisited++;

        if (allVisited == visited.length) return;

        for (int node : graph.get(point)) {
            if (!visited[node]) {
                dfs(node);
            }
        }

    }
}
