package com.web.trippers.repository;

import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.RoundFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoundFlightEntityRepository extends JpaRepository<RoundFlightEntity, Integer> {

    List<RoundFlightEntity> findAll();

    List<RoundFlightEntity> findByDepartureCityAndArrivalCity(CityEntity departureCity, CityEntity arrivalCity);

    @Query("SELECT r FROM RoundFlightEntity r WHERE DATE(r.departureDatetime) = :departureDate AND DATE(r.returnDepartureDatetime) = :returnDate")
    List<RoundFlightEntity> findByDepartureDateAndReturnDate(@Param("departureDate") LocalDate departureDate, @Param("returnDate") LocalDate returnDate);

    @Query("SELECT r FROM RoundFlightEntity r WHERE DATE(r.departureDatetime) = :departureDate AND DATE(r.returnDepartureDatetime) = :returnDate AND r.departureCity = :departureCity AND r.arrivalCity = :arrivalCity")
    List<RoundFlightEntity> findByDepartureCityAndArrivalCityAndDepartureDateAndReturnDate(
            @Param("departureCity") CityEntity departureCity,
            @Param("arrivalCity") CityEntity arrivalCity,
            @Param("departureDate") LocalDate departureDate,
            @Param("returnDate") LocalDate returnDate
    );

}