import java.util.*;

class Solution {
    // 기록o => 더 많이 준 사람이 받기
    // 기록이 없거나 같거나 선물지수가 더 큰 사람이 받기
    // 선물지수 : 이번 달까지 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값
    // 선물 지수가 같다면 다음 달에 선물을 주고 받지 않음
    public static Map<String, Integer> friendsMap;
    public int solution(String[] friends, String[] gifts) {
        friendsMap = new HashMap<>();
        int ans = 0;
        // 선물지수
        int[] giftDegree = new int[friends.length];
        // 선물 주고 받은 횟수
        int[][] giftGraph = new int[friends.length][friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            friendsMap.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftDegree[friendsMap.get(giftName[0])]++;
            giftDegree[friendsMap.get(giftName[1])]--;
            
            giftGraph[friendsMap.get(giftName[0])][friendsMap.get(giftName[1])]++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int num = 0;
            
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                
                if (giftGraph[i][j] > giftGraph[j][i] || 
                   (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
                    num++;
                }
            }
            if (num > ans) ans = num;
        }

        return ans;
    }
}