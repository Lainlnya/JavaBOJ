import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> poss;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[num + 1];
        poss = new ArrayList<>();

        Arrays.fill(arr, true);

        isPrime(arr);
        getSum(num);

    }

    public static void isPrime(boolean[] arr) {
        // 0과 1은 소수가 아니니 false
        arr[0] = false; arr[1] = false;

        for (int i = 2; i * i < arr.length; ++i) {
            if (arr[i]) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]) poss.add(i);
        }
    }

    public static void getSum(int target) {
        int pnt1 = 0, pnt2 = 0, sum = 0, answer = 0;

        while (true) {
            if (sum >= target) {
                sum -= poss.get(pnt1++);
            } else if (pnt2 == poss.size()) break;
             else {
                sum += poss.get(pnt2++);
            }

            if(sum == target) answer++;
        }

        System.out.println(answer);
    }
}
