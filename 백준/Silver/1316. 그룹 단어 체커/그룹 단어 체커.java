import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < num; i++) {
            boolean isGroup = true;

            String checkGroup = br.readLine();
            ArrayList<Character> list = new ArrayList<>();
            list.add(checkGroup.charAt(0));

            for (int j = 1; j < checkGroup.length(); j++) {
                if (checkGroup.charAt(j - 1) == checkGroup.charAt(j)) continue;
                else {
                    if (list.contains(checkGroup.charAt(j))) {
                        isGroup = false;
                    } else list.add(checkGroup.charAt(j));
                }
            }
            if (isGroup) answer++;
        }

        System.out.println(answer);
    }
}
