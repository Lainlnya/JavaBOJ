import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문여부 확인
    static int[] lottos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int totalNum = Integer.parseInt(st.nextToken());
            if (totalNum == 0) break; // 나가는 조건

            visited = new boolean[totalNum];
            lottos = new int[6];
            int[] selection = new int[totalNum];

            for (int i = 0; i < totalNum; i++) {
                selection[i] = Integer.parseInt(st.nextToken());
            }

            dfs(selection, 0, 0);
            System.out.println();
        }

    }

    private static void dfs(int[] test, int index, int start) {
        if (index == 6) {
            for (int lotto : lottos) {
                System.out.print(lotto + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < test.length; i++) {
            lottos[index] = test[i];
            dfs(test, index + 1, i + 1);
        }
    }
}
