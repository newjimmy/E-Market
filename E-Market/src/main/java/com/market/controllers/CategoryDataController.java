package com.market.controllers;

import com.market.models.Category;
import com.market.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryDataController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/loadListOfCategories")
    @ResponseBody
    public List<Category> loadListOfCategories() {
        return categoryService.getListOfCategories();
    }
}
