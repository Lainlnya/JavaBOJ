import java.util.*;
import java.io.*;

public class Main {
    // 이미 가지고 있는 K, 필요한 랜선의 개수 K
    // 만들 수 있는 최대 랜선의 길이

    // 접근방법
    // start = 0, 4개 중 가장 큰거 = end
    // 중간값 잡아서 해당 중간값으로 가지고 있는 k를 나눴을 때 개수
    // 1씩 증가해가면서 개수가 줄어들기 직전까지 확인해야 할듯

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lenN = Integer.parseInt(st.nextToken()); // 랜선의 개수
        int need = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        long end = 0;
        int[] lens = new int[lenN];

        for (int i = 0; i < lenN; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, lens[i]);
        }

        long start = 0;
        long result = 0;
        while (start <= end) {

            long mid = (long)Math.ceil((start + end) / 2.0);
            long num = 0; // 잘랐을 떄 랜선 개수

            for (int len : lens) {
                num += (len / mid);
            }

            if (num < need) { // 랜선 크기가 너무 큰 것 => 자르는 단위를 줄일 것
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
