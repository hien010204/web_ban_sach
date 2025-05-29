package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.quanli.webansach_backend.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    
    // You can add more custom query methods if needed

}
