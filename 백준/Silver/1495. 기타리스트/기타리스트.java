import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int songNum = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());
        int maxV = Integer.parseInt(st.nextToken());
        int[] songBox = new int[songNum + 1];
        boolean[][] dp = new boolean[101][1001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= songNum; i++) {
            songBox[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][startV] = true;


        for (int i = 1; i <= songNum; i++) { // 이미 첫번쨰의 경우 계산했기 때문에 제외 가능
            for (int j = 0; j <= maxV; j++) {
                if (dp[i - 1][j]) { // 이전 값이 true인지 확인하는 단계
                    if (j + songBox[i] >= 0 && j + songBox[i] <= maxV) {
                        dp[i][j + songBox[i]] = true;
                    }

                    if (j - songBox[i] >= 0 && j - songBox[i] <= maxV) {
                        dp[i][j - songBox[i]] = true;
                    }
                }
            }
        }

        for (int i = maxV; i >= 0; i--) {
            if (dp[songNum][i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
