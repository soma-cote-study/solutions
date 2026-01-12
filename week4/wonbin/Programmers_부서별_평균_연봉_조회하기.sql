select d.dept_id, d.dept_name_en, round(avg(e.sal), 0) as avg_sal
from hr_department as d
join hr_employees as e on e.dept_id = d.dept_id
group by d.dept_id, d.dept_name_en
order by avg_sal desc;