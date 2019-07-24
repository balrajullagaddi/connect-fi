package com.northgateps.cm.cases.common;

// utility functions for case event

import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

public class CaseUtility {

	private static ConnectMobilePageHelper cmPageHelper;
	public static String CaseRefNumber = "";

	public CaseUtility() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
		cmPageHelper = new ConnectMobilePageHelper();
	}

	public void clickOnCreatePrechargeCaseIcon() throws InterruptedException {
		cmPageHelper.clickIcon("Create Precharge Case");
		Thread.sleep(30000);
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
	}

	public void clickOnCreatePrechargeCaseCard() {
		cmPageHelper.clickOnEventCardName("Create Precharge Case");
	}

	public void clickOnCasedetailsCard() {
		cmPageHelper.clickOnEventCardName("Case details");
	}

	public void clickOnDefendantCard() {
		cmPageHelper.clickOnEventCardName("Defendant");
	}

	public void clickOnPublicwitnessCard() {
		cmPageHelper.clickOnEventCardName("Public witness");
	}

	public void clickOnProfessionalExpertWitnessCard() {
		cmPageHelper.clickOnEventCardName("Professional Expert Witness");
	}

	public void setCaseRef(String CaseRef) {
		CaseRefNumber = CaseRef;
	}

	public void clickOnCreateCaseIcon() {
		if (Utility.configFileName.equalsIgnoreCase("WMP"))
			cmPageHelper.clickIcon("Create Case");
		else if (Utility.configFileName.equalsIgnoreCase("MET"))
			cmPageHelper.clickIcon("Prepare Case");
		cmPageHelper.findAction();
		cmPageHelper.findEvent();
	}

	public void clickOnSendForPreChargeDecisionCard() {
		cmPageHelper.clickOnEventCardName("Send for Pre Charge Decision");
	}

	public void clickOnPreChargeDecisionReviewCard() {
		cmPageHelper.clickOnEventCardName("Pre Charge Decision Review");
	}

	public void clickOnPreChargeDecisionCard() {
		cmPageHelper.clickOnEventCardName("Pre Charge Decision");
	}

	public void clickOnNewCMTReviewCard() {
		cmPageHelper.clickOnEventCardName("New CMT Review");
	}

	public void clickOnCMTTriageReviewCard() {
		cmPageHelper.clickOnEventCardName("CMT Triage Review");
	}

	public void clickOnPoliceWitnessesCard() {
		cmPageHelper.clickOnEventCardName("Police Witnesses");
	}

	public void clickOnResolvePreChargeActionCard() {
		cmPageHelper.clickOnEventCardName("Resolve Pre Charge Action");
	}

	public void clickOnAllocateDMCard() {
		cmPageHelper.clickOnEventCardName("Allocate DM");
	}

	public void clickOnVictimOrganisationCard() {
		cmPageHelper.clickOnEventCardName("Victim Organisation");
	}

	public void clickOnDefendantOrganisationCard() {
		cmPageHelper.clickOnEventCardName("Defendant Organisation");
	}

	public void clickOnRegisterForUpdateCard() {
		cmPageHelper.clickOnEventCardName("Register for update");
	}

	public void clickOnCMTDMReviewCard() {
		cmPageHelper.clickOnEventCardName("CMT DM Review");
	}

	public void clickOnPendingPreChargeReviewCard() {
		cmPageHelper.clickOnEventCardName("Pending Pre Charge Review");
	}

	public void clickOnAwaitingPreChargeDecisionResultsCard() {
		cmPageHelper.clickOnEventCardName("Awaiting Pre Charge Decision Results");
	}
}