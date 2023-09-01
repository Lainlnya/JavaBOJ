import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int[] result = new int[total];
		Stack<Integer> stack = new Stack<>();
		
		int count = 1;
		
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < result.length; i++) {
			while (count <= result[i]) {
				stack.push(count);
				sb.append("+\n");
				count += 1;
			}
			
			if (stack.peek() != result[i]) {
				System.out.println("NO");
				System.exit(0);
			}
			
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}
