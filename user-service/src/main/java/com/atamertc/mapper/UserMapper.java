package com.atamertc.mapper;


import com.atamertc.dto.request.RegisterRequestDto;
import com.atamertc.dto.response.RegisterResponseDto;
import com.atamertc.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(User user);

}
