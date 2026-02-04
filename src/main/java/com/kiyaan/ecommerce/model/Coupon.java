package com.kiyaan.ecommerce.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.HashSet;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String code;

    private double discountPercentage;

    private LocalDate validityStartDate;

    private LocalDate validityEndDate;

    private double minimumOrderValue;

    private boolean isActive = true;

    @ManyToMany(mappedBy = "usedCoupon")
    private Set<User> usedByUsers = new HashSet<>();
}
