package com.web.trippers.service;

import com.web.trippers.repository.CityEntityRepository;
import com.web.trippers.repository.OneWayFlightEntityRepository;
import com.web.trippers.repository.RoundFlightEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import static org.mockito.Mockito.mock;
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

    @DisplayName("모든 편도 항공권 가져오기 성공")
    @Test
    void testFindAll() {
        Pageable pageable = mock(Pageable.class);
        when(oneWayFlightEntityRepository.findAll(pageable)).thenReturn(Page.empty());
        Assertions.assertDoesNotThrow(() -> flightService.findAllOneWayFlights(pageable));
    }


}