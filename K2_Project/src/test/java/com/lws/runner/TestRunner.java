package com.lws.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.lws.action.WebActions;
import com.lws.base.AutomationBase;
import com.lws.exceptions.AutomationException;
import com.lws.reporting.*;
import com.lws.testhelper.GeneralHelper;


@Listeners(AutomationReports.class)
public class TestRunner extends AutomationBase {
	
	
	@BeforeClass
	@Parameters({"browserName"})
	public void setup(String browserName) throws Exception {
		WebActions webHelper = new WebActions();
		GeneralHelper genHelp = new GeneralHelper();
		startBrowser(browserName);
		String URL=genHelp.getApplicationURL();
		webHelper.loadWebApplication(driver, URL);
	}
	
	//@AfterClass
	public void tearDownMethod() throws AutomationException, InterruptedException {
		WebActions webObj = new WebActions();
		webObj.closeBrowser(driver);
	}
}