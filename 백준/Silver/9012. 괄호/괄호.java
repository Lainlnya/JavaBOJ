import java.io.*;
import java.util.*;

// 입력 받을 때 입력이 "(" 이면 stack에 넣기
// 입력이 ")"이고, stack에 가장 최근에 넣은 요소가 "(" 일 경우 pop
// 마지막에 stack의 크기가 0이면 YES, 아니면 NO
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int dataNum = Integer.parseInt(br.readLine()); // 입력

        for (int i = 0; i < dataNum; i++) {
            Stack<Character> stack = new Stack<>();
            char[] sequence = br.readLine().toCharArray();

            for (int j = 0; j < sequence.length; j++) {
                if (sequence[j] == '(') {
                    stack.push(sequence[j]);
                } else if (sequence[j] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else stack.push(sequence[j]);
            }
            if (stack.isEmpty()) {
                sb.append("YES" + "\n");
            } else sb.append("NO" + "\n");
        }

        System.out.println(sb);
    }
}
