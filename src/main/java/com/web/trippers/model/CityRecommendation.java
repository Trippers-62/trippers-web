package com.web.trippers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CityRecommendation {

    private City departureCity;
    private City arrivalCity;
    private Flight flight;
    private List<Accomodation> accomodations;

}