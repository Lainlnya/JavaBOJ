import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int total; // 총 길이
    static int[] arr; // 기본 배열
    static int num; // 찾을 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = Integer.parseInt(st.nextToken());
        arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = i + 1;
        }
        num = Integer.parseInt(st.nextToken());
        permutation(new ArrayList<Integer>(), num);
    }

    public static void permutation(ArrayList<Integer> list, int count) {
        if (count == 0) {
            for (int l : list) {
                System.out.print(l + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < total; i++) {
            if (list.contains(arr[i])) continue;

            list.add(arr[i]);
            permutation(list, count - 1);
            list.remove(list.size() - 1);
        }
    }
}
