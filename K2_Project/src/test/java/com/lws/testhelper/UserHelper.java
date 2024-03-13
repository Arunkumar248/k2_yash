package com.lws.testhelper;

import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;

import lws.selenium.testobjects.UserObject;

public class UserHelper  {


	public void ClickUser(WebDriver driver) throws AutomationException, InterruptedException {
		UIActions u=new UIActions();
		u.tapUsingLocatorType(driver, "xpath", UserObject.user);

	}
	public void AddRoles(WebDriver driver) throws AutomationException, InterruptedException {
		UIActions u=new UIActions();
		//click_user
		u.tapUsingLocatorType(driver, "xpath", UserObject.roles);
		//add_Roles
		u.tapUsingLocatorType(driver, "id", UserObject.add_newUser);
		u.typeUsingLocatorType(driver,"id",UserObject.roleName,"Dhoni");
		u.tapUsingLocatorType(driver, "xpath", UserObject.addRole);
		Thread.sleep(2000);
		u.tapUsingLocatorType(driver, "id", UserObject.add_newUser);
		u.typeUsingLocatorType(driver,"id",UserObject.roleName,"Rohit");
		u.tapUsingLocatorType(driver, "xpath", UserObject.addRole);
		Thread.sleep(2000);
		u.tapUsingLocatorType(driver, "id", UserObject.add_newUser);
		u.typeUsingLocatorType(driver,"id",UserObject.roleName,"Virat");
		u.tapUsingLocatorType(driver, "xpath", UserObject.addRole);
		Thread.sleep(2000);
		//search
		u.typeUsingLocatorType(driver, "id",UserObject.search,"virat");

	}
	public void DeleteUser(WebDriver driver) throws AutomationException {
		UIActions u=new UIActions();
		u.tapUsingLocatorType(driver, "xpath",UserObject.deleteUserIcon);
		u.tapUsingLocatorType(driver, "xpath", UserObject.deleteUserButton);
	}


}
