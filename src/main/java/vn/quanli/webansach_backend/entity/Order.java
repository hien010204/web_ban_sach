package vn.quanli.webansach_backend.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "shipping_address", length = 512)
    private String shippingAddress;
    @Column(name = "billing_address", length = 512)
    private String billingAddress;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "shipping_cost")
    private double shippingCost;
    @Column(name = "product_total")
    private double productTotal;

    // Relationship with OrderDetails
    @OneToMany(mappedBy="order", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH, 
        CascadeType.REMOVE
    })
    private List<OrderDetails> orderDetailsList;

    // Relationship with User
    @ManyToOne(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relationship with Payment and Delivery
    @ManyToOne(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
