package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepositoryDao;
    public Product addNewProduct(Product product){
       return productRepositoryDao.save(product);

    }

}
