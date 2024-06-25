import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new int[]{start, end});
        }

        int endTime = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[0] >= endTime) {
                answer++;
                endTime = current[1];
            }
        }
        System.out.println(answer);
    }
}
