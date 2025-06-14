package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Custom query methods can be added here if needed
    // For example, to find categories by name, etc.
    

}
