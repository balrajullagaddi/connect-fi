package com.northgateps.cm.staticobject.common;

//Organisation  STATIC OBJECT 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.northgateps.cm.platform.api.CardUtility;
import com.northgateps.cm.platform.api.ConnectMobilePageHelper;


public class Organisation {

	private CardUtility crdUtility;
	private static ConnectMobilePageHelper cmPageHelper;
	private String card = "Organisation";

	public Organisation() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
		cmPageHelper = new ConnectMobilePageHelper();
		crdUtility = new CardUtility();
	}

	public void inputNameTitle(WebDriver driver, String event, String LinkReason, String InputVal)
			throws InterruptedException {
		String card = cmPageHelper.getNameForCard(this.card, LinkReason, event);
		String field = crdUtility.getElementName(card, null, event, "Name or title");
		WebElement element = driver.findElement(By.name(field));
		cmPageHelper.inputFieldValue(driver, element, InputVal);
	}

	public void clickOnOrganisationDetailsTab(WebDriver driver) throws InterruptedException {
		cmPageHelper.clickOnTab(driver, "Organisation details");
	}

	public void clickOnOrganisationAssociationTab(WebDriver driver) throws InterruptedException {
		cmPageHelper.clickOnTab(driver, "Association");
	}
}