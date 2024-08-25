import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int pnt1 = 0, pnt2 = 1;
        int sum = arr[pnt1];
        int answer = Integer.MAX_VALUE;

        while (true) {
            if (sum < target) {
                if (pnt2 >= len) break;
                sum += arr[pnt2];
                pnt2++;
            } else {
                answer = Math.min(answer, (pnt2 - pnt1));
                if (pnt1 >= len) break;
                sum -= arr[pnt1];
                pnt1++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == target) answer = 1;
        }

        if (answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);
    }
}
