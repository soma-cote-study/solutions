const fs = require('fs');
const [XA, XB] = fs.readFileSync(0).toString().trim().split(' ');

function solution(XA, XB) {
  let answers = [];

  const getMinBase = str => {
    let maxVal = 0;
    for (let char of str) {
      const val = parseInt(char, 36);
      if (val > maxVal) maxVal = val;
    }
    return Math.max(2, maxVal + 1);
  };

  const minA = getMinBase(XA);
  const minB = getMinBase(XB);

  //모든 진법 조합 (2~36) 탐색
  for (let a = minA; a <= 36; a++) {
    for (let b = minB; b <= 36; b++) {
      if (a === b) continue;

      try {
        const valA = BigInt(parseInt(XA, a));
        const valB = BigInt(parseInt(XB, b));

        // 두 값이 같고 2^63 미만인지 확인
        if (valA === valB && valA < 2n ** 63n) {
          answers.push([valA.toString(), a, b]);
        }
      } catch (e) {
        // parseInt 과정에서 범위를 벗어나는 등 에러 발생 시 무시
        continue;
      }
    }
  }

  if (answers.length === 0) return 'Impossible';
  if (answers.length > 1) return 'Multiple';
  return answers[0].join(' ');
}

console.log(solution(XA, XB));
