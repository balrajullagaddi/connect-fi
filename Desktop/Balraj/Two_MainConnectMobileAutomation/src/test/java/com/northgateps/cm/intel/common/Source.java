package com.northgateps.cm.intel.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class Source {
	private CardUtility crdUtility;
	private static ConnectMobilePageHelper cmPageHelper;
	private String card = "Source";
//	private String event = "Intelligence Report"; 
	
	public Source() throws Exception
	{
		System.out.println(this.getClass().getName()+" is running..");
		cmPageHelper = new ConnectMobilePageHelper();
		crdUtility = new CardUtility();
	}
	
	public void inputSourceOfIntelligence(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldSourceOfIntelligence = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Source of intelligence");
			WebElement txSourceOfIntelligence = driver.findElement(By.name(fieldSourceOfIntelligence));
			cmPageHelper.inputFieldValue(driver, txSourceOfIntelligence, InputVal);
	}
	
	public void inputSourceOfIntelligence(WebDriver driver, Keys key) {
			String fieldSourceOfIntelligence = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Source of intelligence");
			WebElement txSourceOfIntelligence = driver.findElement(By.name(fieldSourceOfIntelligence));
			txSourceOfIntelligence.sendKeys(key);
	}
	
	public void inputOtherforce(WebDriver driver, String InputVal) throws InterruptedException {
			String fieldOtherforce = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Other force");
			WebElement txOtherforce = driver.findElement(By.name(fieldOtherforce));
			cmPageHelper.inputFieldValue(driver, txOtherforce, InputVal);
	}
	
	public void inputOtherforce(WebDriver driver, Keys key) {
			String fieldOtherforce = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Other force");
			WebElement txOtherforce = driver.findElement(By.name(fieldOtherforce));
			txOtherforce.sendKeys(key);
	}
	
	public void clickOnSourceDetailsTab (WebDriver driver) throws InterruptedException {
			cmPageHelper.clickOnTab(driver, "Source details");
	}
	
	public void clickOnSourceLocationTab (WebDriver driver) throws InterruptedException {
			cmPageHelper.clickOnTab(driver, "Source location");
	}
	
	public boolean verifySourceFieldIsEmpty(WebDriver driver, String FieldName) {
		boolean present = false;
			present = cmPageHelper.verifyFieldIsEmpty(driver, card, "", CardUtility.globalEventType, FieldName);
		return present;
	}
	
	public void BlankOutSourceMandatoryField(WebDriver driver) {
			String field = crdUtility.getElementName(card, null, CardUtility.globalEventType, "Source of intelligence");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.clearField(element);
	}
	public WebElement verifyFieldPresentOrNot(WebDriver driver, String FieldName)
	{
		WebElement field=null;
		
	return field;
		
	}
	
}
