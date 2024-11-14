import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            answer = (answer * arr[i]) / gcp(answer, arr[i]);
        }
        
        return answer;
    }
    
    public static int gcp(int arr1, int arr2) {
        if (arr1 < arr2) {
            int temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        
        while (arr2 != 0) {
            int r = arr1 % arr2;
            arr1 = arr2;
            arr2 = r;
        }
        
        return arr1;
    }
}