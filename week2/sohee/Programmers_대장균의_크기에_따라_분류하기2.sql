-- 방법 1: NTILE(4)
SELECT
    id,
    CASE NTILE(4) OVER (ORDER BY size_of_colony DESC)
        WHEN 1 THEN 'CRITICAL'
        WHEN 2 THEN 'HIGH'
        WHEN 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM ECOLI_DATA
ORDER BY id;

-- 방법 2: PERCENT_RANK()
-- SELECT
--     id,
--     CASE
--         WHEN percent <= 0.25 THEN 'CRITICAL'
--         WHEN percent <= 0.50 THEN 'HIGH'
--         WHEN percent <= 0.75 THEN 'MEDIUM'
--         ELSE 'LOW'
--     END AS COLONY_NAME
-- FROM (
--     SELECT
--         id,
--         PERCENT_RANK() OVER (ORDER BY size_of_colony DESC) AS percent
--     FROM ECOLI_DATA
-- ) AS ranked
-- ORDER BY id;
