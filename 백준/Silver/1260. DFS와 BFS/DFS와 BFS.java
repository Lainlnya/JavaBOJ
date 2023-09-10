import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int nodeNum;
    static int connNum;
    static int startNum;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        nodeNum = Integer.parseInt(st.nextToken()); // 정점의 수
        connNum = Integer.parseInt(st.nextToken()); // 간선의 수
        startNum = Integer.parseInt(st.nextToken()); // 시작할 숫자

        arr = new int[nodeNum + 1][nodeNum + 1];
        visited = new boolean[nodeNum + 1];
        queue = new LinkedList<>();

        for (int i = 0; i < connNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1; // 간선이 양방향이므로 양방향 다 1으로 입력
            arr[end][start] = 1; // 간선이 양방향이므로 양방향 다 1으로 입력
        }

        dfs(startNum);
        sb.append("\n");
        visited = new boolean[nodeNum + 1];
        bfs(startNum);
        System.out.println(sb);
    }

    public static void dfs(int startNum) {
        visited[startNum] = true;
        sb.append(startNum + " ");

        for (int i = 1; i <= nodeNum; i++) {
            if (arr[startNum][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int startNum) {
        queue.offer(startNum);
        visited[startNum] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();
            sb.append(start + " ");

            for (int i = 1; i <= nodeNum; i++) {
                if (arr[start][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
