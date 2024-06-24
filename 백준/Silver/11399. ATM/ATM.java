import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int personNum = Integer.parseInt(br.readLine());

        int[] people = new int[personNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < personNum; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(greedy(people));
    }

    private static int greedy(int[] people) {
        int acc = 0, answer = 0;
        // 작은 것부터 sort
        Arrays.sort(people);

        for(int person: people) {
            acc += person;
            answer += acc;
        }

        return answer;
    }
}
