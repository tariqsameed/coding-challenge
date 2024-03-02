package com.appsfactory.mileageservices.service.impl.mileageFactorService;

import com.appsfactory.mileageservices.constants.MileageConstants;
import com.appsfactory.mileageservices.model.MileageTypeFactor;
import com.appsfactory.mileageservices.repository.AutoMileageRepository;
import com.appsfactory.mileageservices.service.mileageFactorSerivce.MileageFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MileageFactorServiceImpl implements MileageFactorService {

    @Autowired
    AutoMileageRepository autoMileageRepository;

    @Override
    public MileageTypeFactor getMileageFactorybyAutoMileage(Integer mileage) {

        Optional<MileageTypeFactor> mileageByMileage = Optional.ofNullable(autoMileageRepository.findMileageByMileage(mileage));

        if(!mileageByMileage.isPresent()){
            throw new IllegalArgumentException();
        }
        return mileageByMileage.get();
    }

    @Override
    public void deleteMileageFactor(int minMileage, int maxMileage) {

        Optional<MileageTypeFactor> mileage = Optional.ofNullable(autoMileageRepository.findMileageByMinMileageAndMaxMileageAndStatus(minMileage,maxMileage, MileageConstants.STATUS_ACTIVE));

        if(mileage.isPresent()){
            MileageTypeFactor mil = mileage.get();
            mil.setStatus(MileageConstants.STATUS_INACTIVE);
            autoMileageRepository.save(mil);
        }
        return;
    }
}
