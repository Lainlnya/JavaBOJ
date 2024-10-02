import java.util.*;


class Solution {
    public int solution(String word) {
        int answer = word.length();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("E", 1);
        map.put("I", 2);
        map.put("O", 3);
        map.put("U", 4);
        int[] count = new int[]{781, 156, 31, 6, 1};
        int k = 0;
        for (int i = 0; i < word.length(); i++) {
            answer += count[k++] * map.get(Character.toString(word.charAt(i)));
        }

        return answer;
    }
}