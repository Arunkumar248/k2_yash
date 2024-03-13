package lws.selenium.testcases;

import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.DashboardHelper;
import com.lws.testhelper.LocationHelper;
import com.lws.testhelper.LoginHelper;


public class LocationTest extends TestRunner {



	@Test(priority = 3)
	public void TC003_location() throws AutomationException, InterruptedException {
		LoginHelper loginhelper=new LoginHelper();
		loginhelper.loginToApplication(driver, "Valid");
		DashboardHelper dashboardHelper=new DashboardHelper();
		dashboardHelper.SelectOrganization(driver);
		LocationHelper location= new LocationHelper();
		location.location(driver);
		location.AddLocationCredentials(driver, "Valid");


	}

}
