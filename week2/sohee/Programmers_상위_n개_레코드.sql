-- 풀이1
select name
from animal_ins
where datetime = (
    select min(datetime)
    from animal_ins
);

-- 풀이2
-- select name
-- from animal_ins
-- order by datetime
-- limit 1;