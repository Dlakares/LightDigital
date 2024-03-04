package ru.rustam.LightDigital.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rustam.LightDigital.entity.Phone;
import ru.rustam.LightDigital.service.DadataClientService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class Test {
    private final DadataClientService service;

    @GetMapping
    public Phone test(@RequestBody String phone) {
        return service.getPhoneInfo(phone);
    }

}
