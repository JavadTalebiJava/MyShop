package com.ecommerce.myshop.service;

import com.ecommerce.myshop.domain.Product;
import com.ecommerce.myshop.payload.ProductPayload;

import java.util.List;

public interface ProductService {

    Product getOne(Long id);

    Product save(Product product);

    List<Product> findAll();

    Product add(ProductPayload productPayload);
}
