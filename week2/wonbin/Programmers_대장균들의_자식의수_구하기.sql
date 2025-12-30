select d.id, count(l.id) as child_count
from ecoli_data d
left join ecoli_data l on d.id = l.parent_id
group by d.id
order by d.id asc;