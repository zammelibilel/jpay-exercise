package com.jpay.exercise.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class to test the endpoints provided by CustomerController  
 * @author zammelib
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("When all customer are requested then they are all returned")
	public void allCustomersRequested() throws Exception {
		mockMvc.perform(get("/customers"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(jsonPath("items.size()", equalTo(41)));
	}

	@Test
	@DisplayName("When the page is requested then get correct result")
	void getCustomerWithPaginationCorrect() throws Exception {
		mockMvc.perform(get("/customers?page=1&size=3"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(jsonPath("items.size()", equalTo(3)));
	}

}
