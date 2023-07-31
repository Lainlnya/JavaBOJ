import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());
		Queue queue = new Queue();
		
		for (int i = 0; i < total; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			int b = 0;
			
			if (st.hasMoreTokens()) {
				b = Integer.parseInt(st.nextToken());
			}
			
			switch(a) {
			case ("push"):
				queue.push(b);
				break;
			
			case ("pop"):
				System.out.println(queue.pop());
				break;
			
			case("size"):
				System.out.println(queue.size());
				break;
			
			case("empty"):
				System.out.println(queue.empty());
				break;
			
			case ("front"):
				System.out.println(queue.front());
				break;
			
			case ("back"):
				System.out.println(queue.back());
				break;
			
			}
		}
		
	}
	
	public static class Queue {
		List<Integer> queue = new ArrayList<>();
		
		public Queue(){}
		
		public void push(int X) {
			queue.add(X);
		}
		
		public int pop() {
			if (queue.isEmpty()) return -1;
			else return queue.remove(0);
		}
		
		public int size() {
			return queue.size();
		}
		
		public int empty() {
			if (queue.isEmpty()) return 1;
			
			return 0;
		}
		
		public int front() {
			if (queue.isEmpty()) return -1;
			
			return queue.get(0);
		}
		
		public int back() {
			if (queue.isEmpty()) return -1;
			
			return queue.get(queue.size() - 1);
		}
	}
}
