import java.util.*;

class Solution {
    // mumu, soe, poe
    // 바로 앞 선수를 추월할 때 추월한 선수의 이름을 부름
    // 1등 선수의 이름은 불리지 않음
    // map을 써서 value를 바꾸는게 나을까 ?
    public String[] solution(String[] players, String[] callings) {
        int[] positions = new int[players.length];
        
        Map<String, Integer> winners = new HashMap<>();
        // map으로 저장
        for (int i = 0; i < players.length; i++) {
            winners.put(players[i], i);
            positions[i] = i;
        }
        
        for (String calling : callings) {
            int currentIndex = winners.get(calling);
            
            if (currentIndex > 0) {
                int prevIndex = currentIndex - 1;
                String prevPlayer = players[prevIndex];
                players[prevIndex] = calling;
                players[currentIndex] = prevPlayer;

                winners.put(calling, prevIndex);
                winners.put(prevPlayer, currentIndex);
            }
            
        }
        return players;
    }
}