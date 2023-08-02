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
		int win = 0, same = 0, result = 0, lose = 0;
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

		for (int i = seok.get(0); i <= seok.get(seok.size() - 1); i++) {
			int tempSeok = Collections.frequency(seok, i);
			int temp = 0, tempSame = 0;
			
			for (int j = i; j <= ggung.get(ggung.size() - 1); j++) {
				int tempGgng = Collections.frequency(ggung, j);
				if (j == i) {
					tempSame += tempGgng;
				} else temp += tempGgng;
			}
			win += (tempSeok * temp);
			same += (tempSeok * tempSame);
		}

		result = ggung.size() * seok.size();
		lose = result - win - same;

		if (win == lose) {
			System.out.println("Tie");
		} else if (win < lose) {
			System.out.println("Emma");
		} else {
			System.out.println("Gunnar");
		}
	}

}