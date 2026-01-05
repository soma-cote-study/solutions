const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(k) {
  const parseInput = k.split(`\n`);
  const [N, M] = parseInput[0].split(' ').map(Number);
  const arr = parseInput.slice(1).map(a => a.split(' ').map(Number));

  const graph = new Map();
  const cost = {};
  const prev = {};

  for (let i = 1; i <= N; i++) {
    graph.set(i, []);
  }

  for (const [n, v, w] of arr) {
    graph.get(n).push([v, w]);
  }

  for (let i = 1; i <= N; i++) {
    cost[i] = Infinity;
    prev[i] = null;
  }

  cost[1] = 0;

  for (let i = 0; i < N - 1; i++) {
    let updated = false;
    for (const [node, neighbors] of graph) {
      if (cost[node] == Infinity) continue;
      for (const [neighbor, w] of neighbors) {
        if (cost[node] + w < cost[neighbor]) {
          cost[neighbor] = cost[node] + w;
          prev[neighbor] = node;
          updated = true;
        }
      }
    }
    if (!updated) {
      break;
    }
  }

  for (const [node, neighbors] of graph) {
    if (cost[node] == Infinity) continue;
    for (let [neighbor, w] of neighbors) {
      if (cost[neighbor] > cost[node] + w) {
        return '-1';
      }
    }
  }

  const out = [];
  for (let i = 2; i <= N; i++) out.push(cost[i] === Infinity ? -1 : cost[i]);
  return out.join('\n');
}

console.log(solution(input));
