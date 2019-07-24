package com.northgateps.cm.intel.WebMobileWrappers;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.northgateps.cm.common.TaskDashboard;
import com.northgateps.cm.intel.common.IntelUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.MobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

import cucumber.api.DataTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class IntelMobilePageObject {
	public static AppiumDriver<MobileElement> appiumDriver = null;
	private MobilePageHelper mobilePageHelper;
	TaskDashboard taskDashboard;
	private static Logger Log = Logger.getLogger(IntelMobilePageObject.class);
	String EnvName = "";
	private Properties properties = null;
	

	public IntelMobilePageObject() throws Exception {
		mobilePageHelper = new MobilePageHelper();
		appiumDriver = mobilePageHelper.getMobileDriver();
		taskDashboard = new TaskDashboard();
		properties = Utility.loadProperties();
		EnvName = properties.getProperty("EnvName");
	}

	public void userIsOnCardIndexScreenForACreateIntelligenceReport() throws Exception {
		
		ConnectMobilePageHelper.setUpClient();
		appiumDriver = mobilePageHelper.getMobileDriver();
	
		mobilePageHelper.logInToAppAsUser("UserName", "Password","IntelRoles");

		mobilePageHelper.clickIcon(appiumDriver, "Intelligence Report");
		Log.info("User is on Card Index screen for a 'Create intelligence report'");	
	}

	public void userHasCompletedAllTheFieldsOnBasicDetailsCard() throws Exception {
//		mobilePageHelper.swipeUp();
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel,1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if(fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel,2);
					}
					else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel,1);
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
		Log.info("User has filled details on 'Basic Details'");
	}

	public void userHasCompletedAllTheFieldsOnCard(String cardName, String LinkReason) throws Exception {

		if (!LinkReason.equals(""))
			cardName = cardName + " (" + LinkReason + ")";
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel,1);
//				mobilePageHelper.swipeUp(10);
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(500);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel,2);
					switch (newfieldType) {
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
		Log.info("User has filled details on '"+cardName+"'");
	}

	public void clickOnButtonEventObjectSaveReturn(String cardName) throws InterruptedException {
		mobilePageHelper.clickOnButtonEventObjectSaveReturn();
//		mobilePageHelper.swipeCardsUp(cardName);
	}

	public void userClicksOnCardWithLinkReason(String cardName, String LinkReason) throws Exception {
		if (!LinkReason.equals(""))
			cardName = cardName + " (" + LinkReason + ")";
		
		mobilePageHelper.clickOnCard(cardName.trim());
		
//		mobilePageHelper.clickElementByAccessibilityId(appiumDriver, cardName.trim());
		Log.info("User has clicked on card '"+cardName+"'");
	}

	public void userSetsTheCardAsNotApplicable() throws Exception {

		mobilePageHelper.clickYesNoCardRequiredButton(appiumDriver, "No");
//		mobilePageHelper.clickBackButton();
		Log.info("User has set all the remaining cards as Not Applicable");
	}

	public void userSubmitsCreateIntelligenceReportTaskCard() throws InterruptedException {
		// Click on Submit button
		mobilePageHelper.clickElementByAccessibilityId(appiumDriver, "Submit");

		// Click on Submit Intel button
		mobilePageHelper.clickOnSubmitButton();

		// Get URN
		getURN(appiumDriver);

		mobilePageHelper.clickButton(appiumDriver, "Done");
		appiumDriver.closeApp();
		Log.info("User submits the 'Create Intelligence Report' Task");
	}
	
	public void getURN(AppiumDriver<MobileElement> driver) {
		LocalDate currentDate = LocalDate.now();
		String year = String.valueOf(currentDate.getYear());
		year = year.substring(year.length() - 2);
		String urn = mobilePageHelper.getURN(driver, year);
		IntelUtility.IntelRefNumber = urn;
		System.out.println("Unique Reference Number: " + urn);
		Log.info("'Intelligence Report' with Reference "+urn+" generated");
	}

	

	public void userHasCompletedAllTheFieldsOnEnquiryLogForm() {
		// TODO Auto-generated method stub

	}

	public void allTheCardsOnTheCardIndexAreInFollowingStatus() throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < Utility.testDataCards.length; i++) {
			String xlEventName = Utility.testDataCards[i][0];
			if (xlEventName.equals(mobilePageHelper.getEventName())) {
				String cardName = Utility.testDataCards[i][1];
				String linkReason = mobilePageHelper.returnFieldValue(Utility.testDataCards[i][2]);
				String expCardStatus = Utility.testDataCards[i][3];
				String actualCardStatus = mobilePageHelper.getCardStatus(appiumDriver, cardName, linkReason);

				assertTrue(expCardStatus.equals(actualCardStatus),
						"Card '" + cardName + "' does not have expected status as '" + expCardStatus + "'.");
			}
		}
	}

	public void eventRecordSelectedInWorkloadTab() throws Exception {
		appiumDriver.launchApp();
//		mobilePageHelper.logInToAppAsUser("MOBILEWMPUserA");
		

		mobilePageHelper.clickIcon(appiumDriver, "Task Dashboard");

		taskDashboard.clickOnViewInWorkload(appiumDriver, "My Unit", "Intelligence report");
		taskDashboard.selectARecordInWorkload(appiumDriver, IntelUtility.IntelRefNumber);

	}

	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		taskDashboard.validateEventStatus(appiumDriver, eventStatus, IntelUtility.IntelRefNumber);
	}

	public void taskHistoryEntryWillBeCreated(String taskEntry) {

	}

	public void taskWillBeRaisedToIntelSubmitter(String task) {

	}

	public void userIsOnCardIndexScreenForARequestToCreateBriefingItem() {

	}

	public void userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard() {

	}

	public void userSubmitsRequestToCreateBriefingItemCard() {

	}

	public void taskWillBeRaisedToAssessor(String task) {

	}

	public void userIsOnCardIndexScreenForAProcessRequestToCreateBriefing() {

	}

	public void userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard() {
		// TODO Auto-generated method stub

	}

	public void userSubmitsProcessRequestToCreateBriefingCard() {
		// TODO Auto-generated method stub

	}

	public void LogoutFromAnApplicationAndCloseTheBrowser() throws Exception {
		mobilePageHelper.logout();

	}

	public void verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) {
		// TODO Auto-generated method stub

	}

	public void verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) {

	}

	public void userReadTheTestDataSheetFromFile(String sheetName, String fileName) throws IOException {
		mobilePageHelper.readExcel(fileName, sheetName);
	}

	public void userReadTheTestDataForCardsOnSheetFromFile(String sheetName, String fileName) throws IOException {
		mobilePageHelper.readExcelCards(fileName, sheetName);
	}

	public void userHasCompletedAllTheFieldsOnForm(String tabName, String cardName, String linkReason)
			throws Exception {
		if (!linkReason.equals(""))
			cardName = cardName + " (" + linkReason + ")";
//		mobilePageHelper.swipeTabs();
		mobilePageHelper.clickOnTabByName(tabName);
//		mobilePageHelper.clickElementByAccessibilityId(appiumDriver, tabName);
		
		Thread.sleep(2000);
		
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(tabName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel,1);
				
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(1000);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = null;
					if(fieldLabel.equals(newfieldLabel)) {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel,2);
					}
					else {
						newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel,1);
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
				case "NUMBERFIELD":
						
					mobilePageHelper.inputElement(appiumDriver, fieldLabel, fieldValue);
					break;

				}
			
				lastFieldLabel = fieldLabel;
			}
		}
		Log.info("User has filled the '"+tabName+"' form in '"+cardName+"' card");
	}

	public void userSetsTheFollowingCardAsNotApplicable() throws Exception {
		for (int i = 0; i < Utility.testDataCards.length; i++) {
			String xlEventName = Utility.testDataCards[i][0];
			if (xlEventName.equals(mobilePageHelper.getEventName())) {
				String cardName = Utility.testDataCards[i][1];
				String linkReason = mobilePageHelper.returnFieldValue(Utility.testDataCards[i][2]);
				String cardStatus = Utility.testDataCards[i][3];
				if (cardStatus.equalsIgnoreCase("Not Applicable")) {
					userClicksOnCardWithLinkReason(cardName, linkReason);
					userSetsTheCardAsNotApplicable();
				}
			}
		}
		Log.info("User has set the remaining cards as 'Not Applicable'");
	}

	public void userHasCompletedAllTheFieldsOnTheCardWithLinkReason(String cardName, String linkReason)
			throws Exception {
		mobilePageHelper.userSetsTheCardAsApplicable(cardName);
		Thread.sleep(500);
		String card = cardName;
		if (!linkReason.equals(""))
			cardName = cardName + " (" + linkReason + ")";
		String lastFieldLabel = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[0];
				String[] fieldValueArray = Utility.testData[i][3].split(" => ");
				String fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[0]);

				String fieldType = mobilePageHelper.getTypeOfField(appiumDriver, fieldLabel,1);
				
				switch (fieldType) {
				case "REPEATING_GROUP":
					if (!(fieldLabel.equalsIgnoreCase(lastFieldLabel))) {
						mobilePageHelper.clickButton(appiumDriver, "Add New " + fieldLabel);
						Thread.sleep(500);
					}
					String newfieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
					String newfieldType = mobilePageHelper.getTypeOfField(appiumDriver, newfieldLabel,2);
					switch (newfieldType) {
					case "DATETIME":
						mobilePageHelper.inputElement(appiumDriver, newfieldLabel, fieldValue);
						if (fieldValueArray.length > 1) {
							fieldValue = mobilePageHelper.returnFieldValue(fieldValueArray[1]);
							mobilePageHelper.inputElement2(appiumDriver, newfieldLabel, fieldValue);
						}
						break;
					case "BOOLEAN":
						mobilePageHelper.clickYesNoButton(appiumDriver, newfieldLabel, fieldValue);
						break;
					case "LOOKUPUNIT":
						mobilePageHelper.selectLookupUnit(appiumDriver, newfieldLabel,fieldValue);
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
//				mobilePageHelper.swipeUp(7);
			}
		}
		mobilePageHelper.clickOnbuttonStaticObjectSaveReturn(card, linkReason);
		Log.info("User has filled the '"+cardName+"' card");
	}

	

	public void userSavesCardWithLinkReason(String card, String linReason) throws Exception {
		mobilePageHelper.clickButton(appiumDriver, "Save & Return");
		Thread.sleep(500);
		mobilePageHelper.clickBackButton();
		Thread.sleep(500);
//		mobilePageHelper.swipeCardsUp(card);
		Log.info("User saved the '"+card+"' card");
	}

	public void userSubmitsDisseminateIntelligenceReportInternalCard() throws InterruptedException {
		// Click on Submit button
		mobilePageHelper.clickElementByAccessibilityId(appiumDriver, "Submit");

		// Click on Submit Intel button
		mobilePageHelper.clickOnSubmitButton();

		// Get URN
		getURN(appiumDriver);

		mobilePageHelper.clickButton(appiumDriver, "Done");
		appiumDriver.closeApp();
	}

	public void CloseFailedTest(String logFilePath, String screenshotFilePath, String testStep, String testName,
			Throwable throwable) throws Exception {
		mobilePageHelper.CloseFailedTest(logFilePath, screenshotFilePath, testStep, testName,
				EnvName, throwable) ;
			
			
		
		
	}	
	
	public void userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard() {
		// TODO Auto-generated method stub

	}


}