import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2369 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> temp = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		
		int answer = 0;
		for (int i = 0; i < 9; i++) {
			int a = Integer.parseInt(br.readLine());
			temp.add(a);
		}
		
		
		int a = 0, b = 0;
		
		while(answer != 100) {
			answer = temp.stream().reduce(0, (acc, cur) -> acc + cur);
			aa: for (int i = 0; i < temp.size(); i++) {
					for (int j = i + 1; j < temp.size(); j++) {
						if (answer - temp.get(i) - temp.get(j) == 100) {
							a = i;
							b = j;
							answer = 100;
							break aa;
						}
					}
				}				
		}

		for (int i = 0; i < temp.size(); i++) {
			if (i == a || i == b) {
				continue;
			}
			result.add(temp.get(i));
		}
		
		Collections.sort(result);
		
		for (Integer nums : result) {
			System.out.println(nums);
		}
		
		
	}
}
