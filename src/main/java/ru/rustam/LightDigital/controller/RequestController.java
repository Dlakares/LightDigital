package ru.rustam.LightDigital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rustam.LightDigital.dto.CreateRequest;
import ru.rustam.LightDigital.dto.RequestResponse;
import ru.rustam.LightDigital.service.RequestService;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    public ResponseEntity<RequestResponse> create(@RequestBody @Valid CreateRequest request) {
        RequestResponse response = requestService.create(request);

        return ResponseEntity
                .ok(response);
    }
}
