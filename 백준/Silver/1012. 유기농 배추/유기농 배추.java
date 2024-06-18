import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> seeds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine()); // 테스트케이스의 수
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int mapX = Integer.parseInt(st.nextToken());
            int mapY = Integer.parseInt(st.nextToken());
            map = new int[mapX][mapY]; // 밭
            visited = new boolean[mapX][mapY]; // 방문여부 확인
            seeds = new ArrayList<>(); // 배추 있는지 없는지 확인하기 위한 용도

            int count = 0; // 정답을 위한 count

            int seedNum = Integer.parseInt(st.nextToken()); // 배추 숫자

            for (int j = 0; j < seedNum; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
                seeds.add(new int[]{x, y});
            }

            for (int[] seed : seeds) {
                if (!visited[seed[0]][seed[1]]) {
                    bfs(seed[0], seed[1]);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) { // 조건에 부합하다면
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
