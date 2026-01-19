const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const lines = input.split('\n');
  if (lines.length === 0) return;

  const [n, m, r] = lines[0].split(' ').map(Number);
  const map = lines.slice(1).map(line => line.trim().split(/\s+/).map(Number));

  const layers = Math.min(n, m) / 2;

  const dx = [1, 0, -1, 0];
  const dy = [0, 1, 0, -1];

  for (let k = 0; k < r; k++) {
    for (let i = 0; i < layers; i++) {
      let x = i;
      let y = i;
      let preValue = map[i][i];
      let dirIdx = 0;

      // 4바뀡까지 돌아야됨
      while (dirIdx < 4) {
        const nx = x + dx[dirIdx];
        const ny = y + dy[dirIdx];

        if (nx >= i && nx < n - i && ny >= i && ny < m - i) {
          const temp = map[nx][ny];
          map[nx][ny] = preValue;
          preValue = temp;

          x = nx;
          y = ny;
        } else {
          dirIdx += 1;
        }
      }
    }
  }

  return map.map(row => row.join(' ')).join('\n');
}

console.log(solution(input));
