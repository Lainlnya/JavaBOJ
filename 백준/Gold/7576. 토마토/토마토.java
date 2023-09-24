import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // bfs
    static int row; // 가로
    static int column; // 세로
    static int[][] tomato; // 토마토 상자
    static boolean isRipe;
    static Queue<Box> queue;
    static int count;

    static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        tomato = new int[row][column];
        queue = new LinkedList<>();
        count = -1;
        isRipe = true;

        // 입력
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if (tomato[i][j] == 1) {
                    queue.offer(new Box(i, j));
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tomato[i][j] == 0) {
                    isRipe = false;
                }
            }
        }

        if (isRipe) {
            System.out.println(0);
            return;
        }

        bfs();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Box tmt = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = tmt.x + dr[i];
                    int nc = tmt.y + dc[i];

                    if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                        if (tomato[nr][nc] == 0) {
                            tomato[nr][nc] = 1;
                            queue.offer(new Box(nr, nc));
                        }
                    }
                }
            }
            count++;
        }
    }

    public static class Box {
        int x, y;

        public Box(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}