const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

const [n, m] = input.split(' ').map(Number);
const result = [];
const dist = [];

function backtrack(start, depth) {
  if (depth === m) {
    result.push(dist.join(' '));
    return;
  }

  for (let i = start; i <= n; i++) {
    dist.push(i);
    backtrack(i, depth + 1);
    dist.pop();
  }
}

backtrack(1, 0);
console.log(result.join('\n'));
