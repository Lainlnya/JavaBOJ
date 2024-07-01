import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int lineNum = Integer.parseInt(br.readLine()); // 이 줄만큼 반복문

        for (int i = 0; i < lineNum; i++) {
            char[] sentenses = br.readLine().toCharArray();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            int cursor = 0; // 인덱스 기억할 용도의 변수

            for (int j = 0; j < sentenses.length; j++) {
                switch(sentenses[j]) {
                    case '<' :
                        if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                        break;
                    case '>' :
                        if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                        break;
                    case '-' :
                        if (!leftStack.isEmpty()) leftStack.pop();
                        break;
                    default:
                        leftStack.push(sentenses[j]);
                        break;
                }
            }

            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
