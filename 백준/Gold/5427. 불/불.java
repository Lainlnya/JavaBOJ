import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static int[][] fire;
    static int[][] man;
    static Queue<int[]> fireQ;
    static Queue<int[]> manQ;

    // 우선 전부 -1로 초기화
    // 만약 *이면 fire 0으로 변경, fireQ추가 // 만약 @이면 man 0으로 변경, manQ에 추가
    // 순서는 fire -> man
    // fire 돌면서 만약 map[i][j] == . 이고, fire[i][j]가 -1이면 fire[i][j] = 0 + 큐 추가
    // man 돌면서 만약 map[i][j] == . 이고,fire[i][j] != 0 이고, map[i][j]가 -1이면 map[i][j] = 0 + 큐 추가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            map = new char[width][height];
            fire = new int[width][height];
            man = new int[width][height];
            fireQ = new LinkedList<>();
            manQ = new LinkedList<>();

            for (int j = 0; j < width; j++) {
                map[j] = br.readLine().toCharArray();
                // 우선 -1로 채우기
                Arrays.fill(fire[j], -1);
                Arrays.fill(man[j], -1);

                for (int k = 0; k < height; k++) {
                    if (map[j][k] == '*') {
                        fire[j][k] = 0;
                        fireQ.add(new int[]{j, k});
                    }
                    if (map[j][k] == '@') {
                        man[j][k] = 0;
                        manQ.add(new int[]{j, k});
                    }
                }
            }

            fireBfs();
            manBfs();
        }
    }
    public static void fireBfs() {
        while (!fireQ.isEmpty()) {
            int[] current = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length) {
                    if (map[nr][nc] != '#' && fire[nr][nc] < 0) {
                        fire[nr][nc] = fire[current[0]][current[1]] + 1;
                        fireQ.add(new int[]{nr, nc});
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
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                    System.out.println(man[current[0]][current[1]] + 1);
                    return;
                }

                if (man[nr][nc] != -1 || map[nr][nc] == '#') continue;

                if (fire[nr][nc] != -1 && fire[nr][nc] <= man[current[0]][current[1]] + 1) continue;

                man[nr][nc] = man[current[0]][current[1]] + 1;
                manQ.offer(new int[]{nr, nc});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
