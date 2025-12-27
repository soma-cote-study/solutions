select d.id, d.email, d.first_name, d.last_name
from developers d
where d.skill_code & (select sum(code) from skillcodes
where name in ('Python', 'C#')) > 0
order by d.id;