select u.user_id, u.nickname, sum(price) as total_sales
from used_goods_board as b
join used_goods_user as u on b.writer_id = u.user_id
where status = 'DONE'
group by b.writer_id
having total_sales >= 700000
order by total_sales;