package com.web.trippers.service;

import com.web.trippers.controller.SearchForm;
import com.web.trippers.model.Accomodation;
import com.web.trippers.model.Flight;
import com.web.trippers.model.Recommendation;
import com.web.trippers.model.entity.AccomodationEntity;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.repository.AccomodationEntityRepository;
import com.web.trippers.repository.CityEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccomodationService {

    private final CityEntityRepository cityEntityRepository;
    private final AccomodationEntityRepository accomodationEntityRepository;

    //검색 조건에 맞는 숙소 찾기
    public Page<Accomodation> getAccomodationsByCityAndDate(SearchForm searchForm, Pageable pageable) {

        CityEntity arrivalCityEntity = cityEntityRepository.findByName(searchForm.getArrivalCity());

        return accomodationEntityRepository
                .findByArrivalCityAndCheckinDate(
                        arrivalCityEntity, searchForm.getDepartureDate(), pageable
                ).map(Accomodation::fromEntity);
    }


    //여러 날짜의 숙소 찾기
    public Map<LocalDate,Page<Accomodation>> getAccomodationsBetweenDepartureDateAndReturnDate(SearchForm searchForm, Pageable pageable) {

        Map<LocalDate, Page<Accomodation>> accomodationsByDate = new HashMap<>();

        CityEntity city = cityEntityRepository.findByName(searchForm.getArrivalCity());
        LocalDate startDate = searchForm.getDepartureDate();
        LocalDate endDate = searchForm.getReturnDate();

        //마지막 날은 귀국 날짜이므로 포함하지 않음
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {

            Page<Accomodation> accomodations = accomodationEntityRepository
                    .findByArrivalCityAndCheckinDate(
                            city, date, pageable
                    ).map(Accomodation::fromEntity);

            accomodationsByDate.put(date, accomodations);
        }

        return accomodationsByDate;
    }

    //평점 기준 이상의 숙소 찾기
    public Page<Accomodation> getByArrivalCityAndCheckinDateWithMinRating(SearchForm searchForm, BigDecimal minRating, Pageable pageable) {
        CityEntity arrivalCityEntity = cityEntityRepository.findByName(searchForm.getArrivalCity());

        return accomodationEntityRepository
                .findByArrivalCityAndCheckinDateWithMinRating(
                        arrivalCityEntity, searchForm.getDepartureDate(), minRating, pageable)
                .map(Accomodation::fromEntity);
    }

    //특정한 도시와 날짜의 평점 기준 이상의 숙소 찾기
    public Page<Accomodation> getBySpecificArrivalCityAndCheckinDateWithMinRating(CityEntity arrivalCity, LocalDate checkinDate, BigDecimal minRating, Pageable pageable) {

        return accomodationEntityRepository
                .findByArrivalCityAndCheckinDateWithMinRating(
                        arrivalCity, checkinDate, minRating, pageable)
                .map(Accomodation::fromEntity);
    }

    public Page<Accomodation> findAll(Pageable pageable) {

        return accomodationEntityRepository
                .findAll(pageable).map(Accomodation::fromEntity);
    }
}
