select
    customer_id,
    count(order_id) as total_orders,
    round(
        sum(
            case
                when (time(order_timestamp) between '11:00:00' and '13:59:59')
                  or (time(order_timestamp) between '18:00:00' and '20:59:59')
                then 1 else 0
            end
        ) * 100.0 / count(order_id),
        0
    ) as peak_hour_percentage,
    round(avg(order_rating), 2) as average_rating
from restaurant_orders
group by customer_id
having
    count(order_id) >= 3
    and sum(
        case
            when (time(order_timestamp) between '11:00:00' and '13:59:59')
              or (time(order_timestamp) between '18:00:00' and '20:59:59')
            then 1 else 0
        end
    ) * 100.0 / count(order_id) >= 60
    and avg(order_rating) >= 4.0
    and count(order_rating) * 1.0 / count(order_id) >= 0.5
order by
    average_rating desc,
    customer_id desc;