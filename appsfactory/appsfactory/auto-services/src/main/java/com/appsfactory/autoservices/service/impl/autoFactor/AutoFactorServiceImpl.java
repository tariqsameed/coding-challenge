package com.appsfactory.autoservices.service.impl.autoFactor;

import com.appsfactory.autoservices.cosntants.AutoConstants;
import com.appsfactory.autoservices.model.AutoTypeFactor;
import com.appsfactory.autoservices.repository.AutoFactorRepository;
import com.appsfactory.autoservices.service.autoFactor.AutoFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutoFactorServiceImpl implements AutoFactorService {

    @Autowired
    AutoFactorRepository autoFactorRepository;

    @Override
    public AutoTypeFactor getAutoTypeFactor(String car) {

        Optional<AutoTypeFactor> entity = Optional.ofNullable(autoFactorRepository.findByCarNameAndStatus(car, AutoConstants.STATUS_ACTIVE));

        if(!entity.isPresent()){
            throw new IllegalArgumentException();
        }
        return entity.get();
    }

    @Override
    public void deleteAutoTypeFactor(String car) {

        Optional<AutoTypeFactor> entity = Optional.ofNullable(autoFactorRepository.findByCarNameAndStatus(car, AutoConstants.STATUS_ACTIVE));

        if(entity.isPresent()){
            AutoTypeFactor auto = entity.get();
            auto.setStatus(AutoConstants.STATUS_INACTIVE);
            autoFactorRepository.save(auto);
        }

    }
}
