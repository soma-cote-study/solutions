-- SELECT DISTINCT l1.num AS ConsecutiveNums
-- FROM Logs l1
-- JOIN Logs l2 ON l1.id = l2.id - 1 AND l1.num = l2.num
-- JOIN Logs l3 ON l2.id = l3.id - 1 AND l2.num = l3.num;

WITH ranked AS (
  SELECT
    id,
    num,
    ROW_NUMBER() OVER (ORDER BY id) AS rn
  FROM Logs
)
SELECT DISTINCT r1.num AS ConsecutiveNums
FROM ranked r1
JOIN ranked r2 ON r2.rn = r1.rn + 1 AND r2.num = r1.num
JOIN ranked r3 ON r3.rn = r1.rn + 2 AND r3.num = r1.num;
