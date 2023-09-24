import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 순열
    static int N; // 자연수 개수
    static int M; // 고를 수
    static int[] arr; // 주어진 배열
    static int[] answer; // 구할 배열
    static boolean[] visited; // 방문 확인 배열
    static StringBuilder sb;
    static HashSet<String> resultSet; // 중복 체크를 위한 HashSet

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
        resultSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (M == depth) {
            String temp = "";
            for (int value : answer) {
                temp += (value + " ");
            }

            if (!resultSet.contains(temp)) {
                resultSet.add(temp);
                sb.append(temp).append("\n");
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
