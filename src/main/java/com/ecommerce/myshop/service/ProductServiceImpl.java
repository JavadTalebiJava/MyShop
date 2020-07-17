package com.ecommerce.myshop.service;

import com.ecommerce.myshop.domain.Brand;
import com.ecommerce.myshop.domain.Product;
import com.ecommerce.myshop.payload.ProductPayload;
import com.ecommerce.myshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandService brandService;

    public ProductServiceImpl(ProductRepository productRepository, BrandService brandService) {
        this.productRepository = productRepository;
        this.brandService = brandService;
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
    @Transactional
    public Product add(ProductPayload productPayload) {
        Optional<Brand> optBrand = brandService.findByName("default");
        if (optBrand.isPresent()) {
            Product product = new Product(null, productPayload.getName(), productPayload.getImg(), productPayload.getPrice(), productPayload.getBarcode(), optBrand.get());
            return this.save(product);
        } else {
            Brand brand = new Brand("default");
            brand = brandService.save(brand);
            Product product = new Product(null, productPayload.getName(), productPayload.getImg(), productPayload.getPrice(), productPayload.getBarcode(), brand);
            return this.save(product);
        }


    }
}
