class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int width = yellow / i;
                int height = i;

                if ((width * 2 + height * 2 + 4) == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    return answer;
                }
            }
        }

        return answer;
    }
}