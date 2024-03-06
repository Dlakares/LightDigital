package ru.rustam.LightDigital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rustam.LightDigital.dto.CreateRequest;
import ru.rustam.LightDigital.dto.RequestResponse;
import ru.rustam.LightDigital.entity.Phone;
import ru.rustam.LightDigital.entity.Request;
import ru.rustam.LightDigital.entity.User;
import ru.rustam.LightDigital.mapper.RequestMapper;
import ru.rustam.LightDigital.repository.RequestRepository;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final DadataClientService dadataClientService;
    private final UserService userService;
    private final PhoneService phoneService;
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    public RequestResponse create(CreateRequest createRequest) {
        User author = userService.getById(createRequest.getSender_id());
        Phone phone = dadataClientService.getPhoneInfo(createRequest.getPhoneNumber());
        phone.setOwner(author);
        phoneService.save(phone);

        Request request = requestMapper.toEntity(createRequest);
        request.setAuthor(author);
        request.setPhone(phone);

        requestRepository.save(request);

        return requestMapper.toResponse(request);
    }
}
