set @total_users = (
    select count(*)
    from user_info
    where joined like '2021%'
);

select year(s.sales_date) as year, month(s.sales_date) as month,
    count(distinct s.user_id) as purchased_users,
    round(count(distinct s.user_id) / @total_users, 1) as purchased_ratio
from user_info u
join online_sale s on u.user_id = s.user_id
where u.joined like '2021%'
group by year, month
order by year, month;