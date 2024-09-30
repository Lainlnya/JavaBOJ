import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;
        while (true) {
            count++;
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            int[][] cave = new int[num][num];
            int[][] visited = new int[num][num];

            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(visited[i], -1);
                for (int j = 0; j < num; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(cave, visited);
            System.out.println("Problem " + count + ": " + visited[num - 1][num - 1]);
        }
    }

    public static void bfs(int[][] cave, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = cave[0][0];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + current[0];
                int nc = dc[i] + current[1];

                if (nr >= 0 && nc >= 0 && nr < cave.length && nc < cave[0].length) {
                    if (visited[nr][nc] == -1) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = visited[current[0]][current[1]] + cave[nr][nc];
                    } else {
                        if (visited[nr][nc] > visited[current[0]][current[1]] + cave[nr][nc]) {
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = visited[current[0]][current[1]] + cave[nr][nc];
                        }
                        visited[nr][nc] = Math.min(visited[nr][nc], visited[current[0]][current[1]] + cave[nr][nc]);
                    }
                }
            }
        }
    }

    public class Node {
        int idx, value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
