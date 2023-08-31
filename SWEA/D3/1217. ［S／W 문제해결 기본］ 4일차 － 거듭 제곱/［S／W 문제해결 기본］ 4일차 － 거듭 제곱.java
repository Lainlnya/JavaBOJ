import java.util.Scanner;

public class Solution {
	static int answer;
	static int startNum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			answer = 1;
			int t = sc.nextInt();
			startNum = sc.nextInt(); // 처음 시작 숫자
			int powNum = sc.nextInt(); // 반복할 숫자
			fibo(powNum);
			System.out.print("#" + t + " ");
			System.out.println(answer);
		}
	}
	
	public static void fibo(int num) {
		if (num > 0) {
			answer *= startNum;
			num--;
			fibo(num);
		}
	}
}
