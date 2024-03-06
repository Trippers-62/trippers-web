//package com.web.trippers.service;
//
//import com.web.trippers.controller.SearchForm;
//import com.web.trippers.model.entity.CityEntity;
//import com.web.trippers.model.entity.OneWayFlightEntity;
//import com.web.trippers.model.entity.RoundFlightEntity;
//import com.web.trippers.repository.CityEntityRepository;
//import com.web.trippers.repository.OneWayFlightEntityRepository;
//import com.web.trippers.repository.RoundFlightEntityRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class FlightServiceTest {
//
//    @Autowired
//    private FlightService flightService;
//
//    @MockBean
//    private OneWayFlightEntityRepository oneWayFlightEntityRepository;
//
//    @MockBean
//    private RoundFlightEntityRepository roundFlightEntityRepository;
//
//    @MockBean
//    private CityEntityRepository cityEntityRepository;
//
//    @Test
//    void 조건에_해당하는_편도_항공권_목록_요청이_성공한경우() {
//
//        //given
//        CityEntity departureCityEntity = new CityEntity();
//        departureCityEntity.setId(1);
//        departureCityEntity.setName("인천");
//        departureCityEntity.setCityCode("ICN");
//
//        CityEntity arrivalCityEntity = new CityEntity();
//        arrivalCityEntity.setId(5);
//        arrivalCityEntity.setName("도쿄");
//        arrivalCityEntity.setCityCode("HND");
//
//        SearchForm searchForm = new SearchForm();
//        searchForm.setDepartureCity("인천");
//        searchForm.setArrivalCity("도쿄");
//        searchForm.setDepartureDate(LocalDate.parse("2024-02-25"));
//
//        OneWayFlightEntity oneWayFlightEntity1 = new OneWayFlightEntity();
//        oneWayFlightEntity1.setId(1);
//        oneWayFlightEntity1.setDepartureCity(departureCityEntity);
//        oneWayFlightEntity1.setArrivalCity(arrivalCityEntity);
//        oneWayFlightEntity1.setAirline("대한항공");
//        oneWayFlightEntity1.setPrice(BigDecimal.valueOf(20000));
//        oneWayFlightEntity1.setTransferCount(1);
//        oneWayFlightEntity1.setDepartureDatetime(LocalDateTime.of(2024,2,25,9,30,36));
//
//        OneWayFlightEntity oneWayFlightEntity2 = new OneWayFlightEntity();
//        oneWayFlightEntity2.setId(1);
//        oneWayFlightEntity2.setDepartureCity(departureCityEntity);
//        oneWayFlightEntity2.setArrivalCity(arrivalCityEntity);
//        oneWayFlightEntity2.setAirline("아시아나항공");
//        oneWayFlightEntity2.setPrice(BigDecimal.valueOf(30000));
//        oneWayFlightEntity2.setTransferCount(0);
//        oneWayFlightEntity2.setDepartureDatetime(LocalDateTime.of(2024,2,25,10,30,36));
//
//        Pageable pageable = mock(Pageable.class);
//
//        //when
//        when(cityEntityRepository.findByName("인천")).thenReturn(departureCityEntity);
//        when(cityEntityRepository.findByName("도쿄")).thenReturn(arrivalCityEntity);
//        when(oneWayFlightEntityRepository.findByDepartureCityAndArrivalCityAndDepartureDate(
//                departureCityEntity, arrivalCityEntity, LocalDate.parse("2024-02-25"), pageable
//        )).thenReturn(Page.empty());
//
//
//        //then
////        assertEquals(2, flights.size());
//        Assertions.assertDoesNotThrow(() -> flightService.getOneWayFlights(searchForm, pageable));
//    }
//
//    @Test
//    void 조건에_해당하는_왕복_항공권_목록_요청이_성공한경우() {
//
//        //given
//        CityEntity departureCityEntity = new CityEntity();
//        departureCityEntity.setId(1);
//        departureCityEntity.setName("인천");
//        departureCityEntity.setCityCode("ICN");
//
//        CityEntity arrivalCityEntity = new CityEntity();
//        arrivalCityEntity.setId(5);
//        arrivalCityEntity.setName("도쿄");
//        arrivalCityEntity.setCityCode("HND");
//
//        SearchForm searchForm = new SearchForm();
//        searchForm.setDepartureCity("인천");
//        searchForm.setArrivalCity("도쿄");
//        searchForm.setDepartureDate(LocalDate.parse("2024-02-25"));
//        searchForm.setReturnDate(LocalDate.parse("2024-02-29"));
//
//        RoundFlightEntity roundFlightEntity1 = new RoundFlightEntity();
//        roundFlightEntity1.setId(1);
//        roundFlightEntity1.setDepartureCity(departureCityEntity);
//        roundFlightEntity1.setArrivalCity(arrivalCityEntity);
//        roundFlightEntity1.setAirline("대한항공");
//        roundFlightEntity1.setPrice(BigDecimal.valueOf(20000));
//        roundFlightEntity1.setTransferCount(1);
//        roundFlightEntity1.setReturnDepartureCity(arrivalCityEntity);
//        roundFlightEntity1.setReturnArrivalCity(departureCityEntity);
//        roundFlightEntity1.setDepartureDatetime(LocalDateTime.of(2024,2,25,10,30,36));
//        roundFlightEntity1.setReturnDepartureDatetime(LocalDateTime.of(2024,2,29,10,30,36));
//
//
//        RoundFlightEntity roundFlightEntity2 = new RoundFlightEntity();
//        roundFlightEntity2.setId(2);
//        roundFlightEntity2.setDepartureCity(departureCityEntity);
//        roundFlightEntity2.setArrivalCity(arrivalCityEntity);
//        roundFlightEntity2.setAirline("아시아나항공");
//        roundFlightEntity2.setPrice(BigDecimal.valueOf(30000));
//        roundFlightEntity2.setTransferCount(0);
//        roundFlightEntity2.setReturnDepartureCity(arrivalCityEntity);
//        roundFlightEntity2.setReturnArrivalCity(departureCityEntity);
//        roundFlightEntity2.setDepartureDatetime(LocalDateTime.of(2024,2,25,10,30,36));
//        roundFlightEntity2.setReturnDepartureDatetime(LocalDateTime.of(2024,2,29,10,30,36));
//
//        Pageable pageable = mock(Pageable.class);
//
//        //when
//        when(cityEntityRepository.findByName("인천")).thenReturn(departureCityEntity);
//        when(cityEntityRepository.findByName("도쿄")).thenReturn(arrivalCityEntity);
//        when(roundFlightEntityRepository.findByDepartureCityAndArrivalCityAndDepartureDateAndReturnDate(
//                departureCityEntity, arrivalCityEntity, LocalDate.parse("2024-02-25"), LocalDate.parse("2024-02-29"), pageable
//        )).thenReturn(Page.empty());
//
////        List<RoundFlight> flights = flightService.getRoundFlights(searchForm);
//
//        //then
////        assertEquals(2, flights.size());
//        Assertions.assertDoesNotThrow(() -> flightService.getRoundFlights(searchForm, pageable));
//
//    }
//
//}