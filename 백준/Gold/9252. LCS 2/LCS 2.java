import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int size = dp[arr1.length][arr2.length];
        sb.append(size + "\n");
        ArrayList<Character> answer = new ArrayList<>();
        int row = arr1.length, column = arr2.length;

        while (row > 0 && column > 0) {
            if (arr1[row - 1] == arr2[column - 1]) {
                answer.add(arr1[row - 1]);
                row--; column--;
            } else {
                if (dp[row][column] == dp[row - 1][column]) row--;
                else column--;
            }
        }

        for(int i = size - 1; i >= 0; i--) {
            sb.append(answer.get(i));
        }

        System.out.println(sb);
    }
}
