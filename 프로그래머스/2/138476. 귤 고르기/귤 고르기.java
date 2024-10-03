import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int piece : tangerine) {
            if (map.containsKey(piece)) {
                map.put(piece, map.get(piece) + 1);
            } else map.put(piece, 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int limit = k;
        aa: for (int key : keySet) {
            if (limit >= map.get(key)) {
                limit -= map.get(key);
                answer++;
            } else if (limit > 0 && limit < map.get(key)) {
                limit = 0;
                answer++;
            } else if (limit == 0) break aa;
        }
        
        return answer;
    }
}