select a.author_id, a.author_name, b.category, sum(b.price * s.sales)as total_sales
from book_sales as s
join book as b on s.book_id = b.book_id
join author a on b.author_id = a.author_id
where sales_date like '2022-01%'
group by a.author_id, a.author_name, b.category
order by a.author_id asc, b.category desc;