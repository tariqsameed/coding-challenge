package com.appsfactory.mileageservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
public class MileageTypeFactor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    Integer minMileage;

    Integer maxMileage;

    Double factor;

    String status;

    public MileageTypeFactor() {

    }
}
