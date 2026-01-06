const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

class MinHeap {
  constructor() {
    this.h = [];
  }

  push(v) {
    this.h.push(v);
    let cur = this.h.length - 1;

    while (cur > 0) {
      let p = Math.floor((cur - 1) / 2);
      if (this.h[p][0] <= this.h[cur][0]) break;

      [this.h[p], this.h[cur]] = [this.h[cur], this.h[p]];
      cur = p;
    }
  }

  pop() {
    if (this.h.length === 0) return null;
    if (this.h.length === 1) return this.h.pop();

    const res = this.h[0];
    this.h[0] = this.h.pop();
    let cur = 0;

    while (cur * 2 + 1 < this.h.length) {
      let l = cur * 2 + 1;
      let r = cur * 2 + 2;
      let s = l;

      if (r < this.h.length && this.h[r][0] < this.h[l][0]) s = r;
      if (this.h[cur][0] <= this.h[s][0]) break;
      [this.h[s], this.h[cur]] = [this.h[cur], this.h[s]];
      cur = s;
    }
    return res;
  }
}

function solution(input) {
  const parseInput = input.split(`\n`);
  const [V, E] = parseInput[0].split(' ').map(Number);
  const K = Number(parseInput[1]);
  const nums = parseInput.slice(2).map(a => a.split(' ').map(Number));
  const graph = new Map();

  for (let i = 0; i < nums.length; i++) {
    const [v, c, dist] = nums[i];
    if (!graph.has(v)) graph.set(v, []);

    graph.get(v).push([c, dist]);
  }

  const dist = new Array(V + 1).fill(Infinity);
  dist[K] = 0;
  const pd = new MinHeap();
  pd.push([0, K]);

  while (pd.h.length) {
    const popped = pd.pop();
    if (!popped) break;

    const [d, u] = popped;

    if (dist[u] < d) continue;

    const neighbors = graph.get(u) || [];
    for (const [v, w] of neighbors) {
      if (dist[v] > w + d) {
        dist[v] = w + d;
        pd.push([dist[v], v]);
      }
    }
  }

  return dist
    .slice(1)
    .map(v => (v === Infinity ? 'INF' : v))
    .join('\n');
}

console.log(solution(input));
