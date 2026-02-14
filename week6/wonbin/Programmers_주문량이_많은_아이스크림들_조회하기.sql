select f.flavor
from first_half f
inner join(
    select flavor, sum(total_order) as total_order
    from july
    group by flavor
) as j on f.flavor = j.flavor
order by (f.total_order + j.total_order) desc
limit 3;