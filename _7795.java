import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10m
public class _7795 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] A = new int[Integer.parseInt(st.nextToken())];
			int[] B = new int[Integer.parseInt(st.nextToken())];
			int answer = 0;
			

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(B);
			
			for (int i = 0; i < A.length; i++) {
				if (A[i] > B[B.length - 1]) {
					answer += B.length;
				} else {
					for (int j = 0; j < B.length; j++) {
						if (A[i] > B[j]) {
							answer++;
						}
					}
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

}
