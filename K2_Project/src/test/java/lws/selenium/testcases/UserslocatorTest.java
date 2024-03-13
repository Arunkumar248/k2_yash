package lws.selenium.testcases;

import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.DashboardHelper;
import com.lws.testhelper.LoginHelper;
import com.lws.testhelper.UserHelper;
import com.lws.testhelper.UserslocatorHelper;


public class UserslocatorTest extends TestRunner{

	@Test(priority = 6)
	public void TC005_UserLocator() throws AutomationException, InterruptedException {
		LoginHelper loginhelper=new LoginHelper();
		loginhelper.loginToApplication(driver, "Valid");
		DashboardHelper dashboardHelper=new DashboardHelper();
		dashboardHelper.SelectOrganization(driver);
		
		UserHelper userHelper=new UserHelper();
		userHelper.ClickUser(driver);
		
		UserslocatorHelper userlocater=new UserslocatorHelper();
		//userlocater.AddUser(driver);
		userlocater.DownloadTemplate(driver);
	}
}
