import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        // a to z 까지 전부 char 리스트로 만들어놓고, 그게 없는건 0으로 만들기
        // index를 더할 때 해당 숫자가 0인건 건너뛰고 더하기
        // 이후에 전부 더하기
        
        // 알파벳 저장
        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            alphabet.add((char)('a' + i));
        }
        
        // 스킵리스트 없애기
        char[] skipList = skip.toCharArray();
        for (char one: skipList) {
            alphabet.remove(Character.valueOf(one)); 
        }
        
        // 숫자 더하기
        char[] addedList = s.toCharArray();
        for (int i = 0; i < addedList.length; i++) {
            int changedNum = (alphabet.indexOf(addedList[i]) + index) % alphabet.size();
            
            addedList[i] = alphabet.get(changedNum);
        }
        
        return new String(addedList);
    }
}