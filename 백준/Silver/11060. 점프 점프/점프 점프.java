import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mazeNum = Integer.parseInt(br.readLine()); // 미로 개수
        int[] maze = new int[mazeNum];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mazeNum; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[mazeNum];

        dp[0] = 0;

        for (int i = 1; i < mazeNum; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {

                if (j + maze[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        if (dp[mazeNum - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(dp[mazeNum - 1]);
    }
}
