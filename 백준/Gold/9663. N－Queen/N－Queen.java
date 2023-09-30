import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int chessNum;
    static int count;
    static int[][] chess;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chessNum = Integer.parseInt(br.readLine());
        chess = new int[chessNum][chessNum];
        visited = new boolean[chessNum][chessNum];

        count = 0;
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int row) {
        if (row == chessNum) {
            count++;
            return;
        }

        for (int i = 0; i < chessNum; i++) {
            if (isSafe(row, i)) {
                chess[row][i] = 1;
                visited[row][i] = true;

                dfs(row + 1);

                // 백트래킹
                chess[row][i] = 0;
                visited[row][i] = false;
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if(visited[i][col]) return false;
        }

        for (int i = 0; i < col; i++) {
            if (visited[row][i]) return false;
        }

        //  왼쪽 위
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) return false;
        }

        // 오른쪽 위
        for (int i = row, j = col; i >= 0 && j < chessNum; i--, j++) {
            if (visited[i][j]) return false;
        }

        return true;
    }
}
