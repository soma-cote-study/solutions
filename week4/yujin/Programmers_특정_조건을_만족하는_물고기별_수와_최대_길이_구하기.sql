select count(*) as "fish_count", (select max(length)
         from fish_info as i
         where fish_type = i.fish_type) as "max_length" ,
         fish_type
from fish_info 
group by fish_type
having avg(length) >= 33


select count(*) as fish_count, max(ifnull(length, 10)) as max_length, fish_type
from fish_info
group by fish_type
having avg(ifnull(length, 10)) >= 33
order by fish_type