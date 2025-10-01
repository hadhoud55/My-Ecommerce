package com.example.demo.repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);

    @Query("SELECT c FROM Cart c " +
            "LEFT JOIN FETCH c.items i " +
            "LEFT JOIN FETCH i.product " +
            "WHERE c.user.id = :userId")
    Optional<Cart> findByUserIdWithProducts(@Param("userId") Long userId);
}

