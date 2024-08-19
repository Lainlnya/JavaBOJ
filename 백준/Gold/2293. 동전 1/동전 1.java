import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nums = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[nums];

        int[] dp = new int[10001];

        for (int i = 0; i < nums; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 0; j < nums; j++) {
            if (coins[j] <= 10000) {
                dp[coins[j]] += 1;
                for (int i = coins[j]; i <= target; i++) { // [1, 2, 5] 10
                    dp[i] = dp[i] + dp[i - coins[j]];
                }
            }
        }

        System.out.println(dp[target]);
    }
}
