import java.util.*;
import java.io.*;

public class Main {
    static int[][] box;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int count = 1;

    static int answer = Integer.MAX_VALUE;

    static class Node {
        int x, y, value;

        Node (int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        box = new int[len][len];
        visited = new boolean[len][len];

        StringTokenizer st;
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < len; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (box[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (box[i][j] != 0) {
                    visited = new boolean[len][len];
                    int res = bridge(i, j);

                    if (res == -1) continue;
                    if (answer > res) answer = res;
                }
            }
        }

        System.out.println(answer - 1);
    }

    public static void bfs(int x, int y) {
        count++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] land = queue.poll();
            box[land[0]][land[1]] = count;


            for (int i = 0; i < 4; i++) {
                int nr = land[0] + dr[i];
                int nc = land[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < box.length && nc < box.length) {
                    if (!visited[nr][nc] && box[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    public static int bridge(int x, int y) {
        Queue<Node> island = new LinkedList<>();
        island.add(new Node(x, y, 0));
        visited[x][y] = true;
        int location = 0;

        while (!island.isEmpty()) {
            Node current = island.poll();
            int posX = current.x;
            int posY = current.y;
            int val = current.value;

            if (box[posX][posY] != 0 && box[posX][posY] != box[x][y]) {
                return val;
            }

            for (int i = 0; i < 4; i++) {
                int nr = posX + dr[i];
                int nc = posY + dc[i];

                    if (nr >= 0 && nc >= 0 && nr < box.length && nc < box.length) {
                        if (!visited[nr][nc] && box[nr][nc] != box[x][y]) {
                            visited[nr][nc] = true;
                            island.add(new Node(nr, nc, val + 1));
                        }
                    }
            }
        }
        return -1;
    }
}
