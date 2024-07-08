import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();
        int answer = 0;

        int num = Integer.parseInt(st.nextToken());
        int popNum = Integer.parseInt(st.nextToken());

        // 우선 값 추가하여 넣기
        for (int i = 1; i <= num; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < popNum; i++) {
            int where = Integer.parseInt(st.nextToken());
            int howMuch = 0;

            if (deque.indexOf(where) <= deque.size() / 2) {
                while (deque.get(0) != where) {
                    howMuch++;
                    deque.add(deque.remove(0));
                }
                deque.remove(0);
            } else {
                while (deque.get(0) != where) {
                    howMuch++;
                    deque.add(0, deque.remove(deque.size() - 1));
                }
                deque.remove(0);
            }
            answer += howMuch;
        }

        System.out.println(answer);
    }
}
