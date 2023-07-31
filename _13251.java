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
		double answer = 0;
		double answerUp = 0;
		double total = 0;
		if (M == 1) {
			answer = 1;
			System.out.println(answer);
		} else {
			List<Integer> stone = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				stone.add(Integer.parseInt(st.nextToken()));
			}
			
			System.out.println(stone);
			int N = Integer.parseInt(br.readLine());
			int copyN = N;
			if (N != 1) {
				for (int j = 0; j < stone.size(); j++) {
					double temp = 1;
					int K = stone.get(j);
					total += K;
					while (copyN-- > 0 && K > N) {
						temp *= (K--);
						System.out.println(temp);
					}
					copyN = N;
					answerUp += temp;
					temp = 1;
				}
				
				for (int j = 0; j < N - 1; j++) {
					total *= (--total);
				}
				answer = answerUp / total;
				System.out.println(answer);
			} else {
				answer = 1;
				System.out.println(answer);
			}
			
		}
		
	}
}
