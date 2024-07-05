import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int dayNum = Integer.parseInt(br.readLine());

        int[][] days = new int[dayNum + 1][2]; // 0 ~ dayNum 인덱스까지 시간과 비용을 담기 위함
        int[] answer = new int[dayNum + 2]; // 기본값을 가장 마지막에 두기 위해 + 2만큼 설정

        // 입력
        for (int i = 1; i <= dayNum; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            days[i] = new int[]{time, price};
        }

        // 뒤에서부터 계산
        for (int i = dayNum; i >= 1; i--) {
            if (i + days[i][0] > dayNum + 1) {
                answer[i] = answer[i + 1];
            } else {
                answer[i] = Math.max(answer[i + 1], days[i][1] + answer[i + days[i][0]]);
            }
        }

        System.out.println(answer[1]);
    }
}
