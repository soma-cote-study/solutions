const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

const [n, m] = input.split(' ').map(Number);
const visited = new Array(n).fill(false);
const result = [];
const dist = [];

function backtrack(start, depth) {
  if (depth === m) {
    result.push(dist.join(' '));
    return;
  }

  for (let i = start; i < n; i++) {
    visited[i] = true;
    dist.push(i + 1);
    backtrack(i + 1, depth + 1);
    dist.pop();
    visited[i] = false;
  }
}

backtrack(0, 0);
console.log(result.join('\n'));
