class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 마지막 attack 지점
        int lastAttacks = attacks[attacks.length - 1][0];
        // 현재 가지고 있는 attack 지점
        int attackPointer = 0;
        // 체력
        int answer = health;
        // 연속 성공 여부
        int success = 0;
        
        for (int i = 1; i <= lastAttacks; i++) {
            // 공격 포지션이면
            if (attacks[attackPointer][0] == i) {
                // 현재 체력에서 공격치 빼줌
                answer -= attacks[attackPointer][1];
                attackPointer++;
                // 공격하면 연속 성공 0됨
                success = 0;
                if (answer <= 0) return -1;
            
            // 공격이 아니면
            } else {
                // 체력 증가 및 연속 성공 여부 증가
                answer += bandage[1];
                success += 1;
                
                if (success == bandage[0]) {
                    answer += bandage[2];
                    success = 0;
                }       
                if (answer >= health) answer = health;
            }
        }
        return answer;
    }
}