package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{
    
}
