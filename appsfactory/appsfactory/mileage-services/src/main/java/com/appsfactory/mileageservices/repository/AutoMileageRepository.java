package com.appsfactory.mileageservices.repository;

import com.appsfactory.mileageservices.model.MileageTypeFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoMileageRepository extends JpaRepository<MileageTypeFactor, Integer> {

    @Query("Select m from MileageTypeFactor m where :carMileage between m.minMileage and m.maxMileage")
    MileageTypeFactor findMileageByMileage(@Param("carMileage")Integer mileage);

    MileageTypeFactor findMileageByMinMileageAndMaxMileageAndStatus(int minValue, int maxValue, String status);
}
