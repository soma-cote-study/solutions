select route, concat(round(sum(D_between_dist), 1), 'km') as total_distance, concat(round(avg(D_between_dist), 2), 'km') as average_distance
from subway_distance
group by route
order by sum(D_between_dist) desc;