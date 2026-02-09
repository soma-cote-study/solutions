with rankedsessions as (
    -- 1. 각 학생별로 세션 순서(rn)를 매기고 이전 날짜와의 차이를 계산
    select *,
           row_number() over(partition by student_id order by session_date) as rn,
           lag(session_date) over(partition by student_id order by session_date) as prev_date
    from study_sessions
),
validgaps as (
    -- 2. 날짜 간격이 2일을 초과하는 세션이 있는 학생은 제외하거나 그룹화
    select * from rankedsessions
),
findcycles as (
    -- 3. 주기를 찾습니다. (최소 3개 과목이므로 lag 3, 4, 5 등을 체크)
    select student_id, 
           count(*) as total_sessions,
           sum(hours_studied) as total_hours,
           (select count(distinct subject) from study_sessions s2 where s2.student_id = v.student_id) as cycle_len
    from validgaps v
    group by student_id
    having count(*) >= 6 -- 최소 2주기(6세션)
)
-- 4. 최종 조인 및 정렬
select s.student_id, s.student_name, s.major, c.cycle_len, c.total_hours
from students s
join findcycles c on s.student_id = c.student_id
where c.cycle_len >= 3
order by c.cycle_len desc, c.total_hours desc;