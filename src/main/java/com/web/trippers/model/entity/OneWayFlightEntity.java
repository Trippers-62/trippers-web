package com.web.trippers.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"one_way_flight\"")
@Getter
@Setter
public class OneWayFlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="departure_city_id")
    private CityEntity departureCity;

    @ManyToOne
    @JoinColumn(name="arrival_city_id")
    private CityEntity arrivalCity;

    @Column(name = "departure_datetime")
    private LocalDateTime departureDatetime;

    @Column(name = "arrival_datetime")
    private LocalDateTime arrivalDatetime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "carrier_code")
    private String carrierCode;

    @Column(name = "cabin_class")
    private String cabinClass;

    @Column(name = "number_of_bookable_seats")
    private Integer numberOfSeats;

    @Column(name = "departure_terminal")
    private Integer departureTerminal;

    @Column(name = "arrival_terminal")
    private Integer arrivalTerminal;

    @Column(name = "duration")
    private String duration;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
