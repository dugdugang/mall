package com.dg.mall.service.impl;

import com.dg.mall.mapper.ProductMapper;
import com.dg.mall.pojo.Product;
import com.dg.mall.pojo.ProductExample;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList() {
        ProductExample productExample = new ProductExample();
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }
}
