package com.web.trippers.service;

import com.web.trippers.controller.SearchForm;
import com.web.trippers.model.*;
import com.web.trippers.repository.AccomodationEntityRepository;
import com.web.trippers.repository.CityEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final FlightService flightService;
    private final AccomodationService accomodationService;

    public Page<Recommendation> getOneDayRecommendations(SearchForm searchForm, Pageable pageable){

        Pageable pageableWithFiveElementsSortByPrice = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("price").ascending());
        Pageable pageableWithFiveElementsSortByRating = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("rating").descending());

        //편도 항공권 가져오기
        Page<OneWayFlight> flights = flightService.getOneWayFlights(searchForm, pageableWithFiveElementsSortByPrice);

        //숙소 가져오기
        Page<Accomodation> accomodations = accomodationService.getAccomodationsByCityAndDate(searchForm, pageableWithFiveElementsSortByRating);

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

        return new PageImpl<>(recommendations, pageable, recommendations.size());
    }


    //출발 항공권과 숙소 가격 총합이 예산 이하인 경우 하나 추천하기
    public Map<RoundFlight, List<Accomodation>> getSeveralDaysRecommendations(SearchForm searchForm, Pageable pageable){

        Map<RoundFlight, List<Accomodation>> recommendation = new HashMap<>();

        Pageable pageableWithTwoElementsSortByPrice = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("price").ascending());

        //왕복 항공권 가져오기
        Page<RoundFlight> flights = flightService.getRoundFlights(searchForm, pageableWithTwoElementsSortByPrice);

        //숙소 그룹 만들기
        List<Accomodation> accommodationGroup = new ArrayList<>();
        BigDecimal totalAccommodationPrice = BigDecimal.ZERO;

        LocalDate startDate = searchForm.getDepartureDate();
        LocalDate endDate = searchForm.getReturnDate();



        //TODO : 기준 평점 5.0
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {

            //날짜별 숙소 가져오기
            Page<Accomodation> accomodations = accomodationService.getByArrivalCityAndCheckinDateWithMinRating(searchForm, BigDecimal.valueOf(5.0), pageableWithTwoElementsSortByPrice);
            if (!accomodations.isEmpty()) {
                Accomodation accomodation = accomodations.getContent().get(0);
                accommodationGroup.add(accomodation);
                totalAccommodationPrice = totalAccommodationPrice.add(accomodation.getPrice());
            }
        }

        System.out.println("accomodation size" + accommodationGroup.size()); //0이 나옴 왜??

        //제일 싼 비행기 티켓
        if(!flights.isEmpty()){
            RoundFlight flight = flights.getContent().get(0);
            if (isWithinBudget(searchForm.getBudget(), flight.getPrice().add(totalAccommodationPrice))) {
                recommendation.put(flight, accommodationGroup);
            }

            System.out.println("flight data" + flight.toString());
        }


        return recommendation;
    }


    private boolean isWithinBudget(BigDecimal budget, BigDecimal totalPrice) {
            return totalPrice.compareTo(budget) <= 0;
        }

}
