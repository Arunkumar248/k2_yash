package com.lws.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.lws.exceptions.AutomationException;
import com.lws.utilities.AutomationConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase {

	public   WebDriver driver;

	/**
	 * Start the web browser
	 * 
	 */
	public WebDriver startBrowser(String browserName) throws AutomationException, InterruptedException {

		if (browserName.equalsIgnoreCase("Chrome")) {
			startChrome(browserName);
		}
		if (browserName.equalsIgnoreCase("Firefox")) {
			startFirefox();
		}
		System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * Launch Chrome browser
	 */
	private void startChrome(String browserName) throws AutomationException {
		try {
			//Ak reference --to get the webdrivermanager by adding the "github.bonigarcia
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			
//			This argument might be used to disable certain Chrome features during testing.
			options.addArguments("--test-type");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			if (browserName.equalsIgnoreCase("headless")) {
				
				//A sandbox is a security mechanism that isolates web page content				
				options.addArguments("--no-sandbox");
				
				//argument is commonly used in the context of running headless Chrome in environments where
				options.addArguments("--disable-dev-shm-usage");
				
				//headless option to the command line or browser configuration, it instructs the browser to run in headless mode.
				options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Launch Firefox browser
	 */
	private void startFirefox() throws AutomationException {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Get the Exception message, to pass the message whenever an exception is
	 * encountered
	 * 
	 */
	public static String getExceptionMessage() {
		StringBuffer message = new StringBuffer();

		try {
			message.append("Exception in ");
			message.append(Thread.currentThread().getStackTrace()[2].getClassName());
			message.append(".");
			message.append(Thread.currentThread().getStackTrace()[2].getMethodName());
			message.append("()");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		return message.toString();
	}

	/**
	 * Set driver for Web applications
	 * 
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get current running driver session
	 * 
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
}
