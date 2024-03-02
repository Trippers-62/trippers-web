package com.web.trippers.service;

import com.web.trippers.controller.SearchForm;
import com.web.trippers.model.OneWayFlight;
import com.web.trippers.model.RoundFlight;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.repository.CityEntityRepository;
import com.web.trippers.repository.OneWayFlightEntityRepository;
import com.web.trippers.repository.RoundFlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final OneWayFlightEntityRepository oneWayFlightEntityRepository;
    private final RoundFlightEntityRepository roundFlightEntityRepository;
    private final CityEntityRepository cityEntityRepository;

    //검색 조건에 맞는 편도 항공권 찾기
    public Page<OneWayFlight> findOneWayFlights(SearchForm searchForm, Pageable pageable) {

        CityEntity departureCityEntity = cityEntityRepository.findByName(searchForm.getDepartureCity());
        CityEntity arrivalCityEntity = cityEntityRepository.findByName(searchForm.getArrivalCity());

        return oneWayFlightEntityRepository
                .findByDepartureCityAndArrivalCityAndDepartureDate
                        (departureCityEntity, arrivalCityEntity, searchForm.getDepartureDate(), pageable)
                .map(OneWayFlight::fromEntity);
    }

    //검색 조건에 맞는 왕복 항공권 찾기
    public Page<RoundFlight> findRoundFlights(SearchForm searchForm, Pageable pageable) {

        CityEntity departureCityEntity = cityEntityRepository.findByName(searchForm.getDepartureCity());
        CityEntity arrivalCityEntity = cityEntityRepository.findByName(searchForm.getArrivalCity());

        return roundFlightEntityRepository
                .findByDepartureCityAndArrivalCityAndDepartureDateAndReturnDate(
                        departureCityEntity, arrivalCityEntity, searchForm.getDepartureDate(), searchForm.getReturnDate(), pageable)
                .map(RoundFlight::fromEntity);

    }

    //TODO: test
    public Page<OneWayFlight> findAll(Pageable pageable) {
        return oneWayFlightEntityRepository.findAll(pageable).map(OneWayFlight::fromEntity);
    }

}
