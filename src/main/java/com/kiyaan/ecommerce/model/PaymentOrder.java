package com.kiyaan.ecommerce.model;


import com.kiyaan.ecommerce.domain.PaymentMethod;
import com.kiyaan.ecommerce.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;

    private PaymentMethod paymentMethod;

    @ManyToOne
    private User user;

    @OneToMany
    private Set<Order> orders = new HashSet<>();

}
