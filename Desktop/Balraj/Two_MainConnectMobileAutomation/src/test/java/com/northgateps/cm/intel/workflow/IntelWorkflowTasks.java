package com.northgateps.cm.intel.workflow;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class IntelWorkflowTasks {
	private static ConnectMobilePageHelper cmPageHelper;
	CardUtility cardUtility;

	public IntelWorkflowTasks() throws Exception {
		cmPageHelper = new ConnectMobilePageHelper();
		cardUtility = new CardUtility();
	}

	public void clickOnRequestToCreateBriefingCard() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Request to create briefing");
	}

	public void clickOnProcessRequestToCreateBriefingCard() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Process request to create briefing");
	}

	public void clickOnAcknowledgeFailureToCorrect() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Acknowledge user failure to correct intelligence report");
	}

	public void clickOnDisseminateIntelReport() throws InterruptedException {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Disseminate intelligence report internally");
		Thread.sleep(5000);
	}

	public void clickOnCorrectIntelReport() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Correct intelligence report");
	}

	public void clickOnAssessIntelReport() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Assess intelligence report");
	}

	public void clickOnLinkIntelReport() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Link intelligence report");
	}

	public void clickOnPerformAdHocReviewOfCodeC() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Perform ad hoc review of Code C");
	}

	public void clickOnAppendInfoToIntelReport() throws InterruptedException {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Append information to intelligence report");
		Thread.sleep(5000);
	}

	public void clickOnCompleteIntelReport() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Complete intelligence report");
	}

	public void clickOnAcknowledgeRejectionRequest() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Acknowledge rejection of request to create briefing");
	}

	// Naman
	public void clickOnAcknowledgeIntelligenceReportReturnedDeleted() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Acknowledge intelligence report returned or deleted");
	}

	// Naman
	public void clickOnDuplicateIntelligenceReport() {
		cmPageHelper.findAction();
		cmPageHelper.clickOnEventCardName("Duplicate intelligence report");
	}

	// pushpa
	public void clickORegisterInterestInIntelligenceReport() {
		cmPageHelper.findAction();
		cmPageHelper.clickOnEventCardName("Register interest in intelligence report");
	}

	public void clickOnTransferIntelligenceReport() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Transfer intelligence report");
	}

	public void clickOnRemoveInterestInIntelligenceReport() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Remove registered interest in intelligence report");
	}

	// pushpa

	public void clickOnDeleteIntelligenceReportRequest() {
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
		cmPageHelper.clickOnEventCardName("Delete Intelligence Report Request");
	}

	// Upasna
	public void clickOnIntelligenceCard() throws InterruptedException {
		cmPageHelper.clickOnEventCardName("Intelligence");
		Thread.sleep(5000);
	}

	public void clickOnIntelligenceSummary() {
		cmPageHelper.clickOnEventCardName("Intelligence summary");
	}
}