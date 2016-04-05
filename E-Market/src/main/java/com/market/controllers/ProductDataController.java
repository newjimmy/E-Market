package com.market.controllers;

import com.market.models.Product;
import com.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductDataController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/loadListOfProducts")
    @ResponseBody
    public List<Product> loadListOfProducts() {
        return productService.getListOfProducts();
    }

}