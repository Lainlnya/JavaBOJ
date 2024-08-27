import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int groupNum = Integer.parseInt(st.nextToken());
        int studentNum = Integer.parseInt(st.nextToken());
        int[][] loca = new int[groupNum][studentNum];
        int[] sq = new int[groupNum];

        // 우선 입력
        for (int i = 0; i < loca.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < loca[i].length; j++) {
                loca[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(loca[i]);
        }

        int answer = Integer.MAX_VALUE;

        while (true) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < groupNum; i++) {
                if (loca[i][sq[i]] > max) {
                    max = loca[i][sq[i]];
                }

                if (loca[i][sq[i]] < min) {
                    min = loca[i][sq[i]];
                    minIndex = i;
                }
            }

            if (answer > (max - min)) {
                answer = max - min;
            }

            if (++sq[minIndex] >= studentNum) break;
        }

        System.out.println(answer);
    }

}
