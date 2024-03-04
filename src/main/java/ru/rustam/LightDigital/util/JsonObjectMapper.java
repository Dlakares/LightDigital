package ru.rustam.LightDigital.util;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JsonObjectMapper {

    private final Gson mapper;

    public <T> T readValue(String json, Class<T> valueType) {
        try {
            return mapper.fromJson(json, valueType);
        } catch (RuntimeException e) {
            throw new RuntimeException("Json processing exception");
        }
    }
}
