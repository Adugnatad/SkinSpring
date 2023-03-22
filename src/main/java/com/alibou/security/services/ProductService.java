package com.alibou.security.services;

import com.alibou.security.models.Products;
import com.alibou.security.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public void addProduct (Products product){
        productRepository.save(product);
    }

    public Products getProductById (Integer product_id){
      return  productRepository.findByProductId(product_id);
    }
    public List<Products> getProducts (){
        return productRepository.findAll();
    }
}
