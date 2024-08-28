import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        char[][] arr = new char[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = ' ';
            }
        }

        pattern(arr, num, 0, 0);

        for (int i = 0; i < num; i++) {
            for  (int j = 0; j < num; j++) {
                answer.append(arr[i][j]);
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    public static void pattern(char[][] arr, int size, int x, int y) {
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                else pattern(arr, newSize, x + i * newSize, y + j * newSize);
            }
        }
    }
}
