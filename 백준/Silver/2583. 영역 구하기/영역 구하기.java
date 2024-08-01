import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        map = new int[row][column];
        visited = new boolean[row][column];
        answer = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        sb.append(answer.size() + "\n");
        Collections.sort(answer);

        for (int value : answer) {
            sb.append(value + " ");
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        count++;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        answer.add(count);
    }
}
