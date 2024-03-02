package com.web.trippers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Recommendation {

    private Flight flight;
    private Accomodation accomodation;

}