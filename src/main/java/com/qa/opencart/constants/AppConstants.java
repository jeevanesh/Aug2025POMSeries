package com.qa.opencart.constants;

import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_TIMEOUT = 5;
	public static final int MEDIUM_DEFAULT_TIMEOUT = 10;
	public static final int DEFAULT_LONG_TIMEOUT = 15;
	
	public static final String LOGIN_PAGE_TITLE = "Account Login11";
	public static final String HOME_PAGE_TITLE = "My Account";
	
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String HOME_PAGE_URL_FRACTION = "route=account/account";
	
	public static final List<String> expectedAccHeadersList = List.of("My Account",
																		"My Orders",
																		"My Affiliate Account",
																		"Newsletter");
	
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	// ********** Sheet name **************** /
	public static final String REGISTER_SHEET_NAME = "register";
	public static final String PRODUCT_SHEET_NAME = "product";
	

}
