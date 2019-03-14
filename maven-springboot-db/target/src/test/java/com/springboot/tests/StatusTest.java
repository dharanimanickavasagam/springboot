package com.springboot.tests;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.App;
import com.springboot.model.StatusUpdate;
import com.springboot.model.StatusUpdateDao;

// @RunWith
// The test case runs with SpringJUnit4ClassRunner.class
//
// @SpringBootTest(classes = App.class)
// Contains the configuration code to test
//
// @WebAppConfiguration
// testing the data model without the Tomcat server
// but with the same configuration that a web application would use
//
// import static org.junit.Assert.assertNotNull;
// Assert.assertNotNull() is a static method
// so using static in the import avoids using Assert elsewhere for assertNotNull
//
// @Transactional
// Every thing would appear as it it was comited 
// But it will be rolled back 
// Does not add anything to the database 
//
// @Test
// Test case 

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@Transactional
public class StatusTest {

	// @Autowired
	// If spring is managing the object its bean
	// to invoke the object that spring created, use @Autowired
	//

	@Autowired
	private StatusUpdateDao stausUpdateDao;

	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is a test status update");
		stausUpdateDao.save(status);

		// Actuals is status
		Assert.assertNotNull("Non null ID expected", status.getId());
		Assert.assertNotNull("Non null Date expected", status.getAdded());

		// Expected
		// findOne finds an entity from the DB based on the ID, so getID()
		StatusUpdate retrieved = stausUpdateDao.findOne(status.getId());
		Assert.assertEquals("Matching StatusUpdate", status, retrieved);
	}

	@Test
	public void testFindLatest() {
		Calendar cal = Calendar.getInstance();
		StatusUpdate lastStatusUpdate = null;

		for (int i = 0; i < 10; i++) {

			cal.add(Calendar.DAY_OF_YEAR, 1);

			StatusUpdate status = new StatusUpdate("New Stauts with calender "
					+ i, cal.getTime());
			stausUpdateDao.save(status);

			lastStatusUpdate = status;

		}

		StatusUpdate retrieved = stausUpdateDao.findFirstByOrderByAddedDesc();
		Assert.assertEquals("latest status update", lastStatusUpdate, retrieved);

	}

}
