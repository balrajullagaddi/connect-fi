package com.northgateps.cm.search.common;
// USED FOR SEARCHING THE RECORD
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class SearchUtility {
	private static ConnectMobilePageHelper cmPageHelper;
	public static String CaseRefNumber = "";

 	public SearchUtility() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
		cmPageHelper = new ConnectMobilePageHelper();
	}
 	
 	//Shiv - 30/05 - It will select the first option from the drop down
 	public void setReasonForSearch(WebDriver driver, String option) {
 		cmPageHelper.waitForElementToBe(By.name("reason-for-search"), "PRESENCE", driver);
		WebElement we = driver.findElement(By.name("reason-for-search"));
		we.clear();
		we.sendKeys(Keys.DOWN);
		we.sendKeys(Keys.TAB);
	}

	public void setIncidentNumber(WebDriver driver, String incidentNumber) {
		cmPageHelper.waitForElementToBe(By.name("incidentNumber"), "PRESENCE", driver);
		WebElement we = driver.findElement(By.name("incidentNumber"));
		we.clear();
		we.sendKeys(incidentNumber);
		we.sendKeys(Keys.TAB);
	}
	
	public void setPropertyRefNumber(WebDriver driver, String refNumber) {
		cmPageHelper.waitForElementToBe(By.name("propertyEventReferenceNumber"), "PRESENCE", driver);
		WebElement we = driver.findElement(By.name("propertyEventReferenceNumber"));
		we.clear();
		we.sendKeys(refNumber);
		we.sendKeys(Keys.TAB);
	}

	public void clickSearch(WebDriver driver) {
		cmPageHelper.waitForElementToBe(By.cssSelector("a.search-button"), "PRESENCE", driver, 10);
		driver.findElement(By.cssSelector("a.search-button")).click();
	}

	public void selectSearchRecordBy(WebDriver driver, String searchValue) {
		List<WebElement> tabElements = cmPageHelper.waitForElementToBe(By.cssSelector("div.x-grid-cell-inner"), "PRESENCE", driver, 10);
		for (WebElement webElement : tabElements) {
			if (webElement.getText().trim().equalsIgnoreCase(searchValue)) {
				webElement.click();
				break;
			}
		}
	}

	public void clickView(WebDriver driver) throws InterruptedException {
		cmPageHelper.waitForElementToBe(By.cssSelector("a.pole-action-value-view"), "VISIBLE", driver, 60);
		driver.findElement(By.cssSelector("a.pole-action-value-view")).click();
		cmPageHelper.switch_To_PoleViewerModule(driver);
	}

 	public void clickLinkedActionsButton(WebDriver driver) {
		List<WebElement> els = cmPageHelper.waitForElementToBe(By.cssSelector("a.pole-action-value-eventActions"), "VISIBLE", driver, 60);
		els.get(0).click();
	}
}
