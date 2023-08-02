import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[][] tm = new double[8][8];
		double[] result = new double[8];
		
		for (int i = 0; i < tm.length; i++) {
			for (int j = i + 1; j < tm.length; j++) {
				tm[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
			}
		}
		
		for (int i = 1; i < tm.length; i++) {
			for (int j = 0; j < i ; j++) {
				tm[i][j] = 1 - tm[j][i];
			}
		}
		
		// 1라운드
		for (int i = 0; i < tm.length; i++) {
			for (int j = i; j <= 3; j++) { //0
				result[j * 2] = tm[j * 2][j * 2 + 1]; // [0, 1], [2, 3], [4, 5] [6, 7]				
				result[j * 2 + 1] = tm[j * 2 + 1][j * 2];
			}
		}
		
		
		
		System.out.println(Arrays.deepToString(tm));
		System.out.println(Arrays.toString(result));
	}
}
