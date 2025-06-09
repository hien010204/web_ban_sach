package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
