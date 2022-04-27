package com.jpay.exercise.enums;

public enum CountryCodeEnum {

	// @formatter:off
	
	CAMEROON("Cameroon", "237", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
	ETHIOPIA("Ethiopia", "251", "\\(251\\)\\ ?[1-59]\\d{8}$"),
	MOROCCO("Morocco", "212", "\\(212\\)\\ ?[5-9]\\d{8}$"),
	MOZAMBIQUE("Mozambique", "258", "\\(258\\)\\ ?[28]\\d{7,8}$"),
	UGANDA("Uganda", "256", "\\(256\\)\\ ?\\d{9}$");
	
	
	// @formatter:on

	private String countryName;

	/**
	 * This is the first statically prefixed part of the phone number.
	 */
	private String phoneCode;

	private String regex;

	/**
	 * 
	 * @param countryName
	 * @param phoneCode
	 * @param regex
	 */
	private CountryCodeEnum(String countryName, String phoneCode, String regex) {
		this.countryName = countryName;
		this.phoneCode = phoneCode;
		this.regex = regex;
	}
	
	public static CountryCodeEnum getCountryByPhoneCode(String phoneCode) {
		CountryCodeEnum result = null;

		for (CountryCodeEnum countryCode : CountryCodeEnum.values()) {
			if (countryCode.phoneCode.equals(phoneCode)) {
				result = countryCode;
			}
		}

		return result;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public String getRegex() {
		return regex;
	}
	
}
