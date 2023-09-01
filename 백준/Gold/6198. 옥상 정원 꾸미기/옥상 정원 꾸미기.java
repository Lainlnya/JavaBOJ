import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int[] building = new int[total];
		long answer = 0;
		
		for (int i = 0; i < total; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < total; i++) {
			 while (!stack.isEmpty() && stack.peek() <= building[i]) {
				 stack.pop();
			 }
			 answer += stack.size();
			 stack.push(building[i]);
		}
		
		System.out.println(answer);
	}
}
