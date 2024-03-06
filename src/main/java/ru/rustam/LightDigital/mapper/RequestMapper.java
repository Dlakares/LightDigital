package ru.rustam.LightDigital.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.rustam.LightDigital.dto.CreateRequest;
import ru.rustam.LightDigital.dto.RequestResponse;
import ru.rustam.LightDigital.entity.Request;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RequestMapper {

    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "senderName", source = "sender_name")
    Request toEntity(CreateRequest request);

    @Mapping(target = "phoneNumber", source = "phone.fullNumber")
    @Mapping(target = "authorId", source = "author.id")
    RequestResponse toResponse(Request request);
}
