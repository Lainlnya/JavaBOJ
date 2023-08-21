import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 3

        for (int t = 0;  t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            int[] tree = new int[num]; // 통나무 배열
            int[] changeTree = new int[tree.length];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < tree.length; i++) { // 통나무 입력
                tree[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tree);
            if (tree.length % 2 == 1) { // length가 홀수일 경우
                changeTree[0] = tree[tree.length - 1];
                int len = tree.length - 2; // 5
                int j = 1;
                while (len >= 0) {
                    changeTree[j] = tree[len--];
                    changeTree[tree.length - j] = tree[len--];
                    j++;
                }
            } else {
                int len = tree.length - 1;
                int j = 0;
                while (len >= 0) {
                    changeTree[j] = tree[len--];
                    changeTree[tree.length - 1 - j] = tree[len--];
                    j++;
                }
            }

            int maxValue = 0;
            for (int i = 1; i < changeTree.length; i++) {
                int tempMax = Math.abs(changeTree[i - 1] - changeTree[i]);
                if (tempMax > maxValue) {
                    maxValue = tempMax;
                }
            }
            int lastValue = Math.abs(changeTree[changeTree.length - 1] - changeTree[0]);
            maxValue = lastValue > maxValue ? lastValue : maxValue;
            System.out.println(maxValue);

        } // 테케 끝
    }
}
