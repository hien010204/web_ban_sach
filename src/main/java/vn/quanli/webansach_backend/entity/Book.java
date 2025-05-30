package vn.quanli.webansach_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_name", columnDefinition= "NVARCHAR(256)")
    private String bookName;
    @Column(name = "author_name", columnDefinition= "NVARCHAR(256)")
    private String authorName;
    @Column(name = "isbn", length = 256)
    private String ISBN;
    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description;
    @Column(name = "listed_price")
    private double listedPrice; 
    @Column(name = "selling_price")
    private double sellingPrice;
    @Column(name= "quantity")
    private int quatity;
    @Column(name = "average_rating")
    private double averageRating;

    // quan hệ nhiều-nhiều với Category
    @ManyToMany(fetch = FetchType.LAZY,  cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinTable(name = "book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categoryList;

    //quan hes một-nhiều với Image
    @OneToMany(mappedBy="book", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH,
        CascadeType.REMOVE
    })
    List<Image> imageList;

    // quan hệ một-nhiều với Review
    @OneToMany(mappedBy="book", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH,
        CascadeType.REMOVE
    })
    List<Review> reviewList;

    // quan hệ một-nhiều với OrderDetails
    @OneToMany(mappedBy="book", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH
    })
    List<OrderDetails> orderDetailsList;

    // quan hệ một-nhiều với FavoriteBooks
    @OneToMany(mappedBy="book", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH, 
        CascadeType.REMOVE
    })
    List<FavoriteBooks> favoriteBooksList;
}
