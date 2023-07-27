import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] colorP = new boolean[100][100];
		int row = 0, column = 0, area = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			column = Integer.parseInt(st.nextToken());
			
			for (int j = row; j < row + 10; j++) {
				for (int k = column; k < column + 10; k++) {
					if (!colorP[k][j]) {
						area++;
						colorP[k][j] = true;
					}
				}
			}
		}
		System.out.println(area);
	}
}
