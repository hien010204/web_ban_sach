package vn.quanli.webansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import vn.quanli.webansach_backend.entity.Payment;

@RepositoryRestResource(path = "payments")
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Custom query methods can be added here if needed
    // For example, to find payments by user ID, status, etc.

}
