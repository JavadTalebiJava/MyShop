package com.ecommerce.myshop.controller;

import com.ecommerce.myshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/urunler")
    public String catalogPage(Model model) {
        model.addAttribute("urunler", productService.findAll());
        //list.stream().forEach(System.out::println);
        return "catalog";
    }

    @GetMapping("/urunler/{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("urun", productService.getOne(id));
        return "details";
    }
}
