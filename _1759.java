import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1759 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pick = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        String[] pickSt = new String[total];
        boolean[] visited = new boolean[total];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            pickSt[i] = st2.nextToken();
        }

        Arrays.sort(pickSt);
        combi(pickSt, visited, 0, pick);

    }
    static void combi(String[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            String temp = "";
            boolean isInclude = false;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    if (arr[i].matches("[a | e | i | o | u]")) {
                        isInclude = true;
                    }
                    temp += arr[i];
                    cnt += arr[i].replaceAll(("[a | e | i | o | u]"), "").length();
                }
            }
            if(isInclude && cnt >= 2) {
                System.out.println(temp);
            }
        return;
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                combi(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}
