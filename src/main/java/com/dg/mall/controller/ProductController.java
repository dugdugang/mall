package com.dg.mall.controller;

import com.dg.mall.pojo.Product;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public Model getProductList(Model model) {
        List<Product> productList = productService.getProductList();
        productService.getProductList();
        model.addAttribute("productList", productList);
        return model;
    }


}
