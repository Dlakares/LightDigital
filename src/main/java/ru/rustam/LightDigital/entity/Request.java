package ru.rustam.LightDigital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "requests")
public class Request extends DefaultEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "phone_id", nullable = false)
    private Phone phone;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
}
