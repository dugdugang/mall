package com.dg.mall.controller;

import com.dg.mall.pojo.Product;
import com.dg.mall.pojo.ProductCustom;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

//    @RequestMapping("/products")
//    public String  getProductList(Model model) {
//        List<ProductCustom> productaCustoms = productService.getProductaCustoms(0, 0);
//        model.addAttribute("productList", productaCustoms);
//        return "product_list_";
//    }

    @RequestMapping("/products")
    public String getStringList(Model model, @RequestParam(value = "page",defaultValue = "0") int page  , @RequestParam(value = "rows",defaultValue = "10") int rows) {
        PageInfo<ProductCustom> productaCustoms = productService.getProductaCustoms(page, rows);
        model.addAttribute("pageinfo", productaCustoms);
        return "product_list_";
    }



}
