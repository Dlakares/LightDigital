package ru.rustam.LightDigital.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {

    private Integer countryCode;

    private Integer cityCode;

    private Integer number;
}
