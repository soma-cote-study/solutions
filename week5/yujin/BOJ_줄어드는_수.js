const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const nums = [];

  function backtrack(cur) {
    const lastDigit = cur % 10;
    nums.push(cur);

    for (let i = lastDigit - 1; i >= 0; i--) {
      const next = cur * 10 + i;
      backtrack(next);
    }
  }

  for (let i = 0; i <= 9; i++) {
    backtrack(i);
  }

  nums.sort((a, b) => a - b);
  const N = Number(input);

  return nums[N - 1] !== undefined ? nums[N - 1] : -1;
}

console.log(solution(input));
