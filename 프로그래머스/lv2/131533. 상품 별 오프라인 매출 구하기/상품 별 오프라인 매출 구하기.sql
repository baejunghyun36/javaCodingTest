
SELECT a.product_code,sum(b.sales_amount * a.price)
from product a join offline_sale b
on a.product_id = b.product_id
group by a.product_code
order by sum(b.sales_amount * a.price) desc, a.product_code