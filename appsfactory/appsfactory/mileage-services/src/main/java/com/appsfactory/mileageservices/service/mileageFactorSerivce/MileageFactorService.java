package com.appsfactory.mileageservices.service.mileageFactorSerivce;

import com.appsfactory.mileageservices.model.MileageTypeFactor;

public interface MileageFactorService {

    MileageTypeFactor getMileageFactorybyAutoMileage(Integer mileage);

    public void deleteMileageFactor(int minMileage, int maxMileage);
}
