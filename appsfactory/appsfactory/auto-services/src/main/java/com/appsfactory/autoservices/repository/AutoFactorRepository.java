package com.appsfactory.autoservices.repository;

import com.appsfactory.autoservices.model.AutoTypeFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoFactorRepository extends JpaRepository<AutoTypeFactor, Integer> {

    AutoTypeFactor findByCarNameAndStatus(String car, String status);
}
