import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _10262 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> ggung = new ArrayList<>();
		List<Integer> seok = new ArrayList<>();
		int K = 2;
		double result = 0.0;
		double tempBig = 0;
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int i = a; i <= b; i++) {
				for (int j = c; j <= d; j++) {
					if (K == 1) ggung.add(i + j);
					else seok.add(i + j);
				}
			}
		}
		
		Collections.sort(ggung);
		Collections.sort(seok);

		System.out.println(ggung);
		System.out.println(seok);
		for (int i = seok.get(0); i <= seok.get(seok.size() - 1); i++) {
			double temp = 0;
			double tempSeok = Collections.frequency(seok, i);

			for (int j = i; j <= ggung.get(ggung.size() - 1); j++) {
				if(j >= seok.get(0)) {
					double tempGgng = Collections.frequency(ggung, j);
					temp += tempGgng;
				}

				if (j > seok.get(seok.size() - 1)) {
					tempBig += Collections.frequency(ggung, j);
				}
			}
			result += (tempSeok * temp);
		}
		tempBig /= (seok.get(seok.size() - 1) - seok.get(0) + 1);

		result -= (tempBig * ggung.size());
		System.out.println(result);

		result /= (seok.size() * ggung.size());

		System.out.println(result);
		if (result > 0.5) {
			System.out.println("Gunnar");
		} else if (result < 0.5) {
			System.out.println("Emma");
		} else {
			System.out.println("Tie");
		}
	}

}
