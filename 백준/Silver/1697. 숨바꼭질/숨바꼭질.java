import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] hideSeek = new int[100001];

		int subin = Integer.parseInt(st.nextToken());
		int young = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();

		// 일단 subin부터 시작
		hideSeek[subin] = 1;
		queue.add(subin);
		int start = 1;

		while (!queue.isEmpty()) {
			start++;
			int queSize = queue.size();
			for (int i = 0; i < queSize; i++) {
				int queueNum = queue.poll();

				if (queueNum - 1 >= 0 &&hideSeek[queueNum - 1] == 0) {
					hideSeek[queueNum - 1] = start;
					queue.add(queueNum - 1); // 4
				}
				if (queueNum + 1 < hideSeek.length &&hideSeek[queueNum + 1] == 0) {
					hideSeek[queueNum + 1] = start; // 2
					queue.add(queueNum + 1); // 6
				}
				if (queueNum * 2 < hideSeek.length && hideSeek[queueNum * 2] == 0) {
					hideSeek[queueNum * 2] = start;
					queue.add(queueNum * 2);
				}
			}

			// 탈출코드
			if (hideSeek[young] != 0) break;
		}

		System.out.println(hideSeek[young] - 1);
	}
}
