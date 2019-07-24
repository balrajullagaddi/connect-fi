package com.northgateps.cm.intel.common;


import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.ConnectMobilePageHelper;

public class EnquiryLog {

	private static ConnectMobilePageHelper cmPageHelper;

	public EnquiryLog() throws Exception
	{
		System.out.println(this.getClass().getName()+" is running..");
		cmPageHelper = new ConnectMobilePageHelper();
	}

	public void clickOnButtonAddNewEnqLog(WebDriver driver) throws InterruptedException {
			Thread.sleep(2000);
			WebElement newEnquiryLogButton = cmPageHelper.getClickableDiv(
					driver.findElements(By.xpath("//div[text()='Add New Enquiry log']//..//..//..")));
			assertNotNull(newEnquiryLogButton);
			newEnquiryLogButton.click();
	}
	
}