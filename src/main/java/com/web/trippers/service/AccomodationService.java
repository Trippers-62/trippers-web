package com.web.trippers.service;

import com.web.trippers.controller.SearchForm;
import com.web.trippers.model.Accomodation;
import com.web.trippers.model.OneWayFlight;
import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.repository.AccomodationEntityRepository;
import com.web.trippers.repository.CityEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccomodationService {

    private final CityEntityRepository cityEntityRepository;
    private final AccomodationEntityRepository accomodationEntityRepository;

    //검색 조건에 맞는 숙소 찾기
    public Page<Accomodation> findAccomodations(SearchForm searchForm, Pageable pageable) {

        CityEntity arrivalCityEntity = cityEntityRepository.findByName(searchForm.getArrivalCity());

        return accomodationEntityRepository
                .findByArrivalCityAndCheckinDate(
                        arrivalCityEntity, searchForm.getDepartureDate(), pageable
                ).map(Accomodation::fromEntity);
    }

    public Page<Accomodation> findAll(Pageable pageable) {

        return accomodationEntityRepository
                .findAll(pageable).map(Accomodation::fromEntity);
    }
}
