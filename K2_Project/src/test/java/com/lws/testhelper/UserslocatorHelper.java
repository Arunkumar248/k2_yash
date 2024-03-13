package com.lws.testhelper;

import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;

import lws.selenium.testobjects.UserObject;
import lws.selenium.testobjects.UserslocatorObject;

public class UserslocatorHelper {


	public void AddUser(WebDriver driver) throws AutomationException {
		UIActions u=new UIActions();
		u.tapUsingLocatorType(driver, "xpath",UserslocatorObject.users);
		u.tapUsingLocatorType(driver, "id", UserslocatorObject.addUsers);
		u.typeUsingLocatorType(driver, "id", UserslocatorObject.firstName, "Bareeramol");
		u.typeUsingLocatorType(driver, "id", UserslocatorObject.lastName, "V A");
		u.typeUsingLocatorType(driver, "id", UserslocatorObject.email, "Bareera@gmail.in");
		u.typeUsingLocatorType(driver, "id", UserslocatorObject.phoneNumber, "8667255993");
		u.tapUsingLocatorType(driver, "id", UserslocatorObject.selectUserRole);
	}
	

	public void DownloadTemplate(WebDriver driver) throws AutomationException {
		UIActions u=new UIActions();
		u.tapUsingLocatorType(driver, "xpath",UserslocatorObject.users);
		u.tapUsingLocatorType(driver, "id", UserslocatorObject.downloadTemplate);
		u.tapUsingLocatorType(driver, "xpath", UserslocatorObject.downloadExcel);
	}
}
