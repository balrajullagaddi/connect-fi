package com.northgateps.cm.cases.WebMobileWrappers;

import java.time.LocalDate;

import org.apache.log4j.Logger;

import com.northgateps.cm.cases.common.CaseUtility;
import com.northgateps.cm.common.TaskDashboard;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.MobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CaseMobilePageObject {
	public static AppiumDriver<MobileElement> appiumDriver = null;
	private MobilePageHelper mobilePageHelper;
	TaskDashboard taskDashboard;
	private static Logger Log = Logger.getLogger(CaseMobilePageObject.class);
	
	public CaseMobilePageObject() throws Exception {
		mobilePageHelper = new MobilePageHelper();
		appiumDriver = mobilePageHelper.getMobileDriver();
		taskDashboard = new TaskDashboard();
		
	}

	public void userIsOncardIndexScreenForACreatePrechargeCase() throws Exception {
		ConnectMobilePageHelper.setUpClient();
		appiumDriver = mobilePageHelper.getMobileDriver();
		mobilePageHelper.logInToAppAsUser("CaseUserName", "Password", "CaseRoles");
		mobilePageHelper.clickIcon(appiumDriver, "Precharge Case");
		Log.info("User is on Card Index screen for a 'Create Precharge Case'");
//		mobilePageHelper.swipeToBottom();
	}

	public void userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard() throws Exception {
		String cardName = "Create Precharge Case";
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel, 1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if (fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 2);
					} else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 1);
					}
					switch (newfieldType) {
					case "DATETIME":
						mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
						if (fieldValueArray.length > 1) {
							fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[1]);
							mobilePageHelper.inputElement2(appiumDriver, newfieldLabel, fieldValue);
						}
						break;
					case "BOOLEAN":
						mobilePageHelper.clickYesNoButton(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "LOOKUPUNIT":
						mobilePageHelper.selectLookupUnit(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "DROPDOWN":
						mobilePageHelper.selectValueFromDropDown(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "TEXTFIELD":
					case "TEXTAREA":
					case "DATE":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						break;
					}
					break;
				case "DATETIME":
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					if (fieldValueArray.length > 1) {
						fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[1]);
						mobilePageHelper.inputElement2(appiumDriver, fieldLabel, fieldValue);
					}
					break;
				case "BOOLEAN":
					mobilePageHelper.clickYesNoButton(appiumDriver, fieldLabel, fieldValue);
					break;
				case "LOOKUPUNIT":
					mobilePageHelper.selectLookupUnit(appiumDriver, fieldLabel, fieldValue);
					break;
				case "DROPDOWN":
					mobilePageHelper.selectValueFromDropDown(appiumDriver, fieldLabel, fieldValue);
					break;
				case "TEXTFIELD":
				case "TEXTAREA":
				case "DATE":
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					break;

				}

				lastFieldLabel = fieldLabel;
			}
		}
		Log.info("User has filled details on '" + cardName + "'");
	}

	public void userHasCompletedAllTheFieldsOnCaseDetailsCard() throws Exception {
		String cardName = "Case details";
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel, 1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if (fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 2);
					} else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 1);
					}
					switch (newfieldType) {
					case "DROPDOWN":
						mobilePageHelper.selectValueFromDropDown(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "TEXTFIELD":
					case "TEXTAREA":
					case "DATE":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						break;
					}
					break;
				case "DROPDOWN":
					mobilePageHelper.selectValueFromDropDown(appiumDriver, fieldLabel, fieldValue);
					break;
				case "TEXTFIELD":
				case "TEXTAREA":
				case "DATE":
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					break;

				}

				lastFieldLabel = fieldLabel;
			}
		}
		Log.info("User has filled details on '" + cardName + "'");
	}

	public void userSubmitsCreatePrechargeCaseCard() throws Exception {
		// Click on Submit button
		mobilePageHelper.clickElementByAccessibilityId(appiumDriver, "Submit");

		// Click on Submit Intel button
		mobilePageHelper.clickOnSubmitButton();

		// Get URN
		getURN(appiumDriver);

		mobilePageHelper.clickButton(appiumDriver, "Done");
		appiumDriver.closeApp();
		Log.info("User submits the 'Create Precharge Case' Card");

	}

	public void getURN(AppiumDriver<MobileElement> driver) {
		LocalDate currentDate = LocalDate.now();
		String year = String.valueOf(currentDate.getYear());
		year = year.substring(year.length() - 2);
		String urn = mobilePageHelper.getURN(driver, year);
		CaseUtility.CaseRefNumber = urn;
		System.out.println("Unique Reference Number: " + urn);
		Log.info("'Precharge case' with Reference " + urn + " generated");
	}

	public void taskWillBeRaisedToOwningUnit(String task) {

	}

	public void caseRecordSelectedInWorkloadTab() throws Exception {
		appiumDriver.launchApp();
//		mobilePageHelper.logInToAppAsUser("MOBILEWMPUserA");

		mobilePageHelper.clickIcon(appiumDriver, "Task Dashboard");

		taskDashboard.clickOnViewInWorkload(appiumDriver, "My Unit", "Case");
		taskDashboard.selectARecordInWorkload(appiumDriver, CaseUtility.CaseRefNumber);

	}

	public void caseRecordSelectedInMyViewTab() {
	}

	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		taskDashboard.validateEventStatus(appiumDriver, eventStatus, CaseUtility.CaseRefNumber);

	}

	public void userHasCompletedAllTheFieldsOnPreChargeDecisionCard() throws Exception {
		String cardName = "Pre Charge Decision";
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel, 1);
				
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if (fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 2);
					} else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 1);
					}
					switch (newfieldType) {
					case "DROPDOWN":
						mobilePageHelper.selectValueFromDropDown(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "TEXTFIELD":
					case "TEXTAREA":
					case "DATE":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						break;
					}
					break;
				case "DROPDOWN":
					mobilePageHelper.selectValueFromDropDown(appiumDriver, fieldLabel, fieldValue);
					break;
				case "TEXTFIELD":
				case "TEXTAREA":
				case "DATE":
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					break;
				case "BOOLEAN":
					mobilePageHelper.clickYesNoButton(appiumDriver, fieldLabel, fieldValue);
					break;
				}

				lastFieldLabel = fieldLabel;
//				mobilePageHelper.swipeUp(10);
			}
			
		}
		Log.info("User has filled details on '" + cardName + "'");
	}

	public void userHasCompletedAllTheFieldsOnThePoliceWitnessesCard() throws Exception {
		String cardName = "Police Witnesses";
		mobilePageHelper.userSetsTheCardAsApplicable(cardName);
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel, 1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if (fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 2);
					} else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 1);
					}
					switch (newfieldType) {
					case "DROPDOWN":
						mobilePageHelper.selectValueFromDropDown(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "TEXTFIELD":
					case "TEXTAREA":
					case "DATE":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "BOOLEAN":
						mobilePageHelper.clickYesNoButton(appiumDriver, newfieldLabel, fieldValue);
						break;
					}
					break;
				case "DROPDOWN":
					mobilePageHelper.selectValueFromDropDown(appiumDriver, fieldLabel, fieldValue);
					break;
				case "TEXTFIELD":
				case "TEXTAREA":
				case "DATE":
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					break;
				case "BOOLEAN":
					mobilePageHelper.clickYesNoButton(appiumDriver, fieldLabel, fieldValue);
					break;
				}

				lastFieldLabel = fieldLabel;
			}
		}
		Log.info("User has filled details on '" + cardName + "'");
	}

	public void userHasCompletedAllTheFieldsOnCaseNotesCard() throws Exception {
		String cardName = "Case Notes";
		
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel, 1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if (fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 2);
					} else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 1);
					}
					switch (newfieldType) {
					case "DROPDOWN":
						mobilePageHelper.selectValueFromDropDown(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "TEXTFIELD":
					case "TEXTAREA":
					case "DATE":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "BOOLEAN":
						mobilePageHelper.clickYesNoButton(appiumDriver, fieldLabel, fieldValue);
						break;
					}
					break;
			
				}

				lastFieldLabel = fieldLabel;
			}
		}
		Log.info("User has filled details on '" + cardName + "'");
	}

	public void userHasCompletedAllTheFieldsOnRegisterForUpdateCard() throws Exception {
		String cardName = "Register for update";
	
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel, 1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if (fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 2);
					} else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel, 1);
					}
					switch (newfieldType) {
					case "DROPDOWN":
						mobilePageHelper.selectValueFromDropDown(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "TEXTFIELD":
					case "TEXTAREA":
					case "DATE":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "BOOLEAN":
						mobilePageHelper.clickYesNoButton(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "LOOKUPUNIT":
						mobilePageHelper.selectLookupUnit(appiumDriver, newfieldLabel, fieldValue);
						break;
					}
					break;
				case "DROPDOWN":
					mobilePageHelper.selectValueFromDropDown(appiumDriver, fieldLabel, fieldValue);
					break;
				case "TEXTFIELD":
				case "TEXTAREA":
				case "DATE":
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					break;
				case "BOOLEAN":
					mobilePageHelper.clickYesNoButton(appiumDriver, fieldLabel, fieldValue);
					break;
				}

				lastFieldLabel = fieldLabel;
			}
		}
		Log.info("User has filled details on '" + cardName + "'");
		
	}

}
