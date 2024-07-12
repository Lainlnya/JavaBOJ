import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        map = new int[row][column];

        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken()); // 시작 좌표 X
        int startY = Integer.parseInt(st.nextToken()); // 시작 좌표 Y
        int startP = Integer.parseInt(st.nextToken()); // 시작 방향


        // 입력
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(startX, startY, startP);
        System.out.println(answer);
    }

    public static void dfs (int startX, int startY, int position) {
        // 현재 칸이 청소되지 않은 경우 청소한다.
        map[startX][startY] = -1;

        for (int i = 0; i < 4; i++) {
            // 왼쪽 방향으로 회전
            position = (position + 3) % 4;

            int nx = startX + dx[position];
            int ny = startY + dy[position];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸일 경우 한 칸 전진
                if (map[nx][ny] == 0) {
                    answer++;
                    dfs(nx, ny, position);
                    return;
                }
            }
        }

        // 청소하지 않은 빈 칸이 없을 때
        int back = (position + 2) % 4;
        int bx = startX + dx[back];
        int by = startY + dy[back];

        if (bx >= 0 && bx < map.length && by >= 0 && by < map[0].length && map[bx][by] != 1) {
            dfs(bx, by, position);
        }
    }
}
