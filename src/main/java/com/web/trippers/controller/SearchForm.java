package com.web.trippers.controller;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SearchForm {

    private String departureCity;
    private String arrivalCity;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private BigDecimal budget;
    private String tripType;

}