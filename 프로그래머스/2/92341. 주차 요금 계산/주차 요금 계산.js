function solution(fees, records) {
  // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
  // 시각 차량번호 내역 형식의 문자열
  // 출차하지 않았을 경우 23:59에 출차했다고 가정
  // 마지막 시간에 입차되는 경우는 입력으로 주어지지 않음
  let feeRecords = records;
  let answer = [];
  // 같은 차끼리 모으려고,
  let sameCars = new Map();
  // 우선 문자열 split 해서 나누기
  for (let i in feeRecords) {
    feeRecords[i] = feeRecords[i].split(' ');
  }
  // 일단 같은 것끼리 sort
  feeRecords.sort((a, b) => a[1] - b[1]);

  for (let i = 0; i < feeRecords.length; i++) {
    // 일단 두개 이름 같고
    if (
      i !== feeRecords.length - 1 &&
      feeRecords[i][1] === feeRecords[i + 1][1]
    ) {
      // 이렇게 짝으로 지어지는 경우
      if (feeRecords[i][2] === 'IN' && feeRecords[i + 1][2] === 'OUT') {
        let times1 = feeRecords[i][0].split(':');
        let times2 = feeRecords[i + 1][0].split(':');

        let changes =
          parseInt(times2[0]) * 60 +
          parseInt(times2[1]) -
          (parseInt(times1[0]) * 60 + parseInt(times1[1]));
        if (!sameCars.has(feeRecords[i][1])) {
          sameCars.set(feeRecords[i][1], changes);
        } else {
          sameCars.set(
            feeRecords[i][1],
            sameCars.get(feeRecords[i][1]) + changes
          );
        }
      }
    } else if (feeRecords[i][2] === 'IN') {
      let times = feeRecords[i][0].split(':');
      let changes = 23 * 60 + 59 - parseInt(times[0]) * 60 - parseInt(times[1]);
      if (!sameCars.has(feeRecords[i][1])) {
        sameCars.set(feeRecords[i][1], changes);
      } else {
        sameCars.set(
          feeRecords[i][1],
          sameCars.get(feeRecords[i][1]) + changes
        );
      }
    }
  }

  for (let value of sameCars) {
    let fee = value[1];
    // 지정된 시간보다 적으면
    if (fee <= fees[0]) {
      answer.push(fees[1]);
    } else {
      let fee = value[1] - fees[0];
      let tempFee = fees[1] + Math.ceil(fee / fees[2]) * fees[3];
      answer.push(tempFee);
    }
  }
  return answer;
}