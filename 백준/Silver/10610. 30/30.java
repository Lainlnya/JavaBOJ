import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] thirtyArr = br.readLine().toCharArray();
        Arrays.sort(thirtyArr);

        int correctNum = 0;

        for (int i = thirtyArr.length - 1; i >= 0; i--) {
            correctNum += (thirtyArr[i] - '0');
            sb.append(thirtyArr[i]);
        }

        if (thirtyArr[0] == '0' && correctNum % 3 == 0) System.out.println(sb);
        else System.out.println(-1);
    }
}
