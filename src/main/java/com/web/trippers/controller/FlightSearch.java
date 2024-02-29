package com.web.trippers.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class FlightSearch {

    private String departureCity;
    private String arrivalCity;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private BigDecimal budget;
    private String tripType;

}