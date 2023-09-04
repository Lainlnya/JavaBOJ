import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 자연수 N
    static int M; // 뽑을 수 M
    static int[] arr; // 기존 배열
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        } // 입력 끝

        permuation(new ArrayList<Integer>(), M);
        System.out.println(sb);
    }

    // 순열
    public static void permuation(ArrayList<Integer> list, int count) {
        // 기저조건
        if (count == 0) {
            for (int l : list) {
                sb.append(l + " ");
            }
            sb.append("\n");
            return;
        }

        // 재귀조건
        for (int i = 0; i < N; i++) {
            list.add(arr[i]);
            permuation(list, count - 1);
            list.remove(list.size() - 1);
        }
    }
}
