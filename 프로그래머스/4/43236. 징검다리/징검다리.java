import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = Integer.MIN_VALUE;
        
        int[] total = new int[rocks.length + 2];
        int[] gap = new int[total.length];
        
        for (int i = 1; i < total.length - 1; i++) {
            total[i] = rocks[i - 1];
        }
        total[rocks.length + 1] = distance;
        
        for (int i = 1; i < total.length; i++) {
            gap[i] = total[i] - total[i - 1];
        }
        
        int start = 0, end = distance;
        int mid = 0;
        
        while (start <= end) {
            int count = 0;
            int idx = 0;
            mid = (start + end) / 2;
            
            aa: for (int i = 1; i <= total.length - 1; i++) {
                // mid 보다 작으면 제거
                if (mid > total[i] - total[idx]) {
                    count++;
                    // 작지 않으면 다음거 계산
                } else {
                    idx = i;
                }
            }
            
            if (count > n) {
                end = mid - 1;
            } else {
                answer = Math.max(mid, answer);
                start = mid + 1;
            }
        }

        return answer;
    }
}