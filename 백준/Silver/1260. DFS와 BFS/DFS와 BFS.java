import java.io.*;
import java.util.*;

// 정점은 양방향
public class Main {
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken()); // 정점의 개수
        int lineNum = Integer.parseInt(st.nextToken()); // 간선의 개수
        int startNum = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호
        graph = new ArrayList<>();
        visited = new boolean[nodeNum + 1]; // 1부터 인덱스 계산하기 쉽게 +1개로 설정

        for (int i = 0; i <= nodeNum; i++) { // 개수 세기 편하게 일부러 하나 더 추가
            graph.add(new ArrayList<Integer>()); // 배열 초기화
        }

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 양방향이니까 양쪽 다
            graph.get(start).add(end);
            graph.get(end).add(start);
        } // 그래프 초기화 끝

        for (int i = 0; i <= nodeNum; i++) {
            Collections.sort(graph.get(i)); // 정점 번호가 작은 것부터 먼저 방문
        }

        dfs(startNum);
        System.out.println();
        // bfs를 위한 초기화
        visited = new boolean[nodeNum + 1];
        bfs(startNum);
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int node : graph.get(start)) {
            if (!visited[node]) dfs(node);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 현재 노드 방문처리 및 큐에 추가
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int target = queue.poll();
            System.out.print(target + " ");

            // 인접노드 방문
            for (int node : graph.get(target)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
    }
}