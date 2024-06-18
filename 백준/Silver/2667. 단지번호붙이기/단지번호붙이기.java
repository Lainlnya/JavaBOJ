import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] apart; // 아파트 배열
    static boolean[][] visited; // 방문 확인 배열
    static ArrayList<Integer> complex; // 단지 정렬 용도
    static int connect = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int height = Integer.parseInt(br.readLine());
        apart = new int[height][height];
        visited = new boolean[height][height];
        complex = new ArrayList<>();

        // 입력
        for (int i = 0; i < height; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                int temp = Integer.parseInt(str[j]);
                apart[i][j] = temp;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                // 만약에 1이고, 방문하지 않았으면 connect 초기화 후 찾기
                if (apart[i][j] == 1 && !visited[i][j]) {
                    connect = 0;
                    bfs(i, j);
                    complex.add(connect);
                }
            }
        }

        Collections.sort(complex);
        System.out.println(complex.size());
        for (int one : complex) {
            System.out.println(one);
        }
    }

    private static void bfs (int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point house = queue.poll();
            connect++;

            for (int i = 0; i < 4; i++) {
                int nx = house.x + dr[i];
                int ny = house.y + dc[i];

                if (nx >= 0 && ny >= 0 && nx < apart.length && ny < apart.length) {
                    if (apart[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));

                    }
                }
            }

        }
    }
    public static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
