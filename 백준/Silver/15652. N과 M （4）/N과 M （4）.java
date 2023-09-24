import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 중복 조합
    static int total;
    static int[] arr;
    static int pick;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());
        pick = Integer.parseInt(st.nextToken());
        arr = new int[pick];
        sb = new StringBuilder();
        visited = new boolean[total + 1];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if (pick == depth) {
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= total; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
