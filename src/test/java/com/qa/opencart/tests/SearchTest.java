package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SearchTest extends BaseTest {
	
	@BeforeClass
	public void searchSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Check search feature test...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Jeevanesh")
	@Test
	public void searchTest() {
		searchResultsPage = accPage.doSearch("samsung");
		int actResultsCount = searchResultsPage.getResultsProductCount();
		Assert.assertEquals(actResultsCount, 2);
	}
	
	

}
