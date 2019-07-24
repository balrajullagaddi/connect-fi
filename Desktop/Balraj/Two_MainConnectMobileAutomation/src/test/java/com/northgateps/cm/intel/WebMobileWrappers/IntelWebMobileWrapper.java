package com.northgateps.cm.intel.WebMobileWrappers;

import com.northgateps.cm.platform.api.Utility;

import cucumber.api.DataTable;

public class IntelWebMobileWrapper {
	private final String WINDOWS = "windows";
	private IntelWebPageObject intelWebPageObject;
	private IntelMobilePageObject intelMobilePageObject;
	private final String MOBILE = "mobile";
	private IntelWindowsPageObject intelWindowsPageObject;

	public IntelWebMobileWrapper() throws Exception {
		intelWebPageObject = new IntelWebPageObject();
		intelMobilePageObject = new IntelMobilePageObject();
		intelWindowsPageObject = new IntelWindowsPageObject();
	}

	public void userIsOnCardIndexScreenForACreateIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userIsOnCardIndexScreenForACreateIntelligenceReport();
			} else {
				intelMobilePageObject.userIsOnCardIndexScreenForACreateIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForACreateIntelligenceReport();
		}
	}

	public void userClicksOnCardWithLinkReason(String cardName, String LinkReason) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userClicksOnCardWithLinkReason(cardName, LinkReason);
			} else {
				intelMobilePageObject.userClicksOnCardWithLinkReason(cardName, LinkReason);
			}
		} else {
			intelWebPageObject.userClicksOnCardWithLinkReason(cardName, LinkReason);
		}
	}

	public void userHasCompletedAllTheFieldsOnBasicDetailsCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userHasCompletedAllTheFieldsOnBasicDetailsCard();
			} else {
				intelMobilePageObject.userHasCompletedAllTheFieldsOnBasicDetailsCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnBasicDetailsCard();
		}
	}

	public void userSavesCard(String cardName) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userSavesCard(cardName);
			} else {
				intelMobilePageObject.clickOnButtonEventObjectSaveReturn(cardName);
			}
		} else {
			intelWebPageObject.clickOnButtonEventObjectSaveReturn(cardName);
		}
	}

	public void userHasCompletedAllTheFieldsOnForm(String tabName, String card, String LinkReason) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userHasCompletedAllTheFieldsOnForm(tabName, card, LinkReason);
			} else {
				intelMobilePageObject.userHasCompletedAllTheFieldsOnForm(tabName, card, LinkReason);
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnForm(tabName, card, LinkReason);
		}
	}

	public void userSetsTheFollowingCardAsNotApplicable() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userSetsTheFollowingCardAsNotApplicable();
			} else {
				intelMobilePageObject.userSetsTheFollowingCardAsNotApplicable();
			}
		} else {
			intelWebPageObject.userSetsTheFollowingCardAsNotApplicable();
		}
	}

	public void userHasCompletedAllTheFieldsOnEnquiryLogForm() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userHasCompletedAllTheFieldsOnEnquiryLogForm();
			} else {
				intelMobilePageObject.userHasCompletedAllTheFieldsOnEnquiryLogForm();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnEnquiryLogForm();
		}
	}

	public void allTheCardsOnTheCardIndexAreInFollowingStatus() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.allTheCardsOnTheCardIndexAreInFollowingStatus();
			} else {
				intelMobilePageObject.allTheCardsOnTheCardIndexAreInFollowingStatus();
			}
		} else {
			intelWebPageObject.allTheCardsOnTheCardIndexAreInFollowingStatus();
		}
	}

	public void userSubmitsCreateIntelligenceReportTaskCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userSubmitsCreateIntelligenceReportTaskCard();
			} else {
				intelMobilePageObject.userSubmitsCreateIntelligenceReportTaskCard();
			}
		} else {
			intelWebPageObject.userSubmitsCreateIntelligenceReportTaskCard();
		}
	}

	public void eventRecordSelectedInWorkloadTab() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.eventRecordSelectedInWorkloadTab();
			} else {
//				intelMobilePageObject.eventRecordSelectedInWorkloadTab();
			}
		} else {
			intelWebPageObject.eventRecordSelectedInWorkloadTab();
		}
	}

	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.eventStatusWillBeSetTo(eventStatus);
			} else {
				intelMobilePageObject.eventStatusWillBeSetTo(eventStatus);
			}
		} else {
			intelWebPageObject.eventStatusWillBeSetTo(eventStatus);
		}
	}

	public void taskHistoryEntryWillBeCreated(String taskEntry) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.taskHistoryEntryWillBeCreated(taskEntry);
			} else {
				intelMobilePageObject.taskHistoryEntryWillBeCreated(taskEntry);
			}
		} else {
			intelWebPageObject.taskHistoryEntryWillBeCreated(taskEntry);
		}
	}

	public void taskWillBeRaisedToIntelSubmitter(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.taskWillBeRaisedToIntelSubmitter(task);
			} else {
				intelMobilePageObject.taskWillBeRaisedToIntelSubmitter(task);
			}
		} else {
			intelWebPageObject.taskWillBeRaisedToIntelSubmitter(task);
		}
	}

	public void userIsOnCardIndexScreenForARequestToCreateBriefingItem() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userIsOnCardIndexScreenForARequestToCreateBriefingItem();
			} else {
				intelMobilePageObject.userIsOnCardIndexScreenForARequestToCreateBriefingItem();
			}

		} else {
			intelWebPageObject.userIsOnCardIndexScreenForARequestToCreateBriefingItem();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			} else {
				intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnRequestToCreateBriefingCard();
		}
	}

	public void userSubmitsRequestToCreateBriefingItemCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.userSubmitsRequestToCreateBriefingItemCard();
			}
		} else {
			intelWebPageObject.userSubmitsRequestToCreateBriefingItemCard();
		}
	}

	public void taskWillBeRaisedToAssessor(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.taskWillBeRaisedToAssessor(task);
			}
		} else {
			intelWebPageObject.taskWillBeRaisedToAssessor(task);
		}
	}

	public void userIsOnCardIndexScreenForAProcessRequestToCreateBriefing() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.userIsOnCardIndexScreenForAProcessRequestToCreateBriefing();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAProcessRequestToCreateBriefing();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard()
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject
						.userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnProcessRequestToCreateBriefingTaskDetailsCard();
		}
	}

	public void userSubmitsProcessRequestToCreateBriefingCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.userSubmitsProcessRequestToCreateBriefingCard();
			}
		} else {
			intelWebPageObject.userSubmitsProcessRequestToCreateBriefingCard();
		}
	}

	public void LogoutFromAnApplicationAndCloseTheBrowser() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.LogoutFromAnApplicationAndCloseTheBrowser();
			} else {
				intelMobilePageObject.LogoutFromAnApplicationAndCloseTheBrowser();
			}
		} else {
			intelWebPageObject.LogoutFromAnApplicationAndCloseTheBrowser();
		}
	}

	public void userReadTheTestDataSheetFromFile(String sheetName, String fileName) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userReadTheTestDataSheetFromFile(sheetName, WINDOWS + fileName);
			} else {
				intelMobilePageObject.userReadTheTestDataSheetFromFile(sheetName, MOBILE + fileName);
			}
		} else {
			intelWebPageObject.userReadTheTestDataSheetFromFile(sheetName, fileName);
		}
	}

	public void userReadTheTestDataForCardsOnSheetFromFile(String sheetName, String fileName) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userReadTheTestDataForCardsOnSheetFromFile(sheetName, WINDOWS + fileName);
			} else {
				intelMobilePageObject.userReadTheTestDataForCardsOnSheetFromFile(sheetName, MOBILE + fileName);
			}
		} else {
			intelWebPageObject.userReadTheTestDataForCardsOnSheetFromFile(sheetName, fileName);
		}
	}
	
	public void userHasCompletedAllTheFieldsOnTheCardWithLinkReason(String card, String LinkReason) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(card, LinkReason);
			}
			else {
				intelMobilePageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(card, LinkReason);
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(card, LinkReason);
		}
	}
	
	public void userHasCompletedRecordOnTheCardWithLinkReason(String num, String card, String LinkReason) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
//				intelWindowsPageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(num, card, LinkReason);
			}
			else {
//				intelMobilePageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(num, card, LinkReason);
			}
		} else {
			intelWebPageObject.userHasCompletedRecordOnTheCardWithLinkReason(num, card, LinkReason);
		}
	}
	
	public void userHasCompletedRecordOnFormOnCardWithLinkReason(String num, String tab, String card, String LinkReason) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
//				intelWindowsPageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(num, card, LinkReason);
			}
			else {
//				intelMobilePageObject.userHasCompletedAllTheFieldsOnTheCardWithLinkReason(num, card, LinkReason);
			}
		} else {
			intelWebPageObject.userHasCompletedRecordOnFormOnCardWithLinkReason(num, tab, card, LinkReason);
		}
	}

	public void verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(cardName, linkReason,
						fields);
			}
		} else {
			intelWebPageObject.verifyThatBelowFieldsAreMandatoryOnCardWithLinkReason(cardName, linkReason, fields);
		}
	}

	public void verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(cardName, linkReason,
						fields);
			}
		} else {
			intelWebPageObject.verifyThatBelowFieldsAreNonMandatoryOnCardWithLinkReason(cardName, linkReason, fields);
		}
	}

	public void verifyValidationMessageIsDisplayedOnCardToFillTheMandatoryFieldsWithLinkReason(String cardName,
			String fieldLabel, String linkReason) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.verifyValidationMessageIsDisplayedOnCardToFillTheMandatoryFieldsWithLinkReason(cardName,fieldLabel,linkReason);
			}
		} else {
			intelWebPageObject.verifyValidationMessageIsDisplayedOnCardToFillTheMandatoryFieldsWithLinkReason(cardName,
					fieldLabel, linkReason);
		}
	}

	public void userClicksOnCreateIntelligenceReportInWorkloadTab() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userClicksOnCreateIntelligenceReportInWorkloadTab();
			}
		} else {
			intelWebPageObject.userClicksOnCreateIntelligenceReportInWorkloadTab();
		}
	}

	public void CloseFailedTest(String LogFilePath, String ScreenshotFilePath, String TestStep, String TestName,
			Throwable throwable) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.CloseFailedTest(LogFilePath, ScreenshotFilePath, TestStep, TestName, throwable);
			} else {
				intelMobilePageObject.CloseFailedTest(LogFilePath, ScreenshotFilePath, TestStep, TestName, throwable);
			}
		} else {
			intelWebPageObject.CloseFailedTest(LogFilePath, ScreenshotFilePath, TestStep, TestName, throwable);
		}
	}

	public void userIsOnCardIndexScreenForAAssessIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				// intelMobilePageObject.userIsOnCardIndexScreenForAAssessIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAssessIntelligenceReport();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAssessIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnAssessIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnAssessIntelligenceReportCard();
		}
	}

	public void userSubmitsAssessIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userSubmitsAssessIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsAssessIntelligenceReportCard();
		}
	}

	public void taskWillBeRaisedToLinkingUnit(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.taskWillBeRaisedToLinkingUnit(task);
			}
		} else {
			intelWebPageObject.taskWillBeRaisedToLinkingUnit(task);
		}
	}

	public void userIsOnCardIndexScreenForALinkIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userIsOnCardIndexScreenForALinkIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForALinkIntelligenceReport();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnLinkIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnLinkIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnLinkIntelligenceReportCard();
		}
	}

	public void userSavesCardWithLinkReason(String arg1, String arg2) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelWindowsPageObject.userSavesCardWithLinkReason(arg1, arg2);
			} else {
				intelMobilePageObject.userSavesCardWithLinkReason(arg1, arg2);
			}
		} else {
			intelWebPageObject.userSavesCardWithLinkReason(arg1, arg2);
		}
	}

	public void userSubmitsLinkIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userSubmitsLinkIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsLinkIntelligenceReportCard();
		}
	}

	public void userIsOnCardIndexScreenForADeleteIntelligenceReportRequest() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userIsOnCardIndexScreenForADeleteIntelligenceReportRequest();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForADeleteIntelligenceReportRequest();
		}
	}

	public void userHasCompletedAllTheFieldsOnDeleteIntelligenceReportRequestCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userHasCompletedAllTheFieldsOnDeleteIntelligenceReportRequestCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnDeleteIntelligenceReportRequestCard();
		}
	}

	public void userSubmitsDeleteIntelligenceReportRequestCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userSubmitsDeleteIntelligenceReportRequestCard();
			}
		} else {
			intelWebPageObject.userSubmitsDeleteIntelligenceReportRequestCard();
		}
	}

	public void taskWillBeRaised(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.taskWillBeRaised(task);
			}
		} else {
			intelWebPageObject.taskWillBeRaised(task);
		}
	}

	public void userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequest() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				// intelMobilePageObject.userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequest();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequest();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else { // intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard();
		}
	}

	public void userSubmitsAuthoriseIntelligenceReportDeleteRequestCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {// intelMobilePageObject.userSubmitsAuthoriseIntelligenceReportDeleteRequestCard();
			}
		} else {
			intelWebPageObject.userSubmitsAuthoriseIntelligenceReportDeleteRequestCard();
		}
	}

	public void userClicksOnIndexButtonOnAssessIntelligenceReport() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				// intelMobilePageObject.userClicksOnIndexButtonOnAssessIntelligenceReport();
			}
		} else {
			intelWebPageObject.userClicksOnIndexButtonOnAssessIntelligenceReport();
		}
	}

	public void userClicksOnCancelButton() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userClicksOnCancelButton();
			}
		} else {
			intelWebPageObject.userClicksOnCancelButton();
		}
	}

	public void sensitiveEntriesOnShouldBeDisplayedAs(String Label, String Value) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.sensitiveEntriesOnShouldBeDisplayedAs(Label, Value);
			}
		} else {
			intelWebPageObject.sensitiveEntriesOnShouldBeDisplayedAs(Label, Value);
		}
	}

	public void userVerifiesFieldsAndTheValueIsOnFormOnCardWithLinkReason(String tabName, String card,
			String LinkReason) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userVerifiesFieldsAndTheValueIsOnFormOnCardWithLinkReason(tabName,
				// card, LinkReason);
			}
		} else {
			intelWebPageObject.userVerifiesFieldsAndTheValueIsOnFormOnCardWithLinkReason(tabName, card, LinkReason);
		}
	}

	public void taskWillBeRaisedToTheUnitIfTheUserDoesNotCorrectTheReportAsOnTheReSubmissionDate(String task)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.taskWillBeRaisedToTheUnitIfTheUserDoesNotCorrectTheReportAsOnTheReSubmissionDate(task);
			}
		} else {
			intelWebPageObject.taskWillBeRaisedToTheUnitIfTheUserDoesNotCorrectTheReportAsOnTheReSubmissionDate(task);
		}
	}

	public void userIsOnCardIndexScreenForAAcknowledgeUserFailureToCorrectIntelligence() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForAAcknowledgeUserFailureToCorrectIntelligence();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAcknowledgeUserFailureToCorrectIntelligence();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAcknowledgeUserFailureToCorrectIntelligenceCard()
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnAcknowledgeUserFailureToCorrectIntelligenceCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnAcknowledgeUserFailureToCorrectIntelligenceCard();
		}
	}

	public void userSubmitsAcknowledgeUserFailureToCorrectIntelligenceCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsAcknowledgeUserFailureToCorrectIntelligenceCard();
			}
		} else {
			intelWebPageObject.userSubmitsAcknowledgeUserFailureToCorrectIntelligenceCard();
		}
	}

	public void validateIintelligenceReportStatusIsNotSetTo(String eventStatus1, String eventStatus2) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.validateIintelligenceReportStatusIsNotSetTo(eventStatus1,
				// eventStatus2);
			}
		} else {
		}
	}

	public void userIsOnCardIndexScreenForADisseminateIntelligenceReportInternally() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForADisseminateIntelligenceReportInternally();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForADisseminateIntelligenceReportInternally();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnDisseminateIntelligenceReportInternallyCard(DataTable dataTable)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnDisseminateIntelligenceReportInternallyCard(dataTable);
			}
		} else {
			intelWebPageObject
					.userHasCompletedAllTheMandatoryFieldsOnDisseminateIntelligenceReportInternallyCard();
		}
	}

	public void noDisseminationMessageWouldBeSentAcrossToAnyRecipientsListedInTheTaskUntilTheIntelligenceReportIsMadeLIVEOrLIVESensitive()
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.noDisseminationMessageWouldBeSentAcrossToAnyRecipientsListedInTheTaskUntilTheIntelligenceReportIsMadeLIVEOrLIVESensitive();
			}
		} else {
			intelWebPageObject
					.noDisseminationMessageWouldBeSentAcrossToAnyRecipientsListedInTheTaskUntilTheIntelligenceReportIsMadeLIVEOrLIVESensitive();
		}
	}

	public void userIsOnCardIndexScreenForACorrectIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForACorrectIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForACorrectIntelligenceReport();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnCorrectIntelligenceReportCard(DataTable dataTable)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnCorrectIntelligenceReportCard(dataTable);
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnCorrectIntelligenceReportCard(dataTable);
		}
	}

	public void userSubmitsTheCorrectIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsTheCorrectIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsTheCorrectIntelligenceReportCard();
		}
	}

	public void linkIntelligenceReportTaskWillBeRaised() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.linkIntelligenceReportTaskWillBeRaised();
			}
		} else {
			intelWebPageObject.linkIntelligenceReportTaskWillBeRaised();
		}
	}

	public void userSubmitsTheAssessIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsTheAssessIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsTheAssessIntelligenceReportCard();
		}
	}

	public void performReviewOfCodeCTaskWillBeRaisedAfterCodeCNextReviewDate() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.performReviewOfCodeCTaskWillBeRaisedAfterCodeCNextReviewDate();
			}
		} else {
			intelWebPageObject.performReviewOfCodeCTaskWillBeRaisedAfterCodeCNextReviewDate();
		}
	}

	public void disseminationMessageWouldBeSentAcrossToAllRecipientsListedInTheTask() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.disseminationMessageWouldBeSentAcrossToAllRecipientsListedInTheTask();
			}
		} else {
			intelWebPageObject.disseminationMessageWouldBeSentAcrossToAllRecipientsListedInTheTask();
		}
	}

	public void userHasCompletedAllTheFieldsOnLocationCard(DataTable dataTable) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheFieldsOnLocationCard(dataTable);
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnLocationCard(dataTable);
		}
	}

	public void userIsOnCardIndexScreenForAAcknowledgeIntelligenceReportReturnedOrDeleted() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForAAcknowledgeIntelligenceReportReturnedOrDeleted();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAcknowledgeIntelligenceReportReturnedOrDeleted();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAcknowledgeIntelligenceReportReturnedOrDeleted()
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
			else {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnAcknowledgeIntelligenceReportReturnedOrDeleted();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnAcknowledgeIntelligenceReportReturnedOrDeleted();
		}
	}

	public void userSelectsMyViewTabOnWorkloadScreen() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
			else {
//				 intelMobilePageObject.userSelectsMyViewTabOnWorkloadScreen();
			}
		} else {
			intelWebPageObject.userSelectsRecordInMyViewTabOnWorkloadScreen();

		}
	}

	

	public void userHasCompletedAllTheFieldsOnVehicleCard(DataTable dataTable) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				
			}
			else {
				// intelMobilePageObject.userHasCompletedAllTheFieldsOnVehicleCard(dataTable);
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnVehicleCard(dataTable);
		}
	}

	public void userIsOnCardIndexScreenForAUserIntiatedTaskDuplicateIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForAUserIntiatedTaskDuplicateIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAUserIntiatedTaskDuplicateIntelligenceReport();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnDuplicateIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnDuplicateIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnDuplicateIntelligenceReportCard();
		}
	}

	public void userSubmitsDuplicateIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsDuplicateIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsDuplicateIntelligenceReportCard();
		}
	}

	public void userIsDisplayedWithANewURN() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsDisplayedWithANewURN();
			}
		} else {
			intelWebPageObject.userIsDisplayedWithANewURN();
		}
	}

	public void eventStatusOfNewlyCreatedIntelWillBeShownAs(String eventStatus) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.eventStatusOfNewlyCreatedIntelWillBeShownAs(eventStatus);
			}
		} else {
			intelWebPageObject.eventStatusOfNewlyCreatedIntelWillBeShownAs(eventStatus);
		}
	}

	public void forTheTaskOfANewIntelligenceReportWillBeTheDateOnWhichDuplicateIntelligenceReportTaskIsPerformedOnTheSourceIntelligenceReport(
			String arg1) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.forTheTaskOfANewIntelligenceReportWillBeTheDateOnWhichDuplicateIntelligenceReportTaskIsPerformedOnTheSourceIntelligenceReport();
			}
		} else {
			System.out.println("insert web code here..!!!");
		}
	}

	public void noLinksShouldBeCreatedBetweenTheExistingIntelReportAndTheNewlyCreatedOnes() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.noLinksShouldBeCreatedBetweenTheExistingIntelReportAndTheNewlyCreatedOnes();
			}
		} else {
			intelWebPageObject.noLinksShouldBeCreatedBetweenTheExistingIntelReportAndTheNewlyCreatedOnes();
		}
	}

	public void noneOfTheObjectsLinkedToTheOriginalIntelReportShouldBeCopiedOverToTheNewlyCreatedReport()
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.noneOfTheObjectsLinkedToTheOriginalIntelReportShouldBeCopiedOverToTheNewlyCreatedReport();
			}
		} else {
			intelWebPageObject
					.noneOfTheObjectsLinkedToTheOriginalIntelReportShouldBeCopiedOverToTheNewlyCreatedReport();
		}
	}

	public void userOpenNewURN() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userOpenNewURN();
			}
		} else {
			System.out.println("insert web code here..!!!");
		}
	}

	public void userIsOnCardIndexScreenForAUserIntiatedTaskTransferIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForAUserIntiatedTaskTransferIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAUserIntiatedTaskTransferIntelligenceReport();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnTransferIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnTransferIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnTransferIntelligenceReportCard();
		}
	}

	public void userSubmitsTransferIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsTransferIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsTransferIntelligenceReportCard();
		}
	}

	public void userIsOnCardIndexScreenForARegisterInterestInIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForARegisterInterestInIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForARegisterInterestInIntelligenceReportCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnRegisterInterestInIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnRegisterInterestInIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnRegisterInterestInIntelligenceReportCard();
		}
	}

	public void userSubmitsRegisterInterestInIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsRegisterInterestInIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsRegisterInterestInIntelligenceReportCard();
		}
	}

	public void taskWillBeRaisedToStaffMember(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.taskWillBeRaisedToStaffMember(task);
			}
		} else {
			intelWebPageObject.taskWillBeRaisedToStaffMember(task);
		}
	}

	public void userHasCompletedAllTheFieldsOnOrganisationCard(DataTable dataTable) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheFieldsOnOrganisationCard(dataTable);
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnOrganisationCard(dataTable);
		}
	}

	public void userIsOnCardIndexScreenForARemoveInterestInIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForARemoveInterestInIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForARemoveInterestInIntelligenceReportCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnRemoveInterestInIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnRemoveInterestInIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnRemoveInterestInIntelligenceReportCard();
		}
	}

	public void userSubmitsRemoveInterestInIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsRemoveInterestInIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userSubmitsRemoveInterestInIntelligenceReportCard();
		}
	}

	public void taskWillBeRemovedFromWorkloadOf(String task, String arg2) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.taskWillBeRemovedFromWorkloadOfStaffMember(task, arg2);
			}
		} else {
			intelWebPageObject.taskWillBeRemovedFromWorkloadOf(task, arg2);
		}
	}

	public void performReviewOfCodeCTaskShouldBeRaisedOnTheSelectedCodeCNextReviewDate() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.performReviewOfCodeCTaskShouldBeRaisedOnTheSelectedCodeCNextReviewDate();
			}
		} else {
			intelWebPageObject.performReviewOfCodeCTaskShouldBeRaisedOnTheSelectedCodeCNextReviewDate();
		}
	}

	public void userIsOnCardIndexScreenForAPerformAdHocReviewOfCodeC() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForAPerformAdHocReviewOfCodeC();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAPerformAdHocReviewOfCodeC();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnPerformAdHocReviewOfCodeCCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnPerformAdHocReviewOfCodeCCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnPerformAdHocReviewOfCodeCCard();
		}
	}

	public void userSubmitsPerformAdHocReviewOfCodeCCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userSubmitsPerformAdHocReviewOfCodeCCard()
			}
		} else {
			intelWebPageObject.userSubmitsPerformAdHocReviewOfCodeCCard();
		}
	}

	public void performReviewOfCodeCTaskShouldNowBeRaisedOnTheNewCodeCNextReviewDateSelectedAbove() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.performReviewOfCodeCTaskShouldNowBeRaisedOnTheNewCodeCNextReviewDateSelectedAbove();
			}
		} else {
			intelWebPageObject.performReviewOfCodeCTaskShouldNowBeRaisedOnTheNewCodeCNextReviewDateSelectedAbove();
		}
	}

	public void userIsOnCardIndexScreenForAAppendInformationToIntelligenceReport() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userIsOnCardIndexScreenForAAppendInformationToIntelligenceReport();
			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAppendInformationToIntelligenceReport();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAppendInformationToIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				// intelMobilePageObject.userHasCompletedAllTheMandatoryFieldsOnAppendInformationToIntelligenceReportCard();
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnAppendInformationToIntelligenceReportCard();
		}
	}

	public void userSubmitsAppendInformationToIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userSubmitsAppendInformationToIntelligenceReportCard();
		}
	}

	public void intelligenceFieldOnIntelligenceFormWillGetAppendedWithEnteredTextInAppendInformationToIntelligenceReportTask()
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject
					.intelligenceFieldOnIntelligenceFormWillGetAppendedWithEnteredTextInAppendInformationToIntelligenceReportTask();
		}
	}

	public void userIsOnCardIndexScreenForADeleteIntelligenceReportRequestCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForADeleteIntelligenceReportRequestCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnDeleteIntelligenceReportRequestCard(DataTable dataTable)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnDeleteIntelligenceReportRequestCard(dataTable);
		}
	}

	public void taskWillBeRaisedTo(String arg1, String arg2) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {

		}
	}

	public void userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequestCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAuthoriseIntelligenceReportDeleteRequestCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard(DataTable dataTable)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject
					.userHasCompletedAllTheMandatoryFieldsOnAuthoriseIntelligenceReportDeleteRequestCard(dataTable);
		}
	}

	public void clicksOnSaveForLater() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.clicksOnSaveForLater();
		}
	}

	public void userIsOnCardIndexScreenForACompleteIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForACompleteIntelligenceReportCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnCompleteIntelligenceReportCard(DataTable dataTable)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnCompleteIntelligenceReportCard(dataTable);
		}
	}

	public void userSubmitsCompleteIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userSubmitsCompleteIntelligenceReportCard();
		}
	}

	public void userIsOnCardIndexScreenForAAcknowledgeRejectionOfRequestToCreateBriefingCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAAcknowledgeRejectionOfRequestToCreateBriefingCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnAcknowledgeRejectionOfRequestToCreateBriefingCard(
			DataTable dataTable) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnAcknowledgeRejectionOfRequestToCreateBriefingCard(
					dataTable);
		}
	}

	public void userSubmitsAcknowledgeRejectionOfRequestToCreateBriefingCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userSubmitsAcknowledgeRejectionOfRequestToCreateBriefingCard();
		}
	}

	public void userIsOnCardIndexScreenForAReassessIntelligenceReportSensitivityCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForAReassessIntelligenceReportSensitivityCard();
		}
	}

	public void userHasCompletedAllTheMandatoryFieldsOnReassessIntelligenceReportSensitivityCard(DataTable dataTable)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject
					.userHasCompletedAllTheMandatoryFieldsOnReassessIntelligenceReportSensitivityCard(dataTable);
		}
	}

	public void userSubmitsReassessIntelligenceReportSensitivityCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userSubmitsReassessIntelligenceReportSensitivityCard();
		}
	}

	public void userIsOnCardIndexScreenForACorrectIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userIsOnCardIndexScreenForACorrectIntelligenceReportCard();
		}
	}

	public void verifydisabledFieldOnCardHavingLinkReason(String cardName, String linkReason, DataTable fields)
			throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.verifydisabledFieldOnCardHavingLinkReason(cardName, linkReason, fields);
		}
	}

	public void validateFieldsOnCard(String operationType, String card, String linkReason) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.validateFieldsOnCard(operationType, "", card, linkReason);
		}
	}

	public void userExitsWithoutSavingRecord() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userExitsWithoutSavingRecord();
		}
	}

	public void validateFieldsOnFormOnCardWithLinkReason(String operationType, String form, String card,
			String linkReason) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.validateFieldsOnFormOnCardWithLinkReason(operationType, form, card, linkReason);
		}
	}

	public void userSubmitsCorrectIntelligenceReportCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userSubmitsCorrectIntelligenceReportCard();
		}
	}

	public void validateFieldValueInDashboardTab(String field, String value) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.validateFieldValueInDashboardTab(field, value);
		}
	}

	public void user_has_completed_field_and_the_value_supplied_is_on_card_with_Link_Reason(String strFieldName,
			String strValue, String strCard, String strLinkReason) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.user_has_completed_field_and_the_value_supplied_is_on_card_with_Link_Reason(strFieldName,
					strValue, strCard, strLinkReason);
		}

	}

	public void user_has_completed_all_the_mandatory_fields_on_Intelligence_card() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.user_has_completed_all_the_mandatory_fields_on_Intelligence_card();
		}
	}

	public void userHasCompletedAllTheFieldsOnTagsAndTensionLevelsCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.userHasCompletedAllTheFieldsOnTagsAndTensionLevelsCard();
		}
	}

	public void user_is_on_Card_Index_screen_for_a_Correct_Intelligence_Report() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.user_is_on_Card_Index_screen_for_a_Correct_Intelligence_Report();
		}
	}

	public void verify_that_below_fields_are_disabled_on_card_having_Link_Reason(String cardName, String linkReason,
			DataTable fields) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.verify_that_below_fields_are_disabled_on_card_having_Link_Reason(cardName, linkReason,
					fields);
		}
	}

	public void validate_fields_on_card_with_Link_Reason(String operationType, String card, String linkReason)
			throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.validate_fields_on_card_with_Link_Reason(operationType, card, linkReason);
		}
	}

	public void user_exits_without_saving_record() throws Throwable {

		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.user_exits_without_saving_record();
		}
	}

	public void validate_is_set_to_in_Dashboard_tab(String field, String value) throws Throwable {

		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.validate_is_set_to_in_Dashboard_tab(field, value);
		}
	}

	public void intelligenceReportStatusIsNotOr(String eventStatus1, String eventStatus2) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			}
		} else {
			intelWebPageObject.intelligenceReportStatusIsNotOr(eventStatus1, eventStatus2);
		}
	}


	public void userSubmitsProcessRequestToCreateBriefingTask() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				intelMobilePageObject.userSubmitsProcessRequestToCreateBriefingCard();
			}
		} else {
			intelWebPageObject.userSubmitsProcessRequestToCreateBriefingTask();
		}
	}

	public void userSubmitsAssessIntelligenceReportTask() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.userSubmitsAssessIntelligenceReportTask();
		}
	}

	public void NotificationinMessageRecievedInMessageTab(String subName) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.NotificationinMessageRecievedInMessageTab(subName);
		}
		
	}

	public void userSubmitsDisseminateIntelligenceReportInternalCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.userSubmitsDisseminateIntelligenceReportInternalCard();
		}
		
	}

	public void validateFromFieldInNotificationMsg() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.validateFromFieldInNotificationMsg();
		}
		
	}

	public void validatePrepopulatedFieldInNotificationMsg(String strOperation, String tabName) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.validatePrepopulatedFieldInNotificationMsg(strOperation,tabName);
		}
	}


	public void UserIsOnTheCardIndexOfMessages() throws Exception {

		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.UserIsOnTheCardIndexOfMessages();
		}
		
	}

	public void userClicksOnCloseButton() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.userClicksOnCloseButton();
		}
	}


	public void userHasCompletedAllTheMandatoryFieldsOnDisseminateIntelligenceReportInternallyCard() throws Exception {

		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
			}
		} else {
			intelWebPageObject.userHasCompletedAllTheMandatoryFieldsOnDisseminateIntelligenceReportInternallyCard();
		}
		
	}
	
	
	
	public void userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {

			} else {
				intelMobilePageObject.userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard();
			}
		} else {
			intelWebPageObject.userSubmitsAcknowledgeIntelligenceReportReturnedOrDeletedCard();
		}
	}

}