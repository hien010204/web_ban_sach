package vn.quanli.webansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import vn.quanli.webansach_backend.entity.Order;


@RepositoryRestResource(path = "orders")
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    // Custom query methods can be added here if needed
    // For example, to find orders by user or status, etc.

}
