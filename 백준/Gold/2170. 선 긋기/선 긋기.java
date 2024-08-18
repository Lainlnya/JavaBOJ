import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[][] lines = new int[total][2];
        StringTokenizer st;

        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        // 순서대로 정렬
        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        int min = lines[0][0], max = lines[0][1], answer = lines[0][1] - lines[0][0];

        for (int i = 1; i < lines.length; i++) {
            // 1. 범위 내부에 포함될 경우
            if (min <= lines[i][0] && lines[i][1] <= max) continue;
            // 2. 범위 내부를 max가 벗어날 경우 => 벗어난 만큼 더해주기
            else if (lines[i][0] >= min && lines[i][0] < max && lines[i][1] > max) {
                answer += (lines[i][1] - max);
            // 3. 둘 다 벗어날 경우
            } else {
                answer += (lines[i][1] - lines[i][0]);
            }
            min = lines[i][0];
            max = lines[i][1];
        }
        System.out.println(answer);
    }
}
