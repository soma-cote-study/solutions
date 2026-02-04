SELECT 
    user_id,
    DATEDIFF(MAX(event_date), MIN(event_date)) AS days_as_subscriber
FROM subscription_events
GROUP BY user_id
HAVING 
    (SELECT event_type 
     FROM subscription_events e2 
     WHERE e2.user_id = subscription_events.user_id 
     ORDER BY event_date DESC LIMIT 1) <> 'cancel'

    AND COUNT(CASE WHEN event_type = 'downgrade' THEN 1 END) >= 1
    

    AND (SELECT plan_revenue 
         FROM subscription_events e3 
         WHERE e3.user_id = subscription_events.user_id 
         ORDER BY event_date DESC LIMIT 1) < (MAX(plan_revenue) * 0.5)
    

    AND DATEDIFF(MAX(event_date), MIN(event_date)) >= 60

ORDER BY days_as_subscriber DESC, user_id ASC;