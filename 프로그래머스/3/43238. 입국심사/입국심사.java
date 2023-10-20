class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long start = 1, end = Long.MIN_VALUE;
        for (int time : times) {
            end = Math.max(time, end);
        }

        end = end * n;

        while (start <= end) {
            long people = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < times.length; i++) {
                people += mid / times[i];

                if (people >= n) break;
            }


            if (people >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

}