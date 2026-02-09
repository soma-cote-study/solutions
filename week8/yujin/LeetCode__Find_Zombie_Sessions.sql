select 
    session_id,
    user_id,
    timestampdiff(minute, min(event_timestamp), max(event_timestamp)) as session_duration_minutes,
    sum(case when event_type = 'scroll' then 1 else 0 end) as scroll_count
from app_events
group by session_id, user_id
having 
    -- 1. 세션 지속 시간 30분 초과
    timestampdiff(minute, min(event_timestamp), max(event_timestamp)) > 30
    -- 2. 스크롤 이벤트 최소 5개 이상
    and sum(case when event_type = 'scroll' then 1 else 0 end) >= 5
    -- 3. 클릭 대비 스크롤 비율이 0.20 미만
    and (sum(case when event_type = 'click' then 1 else 0 end) / 
         sum(case when event_type = 'scroll' then 1 else 0 end)) < 0.20
    -- 4. 구매 기록이 전혀 없음
    and sum(case when event_type = 'purchase' then 1 else 0 end) = 0
order by 
    scroll_count desc, 
    session_id asc;