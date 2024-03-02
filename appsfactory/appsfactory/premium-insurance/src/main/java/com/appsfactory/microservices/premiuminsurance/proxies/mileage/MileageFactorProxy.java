package com.appsfactory.microservices.premiuminsurance.proxies.mileage;

import com.appsfactory.microservices.premiuminsurance.model.mileage.MileageFactor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mileage")
public interface MileageFactorProxy {

    @GetMapping(value = "/mileage-factor/{mileage}")
    MileageFactor getMileageRangeFactorByMileage(@PathVariable Integer mileage);
}
