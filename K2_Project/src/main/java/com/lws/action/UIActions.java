package com.lws.action;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import com.lws.base.AutomationBase;
import com.lws.exceptions.AutomationException;
import com.lws.utilities.AutomationConstants;

public class UIActions extends AutomationBase {
	
	UtilityActions utilityActionHelper = new UtilityActions();

	/**
	 * Click on an object
	 * 
	 */
	public void tap(WebDriver driver, String elementName) throws AutomationException {
		try {
			if (elementName != null) {
				WebElement element = utilityActionHelper.getWebElement(driver, elementName);
				element.click();
				System.out.println("==========================================================");
				System.out.println("Successfully clicked on " + elementName);
			} else {
				throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
			}
		} catch (Exception e) {
			try {
				WebElement element = utilityActionHelper.getWebElement(driver, elementName);
				Actions builder = new Actions(driver);
				Action action = builder.moveToElement(element).click().build();
				action.perform();
				System.out.println("==========================================================");
				System.out.println("Successfully clicked on " + elementName);
			} catch (Exception ex) {
				throw new AutomationException(getExceptionMessage(), ex);
			}
		}
	}


	/**
	 * Click on the object based on the locator type - xpath, id, classname,
	 * linktext, partial linktext, css selector, tag name
	 * 
	 */
	public void tapUsingLocatorType(WebDriver driver, String locatorType, String elementName)
			throws AutomationException {
		try {
			By elementLocator = null;
			if (elementName != null) {
				switch (locatorType.toLowerCase()) {
				case "xpath":
					elementLocator = By.xpath(elementName);
					break;
				case "id":
					elementLocator = By.id(elementName);
					break;
				case "name":
					elementLocator = By.name(elementName);
					break;
				case "css":
				case "css selector":
				case "cssselector":
					elementLocator = By.cssSelector(elementName);
					break;
				case "class":
				case "classname":
				case "class name":
					elementLocator = By.className(elementName);
					break;
				case "link text":
				case "linktext":
					elementLocator = By.linkText(elementName);
					break;
				case "partial link text":
				case "partiallinktext":
				case "partial linktext":
					elementLocator = By.partialLinkText(elementName);
					break;
				case "tag":
				case "tagname":
				case "tag name":
					elementLocator = By.tagName(elementName);
					break;
				default:
					break;
				}
				WebElement element = utilityActionHelper.getWebElement(driver, elementLocator);
				element.click();
				System.out.println("==========================================================");
				System.out.println("Successfully clicked on " + elementName);
			} else {
				throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Enter values to an input field
	 
	 */
	public void type(WebDriver driver, String elementName, String typeValue) throws AutomationException {
		try {
			if (driver != null && elementName != null) {
				WebElement element = utilityActionHelper.getWebElement(driver, elementName);
				element.sendKeys(typeValue);
				System.out.println("==========================================================");
				System.out.println("Data " + typeValue + " successfully entered into " + elementName);
			} else {
				throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
			}
		} catch (Exception e) {
			try {
				WebElement element = utilityActionHelper.getWebElement(driver, elementName);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0]. value='" + typeValue + "';", element);
				System.out.println("==========================================================");
				System.out.println("Data " + typeValue + " successfully entered into " + elementName);
			} catch (Exception ex) {
				throw new AutomationException(getExceptionMessage(), ex);
			}
		}
	}

	/**
	 * Enter values to an input field based on the locator type - xpath, id,
	 * classname, linktext, partial linktext, css selector, tag name
	 * 
	
	 */
	public void typeUsingLocatorType(WebDriver driver, String locatorType, String elementName, String typeValue)
			throws AutomationException {
		try {
			By elementLocator = null;
			if (elementName != null) {
				switch (locatorType.toLowerCase()) {
				case "xpath":
					elementLocator = By.xpath(elementName);
					break;
				case "id":
					elementLocator = By.id(elementName);
					break;
				case "name":
					elementLocator = By.name(elementName);
					break;
				case "css":
				case "css selector":
				case "cssselector":
					elementLocator = By.cssSelector(elementName);
					break;
				case "class":
				case "classname":
				case "class name":
					elementLocator = By.className(elementName);
					break;
				case "link text":
				case "linktext":
					elementLocator = By.linkText(elementName);
					break;
				case "partial link text":
				case "partiallinktext":
				case "partial linktext":
					elementLocator = By.partialLinkText(elementName);
					break;
				case "tag":
				case "tagname":
				case "tag name":
					elementLocator = By.tagName(elementName);
					break;
				default:
					break;
				}
				WebElement element = utilityActionHelper.getWebElement(driver, elementLocator);
				element.sendKeys(typeValue);
				System.out.println("==========================================================");
				System.out.println("Successfully clicked on " + elementName);
			} else {
				throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}
}
