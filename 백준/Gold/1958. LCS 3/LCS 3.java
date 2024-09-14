import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();
        char[] three = br.readLine().toCharArray();

        int[][][] dp = new int[one.length + 1][two.length + 1][three.length + 1];

        for (int i = 1; i <= one.length; i++) {
            for (int j = 1; j <= two.length; j++) {
                for (int k = 1; k <= three.length; k++) {
                    if ((one[i - 1] == two[j - 1]) && (two[j - 1] == three[k - 1])) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        
        System.out.println(dp[one.length][two.length][three.length]);
    }
}
