package com.market.services;

import com.market.models.Product;
import com.market.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Product> getListOfProducts() {
        return productsRepository.getAllProducts();
    }

}