import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1449{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int leakNum = Integer.parseInt(st.nextToken());
        int tape = Integer.parseInt(st.nextToken());
        int[] leak = new int[leakNum];
        int answer = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < leakNum; i++) {
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak);
        double first = leak[0] - 0.5;
        for (int i = 0; i < leakNum; i++) {
            if (leak[i] < (first + tape)) {
                continue;
            } else {
                answer++;
                first = leak[i] - 0.5;
            }
        }

        System.out.println(answer);
    }
}
