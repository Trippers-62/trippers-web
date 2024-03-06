package com.web.trippers.controller;
import com.web.trippers.model.Accomodation;
import com.web.trippers.model.OneWayFlight;
import com.web.trippers.model.RoundFlight;
import com.web.trippers.service.AccomodationService;
import com.web.trippers.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final FlightService flightService;
    private final AccomodationService accomodationService;

    //검색 폼
    @GetMapping("/search")
    public String getSearchForm(){
        return "search";
    }

    @GetMapping("/team")
    public String getTeamInfo(){
        return "team"; //templates-> html 파일 이름
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    //검색 결과
    @GetMapping("/search/result")
    public String getSearchResult(@ModelAttribute("searchForm") SearchForm searchForm, Model model, Pageable pageable){

        Pageable pageableWithFiveElementsSortByPrice = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("price").ascending());

        //항공권 가져오기
        if (searchForm.getTripType().equals("oneWay")){
            Page<OneWayFlight> flights = flightService.getOneWayFlights(searchForm, pageableWithFiveElementsSortByPrice);
            model.addAttribute("flights", flights);

        } else if(searchForm.getTripType().equals("roundTrip")){
            Page<RoundFlight> flights = flightService.getRoundFlights(searchForm, pageableWithFiveElementsSortByPrice);
            model.addAttribute("flights", flights);
        }

        return "searchResult";
    }

    @GetMapping("/search/result/accomodations")
    public String showAccomodations(@ModelAttribute("searchForm") SearchForm searchForm, Model model, Pageable pageable) {

        if (searchForm.getTripType().equals("oneWay")){
            Page<Accomodation> accomodations = accomodationService.getAccomodationsByCityAndDate(searchForm, pageable);
            model.addAttribute("accomodations", accomodations);

        } else if(searchForm.getTripType().equals("roundTrip")){
            Map<LocalDate,Page<Accomodation>> accomodationsByDate = accomodationService.getAccomodationsBetweenDepartureDateAndReturnDate(searchForm, pageable);
            model.addAttribute("accomodationsByDate", accomodationsByDate);
        }

        return "searchAccomodationResult";
    }


}