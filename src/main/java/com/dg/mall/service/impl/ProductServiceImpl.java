package com.dg.mall.service.impl;

import com.dg.mall.mapper.ProductCustomMapper;
import com.dg.mall.mapper.ProductMapper;
import com.dg.mall.pojo.Product;
import com.dg.mall.pojo.ProductCustom;
import com.dg.mall.pojo.ProductExample;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCustomMapper productCustomMapper;

    @Override
    public List<Product> getProductList() {
        ProductExample productExample = new ProductExample();
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }

    @Override
    public PageInfo<ProductCustom> getProductaCustoms(int page, int rows) {
        System.out.println("page:"+page+" rows:"+rows);
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询查询语句
        List<ProductCustom> productCustoms = productCustomMapper.getProductCustoms();
        //获取分页信息
        PageInfo<ProductCustom> pageInfo = new PageInfo<>(productCustoms);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
