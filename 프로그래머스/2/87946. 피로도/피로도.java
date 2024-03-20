class Solution {
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        answer = 0;
        
        dfs(k, 0, dungeons);
        return answer;
    }
    
    public static void dfs(int k, int count, int[][] dungeons) {
        answer = Math.max(answer, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}