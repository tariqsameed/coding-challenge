package com.appsfactory.microservices.premiuminsurance.repository;

import com.appsfactory.microservices.premiuminsurance.entity.AnnualPremiumDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnnualInsuranceDetailRepository extends JpaRepository<AnnualPremiumDetail, UUID> {
}
