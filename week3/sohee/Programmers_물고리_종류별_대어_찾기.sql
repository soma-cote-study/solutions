select i.id, n.fish_name, i.length
from fish_info as i
join fish_name_info as n on n.fish_type = i.fish_type
where (n.fish_type, i.length) in (select fish_type, max(length) from fish_info group by fish_type);