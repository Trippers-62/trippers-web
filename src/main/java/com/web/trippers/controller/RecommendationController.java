package com.web.trippers.controller;

import com.web.trippers.model.Recommendation;
import com.web.trippers.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public String getRecommendationForm() {
        return "recommendation";
    }


    @GetMapping("/recommendation/result")
    public String getRecommendationResult(@ModelAttribute("searchForm") SearchForm searchForm, Model model, Pageable pageable){

        Page<Recommendation> recommendations = recommendationService.getRecommendations(searchForm, pageable);

        model.addAttribute("recommendations", recommendations);

        return "recommendationResult";
    }

}
