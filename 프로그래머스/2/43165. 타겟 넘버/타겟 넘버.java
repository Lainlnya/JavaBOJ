class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        powerSet(0, target, numbers);
        return answer;
    }
    
    public static void powerSet(int idx, int target, int[] numbers) {
        if (idx == visited.length) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) sum += numbers[i];
                else sum -= numbers[i];
            }
            
            if (sum == target) answer++;    
            return;
        }
        
        visited[idx] = true;
        powerSet(idx + 1, target, numbers);
        visited[idx] = false;
        powerSet(idx + 1, target, numbers);
    }
}