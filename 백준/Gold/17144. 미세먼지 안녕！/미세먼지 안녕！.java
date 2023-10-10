import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, column;
    static int[][]room;
    static int second;
    static int upper, under; // 공기청정기 지점
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());
        room = new int[row][column];


        upper = -1; under = -1;
        int[] machinePoint = new int[2];
        int index = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    machinePoint[index] = i;
                    index++;
                }

            }
        }
        upper = machinePoint[0];
        under = machinePoint[1];
        for (int i = 0; i < second; i++) {
            makeDust();
            upperWind(upper);
            underWind(under);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (room[i][j] != -1) {
                    answer += room[i][j];
                }
            }
        }

        System.out.println(answer);
    }
    // 반시계 방향
    public static void upperWind(int start) {
        int top = start;

        for (int x = top - 1; x > 0; x--) {
            room[x][0] = room[x - 1][0];
        }

        for (int y = 0; y < column - 1; y++) {
            room[0][y] = room[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            room[x][column - 1] = room[x + 1][column - 1];
        }

        for (int y = column - 1; y > 1; y--) {
            room[top][y] = room[top][y - 1];
        }

        room[top][1] = 0;
    }

    // 시계방향
    public static void underWind(int start){
        int bottom = start;

        for (int x = bottom + 1; x < row - 1; x++) {
            room[x][0] = room[x + 1][0];
        }

        for (int y = 0; y < column - 1; y++) {
            room[row - 1][y] = room[row - 1][y + 1];
        }

        for (int x = row - 1; x > bottom; x--) {
            room[x][column - 1] = room[x - 1][column - 1];
        }

        for (int y = column - 1; y > 1; y--) {
            room[bottom][y] = room[bottom][y - 1];
        }

        room[bottom][1] = 0;
    }

    public static void makeDust() {
        int[][] dustRoom = new int[row][column];

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (room[i][j] > 0) {
                    int amount = room[i][j] / 5;
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < row && nc >= 0 && nc < column && room[nr][nc] != -1) {
                            dustRoom[nr][nc] += amount;
                            count++;
                        }
                    }

                    room[i][j] -= amount * count;
                }
                dustRoom[i][j] += room[i][j];
            }
        }
        // 복사
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                room[i][j] = dustRoom[i][j];
            }
        }
    }
}
