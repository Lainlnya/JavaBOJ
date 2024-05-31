import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removedNum = 0;
        String start = s;
        
        while (!start.equals("1")) {
            count++;
            
            // 0을 삭제하고 남은 이진변환의 개수 세기
            String before = start;
            start = start.replace("0", "");
            int num = before.length() - start.length();
            removedNum += num;
            
            // 이진변환
            start = Integer.toBinaryString(start.length());
        }
        
        return new int[]{count, removedNum};
    }
}