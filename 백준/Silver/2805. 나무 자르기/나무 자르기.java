import java.io.*;
import java.util.*;

public class Main {

    // 46, 42, 40, 26, 4
    // 40 중간값 -> 6 + 2 = 8 -> 높이
    // 높이가 자를 수 있는 것보다 작으면 중간값 낮추기
    // 높이가 자를 수 있는 것보다 크면 중간값 높이기
    // 높이가 원하는 값이 나오면 return
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeNum = Integer.parseInt(st.nextToken()); // 나무의 수 N
        long wantedTree = Long.parseLong(st.nextToken()); // 원하는 길이의 나무

        int[] trees = new int[treeNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < treeNum; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬된 상태
        Arrays.sort(trees);

        long start = 0, end = trees[treeNum - 1];
        long result = 0;
        while (start <= end) {
            long goods = 0;
            long mid = start + (end - start) / 2;

            for (int tree : trees) {
                if (tree > mid) {
                    goods += (tree - mid);
                }
            }

            if (goods < wantedTree) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
