package com.web.trippers.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "\"one_way_transfer\"")
public class OneWayTransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private OneWayFlightEntity oneWayFlight;

    @OneToOne
    @JoinColumn(name="city_id")
    private CityEntity city;


    @Column(name = "departure_datetime")
    private LocalDateTime departureDatetime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
