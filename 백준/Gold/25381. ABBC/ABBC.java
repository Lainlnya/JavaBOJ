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
                    if (putB.size() > 0 && putB.poll() < i) {
                        answer++;
                        putB.poll();
                    }
                    break;
            }
        }

        while (!putA.isEmpty() && !putB.isEmpty()) {
            if (putA.peek() < putB.peek()) {
                answer++;
                putB.poll(); putA.poll();
            } else {
                putB.poll();
            }
        }

        System.out.println(answer);
    }
}
