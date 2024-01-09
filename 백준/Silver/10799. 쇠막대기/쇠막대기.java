import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        char[] pipes = br.readLine().toCharArray();
        int answer = 0;

        for (int i = 0; i < pipes.length; i++) {
            if (pipes[i] == '(' && pipes[i + 1] == ')') {
                answer += stack.size();
                i++;
            } else if (pipes[i] == ')') {
                stack.pop();
                answer += 1;
            } else {
                stack.push('(');
            }
        }
        System.out.println(answer);
    }
}
