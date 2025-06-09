package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    // Custom query methods can be added here if needed
    // For example, to find deliveries by status, user, etc.

}
