import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int placeSize; // 공간의 크기
    static int[][] place; // 공간
    static boolean[][] visited;
    static int sharkX, sharkY, time = 0, sharkSize = 2; // 상어의 위치, 시간, 현재 위치
    static int[] dr = {1, -1, 0, 0}; // 좌 우 상 하
    static int[] dc = {0, 0, 1, -1};
    static class Fish implements Comparable<Fish> {
        int x, y, distance;
        Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            // 1. 가장 가까운 순서, 2. 가장 위(x), 3. 가장 왼쪽(y)
            if (distance == o.distance) {
                // 가장 위
                if (x == o.x) {
                    // 가장 왼쪽
                    if (y == o.y) {
                        return 0;
                    }
                    return y - o.y;
                } else {
                    return x - o.x;
                }
            } else {
                // 가장 가까운 곳
                return distance - o.distance;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        placeSize = Integer.parseInt(br.readLine());
        place = new int[placeSize][placeSize];
        visited = new boolean[placeSize][placeSize];

        // 입력
        for (int i = 0; i < placeSize; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < placeSize; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                if (place[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        bfs(sharkX, sharkY);
        System.out.println(time);
    }

    public static void bfs(int x, int y) {
        int eaten = 0;

        while (true) {
            Queue<Fish> queue = new ArrayDeque<>();
            List<Fish> preyList = new ArrayList<>();
            visited = new boolean[placeSize][placeSize];

            queue.add(new Fish(x, y, 0));
            visited[x][y] = true;

            while(!queue.isEmpty()) {

                Fish target = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = target.x + dr[i];
                    int nc = target.y + dc[i];

                    if (nr >= 0 && nr < placeSize && nc >= 0 && nc < placeSize) {
                        if (!visited[nr][nc] && place[nr][nc] <= sharkSize) {
                            visited[nr][nc] = true;
                            queue.offer(new Fish(nr, nc, target.distance + 1));
                            // 0이 아니고 아기 상어의 크기보다 작아야 먹을 수 있음
                            if (place[nr][nc] != 0 && place[nr][nc] < sharkSize) {
                                preyList.add(new Fish(nr, nc, target.distance + 1));
                            }
                        }
                    }
                }
            }

            // 잡아 먹을 먹이가 없으면 종료
            if (preyList.isEmpty()) {
                break;

            } else {
                Collections.sort(preyList);
                Fish eatenFish = preyList.get(0);

                time += eatenFish.distance;
                eaten++;

                place[x][y] = 0;
                x = eatenFish.x;
                y = eatenFish.y;
                place[x][y] = 9;

                if (sharkSize == eaten) {
                    sharkSize++;
                    eaten = 0;
                }
            }

        }
    }
}
