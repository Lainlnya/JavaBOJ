import java.util.*;
import java.io.*;

public class Main {
    static Deque<Node> deque;
    static int num, len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        num = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();

        int[] nNum = new int[num + 1];
        int[] dNum = new int[num + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            nNum[i] = Integer.parseInt(st.nextToken());
            insert(new Node(i, nNum[i]));
            dNum[i] = deque.peekFirst().value;
        }

        for (int i = 1; i <= num; i++) {
            sb.append(dNum[i] + " ");
        }

        System.out.println(sb);
    }

    public static void insert(Node node) {
        if (!deque.isEmpty() && deque.peekFirst().idx == node.idx - len) {
            deque.pollFirst();
        }

        while (!deque.isEmpty()) {
            if (deque.peekLast().value < node.value) break;

            deque.pollLast();
        }
        deque.add(node);
    }

    public static class Node {
        int idx, value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}