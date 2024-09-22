import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] prev = new int[num];
        ArrayList<Integer> arr = new ArrayList<>();
        int[] idx = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            prev[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++) {
            int pos = Collections.binarySearch(arr, prev[i]);

            if (pos < 0) pos = -(pos + 1);

            if (pos < arr.size()) {
                arr.set(pos, prev[i]);
                idx[i] = pos;
            } else {
                arr.add(prev[i]);
                idx[i] = arr.size() - 1;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int lastIndex = arr.size() - 1;
        for (int i = num - 1; lastIndex >= 0 && i >= 0; i--) {
            if (idx[i] != lastIndex) continue;

            lastIndex--;
            stack.add(prev[i]);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }


        System.out.println(arr.size());
        System.out.println(sb);
    }
}
