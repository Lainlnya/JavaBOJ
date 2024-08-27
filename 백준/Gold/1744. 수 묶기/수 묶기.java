import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        int answer = 0;
        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp <= 0) minus.add(temp);
            else if (temp == 1) answer += 1;
            else plus.add(temp);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int plusSize = plus.size();
        int minusSize = minus.size();
        for (int i = 0; i < plusSize - 1; i += 2) {
            answer += plus.get(i) * plus.get(i + 1);
        }

        for (int i = 0; i < minusSize - 1; i += 2) {
            answer += minus.get(i) * minus.get(i + 1);
        }

        if (plusSize % 2 == 1) answer += plus.get(plusSize - 1);
        if (minusSize % 2 == 1) answer += minus.get(minusSize - 1);

        System.out.println(answer);
    }
}
