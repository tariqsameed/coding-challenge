package com.appsfactory.microservices.premiuminsurance.proxies.location;

import com.appsfactory.microservices.premiuminsurance.model.location.LocationTypeFactor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "location")
public interface LocationFactorProxy {

    @GetMapping(value = "/postcode-factor/{postcode}")
    LocationTypeFactor getLocationTypeFactorByPostcode(@PathVariable Integer postcode);
}
