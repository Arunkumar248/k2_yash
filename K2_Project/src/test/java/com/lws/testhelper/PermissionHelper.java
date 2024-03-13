package com.lws.testhelper;


import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;

import lws.selenium.testobjects.PermissionObject;

public class PermissionHelper  {

	public void Permission(WebDriver driver) throws AutomationException {
		UIActions u=new UIActions();
		u.tapUsingLocatorType(driver, "xpath", PermissionObject.permission);
		u.tapUsingLocatorType(driver, "xpath", PermissionObject.click);
		u.tapUsingLocatorType(driver, "id", PermissionObject.save);
	}


}
