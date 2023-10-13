package com.sowndarya.ReceipeManagementSystem.repository;

import com.sowndarya.ReceipeManagementSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
