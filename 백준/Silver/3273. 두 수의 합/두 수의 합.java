import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num];
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int need = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        pointer(need);

        System.out.println(answer);
    }

    public static void pointer(int need) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int target = arr[start] + arr[end];

            if (target == need) {
                answer++;
                start++;
                end--;
            } else if (target > need) {
                end--;
            } else start++;
        }
    }
}
