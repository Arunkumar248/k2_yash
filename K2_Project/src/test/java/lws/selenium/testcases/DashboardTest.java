package lws.selenium.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.DashboardHelper;
import com.lws.testhelper.LoginHelper;


public class DashboardTest  extends TestRunner{

	@Test(priority = 2)
	public void TC002_Dashboard() throws AutomationException, InterruptedException, IOException {
		
		LoginHelper loginhelper=new LoginHelper();
		loginhelper.loginToApplication(driver, "Valid");
		DashboardHelper dashboard=new DashboardHelper();
		dashboard.SelectOrganization(driver);
	}
}
