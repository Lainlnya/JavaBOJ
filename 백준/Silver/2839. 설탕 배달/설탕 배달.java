import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bag = Integer.parseInt(br.readLine());

        int[] dp = new int[bag + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 5001;
        }

        dp[0] = 0;

        for (int i = 3; i <= bag; i++) {
            if (i >= 3 && dp[i - 3] != -1) {
                dp[i] = Math.min(dp[i - 3] + 1, dp[i]);
            }
            if (i >= 5 && dp[i - 5] != -1) {
                dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
            }
        }
        
        if (dp[bag] == 5001) {
            System.out.println(-1);
        } else System.out.println(dp[bag]);
    }
}

// 11
// 5 3 3