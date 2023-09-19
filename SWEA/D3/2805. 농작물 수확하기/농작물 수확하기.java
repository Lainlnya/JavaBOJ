import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine()); // 테케
		for (int t = 0; t < tc; t++) {
			int farmNum = Integer.parseInt(sc.nextLine());
			char[][] farm = new char[farmNum][farmNum];
			int answer = 0;
			
			// farm 입력
			for (int i = 0; i < farm.length; i++) {	
				farm[i] = sc.nextLine().toCharArray();
			}

			int num = 1;
			for (int i = 0; i < farmNum; i++) {
				if (i <= farmNum / 2) {
					for(int j = farmNum / 2 - i; j < farmNum / 2 + 1 + i; j++) {
						answer += (farm[i][j] - '0');
					}					
				} 
				else {
					for (int j = num; j < farmNum - num; j++) {
						answer += (farm[i][j] - '0');
					}
					num++;
				}
			}
			System.out.println("#" + (t + 1) + " " + answer);
		}
	}
}
