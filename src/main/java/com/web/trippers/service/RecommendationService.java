package com.web.trippers.service;

import com.web.trippers.controller.SearchForm;
import com.web.trippers.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final FlightService flightService;
    private final AccomodationService accomodationService;
    private Page<? extends Flight> flights = null;

    public Page<Recommendation> getRecommendations(SearchForm searchForm, Pageable pageable){

        Pageable pageableWithFiveElementsSortByPrice = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("price").ascending());
        Pageable pageableWithFiveElementsSortByRating = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("rating").descending());

        //항공권 가져오기
        if (searchForm.getTripType().equals("oneWay")){
            flights = flightService.getOneWayFlights(searchForm, pageableWithFiveElementsSortByPrice);

        } else if(searchForm.getTripType().equals("roundTrip")){
            flights = flightService.getRoundFlights(searchForm, pageableWithFiveElementsSortByPrice);
        }

        //숙소 가져오기
        Page<Accomodation> accomodations = accomodationService.findAccomodations(searchForm, pageableWithFiveElementsSortByRating);

        List<Recommendation> recommendations = new ArrayList<>();

        if(flights != null) {
            for (Flight flight : flights.getContent()) {
                for (Accomodation accomodation : accomodations.getContent()) {
                    //항공권 가격과 숙소 가격 더해서 예산과 비교
                    if (isWithinBudget(searchForm.getBudget(), flight.getPrice().add(accomodation.getPrice()))) {
                        recommendations.add(new Recommendation(flight, accomodation));
                    }
                }
            }
        }

        //TODO : 왕복일 때 날짜별로 숙소 찾아서 가져오는 것 구현하기
        System.out.println("Recommendations : " + recommendations.size());

        Page<Recommendation> recommendationResult = new PageImpl<>(recommendations, pageable, recommendations.size());

        return recommendationResult;
    }

        private boolean isWithinBudget(BigDecimal budget, BigDecimal totalPrice) {
            return totalPrice.compareTo(budget) <= 0;
        }

}
