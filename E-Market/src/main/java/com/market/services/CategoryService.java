package com.market.services;

import com.market.models.Category;
import com.market.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Category> getListOfCategories() {
        return categoriesRepository.getAllCategories();
    }
}
