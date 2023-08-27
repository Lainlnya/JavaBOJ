import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int mapN;
    static int deep;
    static int[][] map;
    static List<Point> maxArr; // 봉우리들 담을 리스트
    static int max; // max 봉우리 담을 변수
    static int ans; // 정답 담을 변수
    static int[] dr = {-1, 1, 0, 0}; // 좌, 우, 상, 하
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테케

        for (int tc = 1; tc <= T; tc++) { // 테케
            mapN = sc.nextInt();
            deep = sc.nextInt();
            max = Integer.MIN_VALUE;
            map = new int[mapN][mapN];
            maxArr = new ArrayList<>();
            ans = 0;

            // 최고 봉우리 찾기
            for (int i = 0; i < mapN; i++) { // 입력
                for (int j = 0; j < mapN; j++) {
                    map[i][j] = sc.nextInt();
                    max = Math.max(map[i][j], max);
                }
            }
            // 최고 봉우리 값 저장하기
            for (int i = 0; i < mapN; i++) {
                for (int j = 0; j < mapN; j++) {
                    if (map[i][j] == max) {
                        maxArr.add(new Point(i, j));
                    }
                }
            }

            for (int i = 0; i < mapN; i++) {
                for (int j = 0; j < mapN; j++) {
                    for (int k = 0; k <= deep; k++) {
                        map[i][j] -= k;
                        for (int p = 0; p < maxArr.size(); p++) {
                            dfs(1, maxArr.get(p).a, maxArr.get(p).b);
                        }
                        map[i][j] += k;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        } // 테케 끝
    }

    public static void dfs(int cnt, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < mapN && nc >= 0 && nc < mapN) {
                if (map[nr][nc] < map[r][c]) {
                    dfs(cnt + 1, nr, nc);
                }
            }
        }
        ans = Math.max(cnt, ans);
    }
    static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
