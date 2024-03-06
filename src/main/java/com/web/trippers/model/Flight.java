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
    private BigDecimal price;
    private String airline;
    private Integer transferCount;
    private String carrierCode;
    private String cabinClass;
    private Integer numberOfSeats;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
