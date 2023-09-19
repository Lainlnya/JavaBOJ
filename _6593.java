import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6593 {
    static int floor;
    static int row;
    static int column;
    static int[][][] sangbum;

    static int[] dr = {1, -1, 0, 0, 0, 0}; // x좌표 동서남북상하
    static int[] dc = {0, 0, -1, 1, 0, 0}; // y좌표
    static int[] dl = {0, 0, 0, 0, 1, -1}; // z좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (br.readLine() == "0 0 0") {
            StringTokenizer st = new StringTokenizer(br.readLine());
            floor = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            column = Integer.parseInt(st.nextToken());

            sangbum = new int[floor + 1][row + 1][column + 1];

            for (int i = 0; i < floor; i++) {
                
            }


        }


    }
}
