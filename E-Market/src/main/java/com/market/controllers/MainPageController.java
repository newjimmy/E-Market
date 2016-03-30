package com.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping({"/", "/home"})
    public String getMainPage() {
        return "WEB-INF/pages/home.jsp";
    }
}