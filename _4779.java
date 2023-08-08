import java.io.IOException;
import java.util.Scanner;

public class _4779 {
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		while (sc.hasNextInt()) {
			int Total = (int)Math.pow(3, sc.nextInt());
			
			for (int i = 0; i < Total; i++) {
				sb.append("-");
			}
			
			recursive(0, Total);
			System.out.println(sb);
		}
	}
	
	public static void recursive(int start, int num) {
		if (num == 1) {
			return;
		}
		int left = num / 3;
		for (int i = start + left; i < start + left * 2; i++) {
			sb.setCharAt(i, ' ');
		}
		
		recursive(start, left);
		recursive(start + 2 * left, left);
	}
}
