import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int grdN = sc.nextInt(); // 활주로 크기
            int slide = sc.nextInt(); // 경사로 크기
            int[][] ground = new int[grdN][grdN]; // 활주로
            int answer = 0;

            for (int i = 0; i < grdN; i++) { // 활주로 입력
                for (int j = 0; j < grdN; j++) {
                    ground[i][j] = sc.nextInt();
                }
            } // 입력 끝

            // 행탐색
            for (int i = 0; i < grdN; i++) {
                int start = ground[i][0];
                boolean[]check = new boolean[grdN];
                grd: for (int j = 1; j < grdN; j++) {
                    if (ground[i][j] >= start + 2 || ground[i][j] <= start - 2) { // 높이차이가 2 이상이면 그냥 out
                        break grd;
                    } else if (start + 1 == ground[i][j]) { // 시작이 현재보다 1 클 때
                        for (int p = 1; p < slide + 1; p++) {
                            if (j - p < 0 || ground[i][j - p] != start || check[j - p]) break grd;
                            if (ground[i][j - p] == start) check[j - p] = true;
                        }
                        start = ground[i][j];
                    } else if (start - 1 == ground[i][j]) { // 시작이 현재보다 1 작을 때
                        for (int p = 0; p < slide; p++) {
                            if (j + p >= grdN || ground[i][j + p] != start - 1 || check[j + p]) break grd;
                            if (ground[i][j + p] == start - 1) check[j + p] = true;
                        }
                        j = j + slide - 1;
                        start = ground[i][j];
                    }
                    if (j == grdN - 1) answer += 1;
                }
            }
            // 열탐색
            for (int j = 0; j < grdN; j++) {
                int start = ground[0][j];
                boolean[]check = new boolean[grdN];
                grd: for (int i = 1; i < grdN; i++) {
                    if (ground[i][j] >= start + 2 || ground[i][j] <= start - 2) { // 높이차이가 2 이상이면 그냥 out
                        break grd;
                    } else if (start + 1 == ground[i][j]) { // 시작이 현재보다 1 클 때
                        for (int p = 1; p < slide + 1; p++) {
                            if (i - p < 0 || ground[i - p][j] != start || check[i - p]) break grd;
                            if (ground[i - p][j] == start) check[i - p] = true;
                        }
                        start = ground[i][j];
                    } else if (start - 1 == ground[i][j]) { // 시작이 현재보다 1 작을 때
                        for (int p = 0; p < slide; p++) {
                            if (i + p >= grdN || ground[i + p][j] != start - 1 || check[i + p]) break grd;
                            if (ground[i + p][j] == start - 1) check[i + p] = true;
                        }
                        i = i + slide - 1;
                        start = ground[i][j];
                    }
                    if (i == grdN - 1) answer += 1;
                }
            }
            System.out.println("#" + tc + " " + answer);
        } // 테케
    } // 메인
}
