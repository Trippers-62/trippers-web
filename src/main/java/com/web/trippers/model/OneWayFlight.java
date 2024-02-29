package com.web.trippers.model;

import com.web.trippers.model.entity.OneWayFlightEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class OneWayFlight extends Flight{

    public OneWayFlight(Integer id, City departureCity, City arrivalCity, LocalDateTime departureDatetime,
                        BigDecimal price, String airline, Integer transferCount,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, departureCity, arrivalCity, departureDatetime, price, airline, transferCount, createdAt, updatedAt);
    }

    //OneWayFlightEntity -> OneWayFlight
    public static OneWayFlight fromEntity(OneWayFlightEntity entity) {
        return new OneWayFlight(
                entity.getId(),
                City.fromEntity(entity.getDepartureCity()),
                City.fromEntity(entity.getArrivalCity()),
                entity.getDepartureDatetime(),
                entity.getPrice(),
                entity.getAirline(),
                entity.getTransferCount(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}