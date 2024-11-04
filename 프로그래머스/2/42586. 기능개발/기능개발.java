import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> tempAns = new ArrayList<>();
        
        for (int i = progresses.length - 1; i >= 0; i--) {
            int seconds = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            stack.push(seconds);
        }
        
        while (!stack.isEmpty()) {
            int peek = stack.peek();
            int cnt = 0;
            
            while (!stack.isEmpty() && peek >= stack.peek()) {
                stack.pop();
                cnt++;
            }
            tempAns.add(cnt);
        }

        int[] answer = new int[tempAns.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tempAns.get(i);
        }
        
        return answer;
    }
}