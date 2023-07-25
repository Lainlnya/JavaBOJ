import java.io.*;
import java.util.*;


public class _17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		String answer = "";
		Stack<String> stack = new Stack<>();
		boolean open = false;
		for (int i = 0; i < temp.length(); i++) {
			String one = String.valueOf(temp.charAt(i));
			if (one.equals("<")) {
				open = true;
				while (!stack.isEmpty()) {
					answer += stack.pop();
				}
			}
			
			if (open) {
				answer += one;
			} else {
				if (one.equals(" ")) {
					while (!stack.isEmpty()) {
						answer += stack.pop();
					}
					answer += one;
				} else {
					stack.add(one);					
				}
			}
			
			if (one.equals(">")) open = false;
		}
		
		while (!stack.isEmpty()) answer += stack.pop();
		
		System.out.println(answer);
	}

}
