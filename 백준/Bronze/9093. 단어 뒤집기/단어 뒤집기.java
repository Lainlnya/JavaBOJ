import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int inputN = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuffer reverse = new StringBuffer(st.nextToken());
                sb.append(reverse.reverse().toString() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
