package ru.rustam.LightDigital.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
