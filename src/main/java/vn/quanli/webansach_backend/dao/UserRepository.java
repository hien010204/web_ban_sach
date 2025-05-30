package vn.quanli.webansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import vn.quanli.webansach_backend.entity.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {

}
 