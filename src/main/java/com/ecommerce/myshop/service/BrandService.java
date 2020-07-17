package com.ecommerce.myshop.service;

import com.ecommerce.myshop.domain.Brand;

import java.util.Optional;

public interface BrandService {

    Brand save(Brand brand);

    Optional<Brand> findByName(String name);
}
