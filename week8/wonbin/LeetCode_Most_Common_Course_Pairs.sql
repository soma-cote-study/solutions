with qualified_users as (
    select user_id
    from course_completions
    group by user_id
    having count(*) >= 5
       and avg(course_rating) >= 4
),
course_transitions as (
    select
        user_id,
        course_name as first_course,
        lead(course_name) over (partition by user_id order by completion_date) as second_course
    from course_completions
    where user_id in (select user_id from qualified_users)
)
select
    first_course,
    second_course,
    count(distinct user_id) as transition_count
from course_transitions
where second_course is not null
group by first_course, second_course
order by transition_count desc, first_course asc, second_course asc;