package com.web.trippers.repository;

import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OneWayFlightEntityRepository extends JpaRepository<OneWayFlightEntity, Integer> {

    Page<OneWayFlightEntity> findAll(Pageable pageable);

//    Page<OneWayFlightEntity> findByDepartureCityAndArrivalCity(CityEntity departureCity, CityEntity arrivalCity);

    @Query("SELECT o FROM OneWayFlightEntity o WHERE DATE(o.departureDatetime) = :departureDate")
    Page<OneWayFlightEntity> findByDepartureDate(@Param("departureDate") LocalDate departureDate, Pageable pageable);

    //arrival <-> departure
    @Query("SELECT o FROM OneWayFlightEntity o WHERE DATE(o.departureDatetime) = :departureDate AND o.arrivalCity = :departureCity AND o.departureCity = :arrivalCity")
    Page<OneWayFlightEntity> findByDepartureCityAndArrivalCityAndDepartureDate(
            @Param("departureCity") CityEntity departureCity,
            @Param("arrivalCity") CityEntity arrivalCity,
            @Param("departureDate") LocalDate departureDate,
            Pageable pageable
    );

}