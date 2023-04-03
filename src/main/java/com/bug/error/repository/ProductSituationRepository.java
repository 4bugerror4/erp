package com.bug.error.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.error.entity.ProductSituation;

public interface ProductSituationRepository extends JpaRepository<ProductSituation, Long> {

}
