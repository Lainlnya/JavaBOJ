class Solution {
    static int[] sNumbers;
    static int sTarget;
    static int answer;
    public static int solution(int[] numbers, int target) {
        sNumbers = numbers;
        sTarget = target;
        answer = 0;
        dfs(0, 0);

        return answer;
    }

    public static void dfs(int depth, int sum) {
        // 빠져나갈 기저조건
        if (depth == sNumbers.length) {
            if (sum == sTarget) answer++;
            return;
        }

        dfs(depth + 1, sum + sNumbers[depth]);
        dfs(depth + 1, sum - sNumbers[depth]);
    }
}