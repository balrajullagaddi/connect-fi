package com.northgateps.cm.intel.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class BasicDetails {

	private CardUtility crdUtility;
	private static ConnectMobilePageHelper cmPageHelper;
	private String card = "Basic details";
//	private String event = "Intelligence Report"; 

	public BasicDetails() throws Exception
	{
		System.out.println(this.getClass().getName()+" is running..");
		cmPageHelper = new ConnectMobilePageHelper();
		crdUtility = new CardUtility();
	}

	public void inputReportTitle(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldReporttile = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Report title");
			WebElement txReportTitle = driver.findElement(By.name(fieldReporttile));
			cmPageHelper.inputFieldValue(driver, txReportTitle, InputVal);
			//cmPageHelper.SelectValueFromDropDown(driver, txReportTitle, InputVal);
	}
	
	public void inputDateSubmitted(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldDatesubmitted = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Date submitted");
			WebElement txDatesubmitted = driver.findElement(By.name(fieldDatesubmitted));
			cmPageHelper.inputFieldValue(driver, txDatesubmitted, InputVal);
	}

	public void inputForce(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldForce = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Force");
			WebElement txForce = driver.findElement(By.name(fieldForce));
			cmPageHelper.inputFieldValue(driver, txForce, InputVal);
	}

	public void inputPriority(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldPriority = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Priority");
			WebElement txPriority = driver.findElement(By.name(fieldPriority));
			cmPageHelper.inputFieldValue(driver, txPriority, InputVal);
	}


	public void inputIntelligenceDescription(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldIntelligenceDescription = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Intelligence description");
			WebElement txIntelligenceDescription = driver.findElement(By.name(fieldIntelligenceDescription));
			//cmPageHelper.inputFieldValue(driver, txIntelligenceDescription, InputVal);
			cmPageHelper.selectValueFromDropDown(driver, txIntelligenceDescription, InputVal);
	}

	public void inputDateSubmitted(WebDriver driver, Keys key) {
			String fieldDateSubmitted = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Submit to intelligence unit");
			WebElement txDateSubmitted = driver.findElement(By.name(fieldDateSubmitted));
			txDateSubmitted.sendKeys(key);
	}

	public void inputReportTitle(WebDriver driver, Keys key) {
			String fieldReporttile = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Report title");
			WebElement txReportTitle = driver.findElement(By.name(fieldReporttile));
			txReportTitle.sendKeys(key);
	}

	public void inputPriority(WebDriver driver, Keys key) {
			String fieldPriority = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Priority");
			WebElement txPriority = driver.findElement(By.name(fieldPriority));
			txPriority.sendKeys(key);
	}

	public void inputIntelligenceDescription(WebDriver driver, Keys key) {
			String fieldIntelligencedescription = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Intelligence description");
			WebElement txIntelligencedescription = driver.findElement(By.name(fieldIntelligencedescription));
			txIntelligencedescription.sendKeys(key);
	}

	public void inputSubmitToIntelUnit(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldName = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Submit to intelligence unit");
			WebElement elField = driver.findElement(By.name(fieldName));
			//cmPageHelper.inputFieldValue(driver, elField, InputVal);
			cmPageHelper.selectValueFromDropDown(driver, elField, InputVal);
	}

	public void inputLinkingUnit(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldName = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Linking unit");
			WebElement elField = driver.findElement(By.name(fieldName));
			//cmPageHelper.inputFieldValue(driver, elField, InputVal);
			cmPageHelper.selectValueFromDropDown(driver, elField, InputVal);
	}
	
	public boolean verifyBasicDetailFieldIsEmpty(WebDriver driver, String FieldName) {
		boolean present = false;
			present = cmPageHelper.verifyFieldIsEmpty(driver, card, "",CardUtility.globalEventType, FieldName);
		return present;
	}

	public void BlankOutBasicDetailMandatoryField(WebDriver driver) {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Force");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.clearField(element);
	}
	
}