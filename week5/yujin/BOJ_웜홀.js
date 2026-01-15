const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  let line = 1;
  const parseInput = input.split(`\n`);
  const TC = Number(parseInput[0]);
  const result = [];

  for (let t = 0; t < TC; t++) {
    const [N, M, W] = parseInput[line++].split(' ').map(Number);

    const edges = [];

    for (let i = 0; i < M; i++) {
      const [S, E, T] = parseInput[line++].split(' ').map(Number);
      edges.push([S, E, T]);
      edges.push([E, S, T]);
    }

    for (let i = 0; i < W; i++) {
      const [S, E, T] = parseInput[line++].split(' ').map(Number);
      edges.push([S, E, -T]);
    }

    const dist = new Array(N + 1).fill(0);
    let hasNagative = false;

    for (let i = 1; i <= N; i++) {
      for (let [cur, nex, weight] of edges) {
        if (dist[cur] + weight < dist[nex]) {
          dist[nex] = dist[cur] + weight;

          if (i === N) {
            hasNagative = true;
            break;
          }
        }
      }
    }

    if (hasNagative == true) {
      result.push('YES');
    } else {
      result.push('NO');
    }
  }

  return result.join(`\n`);
}

console.log(solution(input));
