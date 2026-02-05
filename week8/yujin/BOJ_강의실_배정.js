const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

const input = fs.readFileSync(filePath).toString().trim();

function solution(n, times) {
  let answer = 0;
  let classroom = 0;
  const obj = [];

  for (let i = 0; i < n; i += 1) {
    // times[i]가 존재할 때만 push (안전한 파싱을 위함)
    if (times[i]) {
      obj.push({ time: times[i][0], start: 1 }); // 시작
      obj.push({ time: times[i][1], start: -1 }); // 종료
    }
  }

  // 시간 순 정렬, 시간이 같으면 종료(-1)를 먼저 처리
  obj.sort((a, b) => (a.time === b.time ? a.start - b.start : a.time - b.time));

  obj.forEach(schedule => {
    classroom += schedule.start;
    answer = Math.max(answer, classroom);
  });

  return answer;
}

const lines = input.split('\n');
if (lines.length > 0) {
  const n = parseInt(lines[0]);
  const times = lines.slice(1).map(line => line.split(/\s+/).map(Number));

  console.log(solution(n, times));
}
