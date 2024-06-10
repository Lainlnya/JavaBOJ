import java.io.*;
import java.util.*;

public class Main {
    // 1, 2, 3, 4, 5, 6, 7
    // 순서대로 k번쨰 사람 제거
    // 결과 3, 6, 2, 7, 5, 1, 4

    // 앞과 뒤가 연결되어있는 자료구조여야하므로, 큐를 사용하는 것이 나을 것 같다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String command = br.readLine();
        int person = Integer.parseInt(command.split(" ")[0]);
        int cut = Integer.parseInt(command.split(" ")[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= person; i++) {
            queue.add(i);
        }
        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i <= cut; i++) {
                if (i == cut) {
                    sb.append(queue.poll());
                } else queue.add(queue.poll());
            }

            if (!queue.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }

}
