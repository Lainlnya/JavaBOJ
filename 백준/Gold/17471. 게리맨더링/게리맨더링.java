import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static int areaNum; // 마을 개수
    static boolean[] visited; // 부분집합 만들 때 사용
    static int[] val; // 가치
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        areaNum = Integer.parseInt(br.readLine());

        val = new int[areaNum + 1];
        visited = new boolean[areaNum + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= areaNum; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList<>();
        for (int i = 0; i <= areaNum; i++) {
            arr.add(new ArrayList<Integer>());

            if (i != 0) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                arr.get(i).add(i);
                for (int j = 0; j < num; j++) {
                    int conn = Integer.parseInt(st.nextToken());
                    arr.get(i).add(conn);
                }
            }
        }

        divide(1);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(answer);
    }

    public static void divide(int idx) {
        if (idx == areaNum) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();

            for (int i = 1; i <= areaNum; i++) {
                if (visited[i]) {
                    listA.add(i);
                } else listB.add(i);
            }
            // 하나라도 비어있으면 안됨
            if (listA.isEmpty() || listB.isEmpty()) {
                return;
            }
            // 여기서 인구 수 체크하기
            if (checkBfs(listA) && checkBfs(listB)) {
                int aNum = 0, bNum = 0;
                for (int i = 0; i < listA.size(); i++) {
                    aNum += val[listA.get(i)];
                }

                for (int i = 0; i < listB.size(); i++) {
                    bNum += val[listB.get(i)];
                }

                answer = Math.min(answer, Math.abs(aNum - bNum));
            }
            return;
        }

        visited[idx] = true;
        divide(idx + 1);
        visited[idx] = false;
        divide(idx + 1);
    }

    public static boolean checkBfs(List<Integer> list) {
        if (list.isEmpty()) return false;

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        queue.offer(list.get(0));
        visited.add(list.get(0));

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : arr.get(current)) {
                if (list.contains(neighbor) && !visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return visited.size() == list.size();
    }

}
