import java.util.*;
import java.io.*;
public class Main {
    // 숫자 개수
    static int numberLen;
    // 합
    static int total;
    // 숫자를 담을 배열
    static int[] numberArr;
    // 합을 테스트할 배열
    static int[] testArr;
    // 선택할 숫자
    static int pickNum;
    // 가능성 있는 숫자
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberLen = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());
        numberArr = new int[numberLen];
        count = 0;

        int i = 0;
        st = new StringTokenizer(br.readLine());
        while (i < numberLen) {
            numberArr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        pickNum = 1;
        for (int j = 0; j < numberLen; j++) {
            testArr = new int[pickNum];
            dfs(0, 0);
            pickNum++;
        }

        System.out.println(count);

    }

    // 1개여도 되고, 2개여도 되고, 3개여도 된다.
    public static void dfs(int idx, int depth) {
        if (depth == pickNum) {
            int answer = 0;
            for (int value : testArr) {
                answer += value;
            }
            if (answer == total) count++;
            return;
        }
        for (int i = idx; i < numberArr.length; i++) {
            testArr[depth] = numberArr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
