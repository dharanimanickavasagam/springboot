package com.springboot.tests;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.App;

// @RunWith
// The test case runs with SpringJUnit4ClassRunner.class
//
// @SpringBootTest(classes = App.class)
// Contains the configuration code to test
//
// @WebAppConfiguration
// testing the data model without the Tomcat server
// same configuration that a web application would use
//
// import static org.junit.Assert.assertNotNull;
// Assert.assertNotNull() is a static method
// so using static in the import avoids using Assert elsewhere for assertNotNull

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class StatusTest {

	@Test
	public void testDummy() {
		Long value = 7L;
		assertNotNull("Value should not be null", value);

	}
}
