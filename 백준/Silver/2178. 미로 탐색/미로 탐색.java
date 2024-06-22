import java.io.*;
import java.util.*;

public class Main {
    static int[][] map; // 지도
    static int[][] visited; // 거리
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int row, column;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        map = new int[row + 1][column + 1]; // 인덱스 계산을 편하게 하기 위함
        visited = new int[row + 1][column + 1];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 1; i <= row; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= column; j++) {
                map[i][j] = temp[j - 1] - '0';
            }
        }

        System.out.println(bfs(new int[]{1, 1}));

    }

    private static int bfs(int[] point) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);
        visited[point[0]][point[1]] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dr[i];
                int ny = current[1] + dc[i];

                if (nx > 0 && nx <= row && ny > 0 && ny <= column) {
                    if (visited[nx][ny] == -1 && map[nx][ny] == 1) {
                        visited[nx][ny] = visited[current[0]][current[1]] + 1;

                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return visited[row][column];
    }
}
