import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] wires = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            wires[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int wire : wires) {
            int pos = Collections.binarySearch(lis, wire);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos < lis.size()) {
                lis.set(pos, wire);
            } else lis.add(wire);
        }

        System.out.println(num - lis.size());

    }
}
