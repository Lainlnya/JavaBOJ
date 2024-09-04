import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static List<Puyo> list;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            visited = new boolean[12][6];
            boolean isPop = true;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        list = new ArrayList<>();
                        bfs(new Puyo(i, j, map[i][j]));

                        if (list.size() >= 4) {
                            isPop = false;
                            for (Puyo mini: list) {
                                map[mini.x][mini.y] = '.';
                            }
                        }
                    }
                }
            }

            if (isPop) break;
            dropPuyo();
            answer++;
        }

        System.out.println(answer);

    }

    public static void bfs (Puyo puyo) {
        Queue<Puyo> queue = new LinkedList<>();

        queue.add(puyo);
        list.add(puyo);
        visited[puyo.x][puyo.y] = true;

        while (!queue.isEmpty()) {
            Puyo current = queue.poll();
            int x = current.x;
            int y = current.y;
            char color = current.color;

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + x;
                int nc = dc[i] + y;

                if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6) {
                    if (!visited[nr][nc] && map[nr][nc] == color) {
                        list.add(new Puyo(nr, nc, map[nr][nc]));
                        queue.add(new Puyo(nr, nc, map[nr][nc]));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    public static void dropPuyo() {
        for (int i = 0; i < 6; i++) {
            Queue<Character> queue = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.')  queue.add(map[j][i]);
            }

            for (int j = 11; j >= 0; j--) {
                if (!queue.isEmpty()) map[j][i] = queue.poll();
                else map[j][i] = '.';
            }

        }
    }

    public static class Puyo {
        int x, y;
        char color;
        Puyo(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }



}
