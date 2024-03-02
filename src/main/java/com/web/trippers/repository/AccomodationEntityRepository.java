package com.web.trippers.repository;

import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccomodationEntityRepository extends JpaRepository<AccomodationEntity, Integer> {

    Page<AccomodationEntity> findAll(Pageable pageable);

    //도착한 나라와 출발 시간으로 숙소 찾
    @Query("SELECT a FROM AccomodationEntity a WHERE a.city = :arrivalCity AND a.checkinDate = :departureDate")
    Page<AccomodationEntity> findByArrivalCityAndCheckinDate(@Param("arrivalCity") CityEntity arrivalCity,
                                                              @Param("departureDate") LocalDate departureDate,
                                                              Pageable pageable);
}