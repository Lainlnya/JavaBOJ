import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		double max = 0;
		double average = 0;
		List<Integer> getAvg = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < total; i++) {
			getAvg.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(getAvg);
		max = getAvg.get(getAvg.size() - 1);
		
		
		for (int i = 0; i < getAvg.size(); i++) {
			average += (getAvg.get(i) / max) * 100;
		}
		System.out.println(average / total);
	}
}
