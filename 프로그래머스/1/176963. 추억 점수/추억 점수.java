import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> score = new HashMap<>();
        int[] answer = new int[photo.length];
        
        // key value로 묶어서 hash로 저장
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            int sumScore = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (score.containsKey(photo[i][j])) {
                    sumScore += score.get(photo[i][j]);
                }
            }
            answer[i] = sumScore;
        }
        
        return answer;
    }
}