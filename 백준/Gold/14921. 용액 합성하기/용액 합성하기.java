import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];
        int answer = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = total - 1;
        while (true) {
            if (start >= end) break;
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < Math.abs(answer)) {
                answer = sum;
            }

            if (sum < 0) start++;
            else end--;
        }

        System.out.println(answer);
    }
}
