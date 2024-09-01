import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        TreeSet<Integer> treeSet = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            int zigzig = Integer.parseInt(st.nextToken());

            if (treeSet.isEmpty()) treeSet.add(zigzig);
            else if (treeSet.last() < zigzig) {
                treeSet.add(zigzig);
            } else {
                Integer lowerValue = treeSet.ceiling(zigzig);
                if (lowerValue != null) {
                    treeSet.remove(lowerValue);
                }
                treeSet.add(zigzig);
            }
        }

        System.out.println(treeSet.size());

    }

}
