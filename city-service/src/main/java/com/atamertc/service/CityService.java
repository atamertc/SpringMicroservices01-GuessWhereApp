package com.atamertc.service;

import com.atamertc.dto.request.AddRequestDto;
import com.atamertc.exception.CityManagerException;
import com.atamertc.exception.ErrorType;
import com.atamertc.mapper.CityMapper;
import com.atamertc.repository.CityRepository;
import com.atamertc.repository.entity.City;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CityService extends ServiceManager<City, Long> {
    private final CityRepository repository;

    public CityService(CityRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public City add(AddRequestDto dto) {
        City city = CityMapper.INSTANCE.toCity(dto);
        city.setBlur(city.getName().substring(0, 2));
        return save(city);
    }

    public City findCity(Long id) {
        Optional<City> city = findById(id);
        if (city.isEmpty()) {
            throw new CityManagerException(ErrorType.USER_NOT_FOUND);
        }
        return city.get();
    }

    public City findRandomCity() {
        Random random = new Random();
        Long lastId = repository.getLastId();
        City lastCity = repository.getFirstByOrderByIdDesc();
        Long lastId2 = repository.countAllBy();
        System.out.println(lastId);
        System.out.println(lastId2);
        System.out.println(lastCity);
        Long id = random.nextLong(1,lastId2+1);
        Optional<City> city = findById(id);
        if (city.isEmpty()) {
            throw new CityManagerException(ErrorType.USER_NOT_FOUND);
        }
        return city.get();
    }
}
