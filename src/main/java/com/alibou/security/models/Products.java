package com.alibou.security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productId;

    private String product_name;

    private String product_quantity;

    private String product_price;
}
