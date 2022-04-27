package com.jpay.exercise.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * customer result including pagination info
 * 
 * @author zammelib
 *
 */
public class CustomersResult extends PaginationResultInfo {

	private List<CustomerDto> items = new ArrayList<>();

	public List<CustomerDto> getItems() {
		return items;
	}

	public void setItems(List<CustomerDto> items) {
		this.items = items;
	}

}
