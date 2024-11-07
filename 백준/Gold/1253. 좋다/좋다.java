import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        int[] arr = new int[total];
        int[] reverse = new int[total];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int result = 0;

        for (int i = 0; i < reverse.length; i++) {
            int left = 0;
            int right = reverse.length - 1;

            while (true) {
                if (left == i) left++;
                else if (right == i) right--;

                if (left >= right) break;

                if (arr[left] + arr[right] > arr[i]) right--;
                else if (arr[left] + arr[right] < arr[i]) left++;
                else {
                    result++;
                    break;
                }
            }

        }
        System.out.println(result);
    }
}
