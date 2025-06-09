package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    // Custom query methods can be added here if needed
    // For example, to find orders by user or status, etc.

}
