import java.util.*;

class Solution {
    public String solution(String s) {
        String[] numString = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < numString.length; i++) {
            max = Math.max(Integer.parseInt(numString[i]), max);
            min = Math.min(Integer.parseInt(numString[i]), min);
        }
        
        return min + " " + max;
    }
}