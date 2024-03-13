package lws.selenium.testcases;

import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.DashboardHelper;
import com.lws.testhelper.LocationHelper;
import com.lws.testhelper.LoginHelper;
import com.lws.testhelper.PermissionHelper;
import com.lws.testhelper.UserHelper;
import com.lws.testhelper.UserslocatorHelper;


public class PermissionTest extends TestRunner {

	@Test(priority = 5)
	public void TC006_Permission() throws AutomationException, InterruptedException {
		LoginHelper loginhelper=new LoginHelper();
		loginhelper.loginToApplication(driver, "Valid");
		DashboardHelper dashboardHelper=new DashboardHelper();
		dashboardHelper.SelectOrganization(driver);

		UserHelper userHelper=new UserHelper();
		userHelper.ClickUser(driver);

		PermissionHelper permissionHelper=new PermissionHelper();
		permissionHelper.Permission(driver);
	}


}
