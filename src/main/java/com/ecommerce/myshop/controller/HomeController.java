package com.ecommerce.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    //@GetMapping({"/catalog", "/urun-katalogu", "/urun-katalog"})

    @RequestMapping(produces = "application/json; charset=UTF-8", value = {"/catalog", "/urun-katalogu", "/urun-katalog"}, method = RequestMethod.GET)
    public String catalogPage() {
        return "catalog";
    }
}
