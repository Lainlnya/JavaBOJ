import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] triangle = new int[num][num];

        for (int i = 0; i < triangle.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle.length - 1; j++) {
                triangle[i - 1][j] = Math.max(triangle[i - 1][j] + triangle[i][j],
                        triangle[i - 1][j] + triangle[i][j + 1]
                        );
            }
        }

        System.out.println(triangle[0][0]);
    }
}
