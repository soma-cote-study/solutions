const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const parseInput = input.split('\n');
  const [n, m] = parseInput[0].split(' ').map(Number);
  const arr = parseInput.slice(1).map(a => a.split(' ').map(Number));

  const dist = Array.from({ length: n }, () => new Array(m).fill(0));
  const queue = [];

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (arr[i][j] === 2) {
        dist[i][j] = 0;
        queue.push([i, j]);
      } else if (arr[i][j] === 0) {
        dist[i][j] = 0;
      } else {
        dist[i][j] = -1;
      }
    }
  }

  const nx = [1, 0, -1, 0];
  const ny = [0, 1, 0, -1];

  let head = 0;
  while (queue.length > head) {
    const [x, y] = queue[head++];

    for (let i = 0; i < 4; i++) {
      const dx = x + nx[i];
      const dy = y + ny[i];

      if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
        if (dist[dx][dy] === -1) {
          dist[dx][dy] = dist[x][y] + 1;
          queue.push([dx, dy]);
        }
      }
    }
  }

  return dist;
}

console.log(
  solution(input)
    .map(a => a.join(' '))
    .join('\n')
);
