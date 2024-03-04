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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccomodationEntityRepository extends JpaRepository<AccomodationEntity, Integer> {

    Page<AccomodationEntity> findAll(Pageable pageable);

    //도착한 나라와 출발 시간으로 숙소 찾기
    @Query("SELECT a FROM AccomodationEntity a WHERE a.city = :city AND a.checkinDate = :date")
    Page<AccomodationEntity> findByArrivalCityAndCheckinDate(@Param("city") CityEntity city,
                                                              @Param("date") LocalDate date,
                                                              Pageable pageable);

    //나라, 시간, 평점 기준으로 숙소 찾기
    @Query("SELECT a FROM AccomodationEntity a WHERE a.city = :city AND a.checkinDate = :date AND a.rating >= :minRating")
    Page<AccomodationEntity> findByArrivalCityAndCheckinDateWithMinRating(
            @Param("city") CityEntity city,
            @Param("date") LocalDate date,
            @Param("minRating") BigDecimal minRating,
            Pageable pageable
    );

}