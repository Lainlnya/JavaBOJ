import java.util.*;

class Solution {
    // 이거 뒤에서부터 계산해야겠군
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(numbers[i]);
                answer[i] = -1;
            } else if (numbers[i] < stack.peek()) {
                answer[i] = stack.peek();
                stack.push(numbers[i]);
            } else {
                while (!stack.isEmpty() && numbers[i] >= stack.peek()) {
                    stack.pop();
                }
                
                if (stack.isEmpty()) answer[i] = -1;
                else answer[i] = stack.peek();
                stack.push(numbers[i]);
            }
        }
        
        return answer;
    }
}