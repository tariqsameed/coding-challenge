package com.appsfactory.microservices.locationservices.service.locationScheduler;


import java.io.IOException;

public interface LocationSeedingService {

    void startFileLoading() throws IOException;
}
