import java.util.*;
import java.io.*;

public class Main {
    // 총 6개, 내구도가 0인 칸의 개수가 2개 이상 => 종료
    // 1 2 1 2 1 2
    // 올리려는 칸이 0이 아니면 로봇을 올림, 이동하려고 해도 해당 칸이 1이상이야 함
    // 1: 1 2 1 2 1 2
        // 1(로봇) 1 2 1 2 1
    // 2: 0(로봇) 1 0(로봇) 2 1 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int half = Integer.parseInt(st.nextToken()); // 벨트 한 쪽
        int target = Integer.parseInt(st.nextToken()); // 타겟

        ArrayList<Integer> con = new ArrayList<>(); // 컨베이어 담을 큐
        ArrayList<Integer> robots = new ArrayList<>(); // 로봇의 위치를 담을 큐

        st = new StringTokenizer(br.readLine());
        // 큐에 입력
        for (int i = 0; i < half * 2; i++) {
            con.add(Integer.parseInt(st.nextToken()));
        }

        int impossible = 0;
        int step = 0;
        // 시작
        while (impossible < target) {
            step++;
            // 1. 일단 회전하며 로봇도 함께 이동
            con.add(0, con.remove(con.size() - 1));
            for (int i = 0; i < robots.size(); i++) {
                robots.set(i, robots.get(i) + 1);
            }

            // 내리는 위치에 있는 로봇 제거
            if (!robots.isEmpty() && robots.get(robots.size() - 1) == half - 1) {
                robots.remove(robots.size() - 1);
            }

            // 2. 한 칸 이동할 수 있다면 이동한다. 하지만 이동할 수 없다면 가만히 있는다.
            for (int i = robots.size() - 1; i >= 0; i--) {
                int current = robots.get(i);
                int next = current + 1;

                if (next < half && con.get(next) >= 1 && (i == robots.size() - 1 || robots.get(i + 1) != next)) {
                    robots.set(i, next);
                    con.set(next, con.get(next) - 1);
                }
            }

            if (!robots.isEmpty() && robots.get(robots.size() - 1) == half - 1) {
                robots.remove(robots.size() - 1);
            }


            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (con.get(0) > 0) {
                robots.add(0, 0); // 로봇 위치 추가
                con.set(0, con.get(0) - 1); // 컨베이어 내구도는 줄이기
            }

            impossible = 0;
            // 4. 내구도가 0인 칸의 개수가 k개 이상이라면 과정 종료
            for (int i = 0; i < con.size(); i++) {
                if (con.get(i) == 0) impossible++;
            }
        }

        System.out.println(step);
    }
}
