import java.util.*;
import java.io.*;

public class Main {
    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int x, y, row, column;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken()); // 4
        column = Integer.parseInt(st.nextToken()); // 2
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        map = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            int arrow = Integer.parseInt(st.nextToken());
            move(arrow);
        }
    }

//  1
//2 3 4
//  5
//  6

    // 0 < x < N (세로)
    // 0 < y < M (가로)
    public static void move(int arrow) {
        int nr = x + dr[arrow - 1];
        int nc = y + dc[arrow - 1];

        if (nr < 0 || nc < 0 || nr > column - 1 || nc > row - 1) return;

        change(nr, nc, arrow);
        x = nr;
        y = nc;

    }

    public static void change(int x, int y, int arrow) {
        int tmp = dice[3];
        switch(arrow) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }

        if(map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[3]);
    }
}
