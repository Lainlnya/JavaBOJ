import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vNum = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int boxes = Integer.parseInt(br.readLine());

        int[] box = new int[vNum + 1];
        Arrays.fill(box, max);
        int answer = 0;

        ArrayList<Node> arr = new ArrayList<>();

        // sort 해야 함
        for (int i = 0; i < boxes; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.add(new Node(start, end, value));
        }

        Collections.sort(arr, (o1, o2) -> o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end);

        for (int i = 0; i < boxes; i++) {
            Node current = arr.get(i);

            boolean right = true;
            int possNum = max;

            for (int j = current.start; j < current.end; j++) {
                if (box[j] < current.value) {
                    right = false;
                    possNum = Math.min(possNum, box[j]);
                }
            }

            for (int j = current.start; j < current.end; j++) {
                if (right) {
                    box[j] -= current.value;
                } else {
                    box[j] -= possNum;
                }
            }

            if (right) answer += current.value;
            else answer += possNum;
        }

        System.out.println(answer);
    }

    public static class Node {
        int start, end, value;

        Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
