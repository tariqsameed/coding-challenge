package com.appsfactory.autoservices.service.autoFactor;

import com.appsfactory.autoservices.model.AutoTypeFactor;

public interface AutoFactorService {

    AutoTypeFactor getAutoTypeFactor(String car);

    void deleteAutoTypeFactor(String car);
}
