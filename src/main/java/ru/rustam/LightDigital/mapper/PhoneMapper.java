package ru.rustam.LightDigital.mapper;

import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rustam.LightDigital.entity.Phone;
import ru.rustam.LightDigital.util.JsonObjectMapper;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PhoneMapper {

    private final int EMPTY_OR_TRASH = 2;
    private final int HALF_OR_FULL_NOT_DETERMINE = 1;

    private final JsonObjectMapper mapper;
    @Value("${application.phone.type}")
    private String TYPE;

    public Phone fromJson(String str) {
        Object[] data = mapper.readValue(str, Object[].class);
        Map<String, Object> map = (LinkedTreeMap) data[0];
        if(!TYPE.equals(map.get("type")) || map.get("qc").equals(EMPTY_OR_TRASH) || map.get("qc").equals(HALF_OR_FULL_NOT_DETERMINE)) {
            throw new RuntimeException("Invalid phone number");
        }
        return Phone.builder()
                .countryCode(Integer.parseInt((String) map.get("country_code")))
                .cityCode(Integer.parseInt((String) map.get("city_code")))
                .number(Integer.parseInt((String) map.get("number")))
                .build();
    }
}
