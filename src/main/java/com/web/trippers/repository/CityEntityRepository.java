package com.web.trippers.repository;

import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.CountryEntity;
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
public interface CityEntityRepository extends JpaRepository<CityEntity, Integer> {

    CityEntity findByName(String name);

    Page<CityEntity> findAll(Pageable pageable);

    Page<CityEntity> findByCountry(CountryEntity country, Pageable pageable);



}