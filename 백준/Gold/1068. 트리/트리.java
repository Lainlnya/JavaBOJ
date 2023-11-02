import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int nodeNum, root, leaf;
    static int removeNode;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeNum = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[nodeNum];
        leaf = 0;

        for (int i = 0; i < nodeNum; i++) {
            tree.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        for (int i = 0; i < nodeNum; i++) {
            int node = Integer.parseInt(st.nextToken()); // 0
            if (node == -1) {
                root = i;
            } else {
                tree.get(node).add(i);
            }
        }

        removeNode = Integer.parseInt(br.readLine());
        visited[removeNode] = true;

        if (removeNode == root) {
            System.out.println(0);
            System.exit(0);
        }
        
        dfs(root);

        System.out.println(leaf);
    }

    static void dfs(int num) {
        // 방문한 적 없다면, 방문처리
        boolean flag = true;


        for (int i = 0; i < tree.get(num).size(); i++) {
            if (visited[tree.get(num).get(i)]) continue;
            flag = false;

            visited[tree.get(num).get(i)] = true;

            dfs(tree.get(num).get(i));
        }
        if (flag) leaf ++;
    }
}
