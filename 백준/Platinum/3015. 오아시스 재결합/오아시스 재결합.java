import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] people = new int[Integer.parseInt(br.readLine())];

        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(countBridges(people));
    }

    public static long countBridges(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        long visible = 0;

        for (int height: heights) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                int[] top = stack.pop();
                visible += top[1];
                if (top[0] == height) {
                    count += top[1];
                }
            }

            if (!stack.isEmpty()) {
                visible += 1;
            }

            stack.push(new int[]{height, count});
        }

        return visible;
    }
}
