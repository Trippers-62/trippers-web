package com.web.trippers.model;

import com.web.trippers.model.entity.CityEntity;
import com.web.trippers.model.entity.CountryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class City {

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
