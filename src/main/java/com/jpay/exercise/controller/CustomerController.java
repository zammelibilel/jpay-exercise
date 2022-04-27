package com.jpay.exercise.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpay.exercise.dto.CustomersResult;
import com.jpay.exercise.enums.CountryCodeEnum;
import com.jpay.exercise.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * Produces a list of customers
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @return the customers to display
	 */
	@GetMapping(value = "", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public CustomersResult getCustomers(
			@RequestParam("page") 
			Optional<Integer> pageNumber, 
			@RequestParam("size") 
			Optional<Integer> pageSize,
			@RequestParam("country") 
			Optional<CountryCodeEnum> country)
	{
		return customerService.getCustomers(country.orElse(null), PageRequest.of(pageNumber.orElse(0), pageSize.orElse(5000), Direction.ASC, "id"));
	}

}
