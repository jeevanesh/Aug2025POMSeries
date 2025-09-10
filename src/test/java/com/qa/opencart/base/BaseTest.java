package com.qa.opencart.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.utils.LogUtil;

import io.qameta.allure.Description;

//@Listeners(ChainTestListener.class)
public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	
	protected Properties prop;
	
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;
	
	public static final Logger log = LogManager.getLogger(BaseTest.class);
	
	@Description("init the driver and properties")
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();  // Load properties from config file
		
		if(browserName != null) {
			prop.setProperty("browser", browserName);
		}
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
//	@BeforeMethod //will be running before each @test method
//	public void beforeMethod(ITestContext result) {
//		LogUtil.info("--------- starting test case ----------" + result.getName());
//	}
	
	@AfterMethod //will be running after each @test method
	public void attachScreenshot(ITestResult result) {
		if(!result.isSuccess()) { //only for failure test cases -- true
			log.info("------ Screenshot is taken ------");
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
		}
		
//		LogUtil.info("--------- ending test case ----------" + result.getMethod().getMethodName());
		
		// ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
	}
	
	@Description("closing the browser...")
	@AfterTest
	public void tearDown() {
		driver.quit();
		log.info("-------------- Closing the browser --------------");
	}

}
