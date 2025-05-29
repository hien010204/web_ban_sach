package vn.quanli.webansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.quanli.webansach_backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
