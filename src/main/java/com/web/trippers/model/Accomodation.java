package com.web.trippers.model;

import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Accomodation {

    private Integer id;
    private City city;
    private Float latitude;
    private Float longitude;
    private BigDecimal price;
    private BigDecimal rating;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //AccomodationEntity -> Accomodation
    public static Accomodation fromEntity(AccomodationEntity entity) {
        return new Accomodation(
                entity.getId(),
                City.fromEntity(entity.getCity()),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getPrice(),
                entity.getRating(),
                entity.getCheckinDate(),
                entity.getCheckoutDate(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
