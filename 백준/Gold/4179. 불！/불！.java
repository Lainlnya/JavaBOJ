import java.io.*;
import java.util.*;

public class Main {
    static char[][] maze;
    static int[][] man; // 지훈이 이동 시간
    static int[][] fire; // 불 전파 시간
    static Queue<int[]> manQ;
    static Queue<int[]> fireQ;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        maze = new char[row][column];
        man = new int[row][column];
        fire = new int[row][column];
        manQ = new LinkedList<>();
        fireQ = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            maze[i] = br.readLine().toCharArray();
            for (int j = 0; j < column; j++) {
                man[i][j] = -1;
                fire[i][j] = -1;
                if (maze[i][j] == 'F') {
                    fire[i][j] = 0;
                    fireQ.offer(new int[]{i, j});
                }

                if (maze[i][j] == 'J') {
                    man[i][j] = 0;
                    manQ.offer(new int[]{i, j});
                }
            }
        }

        fireBfs();
        manBfs();
    }

    public static void fireBfs() {
        while (!fireQ.isEmpty()) {
            int[] current = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length) {
                    if (maze[nr][nc] != '#' && fire[nr][nc] < 0) {
                        fire[nr][nc] = fire[current[0]][current[1]] + 1;
                        fireQ.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    public static void manBfs() {
        while (!manQ.isEmpty()) {
            int[] current = manQ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                // 영역 벗어나면 탈출한 것
                if (nr < 0 || nr >= maze.length || nc < 0 || nc >= maze[0].length) {
                    System.out.println(man[current[0]][current[1]] + 1);
                    return;
                }

                if (man[nr][nc] != -1 || maze[nr][nc] == '#') continue;

                if (fire[nr][nc] != -1 && fire[nr][nc] <= man[current[0]][current[1]] + 1) continue;

                man[nr][nc] = man[current[0]][current[1]] + 1;
                manQ.offer(new int[]{nr, nc});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
