with fe as (select sum(code) as bitmask from skillcodes where category = 'Front End'),
py as (select code from skillcodes where name = 'Python'),
cs as (select code from skillcodes where name = 'C#')
select case
when (skill_code & (select bitmask from fe))
and (skill_code & (select code from py)) then 'A'
when (skill_code & (select code from cs)) then 'B'
when (skill_code & (select bitmask from fe)) then 'C'
end as grade, id, email
from developers
having grade is not null
order by grade, id;