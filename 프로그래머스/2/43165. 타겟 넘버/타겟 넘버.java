class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        count = 0;
        dfs(0, 0, numbers, target);
        
        return count;
    }
    
    public static void dfs(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        
        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
}