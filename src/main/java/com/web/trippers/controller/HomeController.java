package com.web.trippers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String getHome(){
        return "index";
    }

    @GetMapping("/search")
    public String getSearchForm(){
        return "search";
    }

    @GetMapping("/team")
    public String getTeamInfo() {
        return "team";
    }

    @GetMapping("/recommendation")
    public String getRecommendationForm() {
        return "recommendation";
    }



}
