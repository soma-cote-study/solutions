select
    session_id,
    user_id,
    timestampdiff(minute, min(event_timestamp), max(event_timestamp)) as session_duration_minutes,
    count(case when event_type = 'scroll' then 1 end) as scroll_count
from app_events
group by session_id, user_id
having
    timestampdiff(minute, min(event_timestamp), max(event_timestamp)) > 30
    and count(case when event_type = 'scroll' then 1 end) >= 5
    and count(case when event_type = 'purchase' then 1 end) = 0
    and (
        count(case when event_type = 'click' then 1 end) * 1.0 /
        count(case when event_type = 'scroll' then 1 end)
    ) < 0.20
order by scroll_count desc;