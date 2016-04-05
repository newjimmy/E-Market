package com.market.controllers;

import com.market.models.Product;
import com.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class ProductDataController {

    @Autowired
    protected ProductService productService;

    @RequestMapping(value = "/loadListOfProducts")
    @ResponseBody
    public List<Product> loadListOfProducts() {
        return productService.getListOfProducts();
    }

}