import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
    public static int[][] paper;
    public static int white;
    public static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Total = Integer.parseInt(br.readLine());
        paper = new int[Total][Total];

        for (int i = 0; i < Total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Total; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        quadTree(0, 0, Total);

        System.out.println(white);
        System.out.println(blue);
    }
    public static void quadTree(int x, int y, int size) {
        if (isSame(x, y, size)) {
            if (paper[x][y] == 1) {
                blue++;
            } else if(paper[x][y] == 0){
                white++;
            }
            return;
        }
        int newSize = size / 2;

        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);

    }

    public static boolean isSame(int x, int y, int size) {
        int tmp = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tmp != paper[i][j]) {
                    return false;
                };
            }
        }
        return true;
    }
}
