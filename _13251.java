import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		int total = 0, K = 0;
		double answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			if (arr[i] >= K) {
				int temp = total;
				int temp2 = K;

				double tempAnswer = 1;
				while (temp2-- > 0) {
					tempAnswer *= (arr[i]-- / (double) temp--);
				}
				answer += tempAnswer;
			}
		}
		System.out.println(answer >= 1 ? 1 : answer);

	}
}
