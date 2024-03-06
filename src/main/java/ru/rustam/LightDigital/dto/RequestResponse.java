package ru.rustam.LightDigital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.rustam.LightDigital.entity.Status;

@Data
@AllArgsConstructor
@Builder
public class RequestResponse {

    private Long id;
    private Status status;
    private String message;
    private String phoneNumber;
    private String senderName;
    private String authorId;
}
