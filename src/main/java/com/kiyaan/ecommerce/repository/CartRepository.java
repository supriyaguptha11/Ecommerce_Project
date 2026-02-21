package com.kiyaan.ecommerce.repository;

import com.kiyaan.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {


}
