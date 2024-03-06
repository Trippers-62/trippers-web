package com.web.trippers.controller;

import com.web.trippers.model.*;
import com.web.trippers.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

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

//        Page<Recommendation> recommendations = recommendationService.getOneDayRecommendations(searchForm, pageable);
        Page<CityRecommendation> recommendations = recommendationService.getCityRecommendations(searchForm, pageable);

        model.addAttribute("recommendations", recommendations);

        return "recommendationResult";
    }


    //편도와 왕복 항공권에 따라 추천하기
//    @GetMapping("/recommendation/result")
//    public String getRecommendationResult(@ModelAttribute("searchForm") SearchForm searchForm, Model model, Pageable pageable){
//
//        if (searchForm.getTripType().equals("oneWay")){
//
//            Page<Recommendation> recommendations = recommendationService.getOneDayRecommendations(searchForm, pageable);
//            model.addAttribute("recommendations", recommendations);
//
//        } else if(searchForm.getTripType().equals("roundTrip")){
//            Map<RoundFlight, List<Accomodation>> recommendation = recommendationService.getSeveralDaysRecommendations(searchForm, pageable);
//
//            // recommendation이 비어있지 않은 경우
//            if (!recommendation.isEmpty()) {
//                Map.Entry<RoundFlight, List<Accomodation>> firstEntry = recommendation.entrySet().stream().findFirst().orElse(null);
//                if (firstEntry != null) {
//                    RoundFlight flight = firstEntry.getKey();
//                    List<Accomodation> accomodations = firstEntry.getValue();
//                    model.addAttribute("flight", flight);
//                    model.addAttribute("accomodations", accomodations);
//
//                }
//            }
//        }
//
//        return "recommendationResult2";
//    }

}
