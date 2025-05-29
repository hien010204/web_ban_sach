package vn.quanli.webansach_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "delivery")
public class Delivery{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private int deliveryId;
    @Column(name = "delivery_method", length = 256, nullable = false)
    private String deliveryMethod;
    @Column(name = "description", columnDefinition = "TEXT")
    private String desciption;
    @Column(name = "delivery_fee", nullable = false)
    private double deliveryFee;

    // Relationship with Order
    @OneToMany(mappedBy="delivery", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH
    })
    private List<Order> orderList;
}
