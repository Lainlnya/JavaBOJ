import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());

        int[][] matrix = new int[size + 1][2];
        int[][] dp = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            matrix[i] = new int[]{start, end};
        }

        // System.out.println(Arrays.deepToString(matrix));

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0; // 우선 행렬 하나 자체는 값이 존재하지 않기 때문에 0으로 초기화
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length - i; j++) {
                if (j == j + i) continue;

                int a = j;
                int b = j + i;

                for (int k = a; k < b; k++) {
                    dp[a][b] = Math.min(dp[a][b],
                              dp[a][k] + dp[k + 1][b] + matrix[a][0] * matrix[k][1] * matrix[b][1]
                            );
                }
            }
        }

        System.out.println(dp[1][size]);
    }
}
