package com.ecommerce.myshop.controller;

import com.ecommerce.myshop.domain.Product;
import com.ecommerce.myshop.payload.ProductPayload;
import com.ecommerce.myshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/urunler")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String catalogPage(Model model) {
        model.addAttribute("urunler", productService.findAll());
        //list.stream().forEach(System.out::println);
        return "catalog";
    }

    @GetMapping("/{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("urun", productService.getOne(id));
        return "details";
    }

    @GetMapping("/ekle")
    public String addPage() {
        return "addProduct";
    }


    @PostMapping("/ekle")
    @ResponseBody
    public Product save(@ModelAttribute ProductPayload productPayload) {
        return productService.add(productPayload);
    }
}
