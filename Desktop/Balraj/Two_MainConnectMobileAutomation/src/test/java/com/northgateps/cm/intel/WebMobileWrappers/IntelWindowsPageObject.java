package com.northgateps.cm.intel.WebMobileWrappers;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.common.TaskDashboard;
import com.northgateps.cm.intel.common.IntelUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;
import com.northgateps.cm.platform.api.WindowsPageHelper;

import io.appium.java_client.AppiumDriver;

public class IntelWindowsPageObject {
	public static AppiumDriver<WebElement> appiumDriver = null;
	private WindowsPageHelper windowsPageHelper;
	TaskDashboard taskDashboard;
	private static Logger Log = Logger.getLogger(IntelMobilePageObject.class);
	String EnvName = "";
	private Properties properties = null;

	public IntelWindowsPageObject() throws Exception {
		properties = Utility.loadProperties();
		windowsPageHelper = new WindowsPageHelper();
		appiumDriver = windowsPageHelper.getWindowsDriver();
		taskDashboard = new TaskDashboard();
		EnvName = properties.getProperty("EnvName");
	}

	
	public void userIsOnCardIndexScreenForACreateIntelligenceReport() throws Exception {
		ConnectMobilePageHelper.setUpClient();
		appiumDriver = windowsPageHelper.getWindowsDriver();
		windowsPageHelper.logInWithRoles("UserName","Password","IntelRoles");
		windowsPageHelper.clickIcon("Intelligence Report");
		Log.info("User is on Card Index screen for a 'Create intelligence report'");
	}

	

	public void userClicksOnCardWithLinkReason(String cardName, String linkReason) throws Exception {
		cardName = windowsPageHelper.getCompleteCardName(cardName, linkReason);

		windowsPageHelper.clickOnCard(cardName.trim());
		Thread.sleep(200);
		Log.info("User has clicked on '"+cardName+"' card");
	}

	


	public void userSavesCard(String cardName) throws Exception {
		windowsPageHelper.userSavesCard(cardName);
		
	}

	public void userHasCompletedAllTheFieldsOnForm(String tabName, String card, String linkReason) throws Exception {
		card = windowsPageHelper.getCompleteCardName(card, linkReason);
		windowsPageHelper.clickOnTab(tabName);
		
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			
			if (xlCardName.equals(card) && xlFormName.equals(tabName)) {
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
			Log.info("User has filled details on '"+tabName+"'form in '"+card+"' card");
		
	}

	public void userSetsTheFollowingCardAsNotApplicable() throws Exception {
		for (int i = 0; i < Utility.testDataCards.length; i++) {
			String xlEventName = Utility.testDataCards[i][0];
			if (xlEventName.equals(windowsPageHelper.getEventName())) {
				String cardName = Utility.testDataCards[i][1].trim();
				String linkReason = windowsPageHelper.returnFieldValue(Utility.testDataCards[i][2].trim());
				String cardStatus = Utility.testDataCards[i][3];
				if (cardStatus.equalsIgnoreCase("Not Applicable")) {
					userClicksOnCardWithLinkReason(cardName, linkReason);
					windowsPageHelper.userSetsTheCardAsNotApplicable(cardName);
				}
			}
		}
		Log.info("User has set the remaining cards as 'Not Applicable'");
		
	}

	


	public void userHasCompletedAllTheFieldsOnEnquiryLogForm() {
		
	}

	public void allTheCardsOnTheCardIndexAreInFollowingStatus() throws Exception {
		for (int i = 0; i < Utility.testDataCards.length; i++) {
			String xlEventName = Utility.testDataCards[i][0];
			String eventName = windowsPageHelper.getEventName();
			if (xlEventName.equals(eventName)) {
				String cardName = Utility.testDataCards[i][1];
				String linkReason = windowsPageHelper.returnFieldValue(Utility.testDataCards[i][2]);
				String expCardStatus = Utility.testDataCards[i][3];
				String actualCardStatus = windowsPageHelper.getCardStatus(cardName, linkReason);

				assertTrue(expCardStatus.equals(actualCardStatus),
						"Card '" + cardName + "' does not have expected status as '" + expCardStatus + "'.");
			}
		}
		
	}

	public void userSubmitsCreateIntelligenceReportTaskCard() throws Exception {
		windowsPageHelper.submitRecord();
		// Get URN
		String urn = windowsPageHelper.getURN("Intelligence Report");
		windowsPageHelper.clickOnDone(urn);
		Log.info("User submits the 'Create Intelligence Report' Task");
	}


	public void eventRecordSelectedInWorkloadTab() {
		// TODO Auto-generated method stub
		
	}

	public void eventStatusWillBeSetTo(String eventStatus) {
		// TODO Auto-generated method stub
		
	}

	public void taskHistoryEntryWillBeCreated(String taskEntry) throws Exception {
		windowsPageHelper.validateTaskHistoryEntry(taskEntry);
		
	}

	public void taskWillBeRaisedToIntelSubmitter(String task) {
		// TODO Auto-generated method stub
		
	}

	public void userIsOnCardIndexScreenForARequestToCreateBriefingItem() {
		// TODO Auto-generated method stub
		
	}


	public void userReadTheTestDataSheetFromFile(String sheetName, String fileName) throws Exception {
		windowsPageHelper.readExcel(fileName, sheetName);
	}


	public void userReadTheTestDataForCardsOnSheetFromFile(String sheetName, String fileName) throws Exception {
		windowsPageHelper.readExcelCards(fileName, sheetName);
	}


	public void userHasCompletedAllTheFieldsOnCard(String card) throws Exception {
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


	public void userSavesCardWithLinkReason(String arg1, String arg2) throws Exception {
		windowsPageHelper.userSavesCard(arg1);
		Thread.sleep(400);
		windowsPageHelper.clickOnBackButton();
	}


	public void userHasCompletedAllTheFieldsOnBasicDetailsCard() throws Exception {
		String card = "Basic details";
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
					Thread.sleep(100);
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


	public void userHasCompletedAllTheFieldsOnTheCardWithLinkReason(String card, String linkReason) throws Exception {
		card = windowsPageHelper.getCompleteCardName(card, linkReason);
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
			windowsPageHelper.clickOnNextForStaticObject();
			
			Log.info("User has filled details on '"+card+"' with Link Reason '"+linkReason+"'");
	}


	public void LogoutFromAnApplicationAndCloseTheBrowser() throws Exception {
		windowsPageHelper.quitApp();
	}


	public void CloseFailedTest(String LogFilePath, String ScreenShotFilePath, String TestStep, String TestName,
			Throwable throwable) throws Exception {
			windowsPageHelper.CloseFailedTest(LogFilePath, ScreenShotFilePath, TestStep, TestName, EnvName, throwable);
	}

	

}
