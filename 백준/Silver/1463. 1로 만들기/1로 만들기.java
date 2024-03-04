import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] calcuX = new int[X + 1];

        for (int i = 2; i < calcuX.length; i++) {
            calcuX[i] = calcuX[i - 1] + 1;

            if (i % 3 == 0) {
                calcuX[i] = Math.min(calcuX[i], calcuX[i / 3] + 1);
            }
            if (i % 2 == 0) {
                calcuX[i] = Math.min(calcuX[i], calcuX[i / 2] + 1);
            }
        }
        System.out.println(calcuX[X]);
    }
}