import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int row;
    static int column;
    static int[][] lab; // 연구소
    static int[] dr = {0, 0, -1, 1}; // 상하좌우
    static int[] dc = {1, -1, 0, 0}; // 상하좌우

    static class VirusPoint {
        int x, y;
        VirusPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        lab = new int[row][column];
        int[][] tempLab = new int[row][column]; // 임시 연구소
        int maxSafeArea = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row * column; i++) {
            int r1 = i / column;
            int c1 = i % column;

            // 첫번째 벽
            if (lab[r1][c1] == 0) {
                for (int j = i + 1; j < row * column; j++) {
                    int r2 = j / column;
                    int c2 = j % column;

                    // 두번째 벽
                    if (lab[r2][c2] == 0) {
                        for (int k = j + 1; k < row * column; k++) {
                            int r3 = k / column;
                            int c3 = k % column;

                            // 세번째 벽
                            if (lab[r3][c3] == 0) {
                                for (int x = 0; x < row; x++) {
                                    for (int y = 0; y < column; y++) {
                                        tempLab[x][y] = lab[x][y];
                                    }
                                }
                                tempLab[r1][c1] = tempLab[r2][c2] = tempLab[r3][c3] = 1;
                                int count = bfs(tempLab);
                                maxSafeArea = Math.max(count, maxSafeArea);
                                tempLab[r1][c1] = tempLab[r2][c2] = tempLab[r3][c3] = 0;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(maxSafeArea);

    }

    public static int bfs (int[][] lab) {
        Queue<VirusPoint> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 2) {
                    queue.offer(new VirusPoint(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            VirusPoint tempVirus = queue.poll();
            visited[tempVirus.x][tempVirus.y] = true;

            for (int i = 0; i < 4; i++) {
                int nr = tempVirus.x + dr[i];
                int nc = tempVirus.y + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (!visited[nr][nc] && lab[nr][nc] == 0) {
                        lab[nr][nc] = 2;
                        visited[nr][nc] = true;
                        queue.add(new VirusPoint(nr, nc));
                    }
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (lab[i][j] == 0) safeArea++;
            }
        }
        return safeArea;
    }
}
