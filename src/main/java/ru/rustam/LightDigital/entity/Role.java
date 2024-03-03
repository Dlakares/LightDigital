package ru.rustam.LightDigital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@Builder
@Table(name = "roles")
public class Role extends DefaultEntity{
    private String name;
}
