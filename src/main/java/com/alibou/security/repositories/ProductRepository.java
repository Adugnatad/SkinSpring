package com.alibou.security.repositories;

import java.util.Optional;

import com.alibou.security.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    Products findByProductId(Integer product_id);
}
