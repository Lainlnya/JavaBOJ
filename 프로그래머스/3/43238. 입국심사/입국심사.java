import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1, end = Long.MIN_VALUE;
        for (int time : times) {
            end = Math.max(time, end);
        }
        
        end = end * n;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long pass = 0;
            
            for (int time : times) {
                pass += (mid / time);
                if (pass >= n) break;
            }
            
            if (pass >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
        
    }
}