package com.github.s_places.seven_places_rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;

//DON'T FORGOT TO RUN LOCAL APP BEFORE TESTING!

/** 
 * @author splaces.project@gmail.com
 * Integration tests for local app.
 */ 
@SpringBootTest
@WebAppConfiguration
@TestPropertySource(locations = "classpath:application.properties")
class SevenPlacesRestApplicationTests {

	//** Injectiong of 'magic entity' for DAO and REST access. */
	@Autowired
	private ContinentsRepository continentsRepository;

	/** @value link to local server.*/
	private final String HOST = "http://localhost:8080";

	/** @return entity for testing of Rest controller. */
	private TestRestTemplate testRestTemplate() {
		var restTemplate = new RestTemplateBuilder().rootUri(HOST);
		return new TestRestTemplate(restTemplate);
	}

	@Test
	void restResponseIsValid() throws Exception {

		//** Getting all records from database. */
		var continents = continentsRepository.findAll();
		//** Compare gotted value with excected.*/
		assertEquals(7, continents.size());
		//** Getting response from Rest controller.*/
		var response = testRestTemplate().getForEntity("/continents", Continent.class);
		//** Comparing gotted result with expected.*/
		assertEquals(200, response.getStatusCodeValue());

	}
}