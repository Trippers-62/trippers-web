package com.web.trippers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.CountryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class City implements Serializable {

    private Integer Id;
    private CountryEntity country;
    private String name;
    private String cityCode;

    public static City fromEntity(CityEntity entity){
        return new City(
                entity.getId(),
                entity.getCountry(),
                entity.getName(),
                entity.getCityCode()
        );
    }
}
