package com.appsfactory.microservices.locationservices.controller;

import com.appsfactory.microservices.locationservices.dto.AddRegionalLocationFactorDTO;
import com.appsfactory.microservices.locationservices.model.Location;
import com.appsfactory.microservices.locationservices.service.regional.RegionalLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("postcode-factor")
public class PostCodesController {

    @Autowired
    RegionalLocationService regionalLocationService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{postcode}")
    public Location getRegionalLocationFactor(@PathVariable Integer postcode){
       Location location =  regionalLocationService.getRegionalLocationFactor(postcode);
        return location;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Location addRegionalLocationFactor(@ModelAttribute @Valid AddRegionalLocationFactorDTO addRegionalLocationFactorDTO) {
       return regionalLocationService.addRegionalLocationFactor(addRegionalLocationFactorDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/{postcode}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Location updateRegionalLocationFactor(@PathVariable Integer postcode, @ModelAttribute @Valid AddRegionalLocationFactorDTO addRegionalLocationFactorDTO){
        return regionalLocationService.updateRegionalLocationFactor(postcode, addRegionalLocationFactorDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{postcode}")
    public void deleteRegionalLocationFactor(@PathVariable Integer postcode){
        regionalLocationService.deleteRegionalLocationFactor(postcode);
        return;
    }

}
