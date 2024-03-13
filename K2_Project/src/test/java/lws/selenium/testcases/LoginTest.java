package lws.selenium.testcases;


import java.io.IOException;

import org.testng.annotations.Test;

import com.lws.exceptions.AutomationException;
import com.lws.runner.TestRunner;
import com.lws.testhelper.LoginHelper;

public class LoginTest extends TestRunner {

	@Test(priority = 1)
	public void TC001_LoginValidCase() throws AutomationException, IOException, InterruptedException {

		LoginHelper loginHelp=new LoginHelper();
		loginHelp.loginToApplication(driver,"Valid");
	}
}
