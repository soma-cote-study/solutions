function solution(m, n, board) {
  let map = board.map(a => a.split(''));
  let count = 0;

  const dx = [0, 1, 1];
  const dy = [1, 0, 1];

  while (true) {
    let isSame = new Set();

    for (let i = 0; i < m - 1; i++) {
      for (let j = 0; j < n - 1; j++) {
        const value = map[i][j];

        if (!value) continue;

        let same = true;
        for (let k = 0; k < 3; k++) {
          if (value !== map[i + dx[k]][j + dy[k]]) {
            same = false;
            break;
          }
        }

        if (same) {
          isSame.add(`${i},${j}`);
          isSame.add(`${i + 0},${j + 1}`);
          isSame.add(`${i + 1},${j + 0}`);
          isSame.add(`${i + 1},${j + 1}`);
        }
      }
    }

    if (isSame.size === 0) break;

    for (let pos of isSame) {
      const [x, y] = pos.split(',').map(Number);
      if (map[x][y] !== null) {
        map[x][y] = null;
        count += 1;
      }
    }

    for (let j = 0; j < n; j++) {
      let columnData = [];
      for (let i = 0; i < m; i++) {
        if (map[i][j] !== null) columnData.push(map[i][j]);
      }

      for (let i = m - 1; i >= 0; i--) {
        map[i][j] = columnData.length > 0 ? columnData.pop() : null;
      }
    }
  }

  return count;
}
