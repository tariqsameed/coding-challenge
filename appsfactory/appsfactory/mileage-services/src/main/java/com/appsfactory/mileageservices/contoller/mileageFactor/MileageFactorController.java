package com.appsfactory.mileageservices.contoller.mileageFactor;

import com.appsfactory.mileageservices.model.MileageTypeFactor;
import com.appsfactory.mileageservices.service.mileageFactorSerivce.MileageFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("mileage-factor")
@RestController
public class MileageFactorController {

    @Autowired
    MileageFactorService mileageFactorService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{mileage}")
    public MileageTypeFactor getMileageFactorybyAutoMileage(@PathVariable Integer mileage){

        MileageTypeFactor mileageFactorybyAutoMileageTypeFactor = mileageFactorService.getMileageFactorybyAutoMileage(mileage);
        return mileageFactorybyAutoMileageTypeFactor;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{milMinValue}/{milMaxvalue}")
    public void deleteMileageFactor(@PathVariable Integer milMinValue, @PathVariable Integer milMaxvalue){
        mileageFactorService.deleteMileageFactor(milMinValue,milMaxvalue);
        return;
    }

    /* No Update and Add Value is provided. It need a seperate algorithm to make values consistent between
     previous maximum value and next minimum values. */
}
