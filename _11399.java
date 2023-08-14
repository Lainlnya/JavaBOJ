import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 20m
public class _11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int personCount = Integer.parseInt(br.readLine());
		int[] ATM = new int[personCount];
		int[] result = new int[personCount];
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < personCount; i++) {
			ATM[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ATM);
		result[0] = ATM[0];
		for(int i = 1; i < personCount; i++) {
			result[i] = result[i - 1] + ATM[i];
		}
		
		for (int plus : result) {
			answer += plus;
		}
		System.out.println(answer);
		
	}
}
