# SELECT * FROM softhis_db.orders;

# Show total_amount of customer_id and orders_quantity
SELECT customer_id,
	SUM(amount) as total_amount,
    COUNT(amount) as orders_quantity
FROM softhis_db.orders
GROUP BY customer_id;
