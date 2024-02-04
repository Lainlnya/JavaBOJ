function solution(today, terms, privacies) {
  let answer = [];
  let map = new Map();
  for (let term of terms) {
    map.set(term.split(' ')[0], term.split(' ')[1]);
  }

  let [dayYear, dayMonth, day] = today.split('.');

  let i = 1;
  const todayStr = dayYear * 12 * 28 + dayMonth * 28 + day;
  for (let privacy of privacies) {
    let [curYear, curMonth, curDay] = privacy.split(' ')[0].split('.');
    const type = privacy.split(' ')[1];
    const whatMonth = map.get(type);

    const curStr = curYear * 12 * 28 + curMonth * 28 + whatMonth * 28 + curDay;

    if (todayStr >= curStr) {
      answer.push(i);
    }
    i++;
  }
  return answer;
}