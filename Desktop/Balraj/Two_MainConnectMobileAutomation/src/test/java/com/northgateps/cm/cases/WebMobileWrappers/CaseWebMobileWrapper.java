package com.northgateps.cm.cases.WebMobileWrappers;

import com.northgateps.cm.platform.api.Utility;

public class CaseWebMobileWrapper {
	private CaseWebPageObject caseWebPageObject;
	private CaseMobilePageObject caseMobilePageObject;
	private final String MOBILE = "mobile";
	private final String WINDOWS = "windows";
	private CaseWindowsPageObject caseWindowsPageObject;

	public CaseWebMobileWrapper() throws Exception {
		caseWebPageObject = new CaseWebPageObject();
		caseWindowsPageObject = new CaseWindowsPageObject();
		caseMobilePageObject = new CaseMobilePageObject();
	}

	public void userIsOnCardIndexScreenForACreatePrechargeCase() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userIsOnCardIndexScreenForACreatePrechargeCase();
			} else {
				caseMobilePageObject.userIsOncardIndexScreenForACreatePrechargeCase();
			}
		} else {
			caseWebPageObject.userIsOnCardIndexScreenForACreatePrechargeCase();
		}
	}

	public void userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard();
			} else {
				caseMobilePageObject.userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard();
			}
		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnCreatePrechargeCaseCard();
		}
	}

	public void userHasCompletedAllTheFieldsOnCaseDetailsCard() throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userHasCompletedAllTheFieldsOnCaseDetailsCard();
			} else {
				caseMobilePageObject.userHasCompletedAllTheFieldsOnCaseDetailsCard();
			}
		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnCaseDetailsCard();
		}

	}

	public void userSubmitsCreatePrechargeCaseCard() throws Throwable {
		{
			if (Utility.platform.equalsIgnoreCase(MOBILE)) {
				if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
					caseWindowsPageObject.userSubmitsCreatePrechargeCaseCard();
				} else {
					caseMobilePageObject.userSubmitsCreatePrechargeCaseCard();
				}
			} else {
				caseWebPageObject.userSubmitsCreatePrechargeCaseCard();
			}
		}
	}

	public void taskWillBeRaisedToOwningUnit(String task) throws Exception {
		{
			if (Utility.platform.equalsIgnoreCase(MOBILE)) {
				if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
					caseWindowsPageObject.taskWillBeRaisedToOwningUnit(task);
				} else {
				caseMobilePageObject.taskWillBeRaisedToOwningUnit(task);
				}
			} else {
				caseWebPageObject.taskWillBeRaisedToOwningUnit(task);
			}
		}

	}

	public void caseRecordSelectedInWorkloadTab() throws Throwable {
		{
			if (Utility.platform.equalsIgnoreCase(MOBILE)) {
				caseMobilePageObject.caseRecordSelectedInWorkloadTab();
			} else {
				caseWebPageObject.caseRecordSelectedInWorkloadTab();
			}
		}

	}

	public void caseRecordSelectedInMyViewTab() throws Throwable {
		{
			if (Utility.platform.equalsIgnoreCase(MOBILE)) {
				if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
					caseWindowsPageObject.caseRecordSelectedInMyViewTab();
				} else {
					caseMobilePageObject.caseRecordSelectedInMyViewTab();
				}
			} else {
				caseWebPageObject.caseRecordSelectedInMyViewTab();
			}
		}

	}

	public void eventStatusWillBeSetTo(String eventStatus) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.eventStatusWillBeSetTo(eventStatus);
			} else {

				caseMobilePageObject.eventStatusWillBeSetTo(eventStatus);
			}
		} else {
			caseWebPageObject.eventStatusWillBeSetTo(eventStatus);
		}
	}

	public void userIsOnCardIndexScreenForASubmitForPrechargeDecision() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {
			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userIsOnCardIndexScreenForASubmitForPrechargeDecision();
			} else {
//				caseMobilePageObject.userIsOnCardIndexScreenForASubmitForPrechargeDecision();
			}
		} else {
			caseWebPageObject.userIsOnCardIndexScreenForASubmitForPrechargeDecision();
		}
	}

	public void userHasCompletedAllTheFieldsOnSendForPreChargeDecisionCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnSendForPreChargeDecisionCard();
		}
	}

	public void userSubmitsSendForPreChargeDecisionCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userSubmitsSendForPreChargeDecisionCard();
		}
	}

	public void UserStartsTheLaunchpadModule() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.UserStartsTheLaunchpadModule();
		}
	}

	public void taskWillBeRaisedToSupervisoryUnit(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskWillBeRaisedToOfficer(task);
		}
	}

	public void taskWillBeRaisedToReviewingUnit(String task) {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskWillBeRaisedToReviewingUnit(task);
		}
	}

	public void caseEventStatusWillBeSetTo(String eventStatus) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.caseEventStatusWillBeSetTo(eventStatus);
		}

	}

	public void userIsOnCardIndexScreenForALDMPCDReview() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForALDMPCDReview();
		}

	}

	public void userHasCompletedAllTheFieldsOnPreChargeDecisionReviewCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnPreChargeDecisionReviewCard();
		}

	}

	public void userSubmitsPreChargeDecisionReviewCard() {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userSubmitsPreChargeDecisionReviewCard();
		}
	}

	public void userHasCompletedAllTheFieldsOnThePoliceWitnessesCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userHasCompletedAllTheFieldsOnThePoliceWitnessesCard();
			} else {
				caseMobilePageObject.userHasCompletedAllTheFieldsOnThePoliceWitnessesCard();
			}
		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnThePoliceWitnessesCard();
		}
	}

	public void userHasCompletedAllTheFieldsOnPreChargeDecisionCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userHasCompletedAllTheFieldsOnPreChargeDecisionCard();
			} else {
				caseMobilePageObject.userHasCompletedAllTheFieldsOnPreChargeDecisionCard();
			}
		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnPreChargeDecisionCard();
		}

	}

	public void userHasCompletedAllTheFieldsOnCaseNotesCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userHasCompletedAllTheFieldsOnCaseNotesCard();
			} else {
				caseMobilePageObject.userHasCompletedAllTheFieldsOnCaseNotesCard();
			}
		} else {
//			caseWebPageObject.userHasCompletedAllTheFieldsOnCaseNotesCard();
		}
	}

	public void userHasCompletedAllTheFieldsOnRegisterForUpdateCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

			if (Utility.mobileOS.equalsIgnoreCase(WINDOWS)) {
				caseWindowsPageObject.userHasCompletedAllTheFieldsOnRegisterForUpdateCard();
			} else {
				caseMobilePageObject.userHasCompletedAllTheFieldsOnRegisterForUpdateCard();
			}
		} else {
//			caseWebPageObject.userHasCompletedAllTheFieldsOnRegisterForUpdateCard();
		}
	}

	public void caseEventRecordSelectedFromInWorkloadTab(String unit) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.eventRecordSelectedInWorkloadTab(unit);
		}
	}

	public void userIsOnCardIndexScreenForANewCMTReview() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForANewCMTReview();
		}
	}

	public void userHasCompletedAllTheFieldsOnNewCMTReviewCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnNewCMTReviewCard();
		}

	}

	public void clickOnButtonSubmit() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.clickOnButtonSubmit();
		}
	}

	public void caseRecordSelectedForUser(String user) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.caseRecordSelectedForUser(user);
		}
	}

	public void taskWillBeRaisedToCMTSgtUnit(String task) {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskWillBeRaisedToCMTSgtUnit(task);
		}
	}

	public void userIsOnCardIndexScreenForACMTTriageReview() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForACMTTriageReview();
		}
	}

	public void userHasCompletedAllTheFieldsOnCMTTriageReviewCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnCMTTriageReviewCard();
		}

	}

	public void caseRecordSelectedInWorkloadTabFor(String unit) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.caseRecordSelectedInWorkloadTabFor(unit);
		}
	}

	public void taskWillBeRaisedToOIC(String task) {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskWillBeRaisedToOIC(task);
		}

	}

	public void taskWillBeRaisedToCMTReviewUnit(String task) {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskWillBeRaisedToCMTReviewUnit(task);
		}
	}

	public void taskWillBeRaisedToOfficer(String task) throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskWillBeRaisedToOfficer(task);
		}

	}

	public void userIsOnCardIndexScreenForAResolvePreChargeActions() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForAResolvePreChargeActions();
		}

	}

	public void userHasCompletedAllTheFieldsOnResolvePreChargeActionCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnResolvePreChargeActionCard();
		}
	}

	public void userSubmitsResolvePreChargeActionCard() {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userSubmitsResolvePreChargeActionCard();
		}
	}

	public void userIsOnCardIndexScreenForAAllocateDM() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForAAllocateDM();
		}
	}
	
	public void userHasCompletedAllTheFieldsOnAllocateDMCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnAllocateDMCard();
		}

	}
	

	public void userIsOnCardIndexScreenForACMTDMReview() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForACMTDMReview();
		}
	}

	public void userHasCompletedAllTheFieldsOnCMTDMReviewCard() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userHasCompletedAllTheFieldsOnCMTDMReviewCard();
		}
	}

	public void taskIsAddedRemovedFromUserForCaseEvent(String task, String user) throws Throwable {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.taskIsAddedRemovedFromUserForCaseEvent(false, user, task);
		}
	}
	
	public void userIsOnCardIndexScreenForAAwaitingPreChargeDecisionResults() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForAAwaitingPreChargeDecisionResults();
		}

	}
	
	public void userIsOnCardIndexScreenForAPendingPreChargeReview() throws Exception {
		if (Utility.platform.equalsIgnoreCase(MOBILE)) {

		} else {
			caseWebPageObject.userIsOnCardIndexScreenForAPendingPreChargeReview();
		}

	}
}
