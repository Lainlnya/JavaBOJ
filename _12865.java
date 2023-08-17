import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int itemNum = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());
        int[][] items = new int[itemNum + 1][2];
        int[] dp = new int[maxValue + 1];

        for (int i = 1; i <= itemNum; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // weight
            items[i][1] = Integer.parseInt(st.nextToken()); // value
        }

        for (int i = 1; i <= itemNum; i++) {
            for (int j = 1; j <= maxValue; j++) {
                if (items[i][0] <= j) { // j보다 작거나 같을 떄
                    if (items[i][1] + dp[j - 1] > dp[i - 1]) { // 현재 가치 + 이전 무게의 가치
                        dp[i] = items[i][1] + dp[i - 1];
                    } else dp[i] = dp[i - 1]; // 아니라면 이전 가치 그대로 사용
                } else dp[i] = dp[i - 1]; // 아니라면 이전 가치 그대로 사용
            }
        }
        System.out.println(Arrays.toString(dp));
        sb.append(dp[maxValue]);
        System.out.println(sb);
    }
}
