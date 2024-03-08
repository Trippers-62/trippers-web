package com.web.trippers.model;

import com.web.trippers.model.entity.RoundFlightEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
public class RoundFlight extends Flight{

    private City returnDepartureCity;
    private City returnArrivalCity;
    private LocalDateTime returnDepartureDatetime;
    private LocalDateTime returnArrivalDatetime;
    private String returnCarrierCode;
    private String returnCabinClass;
    private Integer returnNumberOfSeats;
    private String returnDepartureTerminal;
    private String returnArrivalTerminal;
    private String returnDuration;

    public RoundFlight(Integer id, City departureCity, City arrivalCity, LocalDateTime departureDatetime,
                       LocalDateTime arrivalDatetime,
                       City returnDepartureCity, City returnArrivalCity,
                       LocalDateTime returnDepartureDatetime,
                       LocalDateTime returnArrivalDatetime,
                       BigDecimal price,
                       String carrierCode, String cabinClass, Integer numberOfSeats,
                       String departureTerminal, String arrivalTerminal, String duration,
                       String returnCarrierCode, String returnCabinClass, Integer returnNumberOfSeats,
                       String returnDepartureTerminal, String returnArrivalTerminal, String returnDuration,
                       LocalDateTime createdAt, LocalDateTime updatedAt) {

        super(id, departureCity, arrivalCity, departureDatetime, arrivalDatetime, price,
                carrierCode, cabinClass, numberOfSeats,
                departureTerminal, arrivalTerminal, duration, createdAt, updatedAt);

        this.returnDepartureCity = returnDepartureCity;
        this.returnArrivalCity = returnArrivalCity;
        this.returnDepartureDatetime = returnDepartureDatetime;
        this.returnArrivalDatetime = returnArrivalDatetime;
        this.returnCarrierCode = returnCarrierCode;
        this.returnCabinClass = returnCabinClass;
        this.returnNumberOfSeats = returnNumberOfSeats;
        this.returnDepartureTerminal = returnDepartureTerminal;
        this.returnArrivalTerminal = returnArrivalTerminal;
        this.returnDuration = returnDuration;

    }

    //RoundFlightEntity -> RoundFlight

    public static RoundFlight fromEntity(RoundFlightEntity entity) {
        return new RoundFlight(
                entity.getId(),
                City.fromEntity(entity.getDepartureCity()),
                City.fromEntity(entity.getArrivalCity()),
                entity.getDepartureDatetime(),
                entity.getArrivalDatetime(),
                City.fromEntity(entity.getReturnDepartureCity()),
                City.fromEntity(entity.getReturnArrivalCity()),
                entity.getReturnDepartureDatetime(),
                entity.getReturnArrivalDatetime(),
                entity.getPrice(),
                entity.getCarrierCode(),
                entity.getCabinClass(),
                entity.getNumberOfSeats(),
                entity.getDepartureTerminal(),
                entity.getArrivalTerminal(),
                entity.getDuration(),
                entity.getReturnCarrierCode(),
                entity.getReturnCabinClass(),
                entity.getReturnNumberOfSeats(),
                entity.getReturnDepartureTerminal(),
                entity.getReturnArrivalTerminal(),
                entity.getReturnDuration(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}
