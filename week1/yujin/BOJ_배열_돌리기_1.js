const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function solution(input) {
  const [N, M, R] = input[0].split(' ').map(Number);
  const arr = input.slice(1).map(line => line.split(' ').map(Number));

  const dx = [1, 0, -1, 0];
  const dy = [0, 1, 0, -1];

  const layers = Math.min(N, M) / 2;

  for (let r = 0; r < R; r++) {
    for (let s = 0; s < layers; s++) {
      let x = s;
      let y = s;
      let preValue = arr[x][y];
      let dirIdx = 0;

      while (dirIdx < 4) {
        const nx = x + dx[dirIdx];
        const ny = y + dy[dirIdx];

        if (nx >= s && nx < N - s && ny >= s && ny < M - s) {
          const temp = arr[nx][ny];
          arr[nx][ny] = preValue;
          preValue = temp;
          x = nx;
          y = ny;
        } else {
          dirIdx++;
        }
      }
    }
  }

  return arr.map(row => row.join(' ')).join('\n');
}

console.log(solution(input));
