import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        
        // HashMap 생성
        for (String num : phone_book) {
            hashMap.put(num, true);
        }
        
        for (String num : phone_book) {
            for (int i = 0; i < num.length(); ++i) {
                String temp = num.substring(0, i);
                if (hashMap.containsKey(temp)) return false;
            }
        }
        return true;
    }
}