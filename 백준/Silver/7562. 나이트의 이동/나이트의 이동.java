import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, 2, 2, 1, -2, -1, -2, -1};
    static int[] dy = {2, 1, -1, -2, -1, -2, 1, 2};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            int num = Integer.parseInt(br.readLine());

            int[][] chess = new int[num][num];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            bfs(startX, startY, chess);

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            if (startX == targetX && startY == targetY) {
                sb.append(0 + "\n");
            } else sb.append(chess[targetX][targetY] + "\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y, int[][] chess) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < chess.length && ny >= 0 && ny < chess[0].length) {
                    if (chess[nx][ny] == 0) {
                        chess[nx][ny] = chess[current[0]][current[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
