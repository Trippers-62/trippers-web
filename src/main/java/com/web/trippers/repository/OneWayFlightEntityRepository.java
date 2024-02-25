package com.web.trippers.repository;

import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OneWayFlightEntityRepository extends JpaRepository<OneWayFlightEntity, Integer> {

    List<OneWayFlightEntity> findAll();
    List<OneWayFlightEntity> findByDepartureCityAndArrivalCity(CityEntity departureCity, CityEntity arrivalCity);

//    List<OneWayFlightEntity> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);

}