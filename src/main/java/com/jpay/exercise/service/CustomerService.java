package com.jpay.exercise.service;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpay.exercise.dto.CustomerDto;
import com.jpay.exercise.dto.CustomersResult;
import com.jpay.exercise.enums.CountryCodeEnum;
import com.jpay.exercise.model.Customer;
import com.jpay.exercise.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PhoneNumberValidationService PhoneNumberValidationService;

	/**
	 * get customers contact with pagination support, including a filter by country
	 * if provided
	 * 
	 * @param countryCode
	 * @param pageable
	 * @return filter customer page by country
	 */
	public CustomersResult getCustomers(CountryCodeEnum countryCode, Pageable pageable) {

		CustomersResult result = null;

		if (countryCode != null) {

			// passing comma(,) and square-brackets as delimiter
			StringJoiner countryPhoneCode = new StringJoiner(",", "(", ")");
			countryPhoneCode.add(countryCode.getPhoneCode());

			result = buildCsutomersResult(
					customerRepository.findByPhoneStartsWith(countryPhoneCode.toString(), pageable));
		} else {
			result = buildCsutomersResult(customerRepository.findAll(pageable));
		}
		return result;

	}

	/**
	 * build customer result and add validate the phone numbers
	 * 
	 * @param page
	 * @return
	 */
	private CustomersResult buildCsutomersResult(Page<Customer> page) {
		CustomersResult result = new CustomersResult();
		result.setTotalCount(page.getTotalElements());
		result.setHasNextPage(page.hasNext());
		result.setHasPreviousPage(page.hasPrevious());

		for (Customer customer : page.getContent()) {

			CountryCodeEnum countryCode = getCountryCodeByPhoneNumber(customer.getPhone());

			CustomerDto dto = new CustomerDto();
			dto.setId(customer.getId());
			dto.setName(customer.getName());
			dto.setPhone(customer.getPhone());
			dto.setCountry(customer.getPhone());
			dto.setCountry(countryCode.getCountryName());
			dto.setValid(PhoneNumberValidationService.isValid(customer.getPhone(), countryCode));
			result.getItems().add(dto);

		}

		return result;
	}

	/**
	 * extract the country result from phonenumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	private CountryCodeEnum getCountryCodeByPhoneNumber(String phoneNumber) {

		CountryCodeEnum result = null;

		if (phoneNumber != null && !"".equals(phoneNumber)) {

			String phoneCode = phoneNumber.substring(phoneNumber.indexOf("(") + 1, phoneNumber.indexOf(")"));

			if (!"".equals(phoneCode)) {

				result = CountryCodeEnum.getCountryByPhoneCode(phoneCode);

			}
		}

		return result;
	}

}
