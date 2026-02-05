with count_stats as (
    select
        user_id,
        reaction,
        count(*) as cnt
    from reactions
    group by user_id, reaction
),
user_totals as (
    select
        user_id,
        sum(cnt) as total_cnt,
        max(cnt) as max_cnt
    from count_stats
    group by user_id
    having sum(cnt) >= 5
)
select
    c.user_id,
    c.reaction as dominant_reaction,
    round(c.cnt / u.total_cnt, 2) as reaction_ratio
from count_stats c
join user_totals u on c.user_id = u.user_id and c.cnt = u.max_cnt
where (c.cnt / u.total_cnt) >= 0.6
order by reaction_ratio desc, c.user_id asc;