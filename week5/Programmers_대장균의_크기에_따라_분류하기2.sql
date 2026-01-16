select id, case
            when percent <= 0.25 then 'CRITICAL'
            when percent <= 0.50 then 'HIGH'
            when percent <= 0.75 then 'MEDIUM'
            else 'LOW'
            end as colony_name
from (select
            id,
            percent_rank() over (order by size_of_colony desc) as percent
        from ecoli_data) as ranked
order by id;
