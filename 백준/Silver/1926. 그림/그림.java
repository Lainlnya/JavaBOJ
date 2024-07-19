import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper;
    static boolean[][] visited;
    static ArrayList<int[]> colored;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> answer;
    static int maxAns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        // 초기화
        paper = new int[column][row];
        visited = new boolean[column][row];
        colored = new ArrayList<>();
        answer = new ArrayList<>();
        maxAns = Integer.MIN_VALUE;

        for (int i = 0; i < column; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < row; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());

                if (paper[i][j] == 1) colored.add(new int[]{i, j});
            }
        }

        for (int[] start : colored) {
            if (!visited[start[0]][start[1]]) {
                answer.add(bfs(start[0], start[1]));
            }
        }

        System.out.println(answer.size());
        if (answer.isEmpty()) {
            System.out.println(0);
        } else System.out.println(maxAns);
    }

    public static int bfs(int x, int y) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dr[i] + current[0];
                int ny = dc[i] + current[1];

                if (nx >= 0 && nx < paper.length && ny >= 0 && ny < paper[0].length) {
                    if (!visited[nx][ny] && paper[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }
        maxAns = Math.max(maxAns, count);
        return count;
    }
}
