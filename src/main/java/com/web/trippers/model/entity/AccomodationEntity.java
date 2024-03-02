package com.web.trippers.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"accomodation\"")
@Getter
public class AccomodationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="city_id")
    private CityEntity city;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    //TODO: 삭제여부 확인
    @Column(name = "latitude")
    private Float latitude;

    //TODO: 삭제여부 확인
    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "checkin_date")
    private LocalDate checkinDate;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
