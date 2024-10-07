import java.util.*;
import java.io.*;

public class Main {

    static int[][] office;
    static int[][] copyOffice;
    static ArrayList<CCTV> cctv;
    static int[] output;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] > 0 && office[i][j] < 6) cctv.add(new CCTV(i, j, office[i][j]));
            }
        }
        output = new int[cctv.size()];
        permu(0, cctv.size());

        System.out.println(min);
    }

    public static void permu(int depth, int size) {
        if (depth == size) {
            copyOffice = new int[office.length][office[0].length];
            for (int i = 0; i < office.length; i++) {
                System.arraycopy(office[i], 0, copyOffice[i], 0, office[i].length);
            }

            for (int i = 0; i < output.length; i++) {
                direction(cctv.get(i), output[i]);
            }
            getSpots();

            return;
        }

        for (int i = 0; i < 4; i++) {
            output[depth] = i;
            permu(depth + 1, size);
        }
    }

    public static void direction (CCTV cctv, int dir) {
        switch(cctv.num) {
            case 1:
                watch(cctv, dir);
                break;
            case 2:
                if (dir == 0 || dir == 2) {
                    watch(cctv, 0); watch(cctv, 2);
                } else {
                    watch(cctv, 1); watch(cctv, 3);
                }
                break;
            case 3:
                if (dir == 0) {
                    watch(cctv, 0);
                    watch(cctv, 1);
                } else if (dir == 1) {
                    watch(cctv, 1);
                    watch(cctv, 2);
                } else if (dir == 2) {
                    watch(cctv, 2);
                    watch(cctv, 3);
                } else {
                    watch(cctv, 3);
                    watch(cctv, 0);
                }
                break;
            case 4:
                if (dir == 0) {
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 3);
                } else if (dir == 1) {
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 2);
                } else if (dir == 2) {
                    watch(cctv, 1);
                    watch(cctv, 2);
                    watch(cctv, 3);
                } else {
                    watch(cctv, 0);
                    watch(cctv, 2);
                    watch(cctv, 3);
                }
                break;

            case 5:
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
                break;
        }


    }

    public static void watch(CCTV cctv, int dir) {
        Queue<CCTV> queue = new LinkedList<>();
        boolean[][] visited = new boolean[office.length][office[0].length];
        queue.add(cctv);
        visited[cctv.x][cctv.y] = true;

        while (!queue.isEmpty()) {
            int nx = dx[dir] + queue.peek().x;
            int ny = dy[dir] + queue.poll().y;

            if (nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length && office[nx][ny] != 6) {
                if (copyOffice[nx][ny] == 0) {
                    copyOffice[nx][ny] = -1;
                    queue.add(new CCTV(nx, ny, dir));
                } else {
                    queue.add(new CCTV(nx, ny, dir));
                }
            }
        }
    }

    public static void getSpots() {
        int count = 0;
        for (int i = 0; i < copyOffice.length; i++) {
            for (int j = 0; j < copyOffice[0].length; j++) {
                if (copyOffice[i][j] == 0) count++;
            }
        }

        min = Math.min(count, min);
    }

    static class CCTV {
        int x, y, num;
        CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
