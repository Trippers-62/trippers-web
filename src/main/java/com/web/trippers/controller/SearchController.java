package com.web.trippers.controller;
import com.web.trippers.model.OneWayFlight;
import com.web.trippers.model.RoundFlight;
import com.web.trippers.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final FlightService flightService;

    //검색 폼
    @GetMapping("/search")
    public String getSearchForm(){
        return "search";
    }

    //검색 결과
    @GetMapping("/search/result")
    public String getSearchResult(@ModelAttribute("flightSearch") FlightSearch flightSearch, Model model){

        if (flightSearch.getTripType().equals("oneWay")){
            List<OneWayFlight> flights = flightService.findOneWayFlights(flightSearch);
            model.addAttribute("flights", flights);

        } else if(flightSearch.getTripType().equals("roundTrip")){
            List<RoundFlight> flights = flightService.findRoundFlights(flightSearch);
            model.addAttribute("flights", flights);
        }

        return "searchResult";
    }


//    @GetMapping
//    public Response<Page<PostResponse>> list(Pageable pageable, Authentication authentication) {
//        return Response.success(postService.list(pageable).map(PostResponse::fromPost));
//    }


}