package com.web.trippers.repository;

import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationEntityRepository extends JpaRepository<AccomodationEntity, Integer> {

    List<AccomodationEntity> findByCity(CityEntity city);

}