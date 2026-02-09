with topstudents as (
    -- 1. 우수 학생 선별
    select user_id
    from course_completions
    group by user_id
    having count(course_id) >= 5 and avg(course_rating) >= 4
),
coursepairs as (
    -- 2. 우수 학생들의 과목 이수 순서에 따른 연속 쌍(a -> b) 생성
    select 
        course_name as first_course,
        lead(course_name) over (partition by user_id order by completion_date) as second_course
    from course_completions
    where user_id in (select user_id from topstudents)
)
-- 3. 가장 흔한 전환 파악 및 정렬
select 
    first_course, 
    second_course, 
    count(*) as transition_count
from coursepairs
where second_course is not null -- 마지막 과목 이후는 쌍이 없으므로 제외
group by first_course, second_course
order by transition_count desc, first_course asc, second_course asc;