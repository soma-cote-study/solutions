select sum(score) as score, g.emp_no, e.emp_name, e.position, e.email
from hr_employees as e
join hr_grade as g on g.emp_no = e.emp_no
where g.year = '2022'
group by g.emp_no, e.emp_name, e.position, e.email
order by score desc
limit 1;