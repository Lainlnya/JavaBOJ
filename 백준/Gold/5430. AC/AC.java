import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < caseNum; i++) {
            char[] call = br.readLine().toCharArray();
            int num = Integer.parseInt(br.readLine());

            String[] result = br.readLine().replaceAll("[\\[|\\]]", "").split(",");
            
            Deque<Integer> deque = new ArrayDeque<>();

            for (int j = 0; j < num; j++) {
                deque.add(Integer.parseInt(result[j]));
            }

            boolean pointer = true;
            boolean isError = false;

            aa: for (char sq: call) {
                switch (sq) {
                    case 'R':
                        pointer = !pointer;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            isError = true;
                            break aa;
                        }
                        else if (pointer) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                        break;
                }
            }

            if (!isError) {
                sb.append("[");
                if (pointer) {
                    while(!deque.isEmpty()) {
                        if (deque.size() == 1) sb.append(deque.pollFirst());
                        else sb.append(deque.pollFirst() + ",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        if (deque.size() == 1) sb.append(deque.pollLast());
                        else sb.append(deque.pollLast() + ",");
                    }
                }
                sb.append("]" + "\n");
            } else sb.append("error" + "\n");
        }
        System.out.println(sb);
    }
}
