import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int house = Integer.parseInt(br.readLine());

        int[][] RGB = new int[house][3];
        int[][] dp = new int[house][3];

        StringTokenizer st;

        for (int i = 0; i < house; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        for (int i = 1; i < house; i++) {
            dp[i][0] = Math.min(RGB[i][0] + dp[i - 1][1], RGB[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(RGB[i][1] + dp[i - 1][0], RGB[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(RGB[i][2] + dp[i - 1][0], RGB[i][2] + dp[i - 1][1]);

        }

        System.out.println(Math.min(Math.min(dp[house - 1][0], dp[house - 1][1]), dp[house - 1][2]));
    }
}
