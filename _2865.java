import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int parti = Integer.parseInt(st.nextToken());
		int genre = Integer.parseInt(st.nextToken());
		int win = Integer.parseInt(st.nextToken());
		double[] eachP = new double[parti];
		double answer = 0;
		
		for (int i = 0; i < genre; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < parti * 2; j += 2) {
				int person = Integer.parseInt(st.nextToken()) - 1;
				double good = Double.parseDouble(st.nextToken());
				eachP[person] = (eachP[person] >= good) ? eachP[person] : good;
			}
		}
		Arrays.sort(eachP);

		for (int i = eachP.length - 1; i >= (eachP.length - win); i--) {
			answer += eachP[i];
		}
		System.out.println(String.format("%.1f", answer));
		
	}
}
