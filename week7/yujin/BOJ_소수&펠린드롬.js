const fs = require('fs');
const input = fs.readFileSync(0).toString().trim();
let N = parseInt(input);

function solution(N) {
  if (N === 1) N = 2;

  for (let i = N; ; i++) {
    if (isPalindrome(i)) {
      if (isPrime(i)) {
        return i;
      }
    }
  }
}

function isPalindrome(num) {
  const str = String(num);
  const len = str.length;
  for (let i = 0; i < len / 2; i++) {
    if (str[i] !== str[len - 1 - i]) return false;
  }
  return true;
}

function isPrime(num) {
  if (num < 2) return false;

  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

console.log(solution(N));
