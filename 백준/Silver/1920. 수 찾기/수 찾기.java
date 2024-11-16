import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int count = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int start = 0;
        while (start < count) {
            int correct = Integer.parseInt(st.nextToken());
            if (binarySearch(correct, nums)) {
                sb.append(1 + "\n");
            } else sb.append(0 + "\n");
            start++;
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int num, int[] criteria) {
        int start = 0, end = criteria.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (num == criteria[mid]) {
                return true;
            } else if (num < criteria[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
