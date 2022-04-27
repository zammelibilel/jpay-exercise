package com.jpay.exercise.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.jpay.exercise.enums.CountryCodeEnum;

@Service
public class PhoneNumberValidationService {

	public boolean isValid(String phoneNumber, CountryCodeEnum countryCodeEnum) {
		
		boolean result = false;

		if (phoneNumber != null && countryCodeEnum != null) {

			Pattern phoneNumberValidationPattern = Pattern.compile(countryCodeEnum.getRegex());

			result = phoneNumberValidationPattern.matcher(phoneNumber).matches();
		}

		return result;
	}

}
