import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int[][] dp = new int[10001][4]; // 개수를 기록할 배열

        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            
        }

        for (int i = 0; i < tc; i++) {
            int target = Integer.parseInt(br.readLine());
            int num = dp[target][1] + dp[target][2] + dp[target][3];
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}
