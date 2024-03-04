package ru.rustam.LightDigital.dto;

import lombok.Data;
import ru.rustam.LightDigital.entity.Role;

import java.util.List;

@Data
public class SignUpRequest {

    private String username;

    private String password;

    private List<Role> roles;
}
