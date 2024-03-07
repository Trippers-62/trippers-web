package com.web.trippers.model;

import com.web.trippers.model.entity.CityEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Flight {

    private Integer id;
    private City departureCity;
    private City arrivalCity;
    private LocalDateTime departureDatetime;
    private LocalDateTime arrivalDatetime;
    private BigDecimal price;
    private String carrierCode;
    private String cabinClass;
    private Integer numberOfSeats;
    private Integer departureTerminal;
    private Integer arrivalTerminal;
    private String duration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
