import java.util.*;
import java.io.*;
public class Main {
    // 숫자 담을 배열(0~9)
    static int[] numArray;
    // 맞는지 테스트할 배열
    static int[] testArray;
    // 방문처리를 위한 배열
    static boolean[] visited;
    // 부등호 개수
    static int num;
    static int[] versa;
    static ArrayList<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new ArrayList<>();
        num = Integer.parseInt(br.readLine());
        // 들어갈 수 있는 숫자
        numArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 들어갈 수 있는 숫자는 num + 1개 이니까(부등호 앞뒤로)
        testArray = new int[num + 1];
        // 방문 처리를 위한 배열
        visited = new boolean[numArray.length];
        versa = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // <는 0으로, >는 1으로 저장
        int i = 0;
        while (i < num) {
            if (st.nextToken().equals("<")) {
                versa[i] = 0;
            } else versa[i] = 1;
            i++;
        }

        dfs(0);
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    public static void dfs(int depth) {
        if (num + 1 == depth) {
            if (checkCondition()) {
                StringBuilder temp = new StringBuilder();
                for (int value : testArray) {
                    temp.append(value);
                }
                answer.add(temp.toString());
            }
            return;
        }

        for (int i = 0; i < numArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                testArray[depth] = numArray[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static boolean checkCondition() {
        for (int j = 0; j < num; j++) {
            if (versa[j] == 0 && (testArray[j] >= testArray[j + 1])) {
                return false;
            } else if (versa[j] == 1 && (testArray[j] <= testArray[j + 1])) {
                return false;
            }
        }
        return true;
    }
}
