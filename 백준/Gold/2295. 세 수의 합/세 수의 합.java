import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];

        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] multi = new int[(num * (num + 1)) / 2];

        // A + B
        int count = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                multi[count++] = nums[i] + nums[j];
            }
        }
        Arrays.sort(multi);

        int answer = -1;

        // X - C
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (binarySearch(multi, nums[i] - nums[j])) {
                    answer = Math.max(nums[i], answer);
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean binarySearch(int[] multi, int target) {
        int start = 0, end = multi.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (target < multi[mid]) {
                end = mid - 1;
            } else if (target > multi[mid]) start = mid + 1;
            else return true;
        }
        return false;
    }
}
