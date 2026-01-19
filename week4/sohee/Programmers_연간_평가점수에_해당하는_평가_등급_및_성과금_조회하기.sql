select g.emp_no, e.emp_name,
        case when (avg(g.score) >= 96) then 'S'
             when (avg(g.score) >= 90) then 'A'
             when (avg(g.score) >= 80) then 'B'
             else 'C'
        end as grade,
        case when (avg(g.score) >= 96) then e.sal * 0.2
             when (avg(g.score) >= 90) then e.sal * 0.15
             when (avg(g.score) >= 80) then e.sal * 0.1
             else 0
        end as bonus
from hr_grade as g
join hr_employees as e on g.emp_no = e.emp_no
group by g.emp_no
order by g.emp_no;