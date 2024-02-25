package com.web.trippers.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"round_flight\"")
@Getter
@Setter
public class RoundFlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="departure_city_id")
    private CityEntity departureCity;

    @OneToOne
    @JoinColumn(name="arrival_city_id")
    private CityEntity arrivalCity;

    @Column(name = "departure_datetime")
    private LocalDateTime departureDatetime;

    @OneToOne
    @JoinColumn(name="return_departure_city_id")
    private CityEntity returnDepartureCity;

    @OneToOne
    @JoinColumn(name="return_arrival_city_id")
    private CityEntity returnArrivalCity;

    @Column(name = "return_departure_datetime")
    private LocalDateTime returnDepartureDatetime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "airline")
    private String airline;

    @Column(name = "transfer_count")
    private Integer transferCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
