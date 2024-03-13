package com.lws.testhelper;

import java.util.ArrayList;
import java.util.List;

import com.lws.action.UIActions;
import com.lws.action.UtilityActions;
import com.lws.action.ValidationActions;
import com.lws.action.WebActions;
import com.lws.exceptions.AutomationException;
import com.lws.reporting.AutomationReports;
import com.lws.utilities.AutomationConstants;
import com.lws.utilities.ExcelDataHandler;
import com.lws.utilities.PropertyDataHandler;

public class GeneralHelper {
	UtilityActions utilHelp = new UtilityActions();
	UIActions uiAction = new UIActions();

	ValidationActions validHelp = new ValidationActions();
	PropertyDataHandler propHandler = new PropertyDataHandler();
	WebActions webhelper = new WebActions();
	AutomationReports reporting = new AutomationReports();
	ExcelDataHandler excelHelp;
	String excelPath = "";
	String environment, clientName;

	public GeneralHelper() throws AutomationException {
		excelPath = propHandler.getProperty(AutomationConstants.AUTOMATION_TEST_CONFIG, "testDataPath");
		environment = new PropertyDataHandler().getProperty(AutomationConstants.AUTOMATION_TEST_CONFIG,
				AutomationConstants.TEST_ENVIRONMENT);
		clientName = new PropertyDataHandler().getProperty(AutomationConstants.AUTOMATION_TEST_CONFIG, "testClient");
	}

	/**
	 * Method to get the application URL from excel data file

	 */
	public String getApplicationURL() {
		String clientNameValue, environmentValue, appURLValue;
		String actualApplicationURL = null;
		try {
			for (int i = 2; i <= new ExcelDataHandler(excelPath, "AppURL").getRowCount(); i++) {
				excelHelp = new ExcelDataHandler(excelPath, "AppURL");
				clientNameValue = excelHelp.getCellData(i, 1);
				environmentValue = excelHelp.getCellData(i, 2);
				appURLValue = excelHelp.getCellData(i, 3);

				if (clientNameValue.equalsIgnoreCase(clientName) && environmentValue.equalsIgnoreCase(environment)) {
					actualApplicationURL = appURLValue;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualApplicationURL;
	}

	/**
	 * Method to get the application and credential details from test data excel
	 *
	 */
	public List<String> getApplicationCredentials(String scenarioname) {
		List<String> credsList = new ArrayList<>();
		String  scenarioName, username, password;
		try {
			for (int i = 2; i <= new ExcelDataHandler(excelPath, "K2Login").getRowCount(); i++) {
				excelHelp = new ExcelDataHandler(excelPath, "K2Login");
				scenarioName = excelHelp.getCellData(i, 1);

				username = excelHelp.getCellData(i, 2);
				password = excelHelp.getCellData(i, 3);
				if (scenarioName.equalsIgnoreCase(scenarioname)) {
					credsList.add(username);
					credsList.add(password);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credsList;
	}
	/**
	 * Method to get the AddLocation and credential details from test data excel
	 *
	 */

	public List<String> AddLocationCredentials(String AddLocation) {
		List<String> credsList = new ArrayList<>();
		String Addlocation,locationName, proxCardmask, address1,address2,city,ZIP;
		try {
			for (int i = 2; i <= new ExcelDataHandler(excelPath, "Location").getRowCount(); i++) {
				excelHelp = new ExcelDataHandler(excelPath, "Location");
				AddLocation = excelHelp.getCellData(i, 1);
				
				locationName=	excelHelp.getCellData(i, 2);
				proxCardmask =  excelHelp.getCellData(i, 3);
				address1 =	    excelHelp.getCellData(i, 4);
				address2 = excelHelp.getCellData(i, 5);
				city     = excelHelp.getCellData(i, 6);
				ZIP      = excelHelp.getCellData(i, 7);
				if (AddLocation.equalsIgnoreCase(AddLocation)) {
					credsList.add(locationName);
					credsList.add(proxCardmask);
					credsList.add(address1);
					credsList.add(address2);
					credsList.add(city);
					credsList.add(ZIP);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credsList;
	}
}

