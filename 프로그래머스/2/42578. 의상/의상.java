// "종류" : 개수
// headgear : "yellow_hat", "green_turban" 2
// eyewear : "blue_sunglasses", "yellow_sunglasses" 2
// clothes: "pants" 1
// yellowhat bluesun/yellowyellow/green blue/ green yellow
// blue pants/ yellow pants
// yello blue pants/ yellowyellow pants/ greenblue pants/ green yellow pants
// 4 + 2 + 2
// 5 + 8 = 13
// 5, 2C1 * 2C1, 2C1 * 1C1, 2C1 * 2C1* 1C1
// 5, 4, 2, 4 => 15

// headgear : yellow_hat
// eyewear : bluesunglasses

import java.util.*;

class Solution {
    static int answer = 1;
    static HashMap<String, List<String>> combi;
    
    public int solution(String[][] clothes) {
        combi = new HashMap<>();
        
        for (String[] cloth: clothes) {
            if (combi.containsKey(cloth[1])) {
                List<String> temp = combi.get(cloth[1]);
                temp.add(cloth[0]);
                combi.put(cloth[1], temp);
            } else {
                combi.put(cloth[1], new ArrayList<>(Arrays.asList(cloth[0])));
            }
        }
        
        ArrayList<String> keyList = new ArrayList<>(combi.keySet());
        
        for (int i = 0; i < keyList.size(); i++) {
            answer *= (combi.get(keyList.get(i)).size() + 1);
        }
        
        return answer - 1;
    }
}