package com.lws.action;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lws.base.AutomationBase;
import com.lws.exceptions.AutomationException;
import com.lws.utilities.AutomationConstants;
import com.lws.utilities.PropertyDataHandler;

public class UtilityActions extends AutomationBase {
	public WebDriverWait wait;
	public Random random;

	/**
	 * Get an element based on the visibility and return WebElement
	 * 
	 *
	 */
	public WebElement getWebElement(WebDriver driver, String elementName) throws AutomationException {
		WebElement element = null;
		PropertyDataHandler objProertyData = new PropertyDataHandler();
		try {
			long timeout = Long.parseLong(objProertyData.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG,
					AutomationConstants.SHORT_LOADING));
			wait =  new WebDriverWait(driver, timeout);
			By actualElement = getElementByLocator(elementName);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(actualElement));
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(" + element.getLocation().x + "," + element.getLocation().y + ")");
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
		}
		return element;
	}

	/**
	 * Get an element based on the presence of element located and return WebElement
	 * 
	 * 
	 */
	public WebElement getWebElement(WebDriver driver, By elementLocator) throws AutomationException {
		WebElement element = null;
		PropertyDataHandler objProertyData = new PropertyDataHandler();
		try {
			long timeout = Long.parseLong(
					objProertyData.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementLocator + "'");
		}
		return element;
	}

	/**
	 * Get the By locator value
	 * 
	 */
	public By getElementByLocator(String elementName) throws AutomationException {
		By byElement = null;
		try {
			if (elementName.startsWith("#") || elementName.startsWith("td[") || elementName.startsWith("tr[")
					|| elementName.startsWith("td ") || elementName.startsWith("tr ")
					|| elementName.startsWith("input[") || elementName.startsWith("span[")
					|| elementName.startsWith("div") || elementName.startsWith(".")) {
				byElement = By.cssSelector(elementName);
			} else if (elementName.startsWith("//") || elementName.startsWith(".//") || elementName.startsWith("(.//")
					|| elementName.startsWith("(//") || elementName.startsWith("((//")) {
				byElement = By.xpath(elementName);
			} else if (elementName.startsWith("name")) {
				byElement = By.name(elementName.split(">>")[1]);
			} else if (elementName.startsWith("id")) {
				byElement = By.id(elementName.split(">>")[1]);
			} else if (elementName.startsWith("className")) {
				byElement = By.className(elementName.split(">>")[1]);
			} else if (elementName.startsWith("linkText")) {
				byElement = By.linkText(elementName.split(">>")[1]);
			} else if (elementName.startsWith("partialLinkText")) {
				byElement = By.partialLinkText(elementName.split(">>")[1]);
			} else {
				byElement = By.tagName(elementName);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return byElement;
	}

	/**
	 * Wait for an element based on the visibility and return true or false
	 * 
	 * 
	 */
	public boolean waitForElement(WebDriver driver, String elementName) throws AutomationException {
		boolean isElementVisible = false;
		PropertyDataHandler objPropertyData = new PropertyDataHandler();
		try {
			long timeout = Long.parseLong(
					objPropertyData.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			By actualElement = getElementByLocator(elementName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(actualElement));
			isElementVisible = true;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return isElementVisible;
	}

	/**
	 * Wait for the element using the object mentioned in the Object repository
	 * 
	 * 
	 */
	public WebElement waitForElement(WebDriver driver, String expectedElementName, long waitTime)
			throws AutomationException {
		WebElement element = null;
		try {
			wait = new WebDriverWait(driver, waitTime);
			By actualElement = getElementByLocator(expectedElementName);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(actualElement));
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + expectedElementName + "'");
		}
		return element;
	}

	/**
	 * Wait for an element based on the invisibility and return true or false
	 * 
	 * 
	 */
	public boolean waitForElementInVisible(WebDriver driver, String elementName) throws AutomationException {
		boolean isElementInVisible = false;
		PropertyDataHandler objPropertyData = new PropertyDataHandler();
		try {
			long timeout = Long.parseLong(
					objPropertyData.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait =  new WebDriverWait(driver, timeout);
			By actualElement = getElementByLocator(elementName);
			isElementInVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(actualElement));
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return isElementInVisible;
	}

	/**
	 * Wait for text or label to be present and return true or false
	 * 
	 * 
	 */
	public boolean waitForTextPresent(WebDriver driver, String elementName, String expectedText)
			throws AutomationException {
		boolean isTextPresent = false;
		PropertyDataHandler objPropertyData = new PropertyDataHandler();
		try {
			long timeout = Long.parseLong(
					objPropertyData.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait =  new WebDriverWait(driver, timeout);
			By actualElement = getElementByLocator(elementName);
			isTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(actualElement, expectedText));
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return isTextPresent;
	}

	/**
	 * Wait for the elements based on the presence of element located and return
	 * lists of WebElement
	 * 
	 */
	public List<WebElement> waitForElements(WebDriver driver, String elementName) throws AutomationException {
		List<WebElement> elements;
		PropertyDataHandler objProertyData = new PropertyDataHandler();
		try {
			if (elementName != null) {
				long timeout = Long.parseLong(
						objProertyData.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, "SHORT_LOADING"));
				wait = new WebDriverWait(driver, timeout);
				By actualElement = getElementByLocator(elementName);
				wait.until(ExpectedConditions.presenceOfElementLocated(actualElement));
				elements = driver.findElements(actualElement);
			} else
				throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.OBJECT_NOT_FOUND + "'" + elementName + "'");
		}
		return elements;
	}

	/**
	 * Set delay between test steps
	 */
	public void delay(int delayInSeconds) throws AutomationException {
		try {
			Thread.sleep(delayInSeconds * 1000);
		} catch (Exception lException) {
			throw new AutomationException(getExceptionMessage(), lException);
		}
	}

	/**
	 * Set delay between test steps based on driver session
	 * 
	 * 
	 */
	public void delay(WebDriver driver, int delayInSeconds) throws AutomationException {
		try {
			driver.manage().timeouts().implicitlyWait(delayInSeconds,TimeUnit.SECONDS);
		} catch (Exception lException) {
			throw new AutomationException(getExceptionMessage(), lException);
		}
	}

	/**
	 * Get the long waiting time from the framework config file
	 * 
	 */
	public long getLongWaitingTime() throws AutomationException {
		long timeout;
		try {
			timeout = Long.parseLong(new PropertyDataHandler()
					.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, AutomationConstants.LONG_LOADING));
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return timeout;
	}

	/**
	 * Get the short waiting time from the framework config file
	 * 
	 */
	public long getShortWaitingTime() throws AutomationException {
		long timeout;
		try {
			timeout = Long.parseLong(new PropertyDataHandler()
					.getProperty(AutomationConstants.AUTOMATION_FRAMEWORK_CONFIG, AutomationConstants.SHORT_LOADING));
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return timeout;
	}

	/**
	 * Get the text or label of the WebElement
	 * 
	 * 
	 */
	public String getElementText(WebDriver driver, String elementName) throws AutomationException {
		String elementText = "";
		try {
			WebElement element = getWebElement(driver, elementName);
			elementText = element.getText();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return elementText;
	}

	/**
	 * Get the attribute value of the WebElement
	 * 
	 * 
	 */
	public String getElementAttributeValue(WebDriver driver, String elementName, String attributeName)
			throws AutomationException {
		String elementAttribute = "";
		try {
			WebElement element = getWebElement(driver, elementName);
			elementAttribute = element.getAttribute(attributeName);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
		return elementAttribute;
	}

	/**
	 * Scroll to an element
	 * 
	 * 
	 */
	public void scrollToElement(WebDriver driver, String elementName) throws AutomationException {
		try {
			WebElement element = getWebElement(driver, elementName);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Scroll to the bottom of the web page
	 * 
	 */
	public void scrollToBottom(WebDriver driver) throws AutomationException {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Scroll to the top of the web page
	 * 
	 */
	public void scrollToTop(WebDriver driver) throws AutomationException {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * 
	 * Scroll the page up in web applications
	 * 
	 * 
	 */

	public void scrollWebPageUp(int numberOfTimes) throws AutomationException {
		int x = 1;

		try {
			Robot robot = new Robot();
			new UtilityActions().delay(2);
			while (x <= numberOfTimes) {
				// Simulate a mouse click
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

				// Simulate a key press
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				new UtilityActions().delay(2);
				x++;
			}
		} catch (AWTException e) {
			throw new AutomationException(e);
		}

	}

	/**
	 * Convert a double value to an Integer
	 * 
	 * 
	 */
	public int convertDoubleToInt(double doubleValue) throws AutomationException {
		try {
			int intValue = (int) doubleValue;
			return intValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Convert an Integer to a string value
	 
	 */
	public String convertIntToString(int intValue) throws AutomationException {
		try {
			String stringValue = String.valueOf(intValue);
			return stringValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * 
	 * Scroll the page down in web applications
	 * 
	 */

	public void scrollWebPageDown(int numberOfTimes) throws AutomationException {
		int x = 1;

		try {
			Robot robot = new Robot();
			new UtilityActions().delay(2);
			while (x <= numberOfTimes) {
				// Simulate a mouse click
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

				// Simulate a key press
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				new UtilityActions().delay(2);
				x++;
			}
		} catch (AWTException e) {
			throw new AutomationException(e);
		}
	}

	/**
	 * Clear an input field
	  
	 */
	public void clearInputField(WebDriver driver, String elementName) throws AutomationException {
		try {
			WebElement element = getWebElement(driver, elementName);
			element.clear();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Select the value from the drop down using the visible text
	 * 
	 */
	public void selectDropDownValueByVisibleText(WebDriver driver, String elementName, String visibleText)
			throws AutomationException {
		try {
			Select select = new Select(getWebElement(driver, elementName));
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Select the value from the drop down using the index
	 * 
	 * 
	 */
	public void selectDropDownValueByIndex(WebDriver driver, String elementName, int index) throws AutomationException {
		try {
			Select select = new Select(getWebElement(driver, elementName));
			select.selectByIndex(index);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Select the value from the drop down using value
	 * 
	 */
	public void selectDropDownValueByValue(WebDriver driver, String elementName, String valueToSelect)
			throws AutomationException {
		try {
			Select select = new Select(getWebElement(driver, elementName));
			select.selectByValue(valueToSelect);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Get current date
	 * 
	 */
	public String getCurrentDate() throws AutomationException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
			Date date = new Date();
			String filePathdate = dateFormat.format(date).toString();
			return filePathdate;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Take a screenshot of the current screen and store into screenshots folder in
	 * the project structure
	 * 
	 */
	public String takeScreenshot(WebDriver driver, String fileName) throws AutomationException {
		try {
			TakesScreenshot screenShot = ((TakesScreenshot) driver);
			File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + getCurrentDate()
					+ "_" + "screenshot.jpg";
			File destinationFile = new File(destination);
			FileUtils.copyFile(sourceFile, destinationFile);
			return destination;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

}
