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
		double temp = 0, result = 0;
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
		
		System.out.println(ggung); // 16
		System.out.println(seok); // 36
		
		for (int i = seok.get(0); i <= seok.get(seok.size() - 1); i++) {
			int tempSeok = Collections.frequency(seok, i);
			double seokNum = tempSeok / seok.size(); // 석이 2일 때
			
			for (int j = i + 1; j <= seok.get(seok.size() - 1); j++) { // 꿍은 3, 4, 5, 6, 7, 8 다 됨
				int tempGgng = Collections.frequency(ggung, j);
				System.out.println("j : " + j);
				System.out.println(tempGgng);
				temp += tempGgng;
			}
			double ggungNum = temp / ggung.size();
			result += (seokNum * ggungNum);
			temp = 0;
		}
		System.out.println(result);
		
		if (result > 0.5) {
			System.out.println("Emma");
		}else if (result == 0.5) {
			System.out.println("Tie");
		}
		else {
			System.out.println("Gunnar");
		}
	}

}
