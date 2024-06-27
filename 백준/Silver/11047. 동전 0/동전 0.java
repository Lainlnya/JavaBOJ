import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinNum = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] coins = new int[coinNum];

        for (int i = coinNum - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (money != 0) {
            answer += (money / coins[count]);
            money %= coins[count];
            count++;
        }

        System.out.println(answer);
    }
}
