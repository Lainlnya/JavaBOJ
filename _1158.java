import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> Josephus = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Josephus.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (Josephus.size() > 1) {
            for (int i = 0; i < M; i++) {
                if ((i + 1) == M) {
                    sb.append(Josephus.poll()).append(", ");
                }
                else {
                    Josephus.add(Josephus.poll());
                }
            }
        }
        sb.append(Josephus.poll()).append(">");

        System.out.println(sb);
    }
}
