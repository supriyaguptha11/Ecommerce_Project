package com.kiyaan.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kiyaan.ecommerce.domain.USER_ROLE;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String email;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;


    @OneToMany
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    private Set<Coupon> usedCoupon = new HashSet<>();

}
