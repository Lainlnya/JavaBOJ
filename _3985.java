import java.io.*;
import java.util.*;

public class _3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] N = new int[Integer.parseInt(br.readLine()) + 1];
		
		int M = Integer.parseInt(br.readLine());
		int max = 0, count = 0;
		
		for (int j = 0; j < M; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (b - a > max) max = b - a;
			
			int k = a - 1;
			while (k++ < b) {
				if (N[k] == 0) {
					N[k] = j + 1;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
		}
		
		System.out.println(max);
		System.out.println(Arrays.toString(N));
	}
}
