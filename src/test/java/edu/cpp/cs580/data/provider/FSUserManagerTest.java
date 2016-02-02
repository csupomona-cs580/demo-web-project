package edu.cpp.cs580.data.provider;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.cpp.cs580.data.User;

public class FSUserManagerTest {
	
	FSUserManager userManager;
	
	@Before
	public void init() {
		userManager = new FSUserManager();
	}
	
	@Test
	public void testUpdateUser() {
		User newUser = new User();
		newUser.setId("580test-new");
		newUser.setName("CPP");
		newUser.setMajor("CS");
		
		int originalSize = userManager.listAllUsers().size();
		
		userManager.updateUser(newUser);
		
		int currentSize = userManager.listAllUsers().size();
		
		// assert
		User resUser = userManager.getUser("580test-new");
		Assert.assertNotNull(resUser);
		Assert.assertEquals("CPP", resUser.getName());
		Assert.assertEquals("CS", resUser.getMajor());	
		
		Assert.assertEquals(currentSize, originalSize + 1);
	}
	
	@After
	public void cleanUp() {
		userManager.deleteUser("580test-new");	
	}

}
