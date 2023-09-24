import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb;
    static HashSet<String> resultSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        sb = new StringBuilder();
        resultSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if (M == depth) {
            String temp = "";
            for (int value : answer) {
                temp += (value + " ");
            }

            if (!resultSet.contains(temp)) {
                resultSet.add(temp);
                sb.append(temp + "\n");
            }

            return;
        }

        for (int i = idx; i < N; i++) {
            answer[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
