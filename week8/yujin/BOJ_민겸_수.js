const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution(input) {
  const coms = [];

  const dist = [];

  function backtrack(start) {
    if (start == input.length) {
      coms.push([...dist]);
      return;
    }

    for (let end = start + 1; end <= input.length; end++) {
      const part = input.slice(start, end);
      dist.push(part);
      backtrack(end);
      dist.pop();
    }
  }

  backtrack(0);

  function convertToNumber(str) {
    const n = str.length;

    if (str.endsWith('K')) {
      for (let i = 0; i < n - 1; i++) {
        if (str[i] !== 'M') return 'null';
      }
      return 10 ** (n - 1) * 5;
    } else {
      for (let i = 0; i < n; i++) {
        if (str[i] !== 'M') return 'null';
      }

      return 10 ** (n - 1);
    }
  }

  let max = -Infinity;

  let min = Infinity;

  for (const com of coms) {
    let total = '';
    let isValid = true;

    for (const part of com) {
      const num = convertToNumber(part);
      if (num == null) {
        isValid = false;
        break;
      }
      total += num;
    }

    if (isValid) {
      if (Number(total) > max) max = Number(total);
      if (Number(total) < min) min = Number(total);
    }
  }

  //길이가 3000을 안넘어서 그리디로 풀어도 됨!

  // 간격 1인경우 ~ N인경우

  // 일단 나눈다음에 max min 구하기
  // max min 구하려면 변환 규칙적용

  // 변환규칙
  // 전체가 M인가
  // 10 ^ (개수 - 1)
  // 끝에가 K로 끝나고 길이가 2이상이면 앞에가 다 M인가
  // 10 ^ (개수 - 1) * 5

  // 다 돌면서 max min 구하기

  return [max, min].join(`\n`);
}

console.log(solution(input));
