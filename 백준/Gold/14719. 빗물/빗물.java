import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[] box = new int[column];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < column; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        // 1case: 3 0 1 4, start = 0, end 3
        for (int i = 1; i < column; i++) {
            int start = 0;
            int end = 0;

            for (int j = 0; j < i; j++) {
                if (box[j] > start) {
                    start = box[j];
                }
            }

            for (int j = i; j < column; j++) {
                if (box[j] > end) {
                    end = box[j];
                }
            }
            
            int criteria = Math.min(start, end);
            sum += Math.max(criteria - box[i], 0);
        }
        System.out.println(sum);
    }

}
