import java.util.*;
import java.io.*;

public class Main {
    static int[][] city;
    static ArrayList<int[]> chicken, distance;
    static int[][] selected;
    static boolean[] visited;
    static int notClosed, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityRow = Integer.parseInt(st.nextToken());
        notClosed = Integer.parseInt(st.nextToken());

        city = new int[cityRow][cityRow];
        chicken = new ArrayList<>();
        distance = new ArrayList<>(); // 실제 거리를 담기 위함
        selected = new int[notClosed][2]; // 선택 당한 항목 중 고르기 위함
        answer = Integer.MAX_VALUE; // 가장 적은 값을 찾기 위한 답

        // 입력
        for (int i = 0; i < city.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < city.length; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) chicken.add(new int[]{i, j});
                if (city[i][j] == 1) distance.add(new int[]{i, j});
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(answer);
    }

    // 경우의 수 계산
    public static void dfs(int idx, int depth) {
        if (depth == notClosed) {
            getDistance(); // 거리 계산
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = chicken.get(i);
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    // 거리를 계산하는 함수
    public static void getDistance() {
        int eachValue = 0;
        for (int i = 0; i < distance.size(); i++) {
            int x = distance.get(i)[0], y = distance.get(i)[1];
            int home = Integer.MAX_VALUE;
            for (int j = 0; j < selected.length; j++) {
                home = Math.min(home, Math.abs(selected[j][0] - x) + Math.abs(selected[j][1] - y));
            }
            eachValue += home;
        }
        answer = Math.min(answer, eachValue);
    }
}
