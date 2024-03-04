package ru.rustam.LightDigital.client.dadata;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rustam.LightDigital.config.OpenFeignConfig;

@FeignClient(
        value = "dadataClient",
        url = "https://cleaner.dadata.ru/",
        configuration = OpenFeignConfig.class
)
public interface DadataClient {
    @PostMapping(value = "api/v1/clean/phone", produces = "application/json", consumes = "application/json")
    String getPhoneInfo(String phone);
}

