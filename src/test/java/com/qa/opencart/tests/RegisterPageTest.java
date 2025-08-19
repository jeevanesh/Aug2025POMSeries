package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	@Test
	public void userRegisterTest() {
		Assert.assertTrue(
				registerPage.
					userRegisteration("vishal", "shah", "vishaltest@email.com", "9898989898", "Test@123", "yes"));
		
	}
	
	

}
