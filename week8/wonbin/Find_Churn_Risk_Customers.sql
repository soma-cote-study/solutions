with userstats as (
    select
        user_id,
        event_type,
        plan_name,
        monthly_amount,
        max(monthly_amount) over(partition by user_id) as max_historical_amount,
        min(event_date) over(partition by user_id) as start_date,
        max(event_date) over(partition by user_id) as last_event_date,
        sum(case when event_type = 'downgrade' then 1 else 0 end) over(partition by user_id) as downgrade_count,
        row_number() over(partition by user_id order by event_date desc, event_id desc) as rn
    from subscription_events
)
select
    user_id,
    plan_name as current_plan,
    monthly_amount as current_monthly_amount,
    max_historical_amount,
    datediff(last_event_date, start_date) as days_as_subscriber
from userstats
where rn = 1
  and event_type != 'cancel'
  and downgrade_count > 0
  and monthly_amount < 0.5 * max_historical_amount
  and datediff(last_event_date, start_date) >= 60
order by days_as_subscriber desc, user_id asc;