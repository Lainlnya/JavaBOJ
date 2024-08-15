import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        Integer[] weights = new Integer[total];

        for (int i = 0; i < total; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weights, Collections.reverseOrder());

        int answer = weights[0];
        for (int i = 1; i < total; i++) {
            answer = Math.max(answer, weights[i] * (i + 1));
        }

        System.out.println(answer);
    }
}
