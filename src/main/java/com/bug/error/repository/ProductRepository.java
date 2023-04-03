package com.bug.error.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.error.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
