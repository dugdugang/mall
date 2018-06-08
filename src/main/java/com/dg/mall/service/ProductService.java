package com.dg.mall.service;

import com.dg.mall.pojo.Product;
import com.dg.mall.pojo.ProductCustom;
import com.dg.mall.pojo.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

   PageInfo getProductaCustoms(int page, int rows);
}
