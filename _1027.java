import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Total = Integer.parseInt(br.readLine());
        int[] building = new int[Total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Total; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < Total; i++) {
            int tempMax = 0;
            double scope1 = 0, scope2 = 0;
            for (int j = i + 1; j < Total - 1; j++) {
                int center = building[j] * building[j + 1];
                if (scope1 < center) {
                    scope1 = center;
                    tempMax++;
                }
            }

            for (int j = i; j >= 1; j--) {
                int center = (building[j] - building[j - 1]);
                if (center > scope2) {
                    scope2 = center;
                    tempMax++;
                }
            }
            max = (tempMax > max) ? tempMax : max;
        }
        System.out.println(max);
    }
}
