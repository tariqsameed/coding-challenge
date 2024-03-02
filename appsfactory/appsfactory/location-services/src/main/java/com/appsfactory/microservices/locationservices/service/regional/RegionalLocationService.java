package com.appsfactory.microservices.locationservices.service.regional;

import com.appsfactory.microservices.locationservices.dto.AddRegionalLocationFactorDTO;
import com.appsfactory.microservices.locationservices.model.Location;

public interface RegionalLocationService {

    public Location getRegionalLocationFactor(Integer postcode);

    public Location addRegionalLocationFactor(AddRegionalLocationFactorDTO addRegionalLocationFactorDTO);

    public void deleteRegionalLocationFactor(Integer postcode);

    public Location updateRegionalLocationFactor(Integer postcode, AddRegionalLocationFactorDTO addRegionalLocationFactorDTO);
}
