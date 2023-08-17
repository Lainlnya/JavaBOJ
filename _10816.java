import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cardNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> numberCard = new HashMap<>();
		
		for (int i = 0; i < cardNum; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (numberCard.containsKey(temp)) {
				numberCard.put(temp, numberCard.get(temp) + 1);
			} else numberCard.put(temp, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (numberCard.containsKey(temp)) {
				sb.append(numberCard.get(temp) + " ");
			} else sb.append(0 + " ");
		}
		System.out.println(sb);
	}
}
