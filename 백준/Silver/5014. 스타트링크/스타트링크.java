import java.util.*;
import java.io.*;

// 총 F층, 현재 S층, 스타트링크 위치 G층
// 위로 U층, 아래로 D층 => 해당하지 않으면 움직이지 않는다.
// G에 갈 수 없다면 "use the starts"를 출력

// 1층에서 10층으로 가려면 1, 3, 5, 7, 9, 8, 10
// 어떻게 갈 수 없다는걸 판단하지 ?
// 그럼 전체 숫자만큼의 배열
// 만약 해당 거기에 값이 있다면 pass 아니면 숫자 더하기
public class Main {
    static int[] link;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        link = new int[total + 1];
        queue = new LinkedList<>();
        queue.add(start);

        elevator(start, up, down);

        if (start == end) System.out.println(0);
        else if (link[end] == 0) System.out.println("use the stairs");
        else System.out.println(link[end]);
    }

    public static void elevator(int start, int up, int down) {
        // 그러니까 전 것보다 하나 더 추가해줘야 하네,
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (start != current + up && current + up < link.length && link[current + up] == 0) {
                link[current + up] = link[current] + 1;
                queue.add(current + up);
            }

            if (start != current - down && current - down > 0 && link[current - down] == 0) {
                link[current - down] = link[current] + 1;
                queue.add(current - down);
            }
        }
    }
}
