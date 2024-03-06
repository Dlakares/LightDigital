package ru.rustam.LightDigital.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.rustam.LightDigital.entity.Status;

@Data
@Builder
@AllArgsConstructor
public class CreateRequest {

    @NotNull(message = "Status required")
    @NotEmpty(message = "Status is empty")
    private Status status;

    @NotNull(message = "Message required")
    @NotEmpty(message = "Message is empty")
    private String message;

    @NotNull(message = "Sender name required")
    @NotEmpty(message = "Sender name is empty")
    private String sender_name;

    @Min(value = 0, message = "Sender id must be equals or greater than zero")
    @NotNull(message = "Sender id required")
    private Long sender_id;

    @NotNull(message = "Phone number required")
    @NotEmpty(message = "Phone number is empty")
    private String phoneNumber;
}
