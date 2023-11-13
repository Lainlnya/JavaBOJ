import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] deathNote;
    static int[] namesArray;
    static int peopleNum, noteWidth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        peopleNum = Integer.parseInt(st.nextToken());
        noteWidth = Integer.parseInt(st.nextToken());

        deathNote = new int[1001][1002]; // answer 저장할 배열
        namesArray = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            namesArray[i] = Integer.parseInt(br.readLine());
        }

        // -1로 채우기
        for (int i = 0; i < deathNote.length; i++) {
            Arrays.fill(deathNote[i], -1);
        }

        System.out.println(dfs(1, namesArray[0] + 1));
    }

    public static int dfs(int index, int grid) {
        if (index == peopleNum) return 0;

        int answer = deathNote[index][grid];

        if (answer != -1) return answer;

        // 다음 줄에 쓰는 경우
        int left = noteWidth - grid + 1;
        answer = left * left + dfs(index + 1, namesArray[index] + 1);

        if (grid + namesArray[index] <= noteWidth) {
            answer = Math.min(answer, dfs(index + 1, grid + namesArray[index] + 1));
        }

        deathNote[index][grid] = answer;
        return answer;
    };
}
