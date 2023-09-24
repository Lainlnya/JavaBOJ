import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 중복순열
    static int total;
    static int[] arr;
    static int pick;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());
        pick = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        arr = new int[pick];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == pick) {
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= total; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
