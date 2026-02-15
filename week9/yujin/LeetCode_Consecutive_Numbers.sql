-- 연속해서 최소 세 번 이상 나타나는 모든 숫자를 찾으세요.
-- 결과 테이블을 어떤 순서 로든 반환합니다 .

SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT
        num,
        LAG(num, 1) OVER (ORDER BY id) AS prev1,
        LAG(num, 2) OVER (ORDER BY id) AS prev2
    FROM Logs
) t
WHERE num = prev1
  AND num = prev2;
