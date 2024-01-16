package com.atamertc.repository;

import com.atamertc.repository.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Long countAllBy();

    @Query(value = "select c.id from tbl_city as c order by c.id desc limit 1",nativeQuery = true)
    Long getLastId();

    City getFirstByOrderByIdDesc();
}
