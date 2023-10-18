import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sdoku;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 초기화
        sdoku = new int[9][9];
        answer = new StringBuilder();

        // 입력
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int row, int column) {
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer.append(sdoku[i][j] + " ");
                }
                answer.append("\n");
            }
            System.out.println(answer);
            System.exit(0);
        }

        int nextRow, nextColumn;

        if (column == 8) {
            nextRow = row + 1;
            nextColumn = 0;
        } else {
            nextRow = row;
            nextColumn = column + 1;
        }

        if (sdoku[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, column, i)) {
                    sdoku[row][column] = i;
                    dfs(nextRow, nextColumn);
                    sdoku[row][column] = 0;
                }
            }
        } else dfs(nextRow, nextColumn);
    }

    public static boolean check(int row, int column, int num) {
        for (int i = 0; i < 9; i++) {
            // row 확인
            if(sdoku[row][i] == num) {
                return false;
            }
            // column확인
            if (sdoku[i][column] == num) {
                return false;
            }
        }

        int sdokuRow = (row / 3) * 3;
        int sdokuColumn = (column / 3) * 3;

        // 3 * 3 확인
        for (int i = sdokuRow; i < sdokuRow + 3; i++) {
            for (int j = sdokuColumn; j < sdokuColumn + 3; j++) {
                if (sdoku[i][j] == num) return false;
            }
        }

        return true;
    }
}
