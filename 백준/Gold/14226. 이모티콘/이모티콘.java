import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        visited = new boolean[1001][1001];
        System.out.println(bfs(target));
    }

    public static int bfs (int target) {
        Queue<Emo> queue = new LinkedList<>();
        queue.add(new Emo(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            Emo now = queue.poll();

            if (now.current == target) return now.val;

            // 1. 복사해서 붙여넣기 한다
            if (!visited[now.current][now.current]) {
                visited[now.current][now.current] = true;
                queue.add(new Emo(now.current, now.current, now.val + 1));
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣는다.
            if (now.clip >= 0 && now.current + now.clip < 1001 && !visited[now.current + now.clip][now.clip]) {
                visited[now.current + now.clip][now.clip] = true;
                queue.add(new Emo(now.current + now.clip, now.clip, now.val + 1));
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (now.current - 1 >= 0 && !visited[now.current - 1][now.clip]) {
                visited[now.current - 1][now.clip] = true;
                queue.add(new Emo(now.current - 1, now.clip, now.val + 1));
            }
        }

        return 0;
    }

    public static class Emo {
        int current, clip, val;
        Emo(int current, int clip, int val) {
            this.current = current;
            this.clip = clip;
            this.val = val;
        }
    }
}