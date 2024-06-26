import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int marbleNum = Integer.parseInt(br.readLine());
        ArrayList<Integer> marbles = new ArrayList<>();

        // 추가
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < marbleNum; i++) {
            marbles.add(Integer.parseInt(st.nextToken()));
        }

        // 큰 것부터 내림차순 정리
        marbles.sort(Collections.reverseOrder());
        
        // 가장 처음 것과 두 번째 것으로 X1 만들고 2부터 gold 갱신해 나가기
        int level = marbles.get(0);
        int gold = marbles.get(0) + marbles.get(1);
        int[] marble = {level, gold};
        for (int i = 2; i < marbleNum; i++) {
            marble[1] += level + marbles.get(i);
        }

        System.out.println(marble[1]);
    }
}
