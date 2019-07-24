package com.northgateps.cm.intel.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class IntelUtility {

	private static ConnectMobilePageHelper cmPageHelper;
	CardUtility cardUtility;
	public static String IntelRefNumber = "";
	
	public IntelUtility() throws Exception {
		cmPageHelper = new ConnectMobilePageHelper();
		cardUtility = new CardUtility();
	}

	public void clickOnCreateIntelIcon() {
			cmPageHelper.waitForElementStateToBe(By.xpath("//div[contains(text(),'Create Intelligence Report')]"), "VISIBLE", cmPageHelper.getDriver());
			cmPageHelper.clickIcon("Create Intelligence Report");
			cmPageHelper.waitForConnectCardLoadMsgToBeInvisible();
			cmPageHelper.findAction();
			cmPageHelper.findEvent();
	}

	public void clickOnBasicDetailCard() {
			cmPageHelper.clickOnEventCardName("Basic details");
	}

	public void clickOnSourceCard() {
			cmPageHelper.clickOnEventCardName("Source");
	}

	public void clickOnSubmissionCard() {
			cmPageHelper.clickOnEventCardName("Submission");
	}
	
	public void clickOnLocationCard(String LinkReason) {
			cmPageHelper.clickOnCardName("Location", LinkReason, CardUtility.globalEventType);
	}

	public void clickOnPersonCard(String LinkReason) {
			cmPageHelper.clickOnCardName("Person", LinkReason, CardUtility.globalEventType);
	}

	public void clickOnVehicleCard(String LinkReason) {
			cmPageHelper.clickOnCardName("Vehicle", LinkReason, CardUtility.globalEventType);
	}

	public void clickOnOrganisationCard(String LinkReason) throws InterruptedException {
			cmPageHelper.clickOnCardName("Organisation", LinkReason, CardUtility.globalEventType);
	}

	public void clickOnCommsCard(String LinkReason) throws InterruptedException {
			cmPageHelper.clickOnCardName("Comms", LinkReason, CardUtility.globalEventType);
	}

	public void clickOnOperationCard(String LinkReason) throws InterruptedException {
			cmPageHelper.clickOnCardName("Operation", LinkReason, CardUtility.globalEventType);
	}

	public void clickOnEnquirylogCard() throws InterruptedException {
			cmPageHelper.clickOnEventCardName("Enquiry log");
	}

	public void clickOnCategoryCard(String LinkReason) throws InterruptedException {
			cmPageHelper.clickOnCardName("Category", LinkReason, CardUtility.globalEventType);
	}

//	private void scrollDown(WebDriver driver) throws InterruptedException {
//		cmPageHelper.waitForElementToBe((By.cssSelector("div[id^='ext-conm-cards-index-']")), "PRESENCE", driver, 20);		
//		cmPageHelper.waitForElementToBe((By.cssSelector("div[id^='ext-conm-cards-index-']")), "CLICKABLE", driver);
//		WebElement el = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-index-']"));
//		for (int i = 0; i <= 20; i++) {
//			el.sendKeys(Keys.ARROW_DOWN);
//			Thread.sleep(500);
//		}
//	}

	public List<String> getCardField(WebDriver driver, String card) {
		List<String> CardFieldList = null;
			CardFieldList = CardUtility.getCardFieldList(CardUtility.globalEventType, card);
		return CardFieldList;
	}

	public void clickOnRequestToCreateBriefingCard() {
			cmPageHelper.clickOnEventCardName("Request to create briefing");
	}

	public void clickOnProcessRequestToCreateBriefingCard() {
			cmPageHelper.clickOnEventCardName("Process request to create briefing");
	}
	
	public void setIntelRef(String IntelRef) {
		IntelRefNumber = IntelRef;
	}

	public void clickOnTagsAndTensionLevelsCard() {
		// TODO Auto-generated method stub
		cmPageHelper.clickOnEventCardName("Tags and tension levels");
	}
}