select sum(score) as score, g.emp_no, e.emp_name, e.position, e.email
from hr_grade as g
join hr_employees as e on g.emp_no = e.emp_no
group by g.emp_no
order by sum(score) desc
limit 1;