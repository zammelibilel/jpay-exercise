package com.jpay.exercise.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpay.exercise.model.Customer;

/**
 * repository to manage customer entries from sqlite db
 * 
 * @author zammelib
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Page<Customer> findByPhoneStartsWith(String code, Pageable pageable);

}
