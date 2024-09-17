import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < num; i++) {
            int current = Integer.parseInt(br.readLine());
            if (treeSet.isEmpty()) treeSet.add(current);
            else {
                if (treeSet.last() < current) treeSet.add(current);
                else {
                    treeSet.remove(treeSet.ceiling(current));
                    treeSet.add(current);
                }
            }
        }
        System.out.println(num - treeSet.size());
    }
}
