import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> computers; // 컴퓨터 연결 상태
    public static boolean[] visited; // 방문여부 확인
    public static int virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computerNum =  Integer.parseInt(br.readLine());
        int connectNum = Integer.parseInt(br.readLine());

       computers = new ArrayList<>();
       visited = new boolean[computerNum + 1];
       virus = 0;

       // 초기화
       for (int i = 0; i <= computerNum; i++) {
           computers.add(new ArrayList<>());
       }

       for (int i = 0; i < connectNum; i++) {
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           // 서로 연결 -> 양방향
           computers.get(start).add(end);
           computers.get(end).add(start);
       }

       bfs(1);
       System.out.println(virus);
    }

    public static void bfs (int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int computer : computers.get(current)) {
                if (!visited[computer]) {
                    virus++;
                    visited[computer] = true;
                    queue.offer(computer);
                }
            }
        }
    }
}
