import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        int[][] duty = new int[total + 1][2];
        int[] dp = new int[total + 2];

        StringTokenizer st;
        for (int i = 1; i <= total; i++) {
            st = new StringTokenizer(br.readLine());

            duty[i][0] = Integer.parseInt(st.nextToken());
            duty[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = total; i >= 1; i--) {
            if (duty[i][0] + i > total + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + duty[i][0]] + duty[i][1]);
            }
        }

        System.out.println(dp[1]);
    }
}
