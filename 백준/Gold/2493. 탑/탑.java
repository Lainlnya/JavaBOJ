import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int topNum = Integer.parseInt(br.readLine());
        Stack<Integer> tops = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= topNum; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!tops.isEmpty() && tops.peek() < height) {
                tops.pop();
                stack.pop();
            }

            if (tops.isEmpty()) sb.append(0 + " ");
            else sb.append(stack.peek() + " ");

            tops.push(height);
            stack.push(i);
        }

        System.out.println(sb);
    }
}
