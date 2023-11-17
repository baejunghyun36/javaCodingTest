select distinct(a.CAR_id)
from car_rental_company_car a
join car_rental_company_rental_history b
on A.CAR_ID = B.CAR_ID
WHERE A.CAR_TYPE = '세단' AND DATE_FORMAT(B.START_DATE, '%m') = '10'
ORDER BY A.CAR_ID DESC