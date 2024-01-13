import java.util.*;
import java.io.*;

public class Main {
    static char[][] sweets;
    static int size;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        sweets = new char[size][size];
        answer = 0;
        // 입력
        for (int i = 0; i < sweets.length; i++) {
            sweets[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                change(i, j, i, j + 1);
                find();
                change(i, j + 1, i, j);
            }
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                change(i, j, i + 1, j);
                find();
                change(i + 1, j, i, j);
            }
        }

        System.out.println(answer);
    }

    public static void change(int x1, int y1, int x2, int y2) {
        char temp = sweets[x1][y1];
        sweets[x1][y1] = sweets[x2][y2];
        sweets[x2][y2] = temp;
    }

    public static void find() {
        // 행
        for (int i = 0; i < size; i++) {
            int count = 1;

            for (int j = 0; j < size - 1; j++) {
                if (sweets[i][j] == sweets[i][j + 1]) {
                    count++;
                    answer = Math.max(count, answer);
                } else {
                    count = 1;
                }
            }
        }

        // 열
        for (int i = 0; i < size; i++) {
            int count = 1;

            for (int j = 0; j < size - 1; j++) {
                if (sweets[j][i] == sweets[j + 1][i]) {
                    count++;
                    answer = Math.max(count, answer);
                } else {
                    count = 1;
                }
            }
        }
    }
}