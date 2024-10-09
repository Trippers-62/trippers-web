package com.web.trippers.repository;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.trippers.controller.SearchForm;
import com.web.trippers.model.CityRecommendation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecommendationCacheRepository {

    private final RedisTemplate<String, CityRecommendation> recommendationRedisTemplate;

    private final static Duration RECOMMENDATION_CACHE_TTL = Duration.ofDays(1);


    public void setRecommendationList(SearchForm searchForm, List<CityRecommendation> recommendations) {
        String key = getKey(searchForm.getDepartureDate(), searchForm.getReturnDate(), searchForm.getBudget());

        recommendationRedisTemplate.opsForList().rightPushAll(key, recommendations);

        log.info("Set Recommendations to Redis {}, {}", key, recommendations);

        recommendationRedisTemplate.expire(key, RECOMMENDATION_CACHE_TTL);
    }


    public List<CityRecommendation> getRecommendations(SearchForm searchForm) {
        String key = getKey(searchForm.getDepartureDate(), searchForm.getReturnDate(), searchForm.getBudget());

        List<CityRecommendation> recommendations = recommendationRedisTemplate.opsForList().range(key, 0, -1);


        return recommendations;
    }

    private String getKey(LocalDate departureDate, LocalDate returnDate, BigDecimal budget) {
        return "DEPARTURE_DATE:" + departureDate.toString() + "RETURN_DATE:" + returnDate.toString() + "BUDGET:" + budget.toString();
    }

}
