package com.lws.testhelper;

import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;

import lws.selenium.testobjects.ProductObject;

public class ProductHelper {

	public void TC010_Product(WebDriver driver) throws AutomationException, InterruptedException {
		UIActions u=new UIActions();
		Thread.sleep(2000);
		u.tapUsingLocatorType(driver, "xpath", ProductObject.product);
	}

}


