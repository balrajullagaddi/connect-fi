package com.northgateps.cm.staticobject.common;

//Adding details of the Vehicles like Model, Colour and Make .


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class Vehicle {

	private CardUtility crdUtility;
	private static ConnectMobilePageHelper cmPageHelper;
	private String card = "Vehicle";

	public Vehicle() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
		cmPageHelper = new ConnectMobilePageHelper();
		crdUtility = new CardUtility();
	}

	public void inputMake(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "Make");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void inputModel(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "Model");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void inputColour1(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "Colour 1");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void inputType(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "Type");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void inputVRMType(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "V.R.M. type");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void inputVRM(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "V.R.M.");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void inputForeignVehicle(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "Foreign Vehicle");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void clickOnVehicleDetailsTab(WebDriver driver) throws InterruptedException {
		cmPageHelper.clickOnTab(driver, "Vehicle details");
	}

	public void clickOnVehicleAssociationTab(WebDriver driver) throws InterruptedException {
		cmPageHelper.clickOnTab(driver, "Association");
	}
}