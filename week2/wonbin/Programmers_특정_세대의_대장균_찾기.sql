select g3.id
from ecoli_data g1
inner join ecoli_data g2 on g1.id = g2.parent_id
inner join ecoli_data g3 on g2.id = g3.parent_id
where g1.parent_id is null
order by g3.id asc;