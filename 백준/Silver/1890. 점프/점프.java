import java.util.*;
import java.io.*;

public class Main {
    static int[][] game; // 게임판
    static long[][] dp; // 개수를 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        game = new int[size][size];
        dp = new long[size][size];

        for (int i = 0; i < game.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 첫시작은 1로

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) break; // 마지막 종점은 신경X

                int jump = game[i][j];

                if (i + jump < size) {
                    dp[i + jump][j] += dp[i][j]; // 오른쪽으로 이동
                }

                if (j + jump < size) {
                    dp[i][j + jump] += dp[i][j]; // 아래로 이동
                }
            }
        }
        System.out.println(dp[size - 1][size - 1]);
    }


}
