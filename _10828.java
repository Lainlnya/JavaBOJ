import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());
		Stack stack = new Stack();
		
		for (int i = 0; i < total; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			int b = 0;
			
			if (st.hasMoreTokens()) {
				b = Integer.parseInt(st.nextToken());
			}
			
			switch(a) {
			case ("push"):
				stack.push(b);
				break;
			
			case ("pop"):
				System.out.println(stack.pop());
				break;
			
			case("size"):
				System.out.println(stack.size());
				break;
			
			case("empty"):
				System.out.println(stack.empty());
				break;
				
			case ("top"):
				System.out.println(stack.top());
				break;
			
			}
		}
		
	}
	
	public static class Stack {
		List<Integer> stack = new ArrayList<>();
		
		public Stack(){}
		
		public void push(int X) {
			stack.add(X);
		}
		
		public int pop() {
			if (stack.isEmpty()) return -1;
			else return stack.remove(stack.size() - 1);
		}
		
		public int size() {
			return stack.size();
		}
		
		public int empty() {
			if (stack.isEmpty()) return 1;
			
			return 0;
		}
		
		public int top() {
			if (stack.isEmpty()) return -1;
			
			return stack.get(stack.size() - 1);
		}
	}
}
