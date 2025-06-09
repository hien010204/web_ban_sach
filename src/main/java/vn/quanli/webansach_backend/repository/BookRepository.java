package vn.quanli.webansach_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quanli.webansach_backend.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // Custom query methods can be added here if needed
    // For example, to find books by title, author, etc.

}
