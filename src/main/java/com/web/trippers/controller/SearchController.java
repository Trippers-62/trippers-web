package com.web.trippers.controller;
import com.web.trippers.model.Accomodation;
import com.web.trippers.model.Flight;
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

import java.util.List;

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

    //검색 결과
    @GetMapping("/search/result")
    public String getSearchResult(@ModelAttribute("searchForm") SearchForm searchForm, Model model, Pageable pageable){

        if (searchForm.getTripType().equals("oneWay")){
            Page<OneWayFlight> flights = flightService.findOneWayFlights(searchForm, pageable);
            model.addAttribute("flights", flights);

        } else if(searchForm.getTripType().equals("roundTrip")){
            Page<RoundFlight> flights = flightService.findRoundFlights(searchForm, pageable);
            model.addAttribute("flights", flights);
        }

        Page<Accomodation> accomodations = accomodationService.findAccomodations(searchForm, pageable);
        model.addAttribute("accomodations", accomodations);

        return "searchResult";
    }


    //TODO: test
    @GetMapping("/flights")
    public String showFlights(Model model, Pageable pageable) {
        Pageable pageableWithFiveElements = PageRequest.of(pageable.getPageNumber(), 5);
        Page<OneWayFlight> flightPage = flightService.findAll(pageableWithFiveElements);
        model.addAttribute("flights", flightPage);
        return "test";
    }


//    @GetMapping
//    public Response<Page<PostResponse>> list(Pageable pageable, Authentication authentication) {
//        return Response.success(postService.list(pageable).map(PostResponse::fromPost));
//    }


}