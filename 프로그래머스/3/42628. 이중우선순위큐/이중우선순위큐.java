import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        for (String oper : operations) {
            String[] temp = oper.split(" ");
            int num = Integer.parseInt(temp[1]);
            if (temp[0].equals("I")) {
                treeSet.add(num);
            } else if (!treeSet.isEmpty()) {
                if (num == 1) {
                    treeSet.pollLast();
                } else {
                    treeSet.pollFirst();
                }
            }
        }
        if (treeSet.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{treeSet.last(), treeSet.first()};
        }
       
    }
}