package com.web.trippers.model;

import com.web.trippers.model.entity.RoundFlightEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class RoundFlight extends Flight{

    private City returnDepartureCity;
    private City returnArrivalCity;
    private LocalDateTime returnDepartureDatetime;

    public RoundFlight(Integer id, City departureCity, City arrivalCity, LocalDateTime departureDatetime,
                       City returnDepartureCity, City returnArrivalCity, LocalDateTime returnDepartureDatetime,
                       BigDecimal price, String airline, Integer transferCount,
                       String carrierCode, String cabinClass, Integer numberOfSeats,
                       LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, departureCity, arrivalCity, departureDatetime, price, airline, transferCount, carrierCode, cabinClass, numberOfSeats, createdAt, updatedAt);

        this.returnDepartureCity = returnDepartureCity;
        this.returnArrivalCity = returnArrivalCity;
        this.returnDepartureDatetime = returnDepartureDatetime;
    }

    //RoundFlightEntity -> RoundFlight
    public static RoundFlight fromEntity(RoundFlightEntity entity) {
        return new RoundFlight(
                entity.getId(),
                City.fromEntity(entity.getDepartureCity()),
                City.fromEntity(entity.getArrivalCity()),
                entity.getDepartureDatetime(),
                City.fromEntity(entity.getReturnDepartureCity()),
                City.fromEntity(entity.getReturnArrivalCity()),
                entity.getReturnDepartureDatetime(),
                entity.getPrice(),
                entity.getAirline(),
                entity.getTransferCount(),
                entity.getCarrierCode(),
                entity.getCabinClass(),
                entity.getNumberOfSeats(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}
