const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const parseInput = input.split(`\n`);
  const [R, C] = parseInput[0].split(' ').map(Number);
  const arr = parseInput.slice(1).map(a => a.split(''));

  const fireArr = Array.from({ length: R }, () => new Array(C).fill(Infinity));
  const fireVisited = Array.from({ length: R }, () => new Array(C).fill(false));

  const fireQueue = [];
  let fireHead = 0;

  const jihoonQueue = [];
  let jihoonHead = 0;
  const jihoonVisited = Array.from({ length: R }, () =>
    new Array(C).fill(false)
  );
  const jihoonArr = Array.from({ length: R }, () => new Array(C).fill(-1));

  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (arr[i][j] == 'F') {
        fireQueue.push([i, j]);
        fireVisited[i][j] = true;
        fireArr[i][j] = 0;
      }
      if (arr[i][j] == 'J') {
        jihoonQueue.push([i, j]);
        jihoonVisited[i][j] = true;
        jihoonArr[i][j] = 0;
      }
    }
  }

  const dx = [1, -1, 0, 0];
  const dy = [0, 0, 1, -1];

  while (fireQueue.length > fireHead) {
    const [x, y] = fireQueue[fireHead++];

    for (let i = 0; i < 4; i++) {
      const nx = dx[i] + x;
      const ny = dy[i] + y;

      if (
        nx >= 0 &&
        nx < R &&
        ny >= 0 &&
        ny < C &&
        arr[nx][ny] == '.' &&
        !fireVisited[nx][ny]
      ) {
        fireVisited[nx][ny] = true;
        fireArr[nx][ny] = fireArr[x][y] + 1;
        fireQueue.push([nx, ny]);
      }
    }
  }
  let time = 0;

  while (jihoonQueue.length > jihoonHead) {
    const [x, y] = jihoonQueue[jihoonHead++];

    if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
      return jihoonArr[x][y] + 1;
    }

    for (let i = 0; i < 4; i++) {
      const nx = dx[i] + x;
      const ny = dy[i] + y;

      if (
        nx >= 0 &&
        nx < R &&
        ny >= 0 &&
        ny < C &&
        arr[nx][ny] == '.' &&
        !jihoonVisited[nx][ny] &&
        fireArr[nx][ny] > jihoonArr[x][y] + 1
      ) {
        jihoonVisited[nx][ny] = true;
        jihoonArr[nx][ny] = jihoonArr[x][y] + 1;
        jihoonQueue.push([nx, ny]);
      }
    }
  }
  return 'IMPOSSIBLE';
}

console.log(solution(input));
