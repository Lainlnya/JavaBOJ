// package SWEA_6485_삼성시;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 전체 테스트케이스 개수
		
		for (int tc = 0; tc < T; tc++) {
			int[] busStop = new int[5001]; // 최대 개수 500이므로 501짜리 int배열 선언
			int busCase = sc.nextInt(); // 버스 개수
			
			// 버스 지나는 노선 추가하기
			for (int b = 0; b < busCase; b++) {
				int start = sc.nextInt();
				int stop = sc.nextInt();
				
				for (int i = start; i <= stop; i++) {
					busStop[i]++;
				}
			}
			
			int where = sc.nextInt();
			
			// 출력부
			System.out.print("#" + (tc + 1) + " ");
			for (int i = 0; i < where; i++) {
				System.out.print(busStop[sc.nextInt()] + " ");
			}
			System.out.println();
		}
	} // 메인 끝
}
