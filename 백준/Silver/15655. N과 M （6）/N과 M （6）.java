import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 조합
    static int N; // 자연수 개수
    static int M; // 고른 개수
    static int[] arr; // 주어진 배열
    static int[] answer; // 만들 배열
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순을 위한 sort
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if (M == depth) {
            for (int value : answer) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            answer[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
