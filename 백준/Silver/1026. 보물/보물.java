import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());

        ArrayList<Integer> A = new ArrayList<>();
        int[] B = new int[total];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {
            int temp = Integer.parseInt(st.nextToken());
            A.add(temp);
        }

        Collections.sort(A, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B);

        int answer = 0;

        for (int i = 0; i < total; i++) {
            answer += A.get(i) * B[i];
        }

        System.out.println(answer);
    }
}
