import java.io.*;

public class Main {
    static int egg;
    static int[][] info;
    // 최대 개수를 저장할 count 변수
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 일단 입력
        egg = Integer.parseInt(br.readLine());
        info = new int[10][2];
        count = 0;

        for (int i = 1; i <= egg; i++) {
            // 0번이 내구도, 1번이 무게
            String[] temp = br.readLine().split(" ");
            info[i] = new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
        }

        backTracking(1);
        System.out.println(count);
    }

    // 백트래킹 시작
    public static void backTracking(int x) {

        // 가장 오른쪽에 위치한 계란일 경우 종료
        if (x > egg + 1) return;

        for (int i = 1; i <= egg; i++) {
            // 이미 들고있는 것이 깨져있을 경우, 바로 오른쪽꺼 탐색하세요.
            if (info[x][0] <= 0) backTracking(x + 1);
            // 자기 자신이거나 찾은 것이 이미 깨져있을 경우 패스
            else if (x == i || info[i][0] <= 0) continue;
            else {

                info[x][0] -= info[i][1];
                info[i][0] -= info[x][1];

                backTracking(x + 1);

                info[x][0] += info[i][1];
                info[i][0] += info[x][1];
            }
        }

        // 최대 개수 구하는 방법
        int temp = 0;
        for (int i = 1; i <= egg; i++) {
            if (info[i][0] <= 0) temp++;
        }
        count = Math.max(count, temp);
    }
}
