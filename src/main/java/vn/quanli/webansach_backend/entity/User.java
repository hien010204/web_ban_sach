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

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id ")
    private int userId;
    @Column(name = "first_name", length = 256)
    private String  firstName;
    @Column(name = "middle_name", length = 256)
    private String middleName;
    @Column(name = "user_name", length = 256)
    private String userName;
    @Column(name = "password", length = 512)
    private String password;
    @Column(name = "email", length = 256)
    private String email;
    @Column(name = "gender")
    private char gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "billing_address")
    private String billingAddress;

    // Relationship with OrderDetails
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH, 
    })
    private List<Review> reviews;

    // Relationship with FavoriteBooks
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH, 
    })
    private List<FavoriteBooks> favoriteBooksList;


    @ManyToMany(fetch = FetchType.LAZY,  cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    // Relationship with Order
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH, 
    })
    private List<Order> orderList;
}

