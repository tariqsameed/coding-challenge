package com.appsfactory.microservices.premiuminsurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@Table
@Entity
@Data
public class AnnualPremiumDetail {

    @Id
    @Type(type="uuid-char")
    UUID uuid;

    String countryISO;

    String location;

    Integer postcode;

    Double regionalFactor;

    String autoType;

    Double autoTypeFactor;

    Integer autoMileage;

    Integer mileageMinimumValue;

    Integer mileageMaximumValue;

    Double autoMileageFactor;

    String currency;

    Double annualPremiumInsurance;

    public AnnualPremiumDetail() {

    }
}
