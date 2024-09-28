import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int gameNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < gameNum; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            String seq = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < seq.length(); j++) {
                if (map.containsKey(seq.charAt(j))) {
                    map.get(seq.charAt(j)).add(j);
                } else {
                    map.put(seq.charAt(j), new ArrayList<>());
                    map.get(seq.charAt(j)).add(j);
                }
            }

            for (Character c :map.keySet()) {
                int size = map.get(c).size();
                if (size < target) continue;
                else if (size == target) {
                    min = Math.min(min, map.get(c).get(size - 1) - map.get(c).get(0) + 1);
                    max = Math.max(max, map.get(c).get(size - 1) - map.get(c).get(0) + 1);
                }
                else {
                    ArrayList<Integer> arr = map.get(c);
                    int start = 0;
                    int end = target - 1;

                    while (end < arr.size()) {
                        int num = arr.get(end) - arr.get(start) + 1;

                        min = Math.min(min, num);
                        max = Math.max(max, num);
                        start++;
                        end++;
                    }
                }
            }
            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) sb.append(-1 + "\n");
            else sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }
}
