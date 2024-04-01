import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> card = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(card);

        int count = Integer.parseInt(br.readLine());
        int[] answer = new int[count];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int searchNum = Integer.parseInt(st.nextToken());
            answer[i] = upperBound(card, searchNum) - lowerBound(card, searchNum);
        }

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(ArrayList<Integer> arr, int value) {
        int start = 0;
        int end = arr.size();

        while (end - start > 0) {
            int mid = (start + end) / 2;
            if (value <= arr.get(mid)) {
                end = mid;
            } else start = mid + 1;
        }

        return start;
    }

    public static int upperBound(ArrayList<Integer> arr, int value) {
        int start = 0;
        int end = arr.size();

        while (end - start > 0) {
            int mid = (start + end) / 2;
            if (value >= arr.get(mid)) {
                start = mid + 1;
            } else end = mid;
        }

        return start;
    }
}
