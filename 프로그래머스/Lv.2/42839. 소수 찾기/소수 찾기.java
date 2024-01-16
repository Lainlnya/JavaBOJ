import java.util.*;

class Solution {
    static boolean[] visited = new boolean[7];
    static Set<Integer> set;
    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);

        System.out.println(set);

        for (int num : set) {
            if (num == 1 || num == 0) continue;
            else if (prime(num) == 0) answer++;

        }
        return answer;
    }

    // 조합
    public static void dfs(String numbers, String c, int depth) {
        if (depth > numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(c + numbers.charAt(i)));
                dfs(numbers, c + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    // 소수 찾기
    public static int prime(int findN) {
        int answer = 0;
        for (int i = 2; i <= Math.sqrt(findN); i++) {
            if (findN % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}