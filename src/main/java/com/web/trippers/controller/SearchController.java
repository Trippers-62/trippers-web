package com.web.trippers.controller;
import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import com.web.trippers.repository.AccomodationEntityRepository;
import com.web.trippers.repository.CityEntityRepository;
import com.web.trippers.repository.OneWayFlightEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final CityEntityRepository cityEntityRepository;
    private final OneWayFlightEntityRepository oneWayFlightEntityRepository;
    private final AccomodationEntityRepository accomodationEntityRepository;

    @GetMapping("/search")
    public String getSearchForm(){
        return "search";
    }

    @GetMapping("/search/result")
    public String getSearchResult(@RequestParam("departureCity") String departureCity,
                                  @RequestParam("arrivalCity") String arrivalCity,
                                  @RequestParam("departureDate") LocalDate departureDate,
                                  @RequestParam(value = "returnDate", required = false) LocalDate returnDate,
                                  Model model){

        CityEntity departureCityEntity = cityEntityRepository.findByName(departureCity);
        CityEntity arrivalCityEntity = cityEntityRepository.findByName(arrivalCity);

        List<OneWayFlightEntity> flights = oneWayFlightEntityRepository.findByDepartureCityAndArrivalCity(departureCityEntity, arrivalCityEntity);
        List<AccomodationEntity> accomodations = accomodationEntityRepository.findByCity(arrivalCityEntity);

        model.addAttribute("departureCity", departureCity);
        model.addAttribute("arrivalCity", arrivalCity);
        model.addAttribute("flights", flights);
        model.addAttribute("accomodations", accomodations);

        return "searchResult";
    }


}