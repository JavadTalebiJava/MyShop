package com.ecommerce.myshop.service;

import com.ecommerce.myshop.domain.Product;
import com.ecommerce.myshop.payload.ProductPayload;
import com.ecommerce.myshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product add(ProductPayload productPayload) {
        Product product = new Product(null, productPayload.getName(), productPayload.getImg(), productPayload.getPrice(), productPayload.getBarcode());
        return this.save(product);
    }
}
