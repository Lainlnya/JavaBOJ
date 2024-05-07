import java.util.*;
import java.io.*;

public class Main {
    static int[][] shark;
    static int[][] distance;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        shark = new int[width][height];
        distance = new int[width][height];
        queue = new LinkedList<>();

        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < height; j++) {
                distance[i][j] = -1;
                shark[i][j] = Integer.parseInt(st.nextToken());

                if (shark[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if (nx >= width || nx < 0 || ny >= height || ny < 0) continue;

                if (shark[nx][ny] == 1 || distance[nx][ny] > 0) continue;

                distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (distance[i][j] > max) max = distance[i][j];
            }
        }

        System.out.println(max);
    }
}