import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(st.nextToken());
        int term = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        // 일단 list로 숫자에 맞게 넣기
        for (int i = 1; i <= total; i++) {
            queue.add(i);
        }

        int count = 1;
        sb.append("<");
        while (!queue.isEmpty()) {
             if (count++ == term) {
                 if (queue.size() == 1) sb.append(queue.poll() + ">");
                 else sb.append(queue.poll() + ", ");
                 count = 1;
             } else queue.add(queue.poll());
        }
        System.out.println(sb);
    }
}
