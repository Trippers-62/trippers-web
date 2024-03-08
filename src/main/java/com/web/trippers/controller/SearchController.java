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

    //검색 결과
    @GetMapping("/search/result")
    public String getSearchResult(@ModelAttribute("searchForm") SearchForm searchForm,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  Model model){

        Pageable pageable = PageRequest.of(page, 5, Sort.by("price").ascending());

        //항공권 가져오기
        if (searchForm.getTripType().equals("oneWay")){
            Page<OneWayFlight> flights = flightService.getOneWayFlights(searchForm, pageable);
            model.addAttribute("flights", flights);

        } else if(searchForm.getTripType().equals("roundTrip")){
            Page<RoundFlight> flights = flightService.getRoundFlights(searchForm, pageable);
            model.addAttribute("flights", flights);
        }

        return "searchResult";
    }

    //숙소 결과
    @GetMapping("/search/result/accomodations")
    public String showAccomodations(@ModelAttribute("searchForm") SearchForm searchForm,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    Model model) {

        Pageable pageable = PageRequest.of(page, 5, Sort.by("price").ascending());


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