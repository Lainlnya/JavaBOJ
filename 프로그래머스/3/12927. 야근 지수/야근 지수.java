import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (true) {
            if (n == 0) break;
            int current = pq.poll();
            if (current == 0) break;
            pq.add(current - 1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        
        return answer;
    }
}