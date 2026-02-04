SELECT 
    customer_id, count(*) as total_orders, (COUNT(CASE WHEN (HOUR(order_timestamp) BETWEEN 11 AND 13) 
                      OR (HOUR(order_timestamp) BETWEEN 18 AND 20) THEN 1 END) * 100 / COUNT(*)) as peak_hour_percentage ,
    ROUND(AVG(order_rating), 2) AS average_rating
FROM restaurant_orders
GROUP BY customer_id
HAVING 
    COUNT(*) >= 3 
    
   
    AND (COUNT(CASE WHEN (HOUR(order_timestamp) BETWEEN 11 AND 13) 
                      OR (HOUR(order_timestamp) BETWEEN 18 AND 20) THEN 1 END) * 1.0 / COUNT(*)) >= 0.6
    
    AND ROUND(AVG(order_rating), 2) >= 4.0
    
    AND (COUNT(order_rating) * 1.0 / COUNT(*)) >= 0.5

ORDER BY average_rating DESC, customer_id DESC;