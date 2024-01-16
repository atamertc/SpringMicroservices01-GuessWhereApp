package com.atamertc.mapper;


import com.atamertc.dto.response.GuessResponseDto;
import com.atamertc.repository.entity.Guess;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GuessMapper {
    GuessMapper INSTANCE = Mappers.getMapper(GuessMapper.class);

    GuessResponseDto toGuessResponseDto(Guess guess);
}
