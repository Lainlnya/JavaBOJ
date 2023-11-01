import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int portionNum, minimum, answer, startP, endP;
    static int[] portion;
    public static void main(String[] args) throws IOException {
        // -99, -2, -1, 4, 98
        // 0, 4 => 두개 혼합했을 때 -1 => 1
        // 포인터 옮김 4 - 1 => 3
        // 0, 3 => 두개 혼합했을 때  95 => 1보다 크므로 앞 index + 1
        // 1, 3 => -2, 4 => 2 => 1보다 크므로 앞 index + 1
        // 2, 3 => 3 => 1보다 크므로 앞 index + 1
        // 만약 startindex >= endindex이면 out;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        portionNum = Integer.parseInt(br.readLine());
        portion = new int[portionNum];
        minimum = Integer.MAX_VALUE;
        answer = Integer.MAX_VALUE; startP = 0; endP = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < portionNum; i++) {
            portion[i] = Integer.parseInt(st.nextToken());
        } // 입력끝
        
        Arrays.sort(portion);

        for (int i = 0; i < portionNum; i++) {
            BST(i, i + 1, portionNum - 1);
        }
        System.out.println(portion[startP] + " " + portion[endP]);
    }

    static void BST(int pin, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = portion[pin] + portion[mid];
            if (minimum > Math.abs(sum)) {
                minimum = Math.abs(sum);
                startP = pin;
                endP = mid;
            }

            if (sum < 0)
                start = mid + 1;
            else
                end = mid - 1;
        }
    }
}
