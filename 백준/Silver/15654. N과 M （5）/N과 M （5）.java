import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열
public class Main {
    static int N; // 자연수 개수
    static int M; // 고를 수
    static int[] arr; // 재시해준 배열
    static int[] answer; // 만들어갈 배열
    static StringBuilder sb;
    static boolean[] visited; // 방문처리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        sb = new StringBuilder();
        visited = new boolean[N];

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
            for (int value : answer) {
                sb.append(value + " ");
            }
            sb.append("\n");
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
