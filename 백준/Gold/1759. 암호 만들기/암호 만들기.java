import java.util.*;
import java.io.*;
public class Main {
    // 비밀번호 만들 길이
    static int passwordLen;
    // 주어진 문자 수
    static int letterLen;
    // 주어진 문자
    static String[] letter;
    // 가능한 비밀번호 담을 칸
    static String[] temp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        passwordLen = Integer.parseInt(st.nextToken()); // 4
        letterLen = Integer.parseInt(st.nextToken()); // 6
        letter = new String[letterLen];
        temp = new String[passwordLen];
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int i = 0;
        while (i < letterLen) {
            letter[i] = st.nextToken();
            i++;
        }
        // ===== 입력끝
        Arrays.sort(letter);
        dfs(0, 0);
        System.out.println(sb);
    }

    // 한 개의 모음 (a, e, i, o, u), 두 개의 자음
    public static void dfs(int idx, int depth) {
        if (depth == passwordLen) {
            String answer = "";
            for (String value : temp) {
                answer += value;
            }
            if (answer.matches(".*[aeiou].*") && transferLetter(answer)) {
                sb.append(answer + "\n");
            }
            return;
        }

        for (int i = idx; i < letterLen; i++) {
            temp[depth] = letter[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static boolean transferLetter(String input) {
        return input.replaceAll("[aeiou]", "").length() >= 2;
    }
}
