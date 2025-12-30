SELECT ID,
       CASE
           WHEN ed.per <= 0.25 THEN 'CRITICAL'
           WHEN ed.per <= 0.5 THEN 'HIGH'
           WHEN ed.per <= 0.75 THEN 'MEDIUM'
           ELSE 'LOW'
           END AS COLONY_NAME
FROM (
         SELECT ID, PERCENT_RANK() over (ORDER BY SIZE_OF_COLONY DESC) as per
         FROM ECOLI_DATA
     ) AS ED
ORDER BY ID
