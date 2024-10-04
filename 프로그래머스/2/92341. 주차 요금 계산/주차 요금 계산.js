function solution(fees, records) {
    const answer = [];
    
    let infoMap = new Map();
    let answerMap = new Map();
    
    for (record of records) {
        [time, carNumber, inNout] = record.split(" ");
        let minute = time.split(":");
        
        if (!infoMap.has(carNumber) && inNout === 'IN') {
            infoMap.set(carNumber, minute[0] * 60 + minute[1] * 1);
        } else {
            let inTime = infoMap.get(carNumber);
            let outTime = minute[0] * 60 + minute[1] * 1;
            
            if (!answerMap.has(carNumber)) {
                answerMap.set(carNumber, outTime - inTime);    
            } else {
                answerMap.set(carNumber, answerMap.get(carNumber) + outTime - inTime);
            }
            infoMap.delete(carNumber);
        }
    }
    
    if (infoMap.size > 0) {
        infoMap.forEach((value, key) => {
            if (!answerMap.has(key)) {
                answerMap.set(key, 1439 - value);
            } else {
                console.log("value: " + value);
                answerMap.set(key, answerMap.get(key) + (1439 - value));
            }
        });
    }
    
    answerMap.forEach((value, key) => {
        let price = 0;
        if (value > fees[0]) {
            price += fees[1]; value -= fees[0]; // 기본요금 더하고 기본 시간 빼고
            price += Math.ceil(value / fees[2]) * fees[3];
        } else {
            price += fees[1];
        }
        answerMap.set(key, price);
    })

    const mapToArray = [...answerMap];
    mapToArray.sort((a, b) => a[0] - b[0]);
    
    for (map of mapToArray) {
        answer.push(map[1]);
    }
    
    return answer;
}