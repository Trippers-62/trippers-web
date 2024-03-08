package com.web.trippers.model;

import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import jakarta.persistence.*;
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
    private String name;
    private String link;
    private String location;
    private BigDecimal price;
    private BigDecimal rating;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer reviewCount;
    private String thumbnail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //AccomodationEntity -> Accomodation
    public static Accomodation fromEntity(AccomodationEntity entity) {
        return new Accomodation(
                entity.getId(),
                City.fromEntity(entity.getCity()),
                entity.getName(),
                entity.getLink(),
                entity.getLocation(),
                entity.getPrice(),
                entity.getRating(),
                entity.getCheckinDate(),
                entity.getCheckoutDate(),
                entity.getReviewCount(),
                entity.getThumbnail(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
