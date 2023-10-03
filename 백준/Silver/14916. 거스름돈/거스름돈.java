import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());

        int[] dp = new int[change + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 100001;
        }

        // 기저 조건
        dp[0] = 0;

        for (int i = 2; i <= change; i++) {
            if (i >= 2 && dp[i - 2] != -1) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }

            if (i >= 5 && dp[i - 5] != -1) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }

        }

        if (dp[change] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[change]);
        }

    }
}
