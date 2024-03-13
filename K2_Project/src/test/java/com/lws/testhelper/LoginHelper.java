package com.lws.testhelper;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;

import lws.selenium.testobjects.LoginPageObject;

public class LoginHelper { 

	public void loginToApplication(WebDriver driver, String scenarioName) throws AutomationException {
		String username = null, password = null;
		List<String> data = new GeneralHelper().getApplicationCredentials(scenarioName);
		try {
			username = data.get(0);
			password = data.get(1);
			Thread.sleep(4000);
			UIActions u=new UIActions();
			u.type(driver, LoginPageObject.email_Field, username);
			u.type(driver, LoginPageObject.password_Field, password);
			u.tap(driver, LoginPageObject.login_Button);

			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

