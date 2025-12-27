const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const parseInput = input.split(`\n`);
  const [N, M] = parseInput[0].split(' ').map(Number);
  const arr = parseInput.slice(1).map(a => a.split('').map(Number));

  const dx = [1, 0, -1, 0];
  const dy = [0, 1, 0, -1];

  const visited = Array.from({ length: N }, () => new Array(M).fill(false));
  const queue = [];

  queue.push([0, 0, 1]);
  visited[0][0] = true;

  while (queue.length) {
    const [x, y, count] = queue.shift();

    if (x === N - 1 && y === M - 1) {
      return count;
    }

    for (let i = 0; i < 4; i++) {
      const nx = dx[i] + x;
      const ny = dy[i] + y;
      if (
        nx >= 0 &&
        nx < N &&
        ny >= 0 &&
        ny < M &&
        arr[nx][ny] === 1 &&
        visited[nx][ny] == false
      ) {
        visited[nx][ny] = true;
        queue.push([nx, ny, count + 1]);
      }
    }
  }
}

console.log(solution(input));
