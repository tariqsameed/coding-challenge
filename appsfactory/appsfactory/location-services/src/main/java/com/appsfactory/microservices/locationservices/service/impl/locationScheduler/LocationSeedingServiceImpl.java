package com.appsfactory.microservices.locationservices.service.impl.locationScheduler;

import com.appsfactory.microservices.locationservices.utilities.PostCodeFilePreprocessors;
import com.appsfactory.microservices.locationservices.utilities.RegionalFactorUtil;
import com.appsfactory.microservices.locationservices.constants.LocationConstants;
import com.appsfactory.microservices.locationservices.model.Location;
import com.appsfactory.microservices.locationservices.repository.LocationRepository;
import com.appsfactory.microservices.locationservices.service.locationScheduler.LocationSeedingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Slf4j
@Service
public class LocationSeedingServiceImpl implements LocationSeedingService {

    @Autowired
    private Environment env;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    RegionalFactorUtil regionalFactorUtil;

    @Autowired
    PostCodeFilePreprocessors postCodeFilePreprocessors;


    public LocationSeedingServiceImpl(LocationRepository locationRepository) throws IOException {
        this.locationRepository = locationRepository;
    }

    @Override
    public void startFileLoading() throws IOException {

        String postCodesFilename = env.getProperty("location.postcodes.filename");

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = (FileInputStream) getResourceFileAsInputStream(postCodesFilename);
            sc = new Scanner(inputStream, "UTF-8");
            sc.nextLine(); // skip the first line.

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Location loc = getLocationModel(line);
                locationRepository.save(loc);

            }

            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (FileNotFoundException e) {
            log.info("Unable to find the file to load data");
            e.printStackTrace();
        } catch (IOException e) {

            log.info("Cannot read the loaded file ");
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

    }

    private InputStream getResourceFileAsInputStream(String fileName) throws IOException {
        Resource resource = new ClassPathResource(fileName);
        FileInputStream file = new FileInputStream(resource.getFile());
        return file;
    }

    private Location getLocationModel(String location){
        Location locationModel = new Location();
        String[] splitLocation = location.split(",");
        locationModel.setCountryISO(postCodeFilePreprocessors.getCountryISOPreprocessedValue(splitLocation[LocationConstants.COUNTRY_ISO_INDEX]));
        locationModel.setStateISO(postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(splitLocation[LocationConstants.STATE_ISO_INDEX]));
        locationModel.setRegionOne(postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(splitLocation[LocationConstants.REGION_ONE_INDEX]));
        locationModel.setRegionTwo(postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(splitLocation[LocationConstants.REGION_TWO_INDEX]));
        locationModel.setRegionThree(postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(splitLocation[LocationConstants.REGION_THREE_INDEX]));
        locationModel.setRegionFour(postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(splitLocation[LocationConstants.REGION_FOUR_INDEX]));
        locationModel.setPostLeitZahl(Integer.valueOf(postCodeFilePreprocessors.getPostLietZahlValue(splitLocation[LocationConstants.POST_ZIEL_INDEX])));
        locationModel.setOrt(postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(splitLocation[LocationConstants.ORT_INDEX]));
        locationModel.setRegionalFactor(regionalFactorUtil.generateRandomRegionalFactor());
        locationModel.setStatus(LocationConstants.STATUS_ACTIVE);
        return locationModel;
    }

}
