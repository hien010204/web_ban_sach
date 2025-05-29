package vn.quanli.webansach_backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.quanli.webansach_backend.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

}
