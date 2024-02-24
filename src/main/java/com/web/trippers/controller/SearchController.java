package com.web.trippers.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class SearchController {

    @GetMapping("/")
    public String search(){
        return "search";
    }

    @GetMapping("/result")
    public String result(){
        return "result";
    }

}