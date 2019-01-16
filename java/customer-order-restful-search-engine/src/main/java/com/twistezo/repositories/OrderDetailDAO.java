package com.twistezo.repositories;

import com.twistezo.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Repository
public interface OrderDetailDAO  extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findAll();
}
