import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] originalNum; // 원래 배열
	static boolean[] visited; // 방문 여부
	static int num; // 자연수 개수
	static int sum; // 자연수 합
	static int answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케
		
		for (int t = 1; t <= T; t++) {
			num = sc.nextInt(); // 자연수 개수
			sum = sc.nextInt(); // 자연수 합
			visited = new boolean[num];
			originalNum = new int[num];
			answer = 0;
			
			// 입력
			for (int i = 0; i < num; i++) {
				originalNum[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= num; i++) {
				combination(0, i);				
			}
			
			System.out.println("#" + t + " " + answer);
			
		} // 테케
		
	} // 메인
	
	public static void combination(int start, int r) {
		if (r == 0) {
			int result = 0;
			for (int i = 0; i < originalNum.length; i++) {
				if (visited[i]) {
					result += originalNum[i];
				}
			}
			
			if (result == sum) answer++;
			return;
		}
		
		for (int i = start; i < originalNum.length; i++) {
			visited[i] = true;
			combination(i + 1, r - 1);
			visited[i] = false;
		}
	}
}
