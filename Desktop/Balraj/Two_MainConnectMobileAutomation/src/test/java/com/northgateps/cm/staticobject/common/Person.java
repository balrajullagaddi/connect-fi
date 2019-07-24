package com.northgateps.cm.staticobject.common;

//Person  STATIC OBJECT 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class Person {

	private CardUtility crdUtility;
	private static ConnectMobilePageHelper cmPageHelper;
	private String card = "Person";

	public Person() throws Exception
	{
		System.out.println(this.getClass().getName()+" is running..");
		cmPageHelper = new ConnectMobilePageHelper();
		crdUtility = new CardUtility();
	}

	public void inputTitle(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Title");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputSurname(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Surname");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputForename1(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Forename 1");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputForename2(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Forename 2");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputForename3(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Forename 3");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputSex(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Sex");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputDoB(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Date of birth");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputPlaceOfBirth(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Place of birth");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputAgeFrom(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Age from");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputAgeTo(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Age to");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputLocality(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Locality");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
	}

	public void inputOccupation(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Occupation");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
		
	}

	public void inputSubOccupation(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Sub occupation");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
		
	}

	public void inputFromDate(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "From date");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
		
	}

	public void inputToDate(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "To date");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
		
	}

	public void inputNationality(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String fieldName = crdUtility.getElementName(card, null, event, "Nationality");
			WebElement elField = driver.findElement(By.name(fieldName));
			cmPageHelper.inputFieldValue(driver, elField, InputVal);
		
	}

	public void inputHeight(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Height from (cms)");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public void inputAliasType(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Alias type");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public void inputEyeColourLeft(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Eye colour (left)");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public void inputClothingType(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Clothing type");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public void inputFeatureType(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Feature type");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public void inputFeatureBodyPart(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Feature body part");
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public void inputFeaturePosition(WebDriver driver, String event, String LinkReason, String InputVal) throws Exception {
			String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
			String field = crdUtility.getElementName(card, null, event, "Feature position");																				
			WebElement element = driver.findElement(By.name(field));
			cmPageHelper.inputFieldValue(driver, element, InputVal);
		
	}
	
	public boolean verifyPersonFieldIsEmpty(WebDriver driver, String event, String LinkReason, String FieldName) {
		boolean present = false;
			present = cmPageHelper.verifyFieldIsEmpty(driver, card, LinkReason, event, FieldName);
		
		return present;
	}
	
	public void clickOnPersonBasicDetailsTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person basic details");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonIdentifiersTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person identifiers");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickOnPersonDescriptionTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person description");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonClothingTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person clothing & jewellery");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonDetailsTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person details");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonAliasTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person alias");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonOccupationTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person occupation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonFeaturesTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Person distinguishing features");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPersonAssociationTab (WebDriver driver) {
		try {
			cmPageHelper.clickOnTab(driver, "Association");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Person - Tab - Person Identifier
	
	
	public void inputCountryOfIssue(WebDriver driver, String event, String LinkReason, String InputVal) throws InterruptedException {
			String fieldCountryOfIssue = crdUtility.getElementName(card, null, event, "Intelligence description");
			WebElement txCountryOfIssue = driver.findElement(By.name(fieldCountryOfIssue));
			//cmPageHelper.inputFieldValue(driver, txIntelligenceDescription, InputVal);
			cmPageHelper.selectValueFromDropDown(driver, txCountryOfIssue, InputVal);
		
	}
	
	// Person - Tab - Person Identifier
}