package com.appsfactory.autoservices.controller;

import com.appsfactory.autoservices.model.AutoTypeFactor;
import com.appsfactory.autoservices.service.autoFactor.AutoFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auto-factor")
@RestController
public class AutoFactorController {

    @Autowired
    AutoFactorService autoFactorService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{car}")
    public AutoTypeFactor getRegionalLocationFactor(@PathVariable String car){
        AutoTypeFactor autoFactor =  autoFactorService.getAutoTypeFactor(car);
        return autoFactor;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{car}")
    public void deleteRegionalLocationFactor(@PathVariable String car){
        autoFactorService.deleteAutoTypeFactor(car);
        return;
    }
}
