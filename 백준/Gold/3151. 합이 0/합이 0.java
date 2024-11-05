import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        long count = 0L;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[total];

        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        int i = 0;
        while (arr[i] <= 0 && (i + 1) < arr.length) {
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int current = arr[start] + arr[end] + arr[i];
                int l = 1, r = 1;

                if (current == 0) {
                    if (arr[start] == arr[end]) {
                        count += combination(end - start + 1);
                        break;
                    }
                    while (start + 1 < end && arr[start] == arr[start + 1]) {
                        l++;
                        start++;
                    }

                    while (start < end - 1 && arr[end] == arr[end - 1]) {
                        r++;
                        end--;
                    }
                    count += l * r;
                }

                if (current > 0) end--;
                else start++;
            }
            i++;
        }
        System.out.println(count);
    }

    static int combination(int n) {
        return n * (n - 1) / 2;
    }
}
