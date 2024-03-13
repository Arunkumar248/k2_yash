package com.lws.testhelper;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.lws.action.UIActions;
import com.lws.exceptions.AutomationException;

import lws.selenium.testobjects.LocationObject;

public class LocationHelper  {


	public void location(WebDriver driver) throws AutomationException, InterruptedException {
		UIActions u=new UIActions();

		u.tapUsingLocatorType(driver,"xpath",LocationObject.clickLocation);
		u.tapUsingLocatorType(driver,"id",LocationObject.add_new);
//		u.typeUsingLocatorType(driver, "id", LocationObject.addLocation, "TamilNadu");
//		u.typeUsingLocatorType(driver, "id", LocationObject.proxCardMask, "123@456");
//		u.typeUsingLocatorType(driver, "id",LocationObject.address1, "No 45, AK nagar");
//		u.typeUsingLocatorType(driver, "id", LocationObject.address2, "tambaram,chennai");
//		u.typeUsingLocatorType(driver, "id", LocationObject.city, "Chennai");
//		u.typeUsingLocatorType(driver, "id", LocationObject.zip, "620001");
//		u.tapUsingLocatorType(driver, "id", LocationObject.state);
//		Thread.sleep(2000);
//		driver.findElement(By.id("select2-ddbState-container")).click();
//		Thread.sleep(3000);
//
//		List<WebElement> findElements = driver.findElements(By.id("select2-ddbState-results"));
//
//		for (WebElement webElement : findElements) {
//			System.out.println(webElement);
//			if (webElement.getText().equals("Alabama")) {
//				webElement.click();
//
//			}
//		}
	}


	public void AddLocationCredentials(WebDriver driver, String AddLocation) throws AutomationException {
		String loactionname = null, proxCardmask = null, address1 =null, address2 =null, city =null, ZIP =null;
		
		
		List<String> data = new GeneralHelper().AddLocationCredentials(AddLocation);
		try {
			loactionname = data.get(0);
			proxCardmask = data.get(1);
			address1     = data.get(2);
			address2     = data.get(3);
			city         = data.get(4); 
			ZIP          = data.get(5);
			Thread.sleep(4000);
			UIActions u=new UIActions();
			u.tap(driver,LocationObject.clickLocation);
			u.tap(driver,LocationObject.add_new);
			u.type(driver, LocationObject.addLocation, loactionname);
			u.type(driver, LocationObject.proxCardMask, proxCardmask);
			u.type(driver, LocationObject.address1, address1);
			u.type(driver, LocationObject.address2, address2);
			u.type(driver, LocationObject.city, city);
			u.type(driver, LocationObject.zip, ZIP);
			//u.tap(driver, LocationObject.login_Button);

			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}



