import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        // 5 2 4 1 3
        int[] dp = new int[num + 1];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= num; i++) {
            int kid = Integer.parseInt(st.nextToken());
            dp[kid] = dp[kid - 1] + 1;
            max = Math.max(dp[kid], max);
        }

        System.out.println(num - max);
    }

}
