package com.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/")
public class MainPageController {
    private static final String MAIN_PAGE = "index";

    @RequestMapping(value = {"/", "index", "home"})
    public String getMainPage() {
        return MAIN_PAGE;
    }
}
