package lws.selenium.testcases;


import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.DashboardHelper;
import com.lws.testhelper.LocationHelper;
import com.lws.testhelper.LoginHelper;
import com.lws.testhelper.UserHelper;


public class UserTest extends TestRunner {

	@Test(priority = 4)
	public void TC004_UserRole() throws AutomationException, InterruptedException {
		LoginHelper loginhelper=new LoginHelper();
		loginhelper.loginToApplication(driver, "Valid");
		DashboardHelper dashboardHelper=new DashboardHelper();
		dashboardHelper.SelectOrganization(driver);
		
		UserHelper userHelper=new UserHelper();
		userHelper.ClickUser(driver);
		userHelper.AddRoles(driver);
		userHelper.DeleteUser(driver);
	}


}
