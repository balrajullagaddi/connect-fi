package com.northgateps.cm.cases.WebMobileWrappers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.cases.common.CaseUtility;
import com.northgateps.cm.common.TaskDashboard;
import com.northgateps.cm.intel.WebMobileWrappers.IntelMobilePageObject;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;
import com.northgateps.cm.platform.api.WindowsPageHelper;

import io.appium.java_client.AppiumDriver;

public class CaseWindowsPageObject {
	public static AppiumDriver<WebElement> appiumDriver = null;
	private WindowsPageHelper windowsPageHelper;
	TaskDashboard taskDashboard;
	private static Logger Log = Logger.getLogger(IntelMobilePageObject.class);
	public String caseURN = "";

	public CaseWindowsPageObject() throws Exception {
		windowsPageHelper = new WindowsPageHelper();
		appiumDriver = windowsPageHelper.getWindowsDriver();
		taskDashboard = new TaskDashboard();
	}

	public void userIsOnCardIndexScreenForACreatePrechargeCase() throws Exception {
		ConnectMobilePageHelper.setUpClient();
		appiumDriver = windowsPageHelper.getWindowsDriver();
		
		windowsPageHelper.logInWithRoles("CaseUserName","Password","CaseRoles");
		windowsPageHelper.clickIcon("Precharge Case");
		Log.info("User is on Card Index screen for a 'Create Precharge Case'");
	}

	public void userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard() throws Exception {
		String card = "Create Precharge Case";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(card)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldType = Utility.testData[i][3];
				String fieldValue = Utility.testData[i][4];
			
				if (fieldType.equalsIgnoreCase("REPEATINGGROUP"))
				{
				
					int noOfTimesToClick = Integer.parseInt(fieldValue.split(",")[0]);
					int noOfFieldsInARepeatingGroup = Integer.parseInt(fieldValue.split(",")[1]);
					
					for (int j=1; j<= noOfTimesToClick ; j++) {
						windowsPageHelper.addARepeatingGroup(fieldLabel);
						
						for (int k=1;k<= noOfFieldsInARepeatingGroup;k++) {
							i++;
							String newFieldLabel = Utility.testData[i][2];
							String newFieldType = Utility.testData[i][3];
							String newFieldValue = Utility.testData[i][4];
							if (newFieldType.equalsIgnoreCase("BOOLEAN")) {
								windowsPageHelper.clickOnYesOrNoButton(newFieldLabel,newFieldValue);
							}
							else if (newFieldType.equalsIgnoreCase("DROPDOWN") || newFieldType.equalsIgnoreCase("TEXTFIELD")) {
								windowsPageHelper.inputElementWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
						}
						
					}
				}
				else if (fieldType.equalsIgnoreCase("BOOLEAN"))
				{
					windowsPageHelper.clickOnYesOrNoButton(fieldLabel,fieldValue);
				}
				else if (fieldType.equalsIgnoreCase("DROPDOWN") || fieldType.equalsIgnoreCase("TEXTFIELD")) {
					windowsPageHelper.inputElement(fieldLabel,fieldValue);
				}
				
				else if (fieldType.equalsIgnoreCase("DATETIME") || fieldType.equalsIgnoreCase("DATE")) {
					windowsPageHelper.inputDateTime(fieldLabel,fieldValue);
				}
				
				else if (fieldType.equalsIgnoreCase("LOOKUP")) {
					windowsPageHelper.inputLookUp(fieldLabel,fieldValue);
				}
			}
			
			}
			Log.info("User has filled details on '"+card+"'");

		
	}

	public void userHasCompletedAllTheFieldsOnCaseDetailsCard() throws Exception {
		String card = "Case details";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(card)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldType = Utility.testData[i][3];
				String fieldValue = Utility.testData[i][4];
			
				if (fieldType.equalsIgnoreCase("REPEATINGGROUP"))
				{
				
					int noOfTimesToClick = Integer.parseInt(fieldValue.split(",")[0]);
					int noOfFieldsInARepeatingGroup = Integer.parseInt(fieldValue.split(",")[1]);
					
					for (int j=1; j<= noOfTimesToClick ; j++) {
						windowsPageHelper.addARepeatingGroup(fieldLabel);
						
						for (int k=1;k<= noOfFieldsInARepeatingGroup;k++) {
							i++;
							String newFieldLabel = Utility.testData[i][2];
							String newFieldType = Utility.testData[i][3];
							String newFieldValue = Utility.testData[i][4];
							if (newFieldType.equalsIgnoreCase("BOOLEAN")) {
								windowsPageHelper.clickOnYesOrNoButton(newFieldLabel,newFieldValue);
							}
							else if (newFieldType.equalsIgnoreCase("DROPDOWN") || newFieldType.equalsIgnoreCase("TEXTFIELD")) {
								windowsPageHelper.inputElementWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
						}
						
					}
				}
				else if (fieldType.equalsIgnoreCase("BOOLEAN"))
				{
					windowsPageHelper.clickOnYesOrNoButton(fieldLabel,fieldValue);
				}
				else if (fieldType.equalsIgnoreCase("DROPDOWN") || fieldType.equalsIgnoreCase("TEXTFIELD")) {
					windowsPageHelper.inputElement(fieldLabel,fieldValue);
				}
				
				else if (fieldType.equalsIgnoreCase("DATETIME") || fieldType.equalsIgnoreCase("DATE")) {
					windowsPageHelper.inputDateTime(fieldLabel,fieldValue);
				}
				
				else if (fieldType.equalsIgnoreCase("LOOKUP")) {
					windowsPageHelper.inputLookUp(fieldLabel,fieldValue);
				}
			}
			
			}
			Log.info("User has filled details on '"+card+"'");

		
	}

	public void userSubmitsCreatePrechargeCaseCard() throws Exception {
		windowsPageHelper.submitRecord();
		// Get URN
		String urn = windowsPageHelper.getURN("Precharge Case");
		windowsPageHelper.clickOnDone(urn);
		Log.info("User submits the 'Create Precharge Case' Task");
	}

	public void userHasCompletedAllTheFieldsOnThePoliceWitnessesCard() throws Exception {
	
		String card = "Police Witnesses";
		windowsPageHelper.userSetsTheCardAsApplicable(card);
		
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(card)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldType = Utility.testData[i][3];
				String fieldValue = Utility.testData[i][4];
			
				if (fieldType.equalsIgnoreCase("REPEATINGGROUP"))
				{
				
					int noOfTimesToClick = Integer.parseInt(fieldValue.split(",")[0]);
					int noOfFieldsInARepeatingGroup = Integer.parseInt(fieldValue.split(",")[1]);
					
					for (int j=1; j<= noOfTimesToClick ; j++) {
						windowsPageHelper.addARepeatingGroup(fieldLabel);
						
						for (int k=1;k<= noOfFieldsInARepeatingGroup;k++) {
							i++;
							String newFieldLabel = Utility.testData[i][2];
							String newFieldType = Utility.testData[i][3];
							String newFieldValue = Utility.testData[i][4];
							if (newFieldType.equalsIgnoreCase("BOOLEAN")) {
								windowsPageHelper.clickOnYesOrNoButton(newFieldLabel,newFieldValue);
							}
							else if (newFieldType.equalsIgnoreCase("DROPDOWN") || newFieldType.equalsIgnoreCase("TEXTFIELD")) {
								windowsPageHelper.inputElementWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
						}
						
					}
				}
				
			}
			
			}
			Log.info("User has filled details on '"+card+"'");

	}

	public void userHasCompletedAllTheFieldsOnPreChargeDecisionCard() throws Exception {
		String card = "Pre Charge Decision";
		
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(card)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldType = Utility.testData[i][3];
				String fieldValue = Utility.testData[i][4];
			
				if (fieldType.equalsIgnoreCase("REPEATINGGROUP"))
				{
				
					int noOfTimesToClick = Integer.parseInt(fieldValue.split(",")[0]);
					int noOfFieldsInARepeatingGroup = Integer.parseInt(fieldValue.split(",")[1]);
					
					for (int j=1; j<= noOfTimesToClick ; j++) {
						windowsPageHelper.addARepeatingGroup(fieldLabel);
						
						for (int k=1;k<= noOfFieldsInARepeatingGroup;k++) {
							i++;
							String newFieldLabel = Utility.testData[i][2];
							String newFieldType = Utility.testData[i][3];
							String newFieldValue = Utility.testData[i][4];
							if (newFieldType.equalsIgnoreCase("BOOLEAN")) {
								windowsPageHelper.clickOnYesOrNoButton(newFieldLabel,newFieldValue);
							}
							else if (newFieldType.equalsIgnoreCase("DROPDOWN") || newFieldType.equalsIgnoreCase("TEXTFIELD")) {
								windowsPageHelper.inputElementWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
						}
						
					}
				}
				
			
			else if (fieldType.equalsIgnoreCase("BOOLEAN"))
			{
				windowsPageHelper.clickOnYesOrNoButton(fieldLabel,fieldValue);
			}
			else if (fieldType.equalsIgnoreCase("DROPDOWN") || fieldType.equalsIgnoreCase("TEXTFIELD")) {
				windowsPageHelper.inputElement(fieldLabel,fieldValue);
			}
			
			else if (fieldType.equalsIgnoreCase("DATETIME") || fieldType.equalsIgnoreCase("DATE")) {
				windowsPageHelper.inputDateTime(fieldLabel,fieldValue);
			}
			
			else if (fieldType.equalsIgnoreCase("LOOKUP")) {
				windowsPageHelper.inputLookUp(fieldLabel,fieldValue);
			}
			}
			}
			Log.info("User has filled details on '"+card+"'");
	}

	public void userHasCompletedAllTheFieldsOnCaseNotesCard() throws Exception {
		String card = "Case Notes";
		
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(card)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldType = Utility.testData[i][3];
				String fieldValue = Utility.testData[i][4];
			
				if (fieldType.equalsIgnoreCase("REPEATINGGROUP"))
				{
				
					int noOfTimesToClick = Integer.parseInt(fieldValue.split(",")[0]);
					int noOfFieldsInARepeatingGroup = Integer.parseInt(fieldValue.split(",")[1]);
					
					for (int j=1; j<= noOfTimesToClick ; j++) {
						windowsPageHelper.addARepeatingGroup(fieldLabel);
						
						for (int k=1;k<= noOfFieldsInARepeatingGroup;k++) {
							i++;
							String newFieldLabel = Utility.testData[i][2];
							String newFieldType = Utility.testData[i][3];
							String newFieldValue = Utility.testData[i][4];
							if (newFieldType.equalsIgnoreCase("BOOLEAN")) {
								windowsPageHelper.clickOnYesOrNoButton(newFieldLabel,newFieldValue);
							}
							else if (newFieldType.equalsIgnoreCase("DROPDOWN") || newFieldType.equalsIgnoreCase("TEXTFIELD")) {
								windowsPageHelper.inputElementWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
						}
						
					}
				}
				
			}
			
			}
			Log.info("User has filled details on '"+card+"'");

		
	}

	public void userHasCompletedAllTheFieldsOnRegisterForUpdateCard() throws Exception {
		String card = "Register for update";
		
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(card)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldType = Utility.testData[i][3];
				String fieldValue = Utility.testData[i][4];
			
				if (fieldType.equalsIgnoreCase("REPEATINGGROUP"))
				{
				
					int noOfTimesToClick = Integer.parseInt(fieldValue.split(",")[0]);
					int noOfFieldsInARepeatingGroup = Integer.parseInt(fieldValue.split(",")[1]);
					
					for (int j=1; j<= noOfTimesToClick ; j++) {
						windowsPageHelper.addARepeatingGroup(fieldLabel);
						
						for (int k=1;k<= noOfFieldsInARepeatingGroup;k++) {
							i++;
							String newFieldLabel = Utility.testData[i][2];
							String newFieldType = Utility.testData[i][3];
							String newFieldValue = Utility.testData[i][4];
							if (newFieldType.equalsIgnoreCase("BOOLEAN")) {
								windowsPageHelper.clickOnYesOrNoButton(newFieldLabel,newFieldValue);
							}
							else if (newFieldType.equalsIgnoreCase("DROPDOWN")) 
							{
								windowsPageHelper.selectFromDropdownWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
								else if(newFieldType.equalsIgnoreCase("TEXTFIELD")) {
								windowsPageHelper.inputElementWithKthRepetition(newFieldLabel,newFieldValue,j);
							}
						}
						
					}
				}
				
			}
			
			}
			Log.info("User has filled details on '"+card+"'");
		
	}

	public void caseRecordSelectedInMyViewTab() throws Exception {
		Thread.sleep(5000);
		windowsPageHelper.clickIcon("Task Dashboard");
		caseURN = CaseUtility.CaseRefNumber;
		windowsPageHelper.selectViewInTaskDashboardforEventRef("My View","Gem case",caseURN);
		
	//	windowsPageHelper.selectRecordInTaskDashboard(caseURN);
		
	}

	public void eventStatusWillBeSetTo(String eventStatus) {
		windowsPageHelper.validateEventStatus(caseURN,eventStatus);
	}

	public void taskWillBeRaisedToOwningUnit(String task) {
		windowsPageHelper.validateTaskRaised(task);
		
	}

	public void userIsOnCardIndexScreenForASubmitForPrechargeDecision() {
		windowsPageHelper.performTaskFromTaskDashboard("Submit For Pre-Charge Decision");
		
	}
	
	
}
