package ru.rustam.LightDigital.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "phones")
public class Phone extends DefaultEntity{

    @Column(name = "country_code")
    private Integer countryCode;

    @Column(name = "city_code")
    private Integer cityCode;

    @Column(name = "number")
    private Integer number;

    @Column(name = "full_number")
    private String fullNumber;

    @OneToOne(mappedBy = "phone")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
}
