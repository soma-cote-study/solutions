select
    m.member_name,
    r.review_text,
    date_format(r.review_date, '%Y-%m-%d') as review_date
from
    member_profile m
join
    rest_review r on m.member_id = r.member_id
where
    m.member_id in (
        select member_id
        from rest_review
        group by member_id
        having count(*) = (
            select count(*)
            from rest_review
            group by member_id
            order by count(*) desc
            limit 1
        )
    )
order by
    review_date asc,
    r.review_text asc;