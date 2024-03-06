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

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "airline")
    private String airline;

    @Column(name = "transfer_count")
    private Integer transferCount;

    @Column(name = "carrier_code")
    private String carrierCode;

    @Column(name = "cabin_class")
    private String cabinClass;

    @Column(name = "number_of_bookable_seats")
    private Integer numberOfSeats;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
