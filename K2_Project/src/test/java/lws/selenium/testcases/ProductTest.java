package lws.selenium.testcases;

import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.DashboardHelper;
import com.lws.testhelper.LoginHelper;
import com.lws.testhelper.PermissionHelper;
import com.lws.testhelper.ProductHelper;
import com.lws.testhelper.UserHelper;
import com.lws.testhelper.UserslocatorHelper;


public class ProductTest extends TestRunner{


	@Test(priority = 7)
	public void Product() throws AutomationException, InterruptedException {
		LoginHelper loginhelper=new LoginHelper();
		loginhelper.loginToApplication(driver, "Valid");
		DashboardHelper dashboardHelper=new DashboardHelper();
		dashboardHelper.SelectOrganization(driver);

		ProductHelper userslocate=new ProductHelper();
		userslocate.TC010_Product(driver);
	}

}
