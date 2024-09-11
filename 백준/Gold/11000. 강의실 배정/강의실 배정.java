import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for (int[] one : arr) {
            if (pq.isEmpty()) {
                pq.add(one[1]);
            } else {
                int current = pq.peek();
                if (one[0] >= current) {
                    pq.poll();
                    pq.add(one[1]);
                } else pq.add(one[1]);
            }
        }

        System.out.println(pq.size());
    }
}
