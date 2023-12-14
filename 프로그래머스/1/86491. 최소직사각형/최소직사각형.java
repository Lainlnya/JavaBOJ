class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        
        for (int[] size : sizes) {
            int curMax = Math.max(size[0], size[1]);
            int curMin = Math.min(size[0], size[1]);
            
            width = Math.max(curMax, width);
            height = Math.max(curMin, height);
        }
        
        return width * height;
    }
}