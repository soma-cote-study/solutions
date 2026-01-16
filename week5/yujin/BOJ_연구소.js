const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const parseInput = input.split(`\n`);
  const [N, M] = parseInput[0].split(' ').map(Number);
  const map = parseInput.slice(1).map(a => a.split(' ').map(Number));

  const emptys = [];

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] == 0) {
        emptys.push([i, j]);
      }
    }
  }

  let dist = [];
  let wallCom = [];
  const visited = new Array(emptys.length).fill(false);

  function backtrack(start, depth) {
    if (depth == 3) {
      return wallCom.push(dist.join(' ').split(' ').map(Number));
    }

    for (let i = start; i < emptys.length; i++) {
      const [x, y] = emptys[i];
      if (!visited[i]) {
        visited[i] = true;
        dist.push(i);
        backtrack(i + 1, depth + 1);
        dist.pop();
        visited[i] = false;
      }
    }
  }
  backtrack(0, 0);
  const dx = [1, -1, 0, 0];
  const dy = [0, 0, 1, -1];

  let maxResult = -Infinity;

  for (let w = 0; w < wallCom.length; w++) {
    const newMap = map.map(row => [...row]);

    for (let k = 0; k < wallCom[w].length; k++) {
      const idx = wallCom[w][k];
      const [x, y] = emptys[idx];

      newMap[x][y] = 1;
    }

    const queue = [];
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (newMap[i][j] == 2) {
          queue.push([i, j]);
        }
      }
    }

    while (queue.length) {
      const [x, y] = queue.shift();

      for (let i = 0; i < 4; i++) {
        const nx = x + dx[i];
        const ny = y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M && newMap[nx][ny] == 0) {
          newMap[nx][ny] = 2;
          queue.push([nx, ny]);
        }
      }
    }

    let result = 0;

    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (newMap[i][j] == 0) {
          result += 1;
        }
      }
    }

    if (maxResult < result) {
      maxResult = result;
    }
  }

  return maxResult;
}

console.log(solution(input));
