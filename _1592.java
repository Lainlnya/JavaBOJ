import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int ball = Integer.parseInt(st.nextToken());
        int[] personList = new int[person];
        int[] countList = new int[person];
        int result = 0, pointer = 0;

        for (int i = 0; i < person; i++) {
            personList[i] = (i + 1);
        }

        while (true) {
            if (countList[pointer] == 0) {
                countList[pointer]++;
            } else if (countList[pointer] % 2 == 1) {
                pointer += ball;
                if (pointer > person - 1) pointer -= person;
                countList[pointer]++;
            } else {
                pointer -= ball;
                if (pointer < 0) pointer += person;
                countList[pointer]++;
            }

            if (countList[pointer] == count) {
                break;
            }

            result++;
        }
        System.out.println(result);
    }
}
