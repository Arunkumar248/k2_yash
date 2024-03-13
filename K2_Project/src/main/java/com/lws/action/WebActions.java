package com.lws.action;

import org.openqa.selenium.WebDriver;

import com.lws.base.AutomationBase;
import com.lws.exceptions.AutomationException;
import com.lws.utilities.AutomationConstants;

public class WebActions extends AutomationBase {
	UtilityActions utilsObj = new UtilityActions();

	/**
	 * Load the web application
	 * 
	 */
	public void loadWebApplication(WebDriver driver, String webApplicationUrl) throws AutomationException {
		try {
			driver.get(webApplicationUrl);
		} catch (Exception lException) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Navigate to the new web application URL
	 * 
	 */
	public void navigateToWebApplication(WebDriver driver, String webApplicationUrl) throws AutomationException {
		try {
			driver.navigate().to(webApplicationUrl);
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Get the current web URL
	 * 
	 */
	public String getWebUrl(WebDriver driver) throws AutomationException {
		String currentURL = "";
		try {
			currentURL = driver.getCurrentUrl();
		} catch (final Exception lException) {
			throw new AutomationException(getExceptionMessage(), lException);
		}
		return currentURL;
	}

	/**
	 * Get the title of the web page
	 * 
	 */
	public String getWebApplicationTitle(WebDriver driver) throws AutomationException {
		String title = "";
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return title;
	}

	/**
	 * Navigate back to the previous web page
	 * 
	 */
	public void navigateBack(WebDriver driver) throws AutomationException {
		try {
			driver.navigate().back();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Navigate forward to the next web page
	 * 
	 */
	public void navigateForward(WebDriver driver) throws AutomationException {
		try {
			driver.navigate().forward();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Refresh the web page
	 * 
	 */
	public void refreshPage(WebDriver driver) throws AutomationException {
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Close the browser window
	 * 
	 */
	public void closeBrowser(WebDriver driver) throws AutomationException {
		try {
			driver.close();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Quit the browser session
	 * 
	 * 
	 */
	public void quitBrowser(WebDriver driver) throws AutomationException {
		try {
			driver.quit();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

}
