import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] foods; // 음식 저장
    static boolean[][] visited;
    static ArrayList<int[]> arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int waste = Integer.parseInt(st.nextToken());
        foods = new int[row + 1][column + 1];
        visited = new boolean[row + 1][column + 1];
        arr = new ArrayList<>();
        answer = 0;

        for (int i = 0; i < waste; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            foods[x][y] = 1;
            arr.add(new int[]{x, y});
        }

        for (int i = 0; i < arr.size(); i++) {
            int[] current = arr.get(i);
            // 방문하지 않았다면
            if (!visited[current[0]][current[1]]) bfs(current[0], current[1]);

        }
        System.out.println(answer);
    }
    private static void bfs(int x, int y) {
        int big = 1;

        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < foods.length && ny >= 0 && ny < foods[0].length) {
                    if (foods[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        big++;
                    }

                }
            }
        }

        answer = Math.max(answer, big);
    }
}
