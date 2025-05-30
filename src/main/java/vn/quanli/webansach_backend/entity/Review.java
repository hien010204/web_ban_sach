package vn.quanli.webansach_backend.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long reviewId;
    @Column(name = "score")
    private float score;
    @Column(name = "comment", columnDefinition = "NVARCHAR(MAX)")
    private String comment;

    // Relationship with Book
    @ManyToOne(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    // Relationship with User
    @ManyToOne(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
