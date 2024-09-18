import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};
        
        int q = s / n; 
        int r = s % n;
        
        int[] result = new int[n];
        Arrays.fill(result, q);
        
        for (int i = 0; i < r; i++) {
            result[i]++;
        }
        
        Arrays.sort(result);
        return result;
    }
}