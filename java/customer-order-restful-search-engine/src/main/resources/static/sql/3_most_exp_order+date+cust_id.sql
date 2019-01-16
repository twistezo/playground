# SELECT * FROM softhis_db.orders_details

# 3 most exp orders + date + cust id
SELECT orders.customer_id, orders.amount, orders.date
FROM orders_details
RIGHT JOIN orders
ON orders.order_id = orders_details.order_id
# WHERE customer_id=1
ORDER BY amount DESC
# LIMIT 3;