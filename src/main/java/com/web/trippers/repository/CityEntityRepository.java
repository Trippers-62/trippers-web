package com.web.trippers.repository;

import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityEntityRepository extends JpaRepository<CityEntity, Integer> {

    CityEntity findByName(String name);

}