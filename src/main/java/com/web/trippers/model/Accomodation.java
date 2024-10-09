package com.web.trippers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accomodation implements Serializable {

    private Integer id;
    private City city;
    private String name;
    private String link;
    private String location;
    private BigDecimal price;
    private BigDecimal rating;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate checkinDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate checkoutDate;

    private Integer reviewCount;
    private String thumbnail;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
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
