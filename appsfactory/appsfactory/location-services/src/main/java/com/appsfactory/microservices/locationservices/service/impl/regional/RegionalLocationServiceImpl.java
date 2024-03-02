package com.appsfactory.microservices.locationservices.service.impl.regional;

import com.appsfactory.microservices.locationservices.utilities.RegionalFactorUtil;
import com.appsfactory.microservices.locationservices.constants.LocationConstants;
import com.appsfactory.microservices.locationservices.dto.AddRegionalLocationFactorDTO;
import com.appsfactory.microservices.locationservices.model.Location;
import com.appsfactory.microservices.locationservices.repository.LocationRepository;
import com.appsfactory.microservices.locationservices.service.regional.RegionalLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@Service
public class RegionalLocationServiceImpl implements RegionalLocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RegionalFactorUtil regionalFactorUtil;

    @Override
    public Location getRegionalLocationFactor(Integer postcode) {

        log.info(String.format("Getting the Regional Factor with Postcode %s",postcode));
        Optional<Location> entity = Optional.ofNullable(locationRepository.findByPostLeitZahlAndStatus(postcode, LocationConstants.STATUS_ACTIVE));

        if(!entity.isPresent()){
            log.info(String.format("Unable to find the regional factor with Postcode %s",postcode));
            throw new IllegalArgumentException();
        }
        return entity.get();
    }

    @Transactional
    @Override
    public Location addRegionalLocationFactor(AddRegionalLocationFactorDTO addRegionalLocationFactorDTO) {

        log.info(String.format("Adding the Location Regional Factor with Postcode %s",addRegionalLocationFactorDTO.getPostLeitZahl()));

        Location location = new Location();
        Optional<Location> postLeitZahl = Optional.ofNullable(locationRepository.findByPostLeitZahlAndStatus(addRegionalLocationFactorDTO.getPostLeitZahl(),LocationConstants.STATUS_ACTIVE));

        if(postLeitZahl.isEmpty()){
            location.setCountryISO(addRegionalLocationFactorDTO.getCountryISO());
            location.setStateISO(addRegionalLocationFactorDTO.getStateISO());
            location.setRegionOne(addRegionalLocationFactorDTO.getRegionOne());
            location.setRegionTwo(addRegionalLocationFactorDTO.getRegionTwo());
            location.setRegionThree(addRegionalLocationFactorDTO.getRegionThree());
            location.setRegionFour(addRegionalLocationFactorDTO.getRegionFour());
            if(null != addRegionalLocationFactorDTO.getPostLeitZahl()){
                location.setPostLeitZahl(addRegionalLocationFactorDTO.getPostLeitZahl());
            }else{
                log.info(String.format("The Location Regional Factor with Postcode cannot be null"));
                throw new IllegalArgumentException("The postcode cannot be null");
            }

            location.setOrt(addRegionalLocationFactorDTO.getOrt());
            location.setRegionalFactor(addRegionalLocationFactorDTO.getRegionalFactor());
            location.setStatus(LocationConstants.STATUS_ACTIVE);

        }else{
            log.info(String.format("The Location Regional Factor with Postcode %s already exist",addRegionalLocationFactorDTO.getPostLeitZahl()));
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The record already exist");
        }
        Location saveLocation = locationRepository.save(location);
        return saveLocation;
    }

    @Override
    public void deleteRegionalLocationFactor(Integer postcode) {

        log.info(String.format("Deleting Location Regional Factor with Postcode %s ",postcode));
        Optional<Location> postLeitZahl = Optional.ofNullable(locationRepository.findByPostLeitZahlAndStatus(postcode,LocationConstants.STATUS_ACTIVE));

        if(postLeitZahl.isPresent()){
            Location location = postLeitZahl.get();
            location.setStatus(LocationConstants.STATUS_INACTIVE);
            locationRepository.save(location);
        }

    }

    @Transactional
    @Override
    public Location updateRegionalLocationFactor(Integer postcode, AddRegionalLocationFactorDTO addRegionalLocationFactorDTO) {

        log.info(String.format("Updating Location Regional Factor with Postcode %s ",postcode));

        Optional<Location> postLeitZahl = Optional.ofNullable(locationRepository.findByPostLeitZahlAndStatus(postcode,LocationConstants.STATUS_ACTIVE));

        if(postLeitZahl.isPresent()){

            postLeitZahl.get().setCountryISO(addRegionalLocationFactorDTO.getCountryISO());
            postLeitZahl.get().setStateISO(addRegionalLocationFactorDTO.getStateISO());
            postLeitZahl.get().setRegionOne(addRegionalLocationFactorDTO.getRegionOne());
            postLeitZahl.get().setRegionTwo(addRegionalLocationFactorDTO.getRegionTwo());
            postLeitZahl.get().setRegionThree(addRegionalLocationFactorDTO.getRegionThree());
            postLeitZahl.get().setRegionFour(addRegionalLocationFactorDTO.getRegionFour());
            postLeitZahl.get().setPostLeitZahl(addRegionalLocationFactorDTO.getPostLeitZahl());
            postLeitZahl.get().setOrt(addRegionalLocationFactorDTO.getOrt());
            postLeitZahl.get().setRegionalFactor(addRegionalLocationFactorDTO.getRegionalFactor());

            Location save = locationRepository.save(postLeitZahl.get());
        }else{
            log.info(String.format("Unable to find Location Regional Factor with Postcode %s ",postcode));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The post code does not exist");
        }
        return postLeitZahl.get();
    }
}
