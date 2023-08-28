import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sentence = br.readLine().toCharArray();
        // 각 알파벳의 index 번호가 들어갈 queue
        Queue<Integer> putA = new LinkedList<>();
        Queue<Integer> putB = new LinkedList<>();
        Queue<Integer> putC = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < sentence.length; i++) {
            switch (sentence[i]) {
                case 'A' :
                    putA.offer(i);
                    break;
                case 'B' :
                    putB.offer(i);
                    break;
                case 'C' :
                    putC.offer(i);
                    break;
            }
        }

        while (!putB.isEmpty()) {
            if (!putC.isEmpty() && (putB.peek() < putC.peek())){
                putB.poll(); putC.poll();
                answer++;
            } else if (!putA.isEmpty() && (putB.peek() > putA.peek())) {
                putB.poll(); putA.poll();
                answer++;
            } else {
                putB.poll();
            }
        }
        System.out.println(answer);
    }
}
