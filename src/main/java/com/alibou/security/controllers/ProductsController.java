package com.alibou.security.controllers;


import com.alibou.security.models.Products;
import com.alibou.security.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Object> addProducts(@RequestBody Products product){
        Products newProduct = Products.builder()
                .product_name(product.getProduct_name())
                .product_price(product.getProduct_price())
                .product_quantity(product.getProduct_quantity())
                .build();
        productService.addProduct(newProduct);
        productResponse response = new productResponse(newProduct, "Product successfully added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Integer id){
       Products product = productService.getProductById(id);
       return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @GetMapping("")
    public ResponseEntity<List> getAllProducts() {
        List<Products> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editProduct(@RequestBody Products product, @PathVariable Integer id){

        Products newProduct = productService.getProductById(id);
        newProduct.setProduct_name(product.getProduct_name());
        newProduct.setProduct_price(product.getProduct_price());
        newProduct.setProduct_quantity(product.getProduct_quantity());

        productService.addProduct(newProduct);
        productResponse response = new productResponse(newProduct, "product edited");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class productResponse {
    Products products;
    String status;
}
