package com.lws.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.lws.base.AutomationBase;
import com.lws.exceptions.AutomationException;



public class ValidationActions extends AutomationBase {
	UtilityActions utilityActionHelper = new UtilityActions();

	/**
	 * Verify that the object is present and return true or false
	
	 */
	public boolean verifyElementPresent(WebDriver driver, String elementName) throws AutomationException {
		boolean elementPresent = false;
		try {
			int count = utilityActionHelper.waitForElements(driver, elementName).size();
			if (count != 0) {
				elementPresent = true;
			} else {
				elementPresent = false;
			}
		} catch (Exception e) {
			elementPresent = false;
		}
		return elementPresent;
	}

	/**
	 * Verify that the object is present
	
	 */
	public void verifyElementPresent(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementPresent = false;
		try {
			int count = utilityActionHelper.waitForElements(driver, elementName).size();
			if (count != 0) {
				elementPresent = true;
			} else {
				elementPresent = false;
			}
			Assert.assertTrue(elementPresent, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(elementPresent, messageOnFailure);
		}
	}

	/**
	 * Verify that the object is not present
	 * 
	
	 */
	public void verifyElementNotPresent(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementNotPresent = false;
		try {
			int count = utilityActionHelper.waitForElements(driver, elementName).size();
			if (count != 0) {
				elementNotPresent = true;
			} else {
				elementNotPresent = false;
			}
			Assert.assertFalse(elementNotPresent, messageOnFailure);
		} catch (Exception e) {
			Assert.assertFalse(elementNotPresent, messageOnFailure);
		}
	}

	/**
	 * Verify that the object is visible and return true or false
	 
	 */
	public boolean verifyElementVisible(WebDriver driver, String elementName) throws AutomationException {
		boolean elementVisible = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isDisplayed()) {
				elementVisible = true;
			} else {
				elementVisible = false;
			}
		} catch (Exception e) {
			elementVisible = false;
		}
		return elementVisible;
	}

	/**
	 * Verify that the object is visible
	
	 */
	public void verifyElementVisible(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementVisible = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isDisplayed()) {
				elementVisible = true;
			} else {
				elementVisible = false;
			}
			Assert.assertTrue(elementVisible, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(elementVisible, messageOnFailure);
		}
	}
	/**
	 * Verify that the object is enabled and return true or false
	 *
	 */
	public boolean verifyElementEnabled(WebDriver driver, String elementName) throws AutomationException {
		boolean elementEnabled = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isEnabled()) {
				elementEnabled = true;
			} else {
				elementEnabled = false;
			}
		} catch (Exception e) {
			elementEnabled = false;
		}
		return elementEnabled;
	}

	/**
	 * Verify that the object is enabled
	 
	 */
	public void verifyElementEnabled(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementEnabled = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isEnabled()) {
				elementEnabled = true;
			} else {
				elementEnabled = false;
			}
			Assert.assertTrue(elementEnabled, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(elementEnabled, messageOnFailure);
		}
	}
	/**
	 * Verify that the object is not enabled
	 */
	public void verifyElementNotEnabled(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementNotEnabled = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isEnabled()) {
				elementNotEnabled = true;
			} else {
				elementNotEnabled = false;
			}
			Assert.assertFalse(elementNotEnabled, messageOnFailure);
		} catch (Exception e) {
			Assert.assertFalse(elementNotEnabled, messageOnFailure);
		}
	}

	/**
	 * Verify that the object is selected and return true or false
	
	 */
	public boolean verifyElementSelected(WebDriver driver, String elementName) throws AutomationException {
		boolean elementSelected = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isSelected()) {
				elementSelected = true;
			} else {
				elementSelected = false;
			}
		} catch (Exception e) {
			elementSelected = false;
		}
		return elementSelected;
	}

	/**
	 * Verify that the object is selected
	 
	 */
	public void verifyElementSelected(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementSelected = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isSelected()) {
				elementSelected = true;
			} else {
				elementSelected = false;
			}
			Assert.assertTrue(elementSelected, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(elementSelected, messageOnFailure);
		}
	}
	/**
	 * Verify that the object is not selected
	
	 */
	public void verifyElementNotSelected(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean elementNotSelected = false;
		try {
			if (utilityActionHelper.getWebElement(driver, elementName).isSelected()) {
				elementNotSelected = true;
			} else {
				elementNotSelected = false;
			}
			Assert.assertFalse(elementNotSelected, messageOnFailure);
		} catch (Exception e) {
			Assert.assertFalse(elementNotSelected, messageOnFailure);
		}
	}

	/**
	 * Verify that the checkbox selected and return true or false
	
	 */
	public boolean verifyCheckboxSelected(WebDriver driver, String elementName) throws AutomationException {
		boolean isCheckboxSelected = false;
		try {
			if (driver != null) {
				WebElement element = utilityActionHelper.getWebElement(driver, elementName);
				if (element != null) {
					if (element.getAttribute("checked") != null) {
						if (element.getAttribute("checked").equals("true")) {
							isCheckboxSelected = true;
						}
					} else {
						isCheckboxSelected = false;
					}
				}
			}
		} catch (Exception e) {
			isCheckboxSelected = false;
		}
		return isCheckboxSelected;
	}

	/**
	 * Verify that the checkbox selected
	 
	 */
	public void verifyCheckboxSelected(WebDriver driver, String elementName, String messageOnFailure)
			throws AutomationException {
		boolean isCheckboxSelected = false;
		try {
			if (driver != null) {
				WebElement element = utilityActionHelper.getWebElement(driver, elementName);
				if (element != null) {
					if (element.getAttribute("checked") != null) {
						if (element.getAttribute("checked").equals("true")) {
							isCheckboxSelected = true;
						}
					} else {
						isCheckboxSelected = false;
					}
					Assert.assertTrue(isCheckboxSelected, messageOnFailure);
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(isCheckboxSelected, messageOnFailure);
		}
	}

	/**
	 * Verify that text or label present and return true or false
	
	 */
	public boolean verifyElementText(WebDriver driver, String elementName, String expectedText)
			throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.getWebElement(driver, elementName);
			String actualText = element.getText();
			if (actualText.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
			}
		} catch (Exception e) {
			textVerified = false;
		}
		return textVerified;
	}

	/**
	 * Verify that text or label present

	 */
	public void verifyElementText(WebDriver driver, String elementName, String expectedText, String messageOnFailure)
			throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.getWebElement(driver, elementName);
			String actualText = element.getText();
			if (actualText.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
			}
			Assert.assertTrue(textVerified, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(textVerified, messageOnFailure);
		}
	}

	/**
	 * Verify that the object contains text or label and return true or false
	
	 */
	public boolean verifyElementContainsText(WebDriver driver, String elementName, String expectedText)
			throws AutomationException {
		boolean textContains = false;
		try {
			WebElement element = utilityActionHelper.getWebElement(driver, elementName);
			String actualText = element.getText();
			if (actualText.contains(expectedText)) {
				textContains = true;
			} else {
				textContains = false;
			}
		} catch (Exception e) {
			textContains = false;
		}
		return textContains;
	}

	/**
	 * Verify that the object contains text or label
	 * 
	
	 */
	public void verifyElementContainsText(WebDriver driver, String elementName, String expectedText,
			String messageOnFailure) throws AutomationException {
		boolean textContains = false;
		try {
			WebElement element = utilityActionHelper.getWebElement(driver, elementName);
			String actualText = element.getText();
			if (actualText.contains(expectedText)) {
				textContains = true;
			} else {
				textContains = false;
			}
			Assert.assertTrue(textContains, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(textContains, messageOnFailure);
		}
	}

	/**
	 * Verify that the object attribute has text or label present and return true or
	 * false
	 *
	 */
	public boolean verifyElementAttributeHasText(WebDriver driver, String elementName, String attributeName,
			String expectedText) throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.getWebElement(driver, elementName);
			String actualAttributeValue = element.getAttribute(attributeName);
			if (actualAttributeValue.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
			}
		} catch (Exception e) {
			textVerified = false;
		}
		return textVerified;
	}

	/**
	 * Verify that the object attribute has text or label present
	 */
	public void verifyElementAttributeHasText(WebDriver driver, String elementName, String attributeName,
			String expectedText, String messageOnFailure) throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.getWebElement(driver, elementName);
			String actualAttributeValue = element.getAttribute(attributeName);
			if (actualAttributeValue.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
			}
			Assert.assertTrue(textVerified, messageOnFailure);
		} catch (Exception e) {
			Assert.assertTrue(textVerified, messageOnFailure);
		}
	}

}
