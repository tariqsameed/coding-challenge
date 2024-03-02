package com.appsfactory.microservices.locationservices.repository;

import com.appsfactory.microservices.locationservices.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    Location findByPostLeitZahlAndStatus(Integer postcode, String status);

}
