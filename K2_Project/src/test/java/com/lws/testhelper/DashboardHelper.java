package com.lws.testhelper;

import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;

import lws.selenium.testobjects.DashboardObject;

public class DashboardHelper  {


	public void SelectOrganization(WebDriver driver ) throws AutomationException, InterruptedException {
		UIActions u=new UIActions();
		u.tapUsingLocatorType(driver,"xpath",DashboardObject.select_organization);
		u.typeUsingLocatorType(driver, "id", DashboardObject.search, "AUTOMATION ACCOUNT");
		u.tapUsingLocatorType(driver,"id",DashboardObject.select_account);	
		Thread.sleep(2000);

		
	}
}
