package com.northgateps.cm.cases.WebMobileWrappers;

// PAGE OCJECT FOR CASE WEB 
// specific to case event
// from here you call the utility functions 

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.northgateps.cm.cases.common.CaseUtility;
import com.northgateps.cm.common.Workload;
//import com.northgateps.cm.investigation.common.InvUtility;
import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

public class CaseWebPageObject {
	CardUtility cardUtility;
	private WebDriver driver;
	private Properties properties = null;
	private CaseUtility caseUtility;
	private CardUtility crdUtility;
	private String username, password;
	private Workload workload;
	private static String CaseRefNumber = "";
	private ConnectMobilePageHelper cmPageHelper;
	private static Logger Log = Logger.getLogger(CaseWebPageObject.class);

	public CaseWebPageObject() throws Exception {
		cmPageHelper = new ConnectMobilePageHelper();
		caseUtility = new CaseUtility();
		crdUtility = new CardUtility();
		workload = new Workload();
		driver = cmPageHelper.getDriver();
		properties = Utility.loadProperties();
	}

	public void userIsOnCardIndexScreenForACreatePrechargeCase() throws Throwable {
		Log.info("###################### Test started. ######################");
		driver = ConnectMobilePageHelper.setUpClient();
		ConnectMobilePageHelper.openUrl(driver);
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		ConnectMobilePageHelper.login(username, password);
		cmPageHelper.eventRoles("CaseRoles");
		cmPageHelper.switch_To_LaunchPadModule(driver);
		Thread.sleep(2000);
		caseUtility.clickOnCreatePrechargeCaseIcon();
		Log.info("User is on Card Index screen for a 'Create Precharge Case'");
	}

	public void userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard() throws Throwable {
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Create Precharge Case") && xlFormName.equals("Create Precharge Case")) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
//				String fieldName = crdUtility.getElementName("Create Precharge Case", null, CardUtility.globalEventType, fieldLabel);
//				String groupName = crdUtility.getGroupName("Create Precharge Case", CardUtility.globalEventType, fieldLabel);

				String fieldName = "";
				String groupName = null;

				if (fieldLabelArray.length > 1) {
					fieldName = crdUtility.getElementNameForGroup("Create Precharge Case", null,
							CardUtility.globalEventType, fieldLabel);
					groupName = crdUtility.getGroupName("Create Precharge Case", null, CardUtility.globalEventType,
							fieldLabel);
				} else
					fieldName = crdUtility.getElementName("Create Precharge Case", null, CardUtility.globalEventType,
							fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				List<WebElement> elFields = driver.findElements(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
			}
		}
		Log.info("User has filled details on 'Create Precharge Case'");
	}

	public void userHasCompletedAllTheFieldsOnCaseDetailsCard() throws Throwable {
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Case details") && xlFormName.equals("Case details")) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Case details", null, CardUtility.globalEventType,
						fieldLabel);

				String groupName = crdUtility.getGroupName("Case details", null, CardUtility.globalEventType, fieldLabel);
				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				List<WebElement> elFields = driver.findElements(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
			}
		}
		Log.info("User has filled details on 'Case details'");
	}

	public void userSubmitsCreatePrechargeCaseCard() throws Throwable {
		cmPageHelper.clickOnButtonSubmit(driver);
		cmPageHelper.clickOnButtonSubmitConfirmationMessage(driver);
		CaseRefNumber = cmPageHelper.getURNNumber(driver);
		caseUtility.setCaseRef(CaseRefNumber);
		cmPageHelper.clickOnButtonSubmitDone(driver);
		Log.info("User has submitted 'Create Precharge Case' card and the reference is - " + CaseRefNumber);
	}

	public void taskWillBeRaisedToOwningUnit(String task) {
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info("Task raised as - " + task);
	}

	public void caseRecordSelectedInWorkloadTab() throws Throwable {
		String unitName = null;
		cmPageHelper.switch_To_LaunchPadModule(driver);
		assertTrue(CaseUtility.CaseRefNumber.length() > 0, "Case reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		unitName = cmPageHelper.returnFieldValue("DefaultOwningUnit");
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, CaseUtility.CaseRefNumber, "Case");
		Log.info("Event record selected in workload tab");
	}

	public void caseRecordSelectedInMyViewTab() throws Throwable {
		String userName = null;
		cmPageHelper.switch_To_LaunchPadModule(driver);
		assertTrue(CaseUtility.CaseRefNumber.length() > 0, "Case reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		userName = cmPageHelper.returnFieldValue("DefaultUserName");
		workload.clickWorkloadMyView(driver, userName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, CaseUtility.CaseRefNumber, "Case");
		Log.info("Case record selected in My View tab");
	}

	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		workload.validateEventStatus(eventStatus, CaseUtility.CaseRefNumber, driver);
		Log.info("Event status has set to - " + eventStatus);
	}

	public void userIsOnCardIndexScreenForASubmitForPrechargeDecision() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Submit For Pre-Charge Decision");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Send for Pre Charge Decision");
		Log.info("User is on Card Index screen for a 'Submit For Pre-charge Decision'");
	}

	public void userHasCompletedAllTheFieldsOnSendForPreChargeDecisionCard() throws Exception {
		String cardName = "Send for Pre Charge Decision";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null, CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else if (fieldValue.contains(" | Checkbox"))
					cmPageHelper.clickOnCurrentUserCheckBox();
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
				}
			}
		}
		Log.info("User has filled details on 'Send for precharge decision' card.");
	}

	public void userSubmitsSendForPreChargeDecisionCard() throws Exception {
		cmPageHelper.clickOnButtonSubmit(driver);
		Log.info("User has submitted task 'Send for precharge decision'.");
	}

	public void UserStartsTheLaunchpadModule() {
		cmPageHelper.clickOnHomeButton();
	}

	public void taskWillBeRaisedToReviewingUnit(String task) {
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info(task + " task is raised to the reviewing unit.");

	}

	public void caseEventStatusWillBeSetTo(String eventStatus) throws Exception {
		workload.validateEventStatus(eventStatus, CaseUtility.CaseRefNumber, driver);
		Log.info("Event status has set to - " + eventStatus);

	}

	public void userIsOnCardIndexScreenForALDMPCDReview() throws Exception {
		workload.clickIntelSubmitterTask(driver, "LDM PCD Review");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Pre Charge Decision Review");
		Log.info("User is on Card Index screen for a 'LDM PCD Review'");

	}

	public void userHasCompletedAllTheFieldsOnPreChargeDecisionReviewCard() throws Exception {
		String cardName = "Pre Charge Decision Review";
		cmPageHelper.clickOnTab(driver, "Pre Charge Decision Review");
		cmPageHelper.waitForTabToBeActive(driver, "Pre Charge Decision Review");
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals("Pre Charge Decision Review")) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null, CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
				}

			}

		}
		Log.info("User has filled details on 'Pre Charge Decision Review' card.");
	}

	public void userSubmitsPreChargeDecisionReviewCard() {
		cmPageHelper.clickOnButtonSubmit(driver);
		Log.info("User has submitted task 'Pre Charge Decision Review'.");

	}

	public void userHasCompletedAllTheFieldsOnPreChargeDecisionCard() throws Exception {
		String cardName = "Pre Charge Decision";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null, CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
				}
			}
		}
		Log.info("User has filled details on '" + cardName + "' card.");
	}

	public void eventRecordSelectedInWorkloadTab(String unit) throws Exception {
		workload.selectEventFromUnits(driver, unit, CaseUtility.CaseRefNumber, "Case");
	}

	public void userIsOnCardIndexScreenForANewCMTReview() throws Exception {
		workload.clickIntelSubmitterTask(driver, "New CMT Review");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "New CMT Review");
		Log.info("User is on Card Index screen for a 'New CMT Review'");
	}

	public void userHasCompletedAllTheFieldsOnNewCMTReviewCard() throws Exception {
		String cardName = "New CMT Review";
		cmPageHelper.clickOnTab(driver, "CMT Review");
		cmPageHelper.waitForTabToBeActive(driver, "CMT Review");
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals("CMT Review")) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null,CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase("Who do you want to allocate?")
						&& Utility.testData[i][3].equalsIgnoreCase("StaffMemberUserName")) {
					driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
					Thread.sleep(4000);
				} else {
					if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
						if (fieldLabel.indexOf("'") > 0) {
							fieldLabel = fieldLabel.substring(fieldLabel.indexOf("'") + 1, fieldLabel.lastIndexOf("'"));
							cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
						} else {
							cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
						}
					else {
						List<WebElement> elFields = driver.findElements(By.name(fieldName));
						cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
						Thread.sleep(1000);
					}
				}
			}
		}
		Log.info("User has filled details on 'New CMT Review' card.");
	}

	public void clickOnButtonSubmit() throws Exception {
		cmPageHelper.clickOnButtonSubmit(driver);
		Thread.sleep(1000);
	}

	public void taskWillBeRaisedToCMTSgtUnit(String task) {
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info(task + " task is raised to the CMT Sgt Unit.");

	}

	public void userIsOnCardIndexScreenForACMTTriageReview() throws Exception {
		workload.clickIntelSubmitterTask(driver, "CMT Triage Review");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "CMT Triage Review");
		Log.info("User is on Card Index screen for a 'CMT Triage Review'");
	}

	public void userHasCompletedAllTheFieldsOnCMTTriageReviewCard() throws Exception {
		String cardName = "CMT Triage Review";
		cmPageHelper.clickOnTab(driver, "CMT Triage Review");
		cmPageHelper.waitForTabToBeActive(driver, "CMT Triage Review");
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals("CMT Triage Review")) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName,null, CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase("Who do you want to allocate?")
						&& Utility.testData[i][3].equalsIgnoreCase("StaffMemberUserName")) {
					driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
					Thread.sleep(2000);
				} else if (fieldLabel.equalsIgnoreCase("Who do you want to allocate?")
						&& Utility.testData[i][3].equalsIgnoreCase("DefaultUserName")) {
					driver.findElement(By.name("useCurrentUserCheckbox")).click();
					Thread.sleep(1000);
				} else {
					if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
						cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
					else {
						List<WebElement> elFields = driver.findElements(By.name(fieldName));
						cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
						Thread.sleep(1000);
					}
				}
			}
		}
		Log.info("User has filled details on 'New CMT Review' card.");
	}

	public void userHasCompletedAllTheFieldsOnThePoliceWitnessesCard() throws Exception {
		String cardName = "Police Witnesses";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null,CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else if (fieldValue.contains(" | Checkbox"))
					cmPageHelper.clickOnCurrentUserCheckBox();
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
					Thread.sleep(1000);
				}
			}
		}
		Log.info("User has filled details on '" + cardName + "' card.");
	}

	public void userIsOnCardIndexScreenForAResolvePreChargeActions() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Resolve Pre Charge Actions");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Resolve Pre Charge Action");
		Log.info("User is on Card Index screen for a 'Resolve Pre Charge Action'");

	}

	public void userHasCompletedAllTheFieldsOnResolvePreChargeActionCard() throws Exception {
		String cardName = "Resolve Pre Charge Action";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null, CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else if (fieldValue.contains(" | Checkbox"))
					cmPageHelper.clickOnCurrentUserCheckBox();
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
				}
			}
		}
		Log.info("User has filled details on '" + cardName + "' card.");

	}

	public void userSubmitsResolvePreChargeActionCard() {
		cmPageHelper.clickOnButtonSubmit(driver);
		Log.info("User has submitted task 'Resolve Pre Charge Action'.");

	}

	public void caseRecordSelectedInWorkloadTabFor(String unit) throws Exception {
		String unitName = null;
		cmPageHelper.switch_To_LaunchPadModule(driver);
		assertTrue(CaseUtility.CaseRefNumber.length() > 0, "Case reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		unitName = cmPageHelper.returnFieldValue(unit);
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, CaseUtility.CaseRefNumber, "Case");
		Log.info("Event record selected in workload tab");
	}

	public void taskWillBeRaisedToOIC(String task) {
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info(task + " task is raised to the OIC.");
	}

	public void taskWillBeRaisedToCMTReviewUnit(String task) {
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info(task + " task is raised to the CMT Review Unit.");
	}

	public void taskWillBeRaisedToOfficer(String task) throws Exception {
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info(task + " task is raised to the linking unit.");
	}

	public void caseRecordSelectedForUser(String user) throws Exception {
		workload.selectEventForUser(driver, user, CaseUtility.CaseRefNumber, "Case");
	}

	public void userIsOnCardIndexScreenForAAllocateDM() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Allocate DM");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Allocate DM");
		Log.info("User is on Card Index screen for a 'Allocate DM'");
	}

	public void userHasCompletedAllTheFieldsOnAllocateDMCard() throws Exception {
		String cardName = "Allocate DM";
		cmPageHelper.clickOnTab(driver, "Allocate DM");
		cmPageHelper.waitForTabToBeActive(driver, "Allocate DM");
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals("Allocate DM")) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null,CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}
				if (fieldLabel.equalsIgnoreCase("Who do you want to allocate?")
						&& Utility.testData[i][3].equalsIgnoreCase("StaffMemberUserName")) {
					driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
					Thread.sleep(2000);
				} else if (fieldValue.contains(" | Checkbox")) {
					cmPageHelper.clickOnCurrentUserCheckBox();
				} else {
					if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
						if (fieldLabel.indexOf("'") > 0) {
							fieldLabel = fieldLabel.substring(fieldLabel.indexOf("'") + 1, fieldLabel.lastIndexOf("'"));
							cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
						} else {
							cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
						}
					else {
						List<WebElement> elFields = driver.findElements(By.name(fieldName));
						cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
						Thread.sleep(1000);
					}
				}
			}
		}
		Log.info("User has filled details on '" + cardName + "' card.");
	}

	public void userIsOnCardIndexScreenForACMTDMReview() throws Exception {
		workload.clickIntelSubmitterTask(driver, "CMT DM Review");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "CMT DM Review");
		Log.info("User is on Card Index screen for a 'CMT DM Review'");
	}

	public void userHasCompletedAllTheFieldsOnCMTDMReviewCard() throws Exception {
		String cardName = "CMT DM Review";
		cmPageHelper.clickOnTab(driver, "CMT DM Review");
		cmPageHelper.waitForTabToBeActive(driver, "CMT DM Review");
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null,CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}
				if (fieldValue.contains(" | Checkbox")) {
					cmPageHelper.clickOnCurrentUserCheckBox();
				} else {
					if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
						if (fieldLabel.indexOf("'") > 0) {
							fieldLabel = fieldLabel.substring(fieldLabel.indexOf("'") + 1, fieldLabel.lastIndexOf("'"));
							cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
						} else {
							cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
						}
					else {
						List<WebElement> elFields = driver.findElements(By.name(fieldName));
						cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
						Thread.sleep(1000);
					}
				}
			}
		}
		Log.info("User has filled details on '" + cardName + "' card.");
	}

	public void userHasCompletedAllTheFieldsOnRegisterForUpdateCard() throws Exception {
		String cardName = "Register for update";
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];

			if (xlCardName.equals(cardName) && xlFormName.equals(cardName)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName(cardName, null, CardUtility.globalEventType, fieldLabel);

				if (groupName != null) {
					List<WebElement> elList = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
					if (elList == null) {
						cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					} else if (elList != null) {
						WebElement el = elList.get(elList.size() - 1);
						if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
							cmPageHelper.clickOnRepeatingGroupButton(driver, "Add New " + groupName);
					}
				}

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else if (fieldValue.contains(" | Checkbox"))
					cmPageHelper.clickOnCurrentUserCheckBox();
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
					Thread.sleep(1000);
				}
			}
		}
		Log.info("User has filled details on '" + cardName + "' card.");
	}

	public void taskIsAddedRemovedFromUserForCaseEvent(boolean found, String user, String task) throws Exception {
		cmPageHelper.switch_To_LaunchPadModule(driver);
		Assert.assertTrue(CaseUtility.CaseRefNumber.length() > 0, "Case reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickWorkloadMyView(driver, properties.getProperty(user));
		workload.clickOnMyUnitsGraph(driver);
		// Deselect checkbox
		workload.clickOnWorkloadEventTab(driver, "Case");
		cmPageHelper.deselectCheckbox(driver);
		// Scroll to end of gridview
		WebElement scrollElement = cmPageHelper.getDisplayedElement(
				driver.findElements(By.cssSelector("div[id^='tasksByObjectResults-'] div[class='x-scroller-spacer'")));
		Actions act = new Actions(driver);
		act.moveToElement(scrollElement).sendKeys(Keys.chord(Keys.CONTROL, Keys.END)).build().perform();
		List<WebElement> checkBoxURN = driver
				.findElements(By.xpath("//div[@class='x-grid-item-container']//table//td/div[contains(text(),'"
						+ CaseUtility.CaseRefNumber + "')]//..//..//td[2]"));
		if (checkBoxURN.size() > 0) {
			checkBoxURN.get(0).click();
			Thread.sleep(1500);

			boolean taskFound = false;
			int column = 1;
			// Get Task name column number
			List<WebElement> taskColumnList = driver
					.findElements(By.cssSelector("div[id^='tasks-'] div.x-grid-header-ct div.x-column-header"));
			for (WebElement taskColumn : taskColumnList) {
				WebElement header = taskColumn.findElement(By.xpath("//span[text()='Task']"));
				if (header != null) {
					break;
				}
				column += 1;
			}

			// Get task name
			List<WebElement> columnList = driver.findElements(
					By.cssSelector("div[id^='tasks-'] div.x-panel-body table tr td:nth-child(" + column + ")"));
			for (WebElement columnElement : columnList) {
				if (columnElement.getText().equalsIgnoreCase(task)) {
					assertEquals(task.toLowerCase(), columnElement.getText().toLowerCase());
					taskFound = true;
					break;
				}
			}
			Assert.assertEquals(taskFound, found, "Task is not matching");
		} else if (checkBoxURN.size() == 0 && found) {
			Assert.assertTrue(false, "Event is not found in workload screen");
		} else {
			Log.info("As expected: Event Id is removed from user");
		}
	}

	public void userIsOnCardIndexScreenForAAwaitingPreChargeDecisionResults() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Awaiting Pre Charge Decision Results");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Awaiting Pre Charge decision results");
		Log.info("User is on Card Index screen for a 'Awaiting Pre Charge Decision Results'");

	}

	public void userIsOnCardIndexScreenForAPendingPreChargeReview() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Pending Pre Charge Review");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Pending Pre Charge Review");
		Log.info("User is on Card Index screen for a 'Pending Pre Charge Review'");

	}
}