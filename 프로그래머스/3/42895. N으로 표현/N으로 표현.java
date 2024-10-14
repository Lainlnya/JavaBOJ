import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> countList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            countList.add(new HashSet<>());
        }
        
        countList.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = new HashSet<>();
            
            for (int j = 1; j <= i; j++) {
                Set<Integer> past = countList.get(j);
                Set<Integer> present = countList.get(i - j);
                
                for (int pastNum : past) {
                    for (int presentNum : present) {
                        countSet.add(pastNum + presentNum);
                        countSet.add(pastNum - presentNum);
                        countSet.add(pastNum * presentNum);
                        
                        if (pastNum != 0 && presentNum != 0) {
                            countSet.add(pastNum / presentNum);
                        }
                    }
                }
            }
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for (int num : countSet) {
                countList.get(i).add(num);
            }
        }
        
        for (Set<Integer> sub: countList) {
            if (sub.contains(number)) {
                return countList.indexOf(sub);
            }
        }
        return -1;
    }
}