import java.util.*;
import java.io.*;

public class Main {
    static int[] visited;
    static int[] dr = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, -1);

        dp(subin, sister);
        
        System.out.println(visited[sister]);
    }

    public static void dp(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (visited[end] != -1) break;

            for (int i = 0; i < 3; i++) {
                int now = cur;
                if (i == 0) now *= dr[i];
                else now += dr[i];

                if (now >= 0 && now < visited.length && visited[now] == -1) {
                    if (i != 0) {
                        visited[now] = visited[cur] + 1;
                    } else {
                        visited[now] = visited[cur];
                    }
                    queue.add(now);
                }
            }

        }
    }
}
