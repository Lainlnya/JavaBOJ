import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10262 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> ggung = new ArrayList<>();
		List<Integer> seok = new ArrayList<>();
		int K = 2;
		int ggungR = 0, seokR = 0;
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int i = a; i <= b; i++) {
				for (int j = c; j <= d; j++) {
					if (K == 1) {
						if (!ggung.contains(i + j)) ggung.add(i + j);
					}
					else {
						if (!seok.contains(i + j)) seok.add(i + j);
					}
				}
			}
		}
		
		ggungR = ggung.get(0) + ggung.get(ggung.size() - 1);
		seokR = seok.get(0) + seok.get(seok.size() - 1); 

		if (ggungR > seokR) {
			System.out.println("Gunnar");
		} else if (ggungR < seokR) {
			System.out.println("Emma");
		} else {
			System.out.println("Tie");
		}
	}

}
