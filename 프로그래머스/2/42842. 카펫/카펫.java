import java.util.*;

class Solution {
    static ArrayList<Integer> arr;
    public int[] solution(int brown, int yellow) {
        arr = new ArrayList<>();
        // 1. 약수 찾기
        findMin(yellow);
        int len = arr.size();
        int target = brown + yellow;
        
        for (int i = 0; i < len; i++) {
            int start = arr.get(i);
            int end = yellow / arr.get(i);
            
            if ((start + 2) * (end + 2) == target) {
                return new int[]{end + 2, start + 2};
            }
        }
        
        
        return new int[]{3, 3};
    }
    
    // 약수 찾기
    public static void findMin(int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) arr.add(i);
        }
    }
}