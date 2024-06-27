import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        long minimum = Long.parseLong(st.nextToken());
        long answer = Long.MAX_VALUE;

        ArrayList<Long> array = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            array.add(Long.parseLong(br.readLine()));
        }
        // 정렬
        Collections.sort(array);

        int start = 0, end = 0;

        while (start < num && end < num) {
            // 우선 차이 계산하기
            long target = array.get(end) - array.get(start);

            if (target >= minimum) {
                answer = Math.min(answer, target);
                start++;
            } else end++;
        }

        System.out.println(answer);
    }
}
