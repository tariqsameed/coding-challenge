package com.appsfactory.microservices.premiuminsurance.proxies.auto;

import com.appsfactory.microservices.premiuminsurance.model.auto.AutoTypeFactor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auto")
public interface AutoFactorProxy {

    @GetMapping(value = "/auto-factor/{auto}")
    AutoTypeFactor getAutoTypeFactorByAutoType(@PathVariable String auto);
}
