package com.web.trippers.service;

import com.web.trippers.controller.FlightSearch;
import com.web.trippers.model.OneWayFlight;
import com.web.trippers.model.RoundFlight;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.RoundFlightEntity;
import com.web.trippers.repository.CityEntityRepository;
import com.web.trippers.repository.OneWayFlightEntityRepository;
import com.web.trippers.repository.RoundFlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final OneWayFlightEntityRepository oneWayFlightEntityRepository;
    private final RoundFlightEntityRepository roundFlightEntityRepository;
    private final CityEntityRepository cityEntityRepository;

    //검색 조건에 맞는 편도 항공권 찾기
    public List<OneWayFlight> findOneWayFlights(FlightSearch flightSearch) {

        CityEntity departureCityEntity = cityEntityRepository.findByName(flightSearch.getDepartureCity());
        CityEntity arrivalCityEntity = cityEntityRepository.findByName(flightSearch.getArrivalCity());

        return oneWayFlightEntityRepository
                .findByDepartureCityAndArrivalCityAndDepartureDate
                        (departureCityEntity, arrivalCityEntity, flightSearch.getDepartureDate())
                .stream().map(OneWayFlight::fromEntity).toList();

    }

    //검색 조건에 맞는 왕복 항공권 찾기
    public List<RoundFlight> findRoundFlights(FlightSearch flightSearch) {

        CityEntity departureCityEntity = cityEntityRepository.findByName(flightSearch.getDepartureCity());
        CityEntity arrivalCityEntity = cityEntityRepository.findByName(flightSearch.getArrivalCity());

        return roundFlightEntityRepository
                .findByDepartureCityAndArrivalCityAndDepartureDateAndReturnDate(
                        departureCityEntity, arrivalCityEntity, flightSearch.getDepartureDate(), flightSearch.getReturnDate()
                ).stream().map(RoundFlight::fromEntity).toList();

    }

}
