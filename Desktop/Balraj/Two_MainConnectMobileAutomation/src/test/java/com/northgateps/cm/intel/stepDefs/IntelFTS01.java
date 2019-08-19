package com.northgateps.cm.intel.stepDefs;

import com.northgateps.cm.intel.WebMobileWrappers.IntelWebMobileWrapper;
import com.northgateps.cm.investigation.WebMobileWrappers.InvWebMobileWrapper;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IntelFTS01 {
	private String LogFilePath = "target/EaG_Log";
	private String TestName = "Intel_FTS";
	private IntelWebMobileWrapper intelWebMobileWrapper;
	
	

	public IntelFTS01() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
		intelWebMobileWrapper = new IntelWebMobileWrapper();
		
	}

	@Before
	
	
	
	@Given("^User is on Card Index screen for a 'Create intelligence report'$")
	public void userIsOnCardIndexScreenForACreateIntelligenceReport() throws Exception {
		try {
			intelWebMobileWrapper.userIsOnCardIndexScreenForACreateIntelligenceReport();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	
	@After
	
	@Then("^Logout from an application and close the browser$")
	public void LogoutFromAnApplicationAndCloseTheBrowser() throws Exception {
	try {
		intelWebMobileWrapper.LogoutFromAnApplicationAndCloseTheBrowser();
	} catch (Exception e) {
		intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
	} catch (AssertionError e) {
		intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
	}
}
	

	@When("^User clicks on \"(.*?)\" card with Link Reason \"(.*?)\"$")
	public void userClicksOnCardWithLinkReason(String cardName, String LinkReason) throws Exception {
		try {
			intelWebMobileWrapper.userClicksOnCardWithLinkReason(cardName, LinkReason);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	//Location added from IntelFTS05
	
	@When("^User has completed all the fields on the \"(.*?)\" card with Link Reason \"(.*?)\"$")
	public void userHasCompletedAllTheFieldsOnTheCardWithLinkReason(String card, String LinkReason) throws Exception {
		try {
			intelWebMobileWrapper.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(card, LinkReason);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, 
					e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, 
					e.fillInStackTrace());
		}
	}

	//Location from IntelFTS02
	
	@When("^User saves \"(.*?)\" card with Link Reason \"(.*?)\"$")
	public void userSavesCardWithLinkReason(String arg1, String arg2) throws Exception {
		try {
			intelWebMobileWrapper.userSavesCardWithLinkReason(arg1, arg2);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest( LogFilePath, LogFilePath, "", TestName, e);
		}
		catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest( LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	@When("^User has completed all the fields on 'Basic Details' card$")
	public void userHasCompletedAllTheFieldsOnBasicDetailsCard() throws Exception {
		try {
			intelWebMobileWrapper.userHasCompletedAllTheFieldsOnBasicDetailsCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User saves \"(.*?)\" card$")
	public void userSavesCard(String cardName) throws Exception {
		try {
			intelWebMobileWrapper.userSavesCard(cardName);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User has completed all the fields on \"(.*?)\" form on \"(.*?)\" card with Link Reason \"(.*?)\"$")
	public void userHasCompletedAllTheFieldsOnForm(String tabName, String card, String LinkReason) throws Exception {
		try {
			intelWebMobileWrapper.userHasCompletedAllTheFieldsOnForm(tabName, card, LinkReason);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User sets the following card as 'Not Applicable'$")
	public void userSetsTheFollowingCardAsNotApplicable() throws Exception {
		try {
			intelWebMobileWrapper.userSetsTheFollowingCardAsNotApplicable();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User has completed all the fields on 'Enquiry log' card$")
	public void userHasCompletedAllTheFieldsOnEnquiryLogForm() throws Exception {
		try {
			intelWebMobileWrapper.userHasCompletedAllTheFieldsOnEnquiryLogForm();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^All the cards on the card index are in following status$")
	public void allTheCardsOnTheCardIndexAreInFollowingStatus() throws Exception {
		try {
			intelWebMobileWrapper.allTheCardsOnTheCardIndexAreInFollowingStatus();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User submits 'Create intelligence report task' card$")
	public void userSubmitsCreateIntelligenceReportTaskCard() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsCreateIntelligenceReportTaskCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^Event record selected in workload tab$")
	public void eventRecordSelectedInWorkloadTab() throws Exception {
		try {
			intelWebMobileWrapper.eventRecordSelectedInWorkloadTab();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^Event status will be set to \"(.*?)\"$")
	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		try {
			intelWebMobileWrapper.eventStatusWillBeSetTo(eventStatus);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^Task history entry \"(.*?)\" will be created$")
	public void taskHistoryEntryWillBeCreated(String taskEntry) throws Exception {
		try {
			intelWebMobileWrapper.taskHistoryEntryWillBeCreated(taskEntry);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@Then("^\"(.*?)\" task will be raised to 'Intel Submitter'$")
	public void taskWillBeRaisedToIntelSubmitter(String task) throws Exception {
		try {
			intelWebMobileWrapper.taskWillBeRaisedToIntelSubmitter(task);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User is on Card Index screen for a 'Request to create briefing item'$")
	public void userIsOnCardIndexScreenForARequestToCreateBriefingItem() throws Exception {
		try {
			intelWebMobileWrapper.userIsOnCardIndexScreenForARequestToCreateBriefingItem();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User has completed all the mandatory fields on 'Request to create briefing' card$")
	public void userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard() throws Exception {
		try {
			intelWebMobileWrapper.userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User submits 'Request to create briefing item' card$")
	public void userSubmitsRequesToCreateBriefingItemCard() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsRequestToCreateBriefingItemCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@Then("^\"(.*?)\" task will be raised to 'Assessor'$")
	public void taskWillBeRaisedToAssessor(String task) throws Exception {
		try {
			intelWebMobileWrapper.taskWillBeRaisedToAssessor(task);
			;
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User is on Card Index screen for a 'Process request to create briefing'$")
	public void userIsOnCardIndexScreenForAProcessRequestToCreateBriefing() throws Exception {
		try {
			intelWebMobileWrapper.userIsOnCardIndexScreenForAProcessRequestToCreateBriefing();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User has completed all the mandatory fields on 'Process request to create briefing task details' card$")
	public void userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard()
			throws Exception {
		try {
			intelWebMobileWrapper
					.userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User submits 'Process request to create briefing' card$")
	public void userSubmitsProcessRequestToCreateBriefingCard() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsProcessRequestToCreateBriefingCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
//Logout
//	@Then("^Logout from an application and close the browser$")
	//		public void LogoutFromAnApplicationAndCloseTheBrowser() throws Exception {
	//try {
	//	intelWebMobileWrapper.LogoutFromAnApplicationAndCloseTheBrowser();
	//} catch (Exception e) {
	//	intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
	//} catch (AssertionError e) {
	//	intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
	//}
	//}

	@When("^User read the test data sheet \"(.*?)\" from file \"(.*?)\"$")
	public void userReadTheTestDataSheetFromFile(String sheetName, String fileName) throws Throwable {
		try {
			intelWebMobileWrapper.userReadTheTestDataSheetFromFile(sheetName, fileName);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User read the test data for cards on sheet \"(.*?)\" from file \"(.*?)\"$")
	public void userReadTheTestDataForCardsOnSheetFromFile(String sheetName, String fileName) throws Throwable {
		try {
			intelWebMobileWrapper.userReadTheTestDataForCardsOnSheetFromFile(sheetName, fileName);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^Verify that below fields are mandatory on card \"([^\"]*)\" with Link Reason \"([^\"]*)\"$")
	public void verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		try {
			intelWebMobileWrapper.verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(cardName, linkReason, fields);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	// Scenario3
	@When("^Verify that below fields are non-mandatory on card \"([^\"]*)\" with Link Reason \"([^\"]*)\"$")
	public void verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		try {
			intelWebMobileWrapper.verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(cardName, linkReason,
					fields);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User has completed \"([^\"]*)\" field and the value supplied is \"([^\"]*)\" on card \"([^\"]*)\" with Link Reason \"([^\"]*)\"$")
	public void user_has_completed_field_and_the_value_supplied_is_on_card_with_Link_Reason(String strFieldName,
			String strValue, String strCard, String strLinkReason) throws Throwable {
		try {
			intelWebMobileWrapper.user_has_completed_field_and_the_value_supplied_is_on_card_with_Link_Reason(
					strFieldName, strValue, strCard, strLinkReason);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^Verify validation message is displayed on card \"([^\"]*)\" to fill the mandatory fields \"([^\"]*)\" with Link Reason \"([^\"]*)\"$")
	public void verifyValidationMessageIsDisplayedOnCardToFillTheMandatoryFieldsWithLinkReason(String cardName,
			String fieldLabel, String linkReason) throws Throwable {
		try {
			intelWebMobileWrapper.verifyValidationMessageIsDisplayedOnCardToFillTheMandatoryFieldsWithLinkReason(
					cardName, fieldLabel, linkReason);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@And("^User clicks on 'Create intelligence report' on Start Launch Pad$")
	public void userClicksOnCreateIntelligenceReportInWorkloadTab() throws Throwable {
		try {
			intelWebMobileWrapper.userClicksOnCreateIntelligenceReportInWorkloadTab();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^Notification message \"(.*?)\" recieved in Message tab$")
	public void NotificationinMessageRecievedInMessageTab(String subName) throws Exception {
		try {
			intelWebMobileWrapper.NotificationinMessageRecievedInMessageTab(subName);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User submits 'Process request to create briefing task'$")
	public void userSubmitsProcessRequestToCreateBriefingTask() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsProcessRequestToCreateBriefingTask();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	
	@And("^User submits 'Disseminate intelligence report internally' card$")
	public void userSubmitsDisseminateIntelligenceReportInternallyCard() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsDisseminateIntelligenceReportInternalCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	
	@Then("^Validate 'From' field in the 'view message' tab$")
	public void validateFromFieldInNotificationMsg() throws Exception {
		try {
			intelWebMobileWrapper.validateFromFieldInNotificationMsg();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	
	@And("^Validate \"(.*?)\" fields on card \"(.*?)\" tab$")
	public void validatePrepopulatedFieldInNotificationMsg(String strOperation,String tabName) throws Exception {
		try {
			intelWebMobileWrapper.validatePrepopulatedFieldInNotificationMsg(strOperation,tabName);
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}

	@When("^User submits the 'Assess Intelligence Report task'$")
	public void userSubmitsAssessIntelligenceReportTask() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsAssessIntelligenceReportTask();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	
	@When("^User is on Card Index screen for a 'Messages'$")
	public void UserIsOnTheCardIndexOfMessages() throws Exception {
		try {
			intelWebMobileWrapper.UserIsOnTheCardIndexOfMessages();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
	
	@When("^User submits 'Acknowledge intelligence report returned or deleted' card$")
	public void userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard() throws Exception {
		try {
			intelWebMobileWrapper.userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard();
		} catch (Exception e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e);
		} catch (AssertionError e) {
			intelWebMobileWrapper.CloseFailedTest(LogFilePath, LogFilePath, "", TestName, e.fillInStackTrace());
		}
	}
}