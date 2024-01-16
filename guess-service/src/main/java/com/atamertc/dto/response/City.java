package com.atamertc.dto.response;


import com.atamertc.repository.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class City {
    private Long id;
    private String name;
    private String area;
    private String blur;


}
