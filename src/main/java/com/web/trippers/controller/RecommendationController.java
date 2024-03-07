package com.web.trippers.controller;

import com.web.trippers.model.*;
import com.web.trippers.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;


    @GetMapping("/recommendation/result")
    public String getRecommendationResult(@ModelAttribute("searchForm") SearchForm searchForm,
                                          @RequestParam(name = "page", defaultValue = "0") int page,
                                          Model model){

        Pageable pageable = PageRequest.of(page, 5);

        Page<CityRecommendation> recommendations = recommendationService.getCityRecommendations(searchForm, pageable);
        model.addAttribute("recommendations", recommendations);

        return "recommendationResult";
    }


}
