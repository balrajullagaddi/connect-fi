package com.northgateps.cm.intel.WebMobileWrappers;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.northgateps.cm.cases.common.CaseUtility;
import com.northgateps.cm.common.Message;
import com.northgateps.cm.common.Workload;
import com.northgateps.cm.intel.common.EnquiryLog;
import com.northgateps.cm.intel.common.IntelUtility;
import com.northgateps.cm.intel.workflow.IntelWorkflowTasks;
import com.northgateps.cm.investigation.common.InvUtility;
//import com.northgateps.cm.investigation.common.InvUtility;
import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;
//import com.northgateps.cm.property.common.PropertyUtility;

import cucumber.api.DataTable;

public class IntelWebPageObject {
	CardUtility cardUtility;
	private WebDriver driver;
	private Properties properties = null;
	private CardUtility crdUtility;
	private IntelUtility intelUtility;
	private InvUtility invUtility;
	//private InvUtility invUtility;
	private EnquiryLog enqLog;
	private Workload workload;
	private Message message;
	private String username, password;
	private static String IntelRefNumber = "";
	private ConnectMobilePageHelper cmPageHelper;
	private IntelWorkflowTasks intelWFTasks;
	private static Logger Log = Logger.getLogger(IntelWebPageObject.class);
	private String EnvName = "";
	//private PropertyUtility propertyUtility;
	private CaseUtility caseUtility;

	public IntelWebPageObject() throws Exception {
		cmPageHelper = new ConnectMobilePageHelper();
		cardUtility = new CardUtility();
		intelUtility = new IntelUtility();
		//invUtility = new InvUtility();
		crdUtility = new CardUtility();
		enqLog = new EnquiryLog();
		workload = new Workload();
		message = new Message();
		driver = cmPageHelper.getDriver();
		properties = Utility.loadProperties();
		intelWFTasks = new IntelWorkflowTasks();
		EnvName = properties.getProperty("EnvName");
		//propertyUtility = new PropertyUtility();
		caseUtility = new CaseUtility();
		invUtility = new InvUtility();
	}

	public void userIsOnCardIndexScreenForACreateIntelligenceReport() throws Exception {
		Log.info("###################### Test started. ######################");
		driver = ConnectMobilePageHelper.setUpClient();
		ConnectMobilePageHelper.openUrl(driver);
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		ConnectMobilePageHelper.login(username, password);
		cmPageHelper.eventRoles("IntelRoles");
		cmPageHelper.switch_To_LaunchPadModule(driver);
		intelUtility.clickOnCreateIntelIcon();
		Log.info("User is on Card Index screen for a 'Create intelligence report'");
	}

	public void userClicksOnCardWithLinkReason(String cardName, String LinkReason) throws Exception {
		switch (cardName) {
		case "Basic details":
			intelUtility.clickOnBasicDetailCard();
			break;

		case "Source":
			intelUtility.clickOnSourceCard();
			break;

		case "Submission":
			intelUtility.clickOnSubmissionCard();
			break;

		case "Tags and tension levels":
			intelUtility.clickOnTagsAndTensionLevelsCard();
			break;

		case "Person":
			intelUtility.clickOnPersonCard(LinkReason);
			break;

		case "Location":
			intelUtility.clickOnLocationCard(LinkReason);
			break;

		case "Vehicle":
			intelUtility.clickOnVehicleCard(LinkReason);
			break;

		case "Organisation":
			intelUtility.clickOnOrganisationCard(LinkReason);
			break;

		case "Comms":
			intelUtility.clickOnCommsCard(LinkReason);
			break;

		case "Operation":
			intelUtility.clickOnOperationCard(LinkReason);
			break;

		case "Category":
			intelUtility.clickOnCategoryCard(LinkReason);
			break;

		case "Enquiry log":
			intelUtility.clickOnEnquirylogCard();
			break;

		case "Request to create briefing":
			intelWFTasks.clickOnRequestToCreateBriefingCard();
			break;

		case "Process request to create briefing":
			intelWFTasks.clickOnProcessRequestToCreateBriefingCard();
			break;

		case "Acknowledge user failure to correct intelligence report":
			intelWFTasks.clickOnAcknowledgeFailureToCorrect();
			break;

		case "Disseminate intelligence report internally":
			intelWFTasks.clickOnDisseminateIntelReport();
			break;

		case "Correct intelligence report":
			intelWFTasks.clickOnCorrectIntelReport();
			break;

		case "Assess intelligence report":
			intelWFTasks.clickOnAssessIntelReport();
			break;

		case "Link intelligence report":
			intelWFTasks.clickOnLinkIntelReport();
			break;

		case "Perform ad hoc review of Code C":
			intelWFTasks.clickOnPerformAdHocReviewOfCodeC();
			break;

		case "Intelligence":
			intelWFTasks.clickOnIntelligenceCard();
			break;

		case "Intelligence summary":
			intelWFTasks.clickOnIntelligenceSummary();
			break;

		case "Append information to intelligence report":
			intelWFTasks.clickOnAppendInfoToIntelReport();
			break;

		case "Complete intelligence report":
			intelWFTasks.clickOnCompleteIntelReport();
			break;

		case "Acknowledge rejection of request to create briefing":
			intelWFTasks.clickOnAcknowledgeRejectionRequest();
			break;

		case "Acknowledge intelligence report returned or deleted":
			intelWFTasks.clickOnAcknowledgeIntelligenceReportReturnedDeleted();
			break;

		case "Duplicate intelligence report":
			intelWFTasks.clickOnDuplicateIntelligenceReport();
			break;

		case "Register interest in intelligence report":
			intelWFTasks.clickORegisterInterestInIntelligenceReport();
			break;

		case "Transfer intelligence report":
			intelWFTasks.clickOnTransferIntelligenceReport();
			break;

		case "Remove registered interest in intelligence report":
			intelWFTasks.clickOnRemoveInterestInIntelligenceReport();
			break;

		case "Victim":
			//invUtility.clickOnVictimCard(LinkReason);
			break;

		case "Witness":
			//invUtility.clickOnWitnessCard(LinkReason);
			break;

		case "Suspect":
			//invUtility.clickOnSuspectCard(LinkReason);
			break;

		case "Incident location":
			invUtility.clickOnIncidentLocationCard();
			break;

		case "M.O.":
			//invUtility.clickOnMOCard();
			break;

		case "QA new Investigation":
			//invUtility.clickOnQANewInvestigationCard();
			break;

		case "Delete Intelligence Report Request":
			intelWFTasks.clickOnDeleteIntelligenceReportRequest();
			break;

		case "Involved party":
			//invUtility.clickOnInvolvedPartyCard(LinkReason);
			break;

		case "IMU Process Investigation":
			//invUtility.clickOnIMUProcessInvestigationCard();
			break;

		case "Stolen vehicle":
			//invUtility.clickOnStolenVehicleCard(LinkReason);
			break;

		case "Involved organisation":
			//invUtility.clickOnInvolvedOrganisationCard(LinkReason);
			break;

		case "Allocate investigation":
			//invUtility.clickOnAllocateInvestigationCard(LinkReason);
			break;

		case "Request Non Crime Investigation Be Filed":
			//invUtility.clickOnRequestNonCrimeInvestigationBeFiledCard(LinkReason);
			break;

		case "Supervisor process non crime investigation filing request":
			//invUtility.clickOnSupervisorProcessNonCrimeInvestigationFilingRequestCard(LinkReason);
			break;

		case "Complete submission":
			//invUtility.clickOnCompleteSubmissionCard();
			break;

		case "Seizure Location":
			//propertyUtility.clickOnSeizureLocationCard();
			break;

		case "Person Detainee":
			//propertyUtility.clickOnPersonDetaineeCard();
			break;

		case "Person Owner":
			//propertyUtility.clickOnPersonOwnerCard();
			break;

		case "Case details":
			caseUtility.clickOnCasedetailsCard();
			break;

		case "Create Precharge Case":
			caseUtility.clickOnCreatePrechargeCaseCard();
			break;

		case "Defendant":
			caseUtility.clickOnDefendantCard();
			break;

		case "Professional Expert Witness":
			caseUtility.clickOnProfessionalExpertWitnessCard();
			break;

		case "Public witness":
			caseUtility.clickOnPublicwitnessCard();
			break;

		case "Pre Charge Decision":
			caseUtility.clickOnPreChargeDecisionCard();
			break;

		case "Send for Pre Charge Decision":
			caseUtility.clickOnSendForPreChargeDecisionCard();
			break;

		case "Pre Charge Decision Review":
			caseUtility.clickOnPreChargeDecisionReviewCard();
			break;

		case "Police Witnesses":
			caseUtility.clickOnPoliceWitnessesCard();
			break;

		case "Resolve Pre Charge Action":
			caseUtility.clickOnResolvePreChargeActionCard();
			break;

		case "Review investigation":
			//invUtility.clickOnReviewInvestigationCard();
			break;

		case "Assess investigation":
			//invUtility.clickOnAssessInvestigationCard();
			break;

		case "Property Item (Seized / Detained)":
			//propertyUtility.clickOnPropertyItemSeizedDetainedCard();
			break;

		case "Create Property Event":
			//propertyUtility.clickOnCreatePropertyEventCard();
			break;

		case "New CMT Review":
			caseUtility.clickOnNewCMTReviewCard();
			break;

		case "CMT Triage Review":
			caseUtility.clickOnCMTTriageReviewCard();
			break;

		case "Allocate DM":
			caseUtility.clickOnAllocateDMCard();
			break;

		case "Victim Organisation":
			caseUtility.clickOnVictimOrganisationCard();
			break;

		case "Defendant Organisation":
			caseUtility.clickOnDefendantOrganisationCard();
			break;

		case "Register for update":
			caseUtility.clickOnRegisterForUpdateCard();
			break;

		case "CMT DM Review":
			caseUtility.clickOnCMTDMReviewCard();
			break;

		case "Pending Pre Charge Review":
			caseUtility.clickOnPendingPreChargeReviewCard();
			break;

		case "Awaiting Pre Charge Decision Results":
			caseUtility.clickOnAwaitingPreChargeDecisionResultsCard();
			break;

		default:
			Log.warn("Card name '" + cardName + "' is not found.");
			return;
		}

		// Click on Yes button if Optional card
		String card = cmPageHelper.getNameForCard(cardName, LinkReason, CardUtility.globalEventType);
		if (crdUtility.cardMode(card).equalsIgnoreCase(CardUtility.OPTIONAL)) {
			Thread.sleep(500);
			cmPageHelper.clickOnButtonYesCardRequired(driver);
			Thread.sleep(500);

		}
		cmPageHelper.setCurrentCard(card);
		Log.info("User clicked on card - " + card);
	}

	public void userHasCompletedAllTheFieldsOnBasicDetailsCard() throws Exception {
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {

				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Basic details", null, CardUtility.globalEventType,
						fieldLabel);
				String groupName = crdUtility.getGroupName("Basic details", null, CardUtility.globalEventType,
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
		Log.info("User has filled details on 'Basic Details'");
	}

	public void clickOnButtonEventObjectSaveReturn(String cardName) {
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		Log.info("User saved the card - " + cardName);
	}

	public void userHasCompletedAllTheFieldsOnForm(String tabName, String card, String LinkReason) throws Exception {
		// Click on Tab
		cmPageHelper.clickOnTab(driver, tabName);
		cmPageHelper.waitForTabToBeActive(driver, tabName);
		// String cardName = cmPageHelper.getNameForCard(card, LinkReason,
		// CardUtility.globalEventType);
		String cardJSONName = cmPageHelper.getJSONNameForCard(card, LinkReason, CardUtility.globalEventType);

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			String xlRecordNum = (Utility.testData[i][4] == null) ? "" : Utility.testData[i][4];

			if (xlCardName.contains(card) && xlCardName.contains(LinkReason) && xlFormName.equals(tabName)
					&& xlRecordNum.isEmpty()) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = "";
				String groupName = null;

				if (fieldLabelArray.length > 1) {
					fieldName = crdUtility.getElementNameForGroup(cardJSONName, tabName, CardUtility.globalEventType,
							fieldLabel);
					groupName = crdUtility.getGroupName(cardJSONName, tabName, CardUtility.globalEventType, fieldLabel);
				} else
					fieldName = crdUtility.getElementName(cardJSONName, tabName, CardUtility.globalEventType,
							fieldLabel);

				// Note - this won't work if the very first element is Yes/No button in the
				// repeating group
				if (groupName != null && !fieldLabel.equalsIgnoreCase(fieldName)) {
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
		Log.info("User has filled form " + tabName + " on " + card + "card");
	}

	public void userHasCompletedRecordOnFormOnCardWithLinkReason(String num, String tabName, String card,
			String LinkReason) throws Exception {
		// Click on Tab
		cmPageHelper.clickOnTab(driver, tabName);
		cmPageHelper.waitForTabToBeActive(driver, tabName);
		// String cardName = cmPageHelper.getNameForCard(card, LinkReason,
		// CardUtility.globalEventType);
		String cardJSONName = cmPageHelper.getJSONNameForCard(card, LinkReason, CardUtility.globalEventType);

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			String xlRecordNum = (Utility.testData[i][4] == null) ? "" : Utility.testData[i][4];
			if (xlCardName.contains(card) && xlCardName.contains(LinkReason) && xlFormName.equals(tabName)
					&& xlRecordNum.equalsIgnoreCase(num)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = "";
				String groupName = null;

				if (fieldLabelArray.length > 1) {
					fieldName = crdUtility.getElementNameForGroup(cardJSONName, tabName, CardUtility.globalEventType,
							fieldLabel);
					groupName = crdUtility.getGroupName(cardJSONName, null, CardUtility.globalEventType, fieldLabel);
				} else
					fieldName = crdUtility.getElementName(cardJSONName, tabName, CardUtility.globalEventType,
							fieldLabel);

				// Note - this won't work if the very first element is Yes/No button in the
				// repeating group
				if (groupName != null && !fieldLabel.equalsIgnoreCase(fieldName)) {
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
		Log.info("User has filled form " + tabName + " on " + card + "card");
	}

	public void userSetsTheFollowingCardAsNotApplicable() throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i < Utility.testDataCards.length; i++) {
			String xlEventName = Utility.testDataCards[i][0];
			if (xlEventName.equals(CardUtility.globalEventType)) {
				String cardName = Utility.testDataCards[i][1];
				String linkReason = cmPageHelper.returnFieldValue(Utility.testDataCards[i][2]);
				String cardStatus = Utility.testDataCards[i][3];
				if (cardStatus.equalsIgnoreCase("Not Applicable")) {
					cmPageHelper.clickOnCardName(cardName, linkReason, CardUtility.globalEventType);
					cmPageHelper.clickOnButtonNoCardRequired(driver);
				}
			}
		}
		Log.info("User sets the cards as 'Not Applicable'");
	}

	public void userHasCompletedAllTheFieldsOnEnquiryLogForm() throws Exception {

		WebElement elField = null;

		// Click on Add New Enquiry log button
		enqLog.clickOnButtonAddNewEnqLog(driver);

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Enquiry log") && xlFormName.equals("Enquiry log")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Enquiry log", null, CardUtility.globalEventType,
						fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}

		Log.info("User has filled the card 'Enquire log'");
	}

	public void allTheCardsOnTheCardIndexAreInFollowingStatus() throws Exception {
		for (int i = 0; i < Utility.testDataCards.length; i++) {
			String xlEventName = Utility.testDataCards[i][0];
			if (xlEventName.equals(CardUtility.globalEventType)) {
				String cardName = Utility.testDataCards[i][1];
				String linkReason = cmPageHelper.returnFieldValue(Utility.testDataCards[i][2]);
				String expCardStatus = Utility.testDataCards[i][3];
				String strCardName = cmPageHelper.getNameForCard(cardName, linkReason, CardUtility.globalEventType);
				String actualCardStatus = cmPageHelper.getCardStatus(strCardName);
				if (expCardStatus.equals(actualCardStatus))
					Log.info("Card '" + strCardName + "' has expected status as '" + expCardStatus + "'.");
				else
					Log.error("Card '" + strCardName + "' does not have expected status as '" + expCardStatus + "'.");

				assertTrue(expCardStatus.equals(actualCardStatus),
						"Card '" + strCardName + "' does not have expected status as '" + expCardStatus + "'.");
			}
		}
	}

	public void userSubmitsCreateIntelligenceReportTaskCard() throws Exception {
		cmPageHelper.clickOnButtonSubmit(driver);
		cmPageHelper.clickOnButtonSubmitConfirmationMessage(driver);
		IntelRefNumber = cmPageHelper.getURNNumber(driver);
		intelUtility.setIntelRef(IntelRefNumber);
		cmPageHelper.clickOnButtonSubmitDone(driver);
		Log.info("User has submitted 'Create intelligence report' card and the reference is - " + IntelRefNumber);
	}

	public void userSubmitsDisseminateIntelligenceReportInternalCard() throws Exception {
		cmPageHelper.clickOnButtonSubmit(driver);
		cmPageHelper.clickOnButtonSubmitConfirmationMessage(driver);
		IntelRefNumber = cmPageHelper.getURNNumber(driver);
		intelUtility.setIntelRef(IntelRefNumber);
		cmPageHelper.clickOnButtonSubmitDone(driver);
		Log.info("User has submitted 'Create intelligence report' card and the reference is - " + IntelRefNumber);
	}

	public void eventRecordSelectedInWorkloadTab() throws Exception {
		String unitName = null;
		String fieldLabel;
		String xlFormName;
		String xlCardName;

		cmPageHelper.switch_To_LaunchPadModule(driver);
		assertTrue(IntelUtility.IntelRefNumber.length() > 0, "Intel reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		for (int i = 0; i < Utility.testData.length; i++) {
			xlCardName = Utility.testData[i][0];
			xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {
				fieldLabel = Utility.testData[i][2];
				if (fieldLabel.trim().equals("Submit to intelligence unit")) {
					unitName = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
					break;
				}
			}
		}
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		Log.info("Event record selected in workload tab");
	}

	public void NotificationinMessageRecievedInMessageTab(String subName) throws Exception {
		String userName = cmPageHelper.returnFieldValue("DefaultUserName");
		cmPageHelper.switch_To_LaunchPadModule(driver);
		message.clickOnMessageIcon();
		message.selectNotification(driver, subName, userName);
		Log.info("Event record selected in workload tab");
	}

	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		workload.validateEventStatus(eventStatus, IntelUtility.IntelRefNumber, driver);
		Log.info("Event status has set to - " + eventStatus);
	}

	public void taskHistoryEntryWillBeCreated(String taskEntry) throws Exception {
		workload.verifyTaskName(driver, taskEntry);
	}

	public void taskWillBeRaisedToIntelSubmitter(String task) throws Exception {
		workload.verifyIntelSubmitterTask(driver, task);
	}

	public void validateFromFieldInNotificationMsg() throws Exception {
		String userName = cmPageHelper.returnFieldValue("DefaultUserName");
		message.validateFromFieldInNotificationMsg(driver, "txtNotificationMultiU", userName);
	}

	public void validatePrepopulatedFieldInNotificationMsg(String strOperation, String tabName) throws Exception {
		message.validateFieldsOnMessageCard(strOperation, tabName);
	}

	public void userIsOnCardIndexScreenForARequestToCreateBriefingItem() throws Exception {
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("1", driver);
		workload.selectLinkedAction("Request To Create Briefing Item", driver);
		workload.waitForCardToBeDisplayed(driver, "Request to create briefing");
		Log.info("User is on Card Index screen for a 'Request to create briefing item'");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard() throws Exception {
		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Request to create briefing") && xlFormName.equals("Request to create briefing")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Request to create briefing", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
		Log.info("User has filled the card 'Request to create briefing' card");
	}

	public void userSubmitsRequestToCreateBriefingItemCard() throws Exception {
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
		Log.info("User has submitted 'Request to create briefing item' task");
	}

	public void taskWillBeRaisedToAssessor(String task) throws Exception {
		String unitName = null;
//		String fieldLabel;	
//		String xlFormName;	
//		String xlCardName;	

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
//		for (int i = 0; i < Utility.testData.length; i++) {	
//			xlCardName = Utility.testData[i][0];	
//			xlFormName = Utility.testData[i][1];	
//			if (xlCardName.equals("Request to create briefing") && xlFormName.equals("Request to create briefing")) {	
//				fieldLabel = Utility.testData[i][2];	
//				if (fieldLabel.trim().equals("Send request to unit")) {	
//					unitName = cmPageHelper.returnFieldValue(Utility.testData[i][3]);	
//					break;	
//				}	
//			}	
//		}	
		unitName = cmPageHelper.returnFieldValue("DefaultRequestUnit");
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		workload.verifyIntelSubmitterTask(driver, task);

		Log.info("Task raised as - " + task);
	}

	public void userIsOnCardIndexScreenForAProcessRequestToCreateBriefing() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Process request to create briefing");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Process request to create briefing");
		Log.info("User is on Card Index screen for a 'Process request to create briefing'");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard()
			throws Exception {
		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Process request to create briefing")
					&& xlFormName.equals("Process request to create briefing")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Process request to create briefing", null,
						"Process request to create briefing", fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
		Log.info("User has filled the data on 'Process request to create briefing'");
	}

	public void userSubmitsProcessRequestToCreateBriefingCard() throws Exception {
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickWorkloadMyUnits(driver, cmPageHelper.returnFieldValue("DefaultIntelUnit"));
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		Log.info(
				"User has submitted task 'Process request to create briefing' and selected the record on workload tab.");
	}

	public void LogoutFromAnApplicationAndCloseTheBrowser() throws Exception {
		cmPageHelper.logOut(driver);
		cmPageHelper.closeBrowser(driver);
		Log.info("###################### User has logged out from an application ######################");
	}

	public void userReadTheTestDataSheetFromFile(String sheetName, String fileName) throws Throwable {
		cmPageHelper.readExcel(fileName, sheetName);

	}

	public void userReadTheTestDataForCardsOnSheetFromFile(String sheetName, String fileName) throws Throwable {
		cmPageHelper.readExcelCards(fileName, sheetName);
	}

	public void verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		List<String> list = fields.asList(String.class);
		String fieldLabel;
		WebElement elField = null;
		String strCardName = cmPageHelper.getNameForCard(cardName, linkReason, CardUtility.globalEventType);
		for (int i = 1; i < list.size(); i++) { // i starts from 1 because i=0 represents the header
			fieldLabel = list.get(i);
			String fieldName = crdUtility.getElementName(strCardName, null, CardUtility.globalEventType, fieldLabel);
			if (fieldName.trim() != null) {
				elField = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", cmPageHelper.getDriver());
				Assert.assertTrue(elField != null);
				cmPageHelper.isElementMandatory(fieldName);
			}
		}
	}

	public void verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		List<String> list = fields.asList(String.class);
		String fieldLabel;
		WebElement elField = null;
		String strCardName = cmPageHelper.getNameForCard(cardName, linkReason, CardUtility.globalEventType);
		for (int i = 1; i < list.size(); i++) { // i starts from 1 because i=0 represents the header
			fieldLabel = list.get(i);
			String fieldName = crdUtility.getElementName(strCardName, null, CardUtility.globalEventType, fieldLabel);
			if (fieldName.trim() != null) {
				elField = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", cmPageHelper.getDriver());
				Assert.assertTrue(elField != null);
				cmPageHelper.isElementnonMandatory(fieldName);
			}
		}
	}

	public void user_has_completed_field_and_the_value_supplied_is_on_card_with_Link_Reason(String strFieldName,
			String strValue, String strCard, String strLinkReason) throws Throwable {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		String cardName = cmPageHelper.getNameForCard(strCard, strLinkReason, CardUtility.globalEventType);
		String fieldLabel, fieldValue;
		WebElement elField = null;
		fieldLabel = strFieldName.trim();
		fieldValue = cmPageHelper.returnFieldValue(strValue.trim());
		String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
		if (fieldName.trim() != null) {
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
				cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
			else {
				elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void verifyValidationMessageIsDisplayedOnCardToFillTheMandatoryFieldsWithLinkReason(String cardName,
			String fieldLabel, String linkReason) throws Throwable {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		WebElement elField = null;
		String strCardName = cmPageHelper.getNameForCard(cardName, linkReason, CardUtility.globalEventType);
		String fieldName = crdUtility.getElementName(strCardName, null, CardUtility.globalEventType, fieldLabel);
		if (!fieldName.toUpperCase().contains("DATE")) {
			elField = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", cmPageHelper.getDriver());
			Assert.assertTrue(elField != null);
			cmPageHelper.ValidationMsgDisplayedForMandtoryFields(fieldName);
		} else {
			cmPageHelper.ValidationMsgDisplayedForMandtoryDateFields(fieldName);
		}
	}

	public void userClicksOnCreateIntelligenceReportInWorkloadTab() throws Throwable {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		cmPageHelper.clickOnHomeButton();
		cmPageHelper.switch_To_LaunchPadModule(driver);
		intelUtility.clickOnCreateIntelIcon();
		Log.info("User is on Card Index screen for a 'Create intelligence report'");
	}

	public void userIsOnCardIndexScreenForAAssessIntelligenceReport() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Assess intelligence report");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Assess intelligence report");
		Log.info("User is on Card Index screen for a 'Assess intelligence report'");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAssessIntelligenceReportCard() throws Exception {
		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Assess intelligence report")
					&& xlFormName.equalsIgnoreCase("Assess intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Assess Intelligence report", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		Log.info("User has filled the card 'Assess intelligence report'");
	}

	public void user_has_completed_all_the_mandatory_fields_on_Intelligence_card() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {

			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Intelligence") && xlFormName.equalsIgnoreCase("Intelligence")) {
				cmPageHelper.clickOnTab(driver, "Intelligence");
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Intelligence", null, CardUtility.globalEventType,
						fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			} else if (xlCardName.equalsIgnoreCase("Intelligence") && xlFormName.equalsIgnoreCase("Risk factors")) {
				cmPageHelper.clickOnTab(driver, "Risk factors");
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Intelligence", null, CardUtility.globalEventType,
						fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
	}

	public void userSubmitsAssessIntelligenceReportCard() throws Exception {
		cmPageHelper.clickOnButtonSubmit(driver);

	}

	public void taskWillBeRaisedToLinkingUnit(String task) throws Exception {

		String unitName = null;
		String fieldLabel;
		String xlFormName;
		String xlCardName;

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		for (int i = 0; i < Utility.testData.length; i++) {
			xlCardName = Utility.testData[i][0];
			xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {
				fieldLabel = Utility.testData[i][2];
				if (fieldLabel.trim().equals("Submit to intelligence unit")) {
					unitName = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
					break;
				}
			}
		}
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		workload.verifyIntelSubmitterTask(driver, task);
		Log.info(task + " task is raised to the linking unit");
	}

	public void userIsOnCardIndexScreenForALinkIntelligenceReport() throws Exception {

		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickIntelSubmitterTask(driver, "Link Intelligence Report");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Link intelligence report");

		Log.info("User is on Card Index screen for a 'Link intelligence report'");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnLinkIntelligenceReportCard() throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Link intelligence report") && xlFormName.equals("Link intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Link intelligence report", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
		// List<List<String>> data = dataTable.asLists(String.class);
		//
		// for (int index = 1; index < data.size(); index++) {
		// String fieldLabel = data.get(index).get(0);
		// String fieldValue = cmPageHelper.getFieldValue("Link intelligence report",
		// "", fieldLabel);
		// String fieldName = crdUtility.getElementName("Link intelligence report",
		// "Link intelligence report",
		// fieldLabel);
		// if (fieldLabel.equalsIgnoreCase(fieldName) &&
		// !fieldName.toUpperCase().contains("DATE"))
		// cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
		// else {
		// WebElement elField = driver.findElement(By.name(fieldName));
		// cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
		// }
		// }
	}

	public void userSavesCardWithLinkReason(String arg1, String arg2) throws Exception {
		cmPageHelper.clickOnButtonStaticObjectSaveReturn(driver);
	}

	public void userSubmitsLinkIntelligenceReportCard() throws Exception {
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);

	}

	public void userIsOnCardIndexScreenForADeleteIntelligenceReportRequest() throws Exception {

		String unitName = null;
		String fieldLabel;
		String xlFormName;
		String xlCardName;

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		for (int i = 0; i < Utility.testData.length; i++) {
			xlCardName = Utility.testData[i][0];
			xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {
				fieldLabel = Utility.testData[i][2];
				if (fieldLabel.trim().equals("Submit to intelligence unit")) {
					unitName = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
					break;
				}
			}
		}
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Delete Intelligence Report Request", driver);
		workload.waitForCardToBeDisplayed(driver, "Delete Intelligence Report Request");
		Log.info("User is on Card Index screen for a 'Delete intelligence report'");
	}

	public void userHasCompletedAllTheFieldsOnDeleteIntelligenceReportRequestCard() throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Delete Intelligence Report Request")
					&& xlFormName.equalsIgnoreCase("Delete Intelligence Report Request")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Delete Intelligence Report Request", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}

	}

	public void userSubmitsDeleteIntelligenceReportRequestCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);

	}

	public void taskWillBeRaised(String task) throws Exception {

		String unitName = null;
		String fieldLabel;
		String xlFormName;
		String xlCardName;

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		for (int i = 0; i < Utility.testData.length; i++) {
			xlCardName = Utility.testData[i][0];
			xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {
				fieldLabel = Utility.testData[i][2];
				if (fieldLabel.trim().equals("Submit to intelligence unit")) {
					unitName = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
					break;
				}
			}
		}
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		workload.verifyIntelSubmitterTask(driver, task);

	}

	public void userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequest() throws Exception {

		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickIntelSubmitterTask(driver, "Authorise Intelligence Report Delete Request");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Authorise Intelligence Report Delete Request");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard() throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Authorise Intelligence Report Delete Request")
					&& xlFormName.equalsIgnoreCase("Authorise Intelligence Report Delete Request")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Authorise Intelligence Report Delete Request", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
	}

	public void userSubmitsAuthoriseIntelligenceReportDeleteRequestCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userClicksOnIndexButtonOnAssessIntelligenceReport() throws Throwable {

		cmPageHelper.clickOnIndexButton(driver);
	}

	public void userClicksOnCancelButton() throws Throwable {

		cmPageHelper.clickOnButtonCancel(driver);
		cmPageHelper.clickOnExitWithoutSavingWarningMsgBox(driver);
	}

	public void userClicksOnCloseButton() throws Throwable {

		message.clickOnButtonClose(driver);
	}

	public void sensitiveEntriesOnShouldBeDisplayedAs(String Label, String Value) throws Throwable {

		cmPageHelper.sensitiveEntryOnIntelligence(Label, Value);
	}

	public void userVerifiesFieldsAndTheValueIsOnFormOnCardWithLinkReason(String tabName, String card,
			String LinkReason) throws Throwable {

		if (!tabName.equalsIgnoreCase("Enquiry log")) {
			cmPageHelper.clickOnTab(driver, tabName);
			cmPageHelper.waitForTabToBeActive(driver, tabName);
		}
		cmPageHelper.switch_To_ConnectMobileModule(driver);

		String cardName = cmPageHelper.getNameForCard(card, LinkReason, CardUtility.globalEventType);

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.contains(card) && xlCardName.contains(LinkReason) && xlFormName.equals(tabName)) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardName, tabName, CardUtility.globalEventType,
						fieldLabel);
				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.ReadValueForButton(driver, fieldLabel, fieldValue);
				else {
					cmPageHelper.readValuesFrTextFields(fieldLabel, fieldName, fieldValue);
				}

			}
		}
	}

	public void taskWillBeRaisedToTheUnitIfTheUserDoesNotCorrectTheReportAsOnTheReSubmissionDate(String task)
			throws Exception {

		workload.verifyIntelSubmitterTask(driver, task);
	}

	public void userIsOnCardIndexScreenForAAcknowledgeUserFailureToCorrectIntelligence() throws Exception {
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Acknowledge User Failure To Correct Intelligence", driver);
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAcknowledgeUserFailureToCorrectIntelligenceCard()
			throws Exception {
		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Acknowledge user failure to correct intelligence report")
					&& xlFormName.equals("Acknowledge user failure to correct intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Acknowledge user failure to correct intelligence report",
						null, "Acknowledge user failure to correct intelligence report", fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}
			}
		}
	}

	public void userSubmitsAcknowledgeUserFailureToCorrectIntelligenceCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void intelligenceReportStatusIsNotOr(String eventStatus1, String eventStatus2) throws Exception {

		workload.validateEventStatusNotLiveOrLiveSensitive(eventStatus1, IntelRefNumber, driver);
		workload.validateEventStatusNotLiveOrLiveSensitive(eventStatus2, IntelRefNumber, driver);
		// workload.validateEventStatus(eventStatus, IntelRefNumber, driver);
	}

	public void userIsOnCardIndexScreenForADisseminateIntelligenceReportInternally() throws Exception {

		// cmPageHelper.switch_To_WorkloaddModule(driver);
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("1", driver);
		workload.selectLinkedAction("Disseminate Intelligence Report Internally", driver);
		workload.waitForCardToBeDisplayed(driver, "Disseminate intelligence report internally");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnDisseminateIntelligenceReportInternallyCard() throws Exception {

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Disseminate intelligence report internally")
					&& xlFormName.equalsIgnoreCase("Disseminate intelligence report internally")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Disseminate intelligence report internally", null,
						CardUtility.globalEventType, fieldLabel);
				String groupName = crdUtility.getGroupName("Disseminate intelligence report internally", null,
						CardUtility.globalEventType, fieldLabel);
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
	}

	public void noDisseminationMessageWouldBeSentAcrossToAnyRecipientsListedInTheTaskUntilTheIntelligenceReportIsMadeLIVEOrLIVESensitive()
			throws Exception {

	}

	public void userIsOnCardIndexScreenForACorrectIntelligenceReport() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Correct intelligence report", driver);
	}

	public void userHasCompletedAllTheMandatoryFieldsOnCorrectIntelligenceReportCard(DataTable dataTable)
			throws Exception {
		String event = "Correct intelligence report";
		String card = "Correct intelligence report";
		WebElement elField = null;

		List<List<String>> data = dataTable.asLists(String.class);
		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue(card, "", fieldLabel);
			String fieldName = crdUtility.getElementName(card, null, event, fieldLabel);
			elField = driver.findElement(By.name(fieldName));
			cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
		}
	}

	public void userSubmitsTheCorrectIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	// public void userIsOnCardIndexScreenForAAssessIntelligenceReport() throws
	// Exception {
	//
	// workload.clickLinkedActionsButton(driver);
	// cmPageHelper.switch_To_WorkloadLinkedActions(driver);
	// workload.selectLinkedAction("Assess intelligence report", driver);
	// }

	public void linkIntelligenceReportTaskWillBeRaised() throws Exception {
		String task = "Link intelligence report";

		workload.verifyIntelSubmitterTask(driver, task);
	}

	public void userSubmitsTheAssessIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void performReviewOfCodeCTaskWillBeRaisedAfterCodeCNextReviewDate() throws Exception {
		String task = "Perform review of code C";

		workload.verifyIntelSubmitterTask(driver, task);
	}

	public void disseminationMessageWouldBeSentAcrossToAllRecipientsListedInTheTask() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userHasCompletedAllTheFieldsOnLocationCard(DataTable dataTable) throws Exception {
		// String event = "Intelligence Report";
		String cardName = "";
		WebElement elField = null;

		cardName = cmPageHelper.getNameForCard("location", "Subject Of", CardUtility.globalEventType);

		List<List<String>> data = dataTable.asLists(String.class);
		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue(cardName, "", fieldLabel);
			String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType, fieldLabel);
			elField = driver.findElement(By.name(fieldName));
			cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
		}
	}

	public void userIsOnCardIndexScreenForAAcknowledgeIntelligenceReportReturnedOrDeleted() throws Exception {

		workload.clickIntelSubmitterTask(driver, "Acknowledge Intelligence Report Returned Or Deleted");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Acknowledge intelligence report returned or deleted");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAcknowledgeIntelligenceReportReturnedOrDeleted()
			throws Exception {
		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Acknowledge intelligence report returned or deleted")
					&& xlFormName.equals("Acknowledge intelligence report returned or deleted")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Acknowledge intelligence report returned or deleted",
						null, "Acknowledge intelligence report returned or deleted", fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}
			}
		}
	}

	public void userHasCompletedAllTheFieldsOnTheCardWithLinkReason(String card, String LinkReason) throws Exception {
		String cardJSONName = cmPageHelper.getJSONNameForCard(card, LinkReason, CardUtility.globalEventType);
		String cardName = cmPageHelper.getNameForCard(card, LinkReason, CardUtility.globalEventType);
		if (LinkReason.trim().isEmpty()) {
			LinkReason = card;
		}
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0].trim();
			String xlFormName = Utility.testData[i][1].trim();
			String xlRecordNum = (Utility.testData[i][4] == null) ? "" : Utility.testData[i][4];

			if (xlCardName.equalsIgnoreCase(cardName) && xlCardName.contains(LinkReason.trim())
					&& xlFormName.equalsIgnoreCase(cardName.trim()) && xlFormName.contains(LinkReason.trim())
					&& xlRecordNum.isEmpty()) {
				// String fieldLabel = Utility.testData[i][2];
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardJSONName, null, CardUtility.globalEventType,
						fieldLabel);
				String groupName = crdUtility.getGroupName(cardJSONName, null, CardUtility.globalEventType, fieldLabel);

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

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")
						&& !fieldName.toUpperCase().contains("DOB"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else if (fieldValue.contains(" | Checkbox"))
					cmPageHelper.clickOnCurrentUserCheckBox();
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
				}
			}

		}
		// Click on Next button to search the record
		cmPageHelper.clickOnNextButton(driver);
		Thread.sleep(3000);

		if (cmPageHelper.isSearchResultDisplayed(driver)) {
			cmPageHelper.clickOnNoneOfTheseButton(driver);

		}
	}

	public void userHasCompletedRecordOnTheCardWithLinkReason(String num, String card, String LinkReason)
			throws Exception {
		String cardJSONName = cmPageHelper.getJSONNameForCard(card, LinkReason, CardUtility.globalEventType);
		String cardName = cmPageHelper.getNameForCard(card, LinkReason, CardUtility.globalEventType);
		if (LinkReason.trim().isEmpty()) {
			LinkReason = card;
		}
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0].trim();
			String xlFormName = Utility.testData[i][1].trim();
			String xlRecordNum = (Utility.testData[i][4] == null) ? "" : Utility.testData[i][4];
			if (xlCardName.equalsIgnoreCase(cardName) && xlCardName.contains(LinkReason.trim())
					&& xlFormName.equalsIgnoreCase(cardName.trim()) && xlFormName.contains(LinkReason.trim())
					&& xlRecordNum.equalsIgnoreCase(num)) {
				String fieldLabelArray[] = Utility.testData[i][2].split(" => ");
				String fieldLabel = fieldLabelArray[fieldLabelArray.length - 1];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName(cardJSONName, null, CardUtility.globalEventType,
						fieldLabel);
				String groupName = crdUtility.getGroupName(cardJSONName, null, CardUtility.globalEventType, fieldLabel);

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

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")
						&& !fieldName.toUpperCase().contains("DOB"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else if (fieldValue.contains(" | Checkbox"))
					cmPageHelper.clickOnCurrentUserCheckBox();
				else {
					List<WebElement> elFields = driver.findElements(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elFields.get(elFields.size() - 1), fieldLabel, fieldValue);
				}

			}
		}

		// Click on Next button to search the record
		cmPageHelper.clickOnNextButton(driver);
		Thread.sleep(5000);
		if (cmPageHelper.isSearchResultDisplayed(driver)) {
			cmPageHelper.clickOnNoneOfTheseButton(driver);
		}
	}

	public void CloseFailedTest(String LogFilePath, String ScreenshotFilePath, String testStep, String testName,
			Throwable throwable) throws Exception {
		cmPageHelper.CloseFailedTest(LogFilePath, ScreenshotFilePath, testStep, testName, EnvName, throwable);
	}

	public void userHasCompletedAllTheFieldsOnVehicleCard(DataTable dataTable) throws Exception {

		List<List<String>> data = dataTable.asLists(String.class);

		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue("Vehicle", "", fieldLabel);
			String fieldName = crdUtility.getElementName("Vehicle", null, CardUtility.globalEventType, fieldLabel);
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
				cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
			else {
				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void userIsOnCardIndexScreenForAUserIntiatedTaskDuplicateIntelligenceReport() throws Exception {

		// cmPageHelper.switch_To_WorkloaddModule(driver);
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("2", driver);
		workload.selectLinkedAction("Duplicate Intelligence Report", driver);
		workload.waitForCardToBeDisplayed(driver, "Duplicate intelligence report");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnDuplicateIntelligenceReportCard() throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Duplicate intelligence report")
					&& xlFormName.equals("Duplicate intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Duplicate intelligence report", null,
						"Duplicate intelligence report", fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
	}

	public void userSubmitsDuplicateIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userIsDisplayedWithANewURN() throws Exception {

		IntelUtility.IntelRefNumber = cmPageHelper.getURNNumber(driver);
		System.out.println("Intelligence report reference number is  - " + IntelUtility.IntelRefNumber);
		cmPageHelper.clickOnButtonSubmitDone(driver); // Need to confirm the flow
	}

	public void eventStatusOfNewlyCreatedIntelWillBeShownAs(String eventStatus) throws Exception {

		String unitName = null;
		String fieldLabel;
		String xlFormName;
		String xlCardName;

		cmPageHelper.switch_To_LaunchPadModule(driver);
		assertTrue(IntelUtility.IntelRefNumber.length() > 0, "Intel reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		for (int i = 0; i < Utility.testData.length; i++) {
			xlCardName = Utility.testData[i][0];
			xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Basic details") && xlFormName.equals("Basic details")) {
				fieldLabel = Utility.testData[i][2];
				if (fieldLabel.trim().equals("Submit to intelligence unit")) {
					unitName = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
					break;
				}
			}
		}
		workload.clickWorkloadMyUnits(driver, unitName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		workload.validateEventStatus(eventStatus, IntelUtility.IntelRefNumber, driver);
	}

	public void forTheTaskOfANewIntelligenceReportWillBeTheDateOnWhichDuplicateIntelligenceReportTaskIsPerformedOnTheSourceIntelligenceReport(
			String arg1) throws Exception {

	}

	public void noLinksShouldBeCreatedBetweenTheExistingIntelReportAndTheNewlyCreatedOnes() throws Exception {

		workload.verifyIntelReportsLinking();
	}

	public void noneOfTheObjectsLinkedToTheOriginalIntelReportShouldBeCopiedOverToTheNewlyCreatedReport()
			throws Exception {

		workload.verifyIntelReportsLinking();
	}

	public void userOpenNewURN() throws Exception {

	}

	public void userIsOnCardIndexScreenForAUserIntiatedTaskTransferIntelligenceReport() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("2", driver);
		workload.selectLinkedAction("Transfer intelligence report", driver);
		workload.waitForCardToBeDisplayed(driver, "Transfer intelligence report");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnTransferIntelligenceReportCard() throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Transfer intelligence report")
					&& xlFormName.equals("Transfer intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Transfer intelligence report", null,
						"Transfer intelligence report", fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}

			}
		}
	}

	public void userSubmitsTransferIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userIsOnCardIndexScreenForARegisterInterestInIntelligenceReportCard() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("1", driver);
		workload.selectLinkedAction("Register Interest In Intelligence Report", driver);
		workload.waitForCardToBeDisplayed(driver, "Register Interest in intelligence report");

	}

	public void userHasCompletedAllTheMandatoryFieldsOnRegisterInterestInIntelligenceReportCard() throws Exception {

		for (int i = 0; i < Utility.testData.length; i++) {
			System.out.println();
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Register interest in intelligence report")
					&& xlFormName.equals("Register interest in intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);

				String fieldName = crdUtility.getElementName("Register interest in intelligence report", null,
						CardUtility.globalEventType, fieldLabel);

				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void userSubmitsRegisterInterestInIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void taskWillBeRaisedToStaffMember(String task) throws Exception {

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickWorkloadMyView(driver, cmPageHelper.returnFieldValue("DefaultUserName"));
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");
		workload.verifyIntelSubmitterTask(driver, task);
	}

	public void userHasCompletedAllTheFieldsOnOrganisationCard(DataTable dataTable) throws Exception {

		List<List<String>> data = dataTable.asLists(String.class);

		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue("Organisation", "", fieldLabel);
			String fieldName = crdUtility.getElementName("Organisation", null, "Organisation", fieldLabel);
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
				cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
			else {
				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}

		}
	}

	public void userIsOnCardIndexScreenForARemoveInterestInIntelligenceReportCard() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("1", driver);
		workload.selectLinkedAction("Remove Interest In Intelligence Report", driver);
		workload.waitForCardToBeDisplayed(driver, "Remove Registered Interest In Intelligence Report");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnRemoveInterestInIntelligenceReportCard() throws Exception {

		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Remove interest in Intelligence Report")
					&& xlFormName.equalsIgnoreCase("Remove registered interest in Intelligence Report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Remove registered interest in Intelligence Report", null,
						CardUtility.globalEventType, fieldLabel);
				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void userSubmitsRemoveInterestInIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void taskWillBeRemovedFromWorkloadOf(String task, String arg2) throws Exception {
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
				taskFound = true;
				break;
			}
		}
		assertFalse(taskFound, "Task '" + task + "' found in Workload.");
	}

	public void performReviewOfCodeCTaskShouldBeRaisedOnTheSelectedCodeCNextReviewDate() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Perform ad hoc review of Code C", driver);
		workload.verifyIntelSubmitterTask(driver, "Perform review of code C");
	}

	public void userIsOnCardIndexScreenForAPerformAdHocReviewOfCodeC() throws Exception {

		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Perform Ad Hoc Review Of Code C", driver);
		workload.waitForCardToBeDisplayed(driver, "Perform ad hoc review of Code C");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnPerformAdHocReviewOfCodeCCard() throws Exception {

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Perform ad hoc review of Code C")
					&& xlFormName.equals("Perform ad hoc review of Code C")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Perform ad hoc review of Code C", null,
						"Perform ad hoc review of Code C", fieldLabel);
				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void userSubmitsPerformAdHocReviewOfCodeCCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void performReviewOfCodeCTaskShouldNowBeRaisedOnTheNewCodeCNextReviewDateSelectedAbove() throws Exception {

		workload.verifyIntelSubmitterTask(driver, "Perform review of code C");
	}

	public void userIsOnCardIndexScreenForAAppendInformationToIntelligenceReport() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Append Information", driver);
		workload.waitForCardToBeDisplayed(driver, "Append information to intelligence report");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAppendInformationToIntelligenceReportCard() throws Exception {

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Append information to intelligence report")
					&& xlFormName.equals("Append information to intelligence report")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Append information to intelligence report", null,
						"Append information to intelligence report", fieldLabel);
				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void userSubmitsAppendInformationToIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void intelligenceFieldOnIntelligenceFormWillGetAppendedWithEnteredTextInAppendInformationToIntelligenceReportTask()
			throws Exception {

		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Append information to intelligence report")
					&& xlFormName.equals("Append information to intelligence report")) {
				String informationTextSheet = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String informationTextUI = workload.captureInformationText(driver);
				Assert.assertTrue(informationTextUI.contains(informationTextSheet.trim()),
						"Information is not appended to Intelligence report text");
				break;
			}
		}

	}

	public void userIsOnCardIndexScreenForADeleteIntelligenceReportRequestCard() throws Exception {

		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectActionGroup("2", driver);
		workload.selectLinkedAction("Delete Intelligence Report Request", driver);
		workload.waitForCardToBeDisplayed(driver, "Delete Intelligence Report Request");

	}

	public void userHasCompletedAllTheMandatoryFieldsOnDeleteIntelligenceReportRequestCard(DataTable dataTable)
			throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Delete Intelligence Report Request")
					&& xlFormName.equalsIgnoreCase("Delete Intelligence Report Request")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				// String fieldName = crdUtility.getElementName("Assess Intelligence report",
				// "Assess Intelligence report", fieldLabel);
				String fieldName = crdUtility.getElementName("Delete Intelligence Report Request", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}
			}
		}
	}

	public void taskWillBeRaisedTo(String arg1, String arg2) throws Exception {

	}

	public void userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequestCard() throws Exception {

		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickIntelSubmitterTask(driver, "Authorise intelligence report delete request");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Authorise intelligence report delete request");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard(DataTable dataTable)
			throws Exception {

		WebElement elField = null;
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equalsIgnoreCase("Authorise intelligence report delete request")
					&& xlFormName.equalsIgnoreCase("Authorise intelligence report delete request")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Authorise intelligence report delete request", null,
						CardUtility.globalEventType, fieldLabel);

				if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
					cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
				else {
					elField = driver.findElement(By.name(fieldName));
					cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
				}
			}
		}
	}

	public void clicksOnSaveForLater() throws Exception {

		cmPageHelper.clickOnButtonSaveForLater(driver);
		cmPageHelper.clickOnSaveForLaterWarningMsgBox(driver);
	}

	public void userIsOnCardIndexScreenForACompleteIntelligenceReportCard() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Complete intelligence report", driver);
	}

	public void userHasCompletedAllTheMandatoryFieldsOnCompleteIntelligenceReportCard(DataTable dataTable)
			throws Exception {

		WebElement elField = null;
		List<List<String>> data = dataTable.asLists(String.class);
		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue("Complete intelligence report", "", fieldLabel);
			String fieldName = crdUtility.getElementName("Complete intelligence report", null,
					"Complete intelligence report", fieldLabel);
			elField = driver.findElement(By.name(fieldName));
			cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
		}
	}

	public void userSubmitsCompleteIntelligenceReportCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userIsOnCardIndexScreenForAAcknowledgeRejectionOfRequestToCreateBriefingCard() throws Exception {

		workload.clickLinkedActionsButton(driver);
		cmPageHelper.switch_To_WorkloadLinkedActions(driver);
		workload.selectLinkedAction("Acknowledge rejection of request to create briefing", driver);
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAcknowledgeRejectionOfRequestToCreateBriefingCard(
			DataTable dataTable) throws Exception {
		WebElement elField = null;

		List<List<String>> data = dataTable.asLists(String.class);
		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue("Acknowledge rejection of request to create briefing", "",
					fieldLabel);
			String fieldName = crdUtility.getElementName("Acknowledge rejection of request to create briefing", null,
					"Acknowledge rejection of request to create briefing", fieldLabel);
			elField = driver.findElement(By.name(fieldName));
			cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
		}
	}

	public void userSubmitsAcknowledgeRejectionOfRequestToCreateBriefingCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userIsOnCardIndexScreenForAReassessIntelligenceReportSensitivityCard() throws Exception {

		workload.clickIntelSubmitterTask(driver, "Reassess intelligence report sensitivity");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Reassess intelligence report sensitivity");
	}

	public void userHasCompletedAllTheMandatoryFieldsOnReassessIntelligenceReportSensitivityCard(DataTable dataTable)
			throws Exception {

		List<List<String>> data = dataTable.asLists(String.class);

		for (int index = 1; index < data.size(); index++) {
			String fieldLabel = data.get(index).get(0);
			String fieldValue = cmPageHelper.getFieldValue("Reassess intelligence report sensitivity", "", fieldLabel);
			String fieldName = crdUtility.getElementName("Reassess intelligence report sensitivity", null,
					"Reassess intelligence report sensitivity", fieldLabel);
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE"))
				cmPageHelper.clickOnYesOrNoButton(driver, fieldLabel, fieldValue);
			else {
				WebElement elField = driver.findElement(By.name(fieldName));
				cmPageHelper.enterFormValues(driver, elField, fieldLabel, fieldValue);
			}
		}
	}

	public void userSubmitsReassessIntelligenceReportSensitivityCard() throws Exception {

		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void userHasCompletedAllTheFieldsOnTagsAndTensionLevelsCard() throws Exception {
		for (int i = 0; i < Utility.testData.length; i++) {
			String xlCardName = Utility.testData[i][0];
			String xlFormName = Utility.testData[i][1];
			if (xlCardName.equals("Tags and tension levels") && xlFormName.equals("Tags and tension levels")) {
				String fieldLabel = Utility.testData[i][2];
				String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]);
				String fieldName = crdUtility.getElementName("Tags and tension levels", null,
						CardUtility.globalEventType, fieldLabel);

				String groupName = crdUtility.getGroupName("Tags and tension levels", null, CardUtility.globalEventType,
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
		Log.info("User has filled details on 'Tags and tension levels'");
	}

	public void user_is_on_Card_Index_screen_for_a_Correct_Intelligence_Report() throws Throwable {
		workload.clickIntelSubmitterTask(driver, "Correct Intelligence Report");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Correct intelligence report");

	}

	public void verify_that_below_fields_are_disabled_on_card_having_Link_Reason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		List<String> list = fields.asList(String.class);
		String fieldLabel;
		WebElement elField = null;
		String strCardName = cmPageHelper.getNameForCard(cardName, linkReason, CardUtility.globalEventType);
		for (int i = 1; i < list.size(); i++) { // i starts from 1 because i=0 represents the header
			fieldLabel = list.get(i);
			String fieldName = crdUtility.getElementName(strCardName, null, CardUtility.globalEventType, fieldLabel);
			if (fieldName.trim() != null) {
				elField = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", cmPageHelper.getDriver());
				Assert.assertTrue(elField != null, "Element is not displayed" + fieldLabel);
				Assert.assertTrue((elField.getAttribute("readonly").toString().equalsIgnoreCase("true")));
			}
		}
	}

	public void validate_fields_on_card_with_Link_Reason(String operationType, String card, String linkReason)
			throws Throwable {
		cmPageHelper.validateFieldsOnCard(operationType, "", card, linkReason);
	}

	public void user_exits_without_saving_record() throws Throwable {
		cmPageHelper.clickOnIndexButton(driver);
		cmPageHelper.clickOnButtonCancel(driver);
		cmPageHelper.clickOnExitWithoutSavingWarningMsgBox(driver);
	}

	public void validateFieldsOnFormOnCardWithLinkReason(String operationType, String form, String card,
			String linkReason) throws Throwable {
		cmPageHelper.validateFieldsOnCard(operationType, form, card, linkReason);
	}

	public void userSubmitsCorrectIntelligenceReportCard() throws Exception {
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);
	}

	public void validate_is_set_to_in_Dashboard_tab(String field, String value) throws Throwable {
		workload.validateFieldValueInDashboardTab(field, value, driver);
	}

	public void userSelectsRecordInMyViewTabOnWorkloadScreen() throws Exception {
		cmPageHelper.switch_To_LaunchPadModule(driver);
		assertTrue(IntelUtility.IntelRefNumber.length() > 0, "Intel reference number is not captured");
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		String teamName = cmPageHelper.returnFieldValue("DefaultUserName");
		workload.clickWorkloadMyView(driver, teamName);
		workload.clickOnMyUnitsGraph(driver);
		workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence Report");

	}

	public void verifydisabledFieldOnCardHavingLinkReason(String cardName, String linkReason, DataTable fields)
			throws Exception {
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		List<String> list = fields.asList(String.class);
		String fieldLabel;
		WebElement elField = null;
		String strCardName = cmPageHelper.getNameForCard(cardName, linkReason, CardUtility.globalEventType);
		for (int i = 1; i < list.size(); i++) { // i starts from 1 because i=0 represents the header
			fieldLabel = list.get(i);
			String fieldName = crdUtility.getElementName(strCardName, null, CardUtility.globalEventType, fieldLabel);
			if (fieldName.trim() != null) {
				elField = cmPageHelper.waitForElementToBe(By.name(fieldName), "VISIBLE", cmPageHelper.getDriver());
				Assert.assertTrue(elField != null, "Element is not displayed" + fieldLabel);
				Assert.assertTrue((elField.getAttribute("readonly").toString().equalsIgnoreCase("true")));
			}
		}

	}

	public void validateFieldsOnCard(String operationType, String form, String card, String linkReason)
			throws Exception {
		cmPageHelper.validateFieldsOnCard(operationType, "", card, linkReason);
	}

	public void userExitsWithoutSavingRecord() throws Exception {
		cmPageHelper.clickOnIndexButton(driver);
		cmPageHelper.clickOnButtonCancel(driver);
		cmPageHelper.clickOnExitWithoutSavingWarningMsgBox(driver);
	}

	public void userIsOnCardIndexScreenForACorrectIntelligenceReportCard() throws Exception {
		workload.clickIntelSubmitterTask(driver, "Correct Intelligence Report");
		workload.clickPerformButton(driver);
		workload.waitForCardToBeDisplayed(driver, "Correct intelligence report");
	}

	public void validateFieldValueInDashboardTab(String field, String value) {
		workload.validateFieldValueInDashboardTab(field, value, driver);
	}

	public void userSubmitsProcessRequestToCreateBriefingTask() throws Exception {
		cmPageHelper.clickOnButtonEventObjectSaveReturn(driver);
		cmPageHelper.clickOnButtonSubmit(driver);

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickMyViewTab(driver);
		workload.selectTabInMyView("Intelligence Report", driver);
		workload.selectURNViewTab(driver, IntelUtility.IntelRefNumber);
		// workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence
		// Report");
		Log.info(
				"User has submitted task 'Process request to create briefing' and selected the record on workload tab.");
	}

	public void userSubmitsAssessIntelligenceReportTask() throws Exception {
		cmPageHelper.clickOnButtonSubmit(driver);

		cmPageHelper.switch_To_LaunchPadModule(driver);
		workload.clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		workload.clickMyViewTab(driver);
		workload.selectTabInMyView("Intelligence Report", driver);
		workload.selectURNViewTab(driver, IntelUtility.IntelRefNumber);
		// workload.selectURN(driver, IntelUtility.IntelRefNumber, "Intelligence
		// Report");
		Log.info(
				"User has submitted task 'Process request to create briefing' and selected the record on workload tab.");
	}

	public void UserIsOnTheCardIndexOfMessages() throws Exception {

		Log.info("###################### Test started. ######################");
		driver = ConnectMobilePageHelper.setUpClient();
		ConnectMobilePageHelper.openUrl(driver);
		username = properties.getProperty("StaffMember");
		password = properties.getProperty("Password");
		ConnectMobilePageHelper.login(username, password);
		cmPageHelper.eventRoles("IntelRoles");
		// cmPageHelper.switch_To_LaunchPadModule(driver);
		// message.clickOnMessageIcon();
		Log.info("User is on Card Index screen for a 'Message'");

	}

	public void userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard() {
		cmPageHelper.clickOnButtonSubmit(driver);
		Log.info("User has submitted 'Acknowledge intelligence report' card and the reference is");

	}
}
