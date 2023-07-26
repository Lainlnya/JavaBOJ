import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int j = 0; j < N; j++) {
                    if ((j + 1) % num == 0) {
                        intArr[j] = (intArr[j] == 1) ? 0 : 1;
                    }
                }
            } else {
                intArr[num - 1] = (intArr[num - 1] == 1) ? 0 : 1;

                for (int j = 1; j < N / 2; j++) {
                    if (num - 1 + j >= N || num - 1 - j < 0) {
                        break;
                    }

                    if (intArr[num - 1 + j] == intArr[num - 1 - j]) {
                        intArr[num - 1 + j] = (intArr[num - 1 + j] == 1) ? 0 : 1;
                        intArr[num - 1 - j] = (intArr[num - 1 - j] == 1) ? 0 : 1;
                    } else break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(intArr[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }

    }
}
