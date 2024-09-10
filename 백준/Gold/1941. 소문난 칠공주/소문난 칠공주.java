import java.util.*;
import java.io.*;

public class Main {
    static char[][] princess = new char[5][5];
    static boolean[] visited = new boolean[7];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 7명을 담을 배열
    static int[] seven = new int[7];
    static int[] combiX = new int[26];
    static int[] combiY = new int[26];

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            princess[i] = br.readLine().toCharArray();
        }
        dfs(1, 0);
        
        System.out.println(answer);
    }

    // 조합 개수 세기
    public static void dfs(int idx, int depth) {
        if (depth == 7) {
            bfs(seven);
            return;
        }

        for (int i = idx; i <= 25; i++) {
            int row = (i - 1) / 5, column = (i - 1) % 5;
            seven[depth] = i;
            combiX[i] = row;
            combiY[i] = column;
            dfs(i + 1, depth + 1);
        }
    }

    public static void bfs(int[] combi) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[7];
        visited[0] = true;
        queue.add(combi[0]);

        int sCount = 0, count = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (princess[combiX[now]][combiY[now]] == 'S') sCount++;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && (combiX[now] + dx[i] == combiX[combi[j]])
                            && (combiY[now] + dy[i] == combiY[combi[j]])) {
                        visited[j] = true;
                        queue.add(combi[j]);
                        count++;
                    }
                }
            }
        }

        if (count == 7) {
            if (sCount >= 4) answer++;
        }
    }

}
