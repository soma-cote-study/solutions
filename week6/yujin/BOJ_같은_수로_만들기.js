const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const parseInput = input.split(`\n`);
  const N = Number(parseInput[0]);
  const nums = parseInput.slice(1).map(Number);
  let count = 0;

  function division(start, end, target) {
    if (start >= end) return;

    const currArr = nums.slice(start, end);

    const max = Math.max(...currArr);

    count += target - max;

    const maxIdx = [];

    for (let i = start; i < end; i++) {
      if (nums[i] === max) {
        maxIdx.push(i);
      }
    }

    let left = start;
    for (let i = 0; i < maxIdx.length; i++) {
      division(left, maxIdx[i], max);
      left = maxIdx[i] + 1;
    }
    division(left, end, max);
  }

  division(0, nums.length, Math.max(...nums));

  return count;
}

console.log(solution(input));
