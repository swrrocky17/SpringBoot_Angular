package com.luv2code.ecommerce.controller;
import com.luv2code.ecommerce.entity.Product;


import com.luv2code.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRepositoryController {
    //Add API

    @Autowired
    private ProductService productService;

    @PostMapping({"/addNewProduct"})
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);

    }

}


