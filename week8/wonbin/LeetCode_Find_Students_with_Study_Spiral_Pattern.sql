with consecutive_groups as (
    select
        student_id,
        session_id,
        subject,
        session_date,
        hours_studied,
        sum(case when datediff(session_date, prev_date) > 2 then 1 else 0 end)
            over (partition by student_id order by session_date) as group_id
    from (
        select
            *,
            lag(session_date) over (partition by student_id order by session_date) as prev_date
        from study_sessions
    ) t1
),
group_stats as (
    select
        student_id,
        group_id,
        count(distinct subject) as cycle_len,
        count(*) as total_sessions,
        sum(hours_studied) as total_hours
    from consecutive_groups
    group by student_id, group_id
),
ranked_sessions as (
    select
        cg.student_id,
        cg.group_id,
        cg.subject,
        gs.cycle_len,
        row_number() over (partition by cg.student_id, cg.group_id order by cg.session_date) as rn
    from consecutive_groups cg
    join group_stats gs
      on cg.student_id = gs.student_id and cg.group_id = gs.group_id
    where gs.cycle_len >= 3
      and gs.total_sessions >= 2 * gs.cycle_len
),
validation as (
    select
        t1.student_id,
        t1.group_id
    from ranked_sessions t1
    join ranked_sessions t2
      on t1.student_id = t2.student_id
      and t1.group_id = t2.group_id
      and t2.rn = (t1.rn - 1) % t1.cycle_len + 1
    where t1.subject = t2.subject
    group by t1.student_id, t1.group_id
    having count(*) = (
        select count(*)
        from ranked_sessions rs
        where rs.student_id = t1.student_id and rs.group_id = t1.group_id
    )
)
select
    st.student_id,
    st.student_name,
    st.major,
    gs.cycle_len as cycle_length,
    round(gs.total_hours, 2) as total_study_hours
from validation v
join group_stats gs on v.student_id = gs.student_id and v.group_id = gs.group_id
join students st on v.student_id = st.student_id
order by cycle_length desc, total_study_hours desc, st.student_id asc;