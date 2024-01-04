function solution(bandage, health, attacks) {
    const lastAttacks = attacks[attacks.length - 1][0];
    let attackPointer = 0;
    let answer = health;
    let success = 0;
    
    for (let i = 0; i <= lastAttacks; i++) {
        if (attacks[attackPointer][0] === i) {
            answer -= attacks[attackPointer][1];
            attackPointer++;
            success = 0;
            
            if (answer <= 0) return -1;
        
        } else {
            answer += bandage[1];
            success += 1;
            
            if (success === bandage[0]) {
                answer += bandage[2];
                success = 0;
            }
            
            if (answer >= health) answer = health;
        }
    }
    return answer;
    
}