package ru.rustam.LightDigital.config;

import feign.okhttp.OkHttpClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rustam.LightDigital.client.dadata.DadataClient;

@Configuration
@EnableFeignClients(clients = DadataClient.class)
public class OpenFeignConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
