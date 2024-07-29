import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < caseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String info = st.nextToken();

            if (info.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        Object[] nameArr = set.toArray();
        Arrays.sort(nameArr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < set.size(); i++) {
            sb.append(nameArr[i] + "\n");
        }

        System.out.println(sb);
    }
}
