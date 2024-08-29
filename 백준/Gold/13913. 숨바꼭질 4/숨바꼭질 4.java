import java.util.*;
import java.io.*;

public class Main {
    static int[] visited;
    static int[] dr = {-1, 1, 2};
    static ArrayList<Integer> road;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        road = new ArrayList<>();
        Arrays.fill(visited, -1); // -1 아직 방문 안함
        bfs(subin, sister);

        int prt = sister;
        while (prt != subin) {
            road.add(prt);
            prt = visited[prt];
        }

        road.add(subin);
        sb.append(answer + "\n");
        for (int i = answer; i >= 0; i--) {
            sb.append(road.get(i) + " ");
        }

        System.out.println(sb);
    }


    public static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.idx == end) {
                answer = cur.value;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nor = cur.idx;
                if (i == 2) nor *= dr[i];
                else nor += dr[i];

                if (nor >= 0 && nor < visited.length) {
                    if (visited[nor] == -1) {
                        visited[nor] = cur.idx;
                        queue.add(new Node(nor, cur.value + 1));
                    }
                }
            }
        }
    }

    public static class Node {
        int idx, value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
