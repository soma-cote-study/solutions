const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function flip(val) {
  return val === 'H' ? 'T' : 'H';
}

function bfs(initialMatrix) {
  const queue = [[initialMatrix, 0]];
  const visited = new Set();
  visited.add(initialMatrix.flat().join(''));

  while (queue.length > 0) {
    const [curr, count] = queue.shift();

    const flat = curr.flat();
    if (flat.every(v => v === 'H') || flat.every(v => v === 'T')) {
      return count;
    }

    for (let i = 0; i < 8; i++) {
      let next = curr.map(row => [...row]);

      if (i < 3) {
        // 행 뒤집기
        for (let j = 0; j < 3; j++) next[i][j] = flip(next[i][j]);
      } else if (i < 6) {
        // 열 뒤집기
        for (let j = 0; j < 3; j++) next[j][i - 3] = flip(next[j][i - 3]);
      } else if (i === 6) {
        // 주 대각선 뒤집기
        for (let j = 0; j < 3; j++) next[j][j] = flip(next[j][j]);
      } else {
        // 부 대각선 뒤집기
        for (let j = 0; j < 3; j++) next[j][2 - j] = flip(next[j][2 - j]);
      }

      const stateStr = next.flat().join('');
      if (!visited.has(stateStr)) {
        visited.add(stateStr);
        queue.push([next, count + 1]);
      }
    }
  }
  return -1;
}

function solution(input) {
  const lines = input.trim().split('\n');
  const T = Number(lines[0]);
  const data = lines.slice(1);
  const results = [];

  for (let i = 0; i < T; i++) {
    const matrix = data.slice(i * 3, i * 3 + 3).map(line => line.split(' '));
    results.push(bfs(matrix));
  }

  return results.join('\n');
}

console.log(solution(input));
