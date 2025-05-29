package vn.quanli.webansach_backend.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.quanli.webansach_backend.entity.Book;

@Repository

public interface BookRepository extends JpaRepository<Book, Integer> {
    // Custom query methods can be added here if needed
    // For example, to find books by title, author, etc.

}
