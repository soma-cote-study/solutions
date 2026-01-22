SELECT
    c.car_id,
    c.car_type,
    ROUND(c.daily_fee * 30 * (100 - p.discount_rate) / 100) AS fee
FROM CAR_RENTAL_COMPANY_CAR c
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
  ON c.car_type = p.car_type
 AND p.duration_type = '30일 이상'
WHERE c.car_type IN ('세단', 'SUV')
  AND c.car_id NOT IN (
      SELECT h.car_id
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
      WHERE h.start_date <= '2022-11-30'
        AND h.end_date >= '2022-11-01'
  )
HAVING fee >= 500000
   AND fee < 2000000
ORDER BY fee DESC, c.car_type ASC, c.car_id DESC;
