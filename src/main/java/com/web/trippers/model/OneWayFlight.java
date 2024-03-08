package com.web.trippers.model;

import com.web.trippers.model.entity.OneWayFlightEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
public class OneWayFlight extends Flight{

    public OneWayFlight(Integer id, City departureCity, City arrivalCity, LocalDateTime departureDatetime,
                        LocalDateTime arrivalDatetime,
                        BigDecimal price, String carrierCode, String cabinClass, Integer numberOfSeats,
                        String departureTerminal, String arrivalTerminal, String duration,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, departureCity, arrivalCity, departureDatetime, arrivalDatetime, price,
                carrierCode, cabinClass, numberOfSeats,
                departureTerminal, arrivalTerminal, duration,
                createdAt, updatedAt);
    }

    //OneWayFlightEntity -> OneWayFlight
    public static OneWayFlight fromEntity(OneWayFlightEntity entity) {
        return new OneWayFlight(
                entity.getId(),
                City.fromEntity(entity.getDepartureCity()),
                City.fromEntity(entity.getArrivalCity()),
                entity.getDepartureDatetime(),
                entity.getArrivalDatetime(),
                entity.getPrice(),
                entity.getCarrierCode(),
                entity.getCabinClass(),
                entity.getNumberOfSeats(),
                entity.getDepartureTerminal(),
                entity.getArrivalTerminal(),
                entity.getDuration(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}