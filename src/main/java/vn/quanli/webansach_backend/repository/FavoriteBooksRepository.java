package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.FavoriteBooks;

public interface FavoriteBooksRepository extends JpaRepository<FavoriteBooks, Integer> {

}
