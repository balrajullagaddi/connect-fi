package com.northgateps.cm.intel.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class Submission {
	
	private CardUtility crdUtility;
	private static ConnectMobilePageHelper cmPageHelper;
	private String card = "Submission";
//	private String event = "Intelligence Report";
	private String sourceFirst = "When did the source FIRST know it to be the case?";
	private String sourceLast = "When did the source LAST know it to be the case?";
	private String sourceProvideMoreInfo = "Will the source be able to provide more information regarding this subject in the future?";
	private String riskToSafety = "Is there a risk to safety of source or other than source?";
	
	public Submission() throws Exception{
		System.out.println(this.getClass().getName()+" is running..");
		cmPageHelper = new ConnectMobilePageHelper();
		crdUtility = new CardUtility();
	}

	public void inputSubmissionText(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Submission text");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputSourceEvaluation(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Source evaluation (S)");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputIntelligenceAssessment(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Intelligence assessment (I)");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputHandlingCode(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Handling code (H)");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputHowDoesTheSourceKnow(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "How does the source know?");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputWhoElseKnows(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Who else knows?");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputSourceFirst(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, sourceFirst);
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputSourceLast(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, sourceLast);
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputSourceProvideMoreInfo(WebDriver driver, String InputVal) throws InterruptedException {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, sourceProvideMoreInfo);
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
	}
	
	public void inputPublicInterestImmunity(WebDriver driver, String InputVal) throws InterruptedException {
			cmPageHelper.clickOnYesOrNoButton(driver, "Public interest immunity?", InputVal);			
	}
	
	public void inputRiskToSafety(WebDriver driver, String InputVal) throws InterruptedException {
			cmPageHelper.clickOnYesOrNoButton(driver, riskToSafety, InputVal);
	}
	
	public void inputOperationallySensitive(WebDriver driver, String InputVal) throws InterruptedException {
			cmPageHelper.clickOnYesOrNoButton(driver, "Is this operationally sensitive?", InputVal);
	}
	
	public void clickOnSubmissionTab (WebDriver driver) throws InterruptedException {
			cmPageHelper.clickOnTab(driver, "Submission");
	}
	
	public void clickOnProvenanceTab (WebDriver driver) throws InterruptedException {
			cmPageHelper.clickOnTab(driver, "Provenance");
	}
	
	public void clickOnRiskFactorsTab (WebDriver driver) throws InterruptedException {
			cmPageHelper.clickOnTab(driver, "Risk factors");
	}
	
	public void BlankOutSubmissionMandatoryField(WebDriver driver) {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Submission text");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.clearField(element);
	}
}
