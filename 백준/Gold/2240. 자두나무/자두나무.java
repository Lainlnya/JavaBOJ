import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int[] plums = new int[time + 1];
        plums[0] = 1;
        for (int i = 1; i <= time; i++) {
            plums[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[time + 1][weight + 1][3];

        if (plums[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int t = 2; t <= time; t++) {
            if (plums[t] == 1) {
                dp[t][0][1] = dp[t - 1][0][1] + 1;
                dp[t][0][2] = dp[t - 1][0][2];

                for (int w = 1; w <= weight; w++) {
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]) + 1;
                    dp[t][w][2] = Math.max(dp[t - 1][w - 1][1], dp[t - 1][w][2]);
                }
            } else {
                dp[t][0][1] = dp[t - 1][0][1];
                dp[t][0][2] = dp[t - 1][0][2] + 1;

                for (int w = 1; w <= weight; w++) {
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]);
                    dp[t][w][2] = Math.max(dp[t - 1][w - 1][1], dp[t - 1][w][2]) + 1;
                }
            }
        }

        int answer = 0;
        for (int w = 0; w <= weight; w++) {
            answer = Math.max(answer, Math.max(dp[time][w][1], dp[time][w][2]));
        }

        System.out.println(answer);
    }
}
