//종이가 접혀있는 정보가 왼쪽부터 오른쪽까지 차례대로 주어졌을 때,
//이 종이를 동호의 규칙대로 접을 수 있는지 없는지를 구하는 프로그램을 작성하시오.

// out이 처음 접힌 부분
// in 3개부터 안되나

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const parseInput = input.split(`\n`);

  const N = Number(parseInput[0]);
  const nums = parseInput.slice(1).map(a => a.split('').map(Number));

  const result = [];

  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];

    function recursive(num) {
      const mid = Math.floor(num.length / 2);

      if (num.length == 1) return true;

      for (let j = 0; j < mid; j++) {
        if (num[j] === num[num.length - 1 - j]) {
          return false;
        }
      }

      return recursive(num.slice(0, mid));
    }

    if (recursive(num)) {
      result.push('YES');
    } else {
      result.push('NO');
    }
  }

  return result.join('\n');
}

console.log(solution(input));
