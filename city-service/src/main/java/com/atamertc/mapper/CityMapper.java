package com.atamertc.mapper;


import com.atamertc.dto.request.AddRequestDto;
import com.atamertc.repository.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City toCity(AddRequestDto dto);
}
