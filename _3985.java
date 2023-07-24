import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList list1 = new ArrayList<>();

		for(int i = 0; i <= N; i++) {
			list1.add(0);
		}

		int M = Integer.parseInt(br.readLine());
		int max = 0, count = 0, maxP = 0, countP = 0, temp = 0;

		for (int j = 0; j < M; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (b - a + 1 > max) {
				max = b - a + 1;
				maxP = j + 1;
			};

			int k = a - 1;
			while (k < b) {
				if (list1.get(k).equals(0)) {
					list1.remove(k);
					list1.add(k, j + 1);
				}
				k++;
			}
		}

		for (int i = M; i > 0; i--) {
			temp = Collections.frequency(list1, i);
			if (temp >= count) {
				count = temp;
				countP = i;
			}
		}

		System.out.println(maxP);
		System.out.println(countP);
	}
}
