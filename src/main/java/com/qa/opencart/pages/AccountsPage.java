package com.qa.opencart.pages;
import static com.qa.opencart.constants.AppConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// 1. Private By locators
	private final By headers = By.cssSelector("div#content > h2");
	private final By search = By.name("search");
	private final By searchIcon = By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	@Step("getting acc page title")
	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs(HOME_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("Home Page Title: " + title);
		return title;	
	}
	
	@Step("getting acc page url")
	public String getAccPageUrl() {
		String url = eleUtil.waitForURLContains(HOME_PAGE_URL_FRACTION, DEFAULT_TIMEOUT);
		System.out.println("Accounts page URL: " + url);
		return url;
	}
	
	@Step("getting acc page headers")
	public List<String> getAccPageHeaders() {
		List<WebElement> headerList = eleUtil.getElements(headers);
		List<String> headerValList = new ArrayList<String>();
		
		for(WebElement e : headerList) {
			String text = e.getText();
			headerValList.add(text);
		}
		System.out.println("Acc Page headers: " + headerValList);
		return headerValList;
	}
	
	@Step("perform search: {0}")
	public SearchResultsPage doSearch(String searchKey) {
		System.out.println("search key : " + searchKey);
		eleUtil.doSendKeys(search, searchKey, DEFAULT_TIMEOUT);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
	}
	

}
