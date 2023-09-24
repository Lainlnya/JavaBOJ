import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int subNum; // 과목수
    static int preNum; // 선수 조건 수
    static int[] degree;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue; // 위상 정렬 계산할 queue
    static int[] answer; // 결과 배열
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        subNum = Integer.parseInt(st.nextToken());
        preNum = Integer.parseInt(st.nextToken());
        degree = new int[subNum + 1];
        queue = new LinkedList<>();
        graph = new ArrayList<>();
        answer = new int[subNum + 1];
        count = 1;

        for (int i = 0; i <= subNum; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < preNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            degree[b]++;
        }

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.offer(i);
            answer[i] = count;
        }

        while (!queue.isEmpty()) {
            int nodeNum = queue.poll();

            List<Integer> list = graph.get(nodeNum); // 2, 3

            for (int i = 0; i < list.size(); i++) {
                degree[list.get(i)]--;
                if (degree[list.get(i)] == 0) {
                    queue.offer(list.get(i));
                    answer[list.get(i)] = answer[nodeNum] + 1;
                };
            }
        }

        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb);
    }
}