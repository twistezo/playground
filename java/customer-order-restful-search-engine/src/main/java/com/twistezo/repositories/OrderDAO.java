package com.twistezo.repositories;

import com.twistezo.models.CustomerThreeOrdersResult;
import com.twistezo.models.CustomerTotalAmountResult;
import com.twistezo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

    /*
    List of all customers: id, surname, sum of total amount.
    Way with external class CustomerTotalAmountResult.
    Query search customers by writing a couple of letters from searched surname.
    The same query without wrapping by external class constructor:
    @Query("select o.customer.id, o.customer.surname, sum(o.amount) as s from Order as o group by o.customer")

    Hibernate console test:
    select NEW com.twistezo.models.CustomerTotalAmountResult
    (o.customer.id, o.customer.surname , sum(o.amount))
    from Order as o
    group by o.customer.surname
     */
    @Query("select NEW com.twistezo.models.CustomerTotalAmountResult " +
            "(o.customer.id, o.customer.surname , sum(o.amount)) " +
            "from Order as o " +
            "where o.customer.surname like %?1% " +
            "group by o.customer.surname")
    List<CustomerTotalAmountResult> findCustomersBySumOfAmount(String surname);

    /*
    List of all customers: id, surname, 3 most expensive orders <-> their dates
    Way with external class CustomerThreeOrders
    The same query without wrapping by external class CustomerThreeOrders:
    @Query("select o.customer.id, o.customer.surname, o.amount, o.date from Order as o, OrderDetail as od")

    Hibernate console test:
    select NEW com.twistezo.models.CustomerThreeOrdersResult
    (o.customer.id, o.customer.surname, o.amount, o.date)
    from Order as o
    where o.date between '2000-02-15 00:00:00' and '3000-02-15 00:00:00'
    and o.amount between 'BigDecimal.valueOf(0)' and :high
    order by o.amount desc
     */
    @Query("select NEW com.twistezo.models.CustomerThreeOrdersResult " +
            "(o.customer.id, o.customer.surname, o.amount, o.date) " +
            "from Order as o " +
            "where o.date between :startDate and :endDate " +
            "and o.amount between :low and :high " +
            "order by o.amount desc")
    List<CustomerThreeOrdersResult> findCustomersByThreeOrders(@Param("startDate") Date startDate,
                                                               @Param("endDate") Date endDate,
                                                               @Param("low") BigDecimal low,
                                                               @Param("high") BigDecimal high);

}