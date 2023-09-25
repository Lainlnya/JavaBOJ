import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int itemNum = Integer.parseInt(st.nextToken()); // 필요한 물품의 수
        int weight = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        int[][] dp = new int[itemNum + 1][weight + 1];

        Point[] points = new Point[itemNum + 1];

        for (int i = 1; i <= itemNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 무게
            int b = Integer.parseInt(st.nextToken()); // 가치
            points[i] = new Point(a, b);
        }

        for (int i = 1; i <= itemNum; i++) {
            for (int j = 1; j <= weight; j++) {
                if (j < points[i].weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - points[i].weight] + points[i].value);
                }
            }
        }

        System.out.println(dp[itemNum][weight]);
    }
    public static class Point {
        int weight, value;

        Point(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}