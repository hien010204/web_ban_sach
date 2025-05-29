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

@Entity
@Data
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;
    @Column(name = "payment_method", length = 256, nullable = false)
    private String paymentMethod;
    @Column(name = "description", columnDefinition = "TEXT")
    private String desciption;
    @Column(name = "payment_fee", nullable = false)
    private double paymentFee;


    @OneToMany(mappedBy="payment", fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE, 
        CascadeType.REFRESH, CascadeType.DETACH
    })
    private List<Order> orderList;
    
}
