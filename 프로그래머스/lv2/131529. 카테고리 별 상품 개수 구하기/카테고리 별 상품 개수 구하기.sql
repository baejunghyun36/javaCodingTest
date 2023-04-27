select left(product_code, 2), count(left(product_code, 2))
from product
group by left(product_code, 2)