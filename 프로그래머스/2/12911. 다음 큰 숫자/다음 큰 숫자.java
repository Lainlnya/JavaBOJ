class Solution {
    public int solution(int n) {
        char[] binary = Integer.toBinaryString(n).toCharArray();
        int prev = countOne(binary);
        int nextNum = n + (int)Math.pow(2, binary.length + 1);
        int answer = 0;
        aa: for (int i = n + 1; i < nextNum; i++) {
                if(prev == countOne(Integer.toBinaryString(i).toCharArray())) {
                    answer = i;
                    break aa;
                }
        }
        
        return answer;
    }
    public static int countOne(char[] binary) {
        int count = 0;
        
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '1') count++;
        }
        
        return count;
    }
}