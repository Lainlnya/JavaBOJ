import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[]{51, 51, -1, -1};
        
        int horizontal = 0;
        
        for (String wall : wallpaper) {
            char[] wallChar = wall.toCharArray();
            
            for (int i = 0; i < wallChar.length; i++) {
                if (wallChar[i] == '#') {
                    answer[0] = Math.min(answer[0], horizontal);
                    answer[1] = Math.min(answer[1], i);
                    answer[2] = Math.max(answer[2], horizontal + 1);
                    answer[3] = Math.max(answer[3], i + 1);
                }        
            }
            
            horizontal++;
        }
        
        return answer;
    }
}