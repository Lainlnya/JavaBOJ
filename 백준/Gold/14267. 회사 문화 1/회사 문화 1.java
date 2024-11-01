import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static int[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int employeeNum = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        list = new ArrayList[employeeNum + 1];
        points = new int[employeeNum + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < employeeNum + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < employeeNum + 1; i++) {
            int parent = Integer.parseInt(st.nextToken());
            // 부모에 자식 추가
            if (parent != -1) list[parent].add(i);
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            points[num] += amount;
        }

        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < points.length; i++) {
            sb.append(points[i] + " ");
        }
        
        System.out.println(sb);

    }
    static void dfs(int idx) {
        for (int child : list[idx]) {
            points[child] += points[idx];
            dfs(child);
        }
    }
}
