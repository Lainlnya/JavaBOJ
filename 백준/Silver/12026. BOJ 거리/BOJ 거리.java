import java.util.*;
import java.io.*;

public class Main {
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int linkP = Integer.parseInt(br.readLine());
        char[] boj = br.readLine().toCharArray();
        char[] sequence = {'B', 'O', 'J'};
        distance = new int[linkP];
        // 최솟값을 구하기 위해서 우선은 전부 max 값으로
        Arrays.fill(distance, linkP * linkP);
        // 시작은 어차피 B이고 거리는 0이기에
        distance[0] = 0;

        for (int i = 0; i < boj.length - 1; i++) {
            for (int j = i + 1; j < boj.length; j++) {
                if (canMove(boj[i], boj[j])) {
                    distance[j] = Math.min(distance[j], (distance[i] + (j - i) * (j - i)));
                }
            }
        }

        System.out.println(distance[linkP - 1] == linkP * linkP ? -1 : distance[linkP - 1]);
    }

    private static boolean canMove(char current, char next) {
        return ((current == 'B' && next == 'O') ||
                (current == 'O' && next == 'J') ||
                (current == 'J' && next == 'B'));
    }
}
