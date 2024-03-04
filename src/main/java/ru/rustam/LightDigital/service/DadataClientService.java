package ru.rustam.LightDigital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rustam.LightDigital.client.dadata.DadataClient;
import ru.rustam.LightDigital.entity.Phone;
import ru.rustam.LightDigital.mapper.PhoneMapper;

@Service
@RequiredArgsConstructor
public class DadataClientService {

    private final DadataClient dadataClient;
    private final PhoneMapper phoneMapper;

    public Phone getPhoneInfo(String phoneStr) {
        String json = dadataClient.getPhoneInfo(phoneStr);
        return getPhone(json);
    }

    private Phone getPhone(String json) {
        return phoneMapper.fromJson(json);
    }
}
