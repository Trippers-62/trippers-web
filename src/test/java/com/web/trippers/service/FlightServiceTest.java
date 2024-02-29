package com.web.trippers.service;

import com.web.trippers.controller.FlightSearch;
import com.web.trippers.model.City;
import com.web.trippers.model.OneWayFlight;
import com.web.trippers.model.RoundFlight;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.CountryEntity;
import com.web.trippers.model.entity.OneWayFlightEntity;
import com.web.trippers.model.entity.RoundFlightEntity;
import com.web.trippers.repository.CityEntityRepository;
import com.web.trippers.repository.OneWayFlightEntityRepository;
import com.web.trippers.repository.RoundFlightEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @MockBean
    private OneWayFlightEntityRepository oneWayFlightEntityRepository;

    @MockBean
    private RoundFlightEntityRepository roundFlightEntityRepository;

    @MockBean
    private CityEntityRepository cityEntityRepository;

    @Test
    void 조건에_해당하는_편도_항공권_목록_요청이_성공한경우() {

        //given
        CityEntity departureCityEntity = new CityEntity();
        departureCityEntity.setId(1);
        departureCityEntity.setName("인천");
        departureCityEntity.setCityCode("ICN");

        CityEntity arrivalCityEntity = new CityEntity();
        arrivalCityEntity.setId(5);
        arrivalCityEntity.setName("도쿄");
        arrivalCityEntity.setCityCode("HND");

        FlightSearch flightSearch = new FlightSearch();
        flightSearch.setDepartureCity("인천");
        flightSearch.setArrivalCity("도쿄");
        flightSearch.setDepartureDate(LocalDate.parse("2024-02-25"));

        OneWayFlightEntity oneWayFlightEntity1 = new OneWayFlightEntity();
        oneWayFlightEntity1.setId(1);
        oneWayFlightEntity1.setDepartureCity(departureCityEntity);
        oneWayFlightEntity1.setArrivalCity(arrivalCityEntity);
        oneWayFlightEntity1.setAirline("대한항공");
        oneWayFlightEntity1.setPrice(BigDecimal.valueOf(20000));
        oneWayFlightEntity1.setTransferCount(1);
        oneWayFlightEntity1.setDepartureDatetime(LocalDateTime.of(2024,2,25,9,30,36));

        OneWayFlightEntity oneWayFlightEntity2 = new OneWayFlightEntity();
        oneWayFlightEntity2.setId(1);
        oneWayFlightEntity2.setDepartureCity(departureCityEntity);
        oneWayFlightEntity2.setArrivalCity(arrivalCityEntity);
        oneWayFlightEntity2.setAirline("아시아나항공");
        oneWayFlightEntity2.setPrice(BigDecimal.valueOf(30000));
        oneWayFlightEntity2.setTransferCount(0);
        oneWayFlightEntity2.setDepartureDatetime(LocalDateTime.of(2024,2,25,10,30,36));

        //when
        when(cityEntityRepository.findByName("인천")).thenReturn(departureCityEntity);
        when(cityEntityRepository.findByName("도쿄")).thenReturn(arrivalCityEntity);
        when(oneWayFlightEntityRepository.findByDepartureCityAndArrivalCityAndDepartureDate(
                departureCityEntity, arrivalCityEntity, LocalDate.parse("2024-02-25")
        )).thenReturn(Arrays.asList(oneWayFlightEntity1, oneWayFlightEntity2));

        List<OneWayFlight> flights = flightService.findOneWayFlights(flightSearch);

        //then
        assertEquals(2, flights.size());

    }

    @Test
    void 조건에_해당하는_왕복_항공권_목록_요청이_성공한경우() {

        //given
        CityEntity departureCityEntity = new CityEntity();
        departureCityEntity.setId(1);
        departureCityEntity.setName("인천");
        departureCityEntity.setCityCode("ICN");

        CityEntity arrivalCityEntity = new CityEntity();
        arrivalCityEntity.setId(5);
        arrivalCityEntity.setName("도쿄");
        arrivalCityEntity.setCityCode("HND");

        FlightSearch flightSearch = new FlightSearch();
        flightSearch.setDepartureCity("인천");
        flightSearch.setArrivalCity("도쿄");
        flightSearch.setDepartureDate(LocalDate.parse("2024-02-25"));
        flightSearch.setReturnDate(LocalDate.parse("2024-02-29"));

        RoundFlightEntity roundFlightEntity1 = new RoundFlightEntity();
        roundFlightEntity1.setId(1);
        roundFlightEntity1.setDepartureCity(departureCityEntity);
        roundFlightEntity1.setArrivalCity(arrivalCityEntity);
        roundFlightEntity1.setAirline("대한항공");
        roundFlightEntity1.setPrice(BigDecimal.valueOf(20000));
        roundFlightEntity1.setTransferCount(1);
        roundFlightEntity1.setReturnDepartureCity(arrivalCityEntity);
        roundFlightEntity1.setReturnArrivalCity(departureCityEntity);
        roundFlightEntity1.setDepartureDatetime(LocalDateTime.of(2024,2,25,10,30,36));
        roundFlightEntity1.setReturnDepartureDatetime(LocalDateTime.of(2024,2,29,10,30,36));


        RoundFlightEntity roundFlightEntity2 = new RoundFlightEntity();
        roundFlightEntity2.setId(2);
        roundFlightEntity2.setDepartureCity(departureCityEntity);
        roundFlightEntity2.setArrivalCity(arrivalCityEntity);
        roundFlightEntity2.setAirline("아시아나항공");
        roundFlightEntity2.setPrice(BigDecimal.valueOf(30000));
        roundFlightEntity2.setTransferCount(0);
        roundFlightEntity2.setReturnDepartureCity(arrivalCityEntity);
        roundFlightEntity2.setReturnArrivalCity(departureCityEntity);
        roundFlightEntity2.setDepartureDatetime(LocalDateTime.of(2024,2,25,10,30,36));
        roundFlightEntity2.setReturnDepartureDatetime(LocalDateTime.of(2024,2,29,10,30,36));


        //when
        when(cityEntityRepository.findByName("인천")).thenReturn(departureCityEntity);
        when(cityEntityRepository.findByName("도쿄")).thenReturn(arrivalCityEntity);
        when(roundFlightEntityRepository.findByDepartureCityAndArrivalCityAndDepartureDateAndReturnDate(
                departureCityEntity, arrivalCityEntity, LocalDate.parse("2024-02-25"), LocalDate.parse("2024-02-29")
        )).thenReturn(Arrays.asList(roundFlightEntity1, roundFlightEntity2));

        List<RoundFlight> flights = flightService.findRoundFlights(flightSearch);

        //then
        assertEquals(2, flights.size());

    }

}