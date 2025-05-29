package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.quanli.webansach_backend.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Custom query methods can be added here if needed
    // For example, to find payments by user ID, status, etc.

}
