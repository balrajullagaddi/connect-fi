package com.northgateps.cm.common;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.northgateps.cm.platform.api.MobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TaskDashboard {
	private static MobilePageHelper mobilePageHelper;
	static Properties properties;
	private static Logger Log = Logger.getLogger(MobilePageHelper.class.getName());

	public TaskDashboard() throws InterruptedException, Exception {
		super();
		mobilePageHelper = new MobilePageHelper();
		properties = Utility.loadProperties();
	}
	
	public void clickOnViewInWorkload(AppiumDriver<MobileElement> appiumDriver, String view, String eventObject) {
		appiumDriver.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-simplelistitem')][starts-with(@content-desc,'"+view+"')]").click();
		appiumDriver.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-simplelistitem')][starts-with(@content-desc,'"+eventObject+"')]").click();
		
	}

	public void selectARecordInWorkload(AppiumDriver<MobileElement> appiumDriver, String eventID) {
		appiumDriver.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-simplelistitem')][starts-with(@content-desc,'"+eventID+"')]").click();		
	}

	public void validateEventStatus(AppiumDriver<MobileElement> appiumDriver, String eventStatus,
			String eventId) throws Exception{
		String actualStatus = appiumDriver.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-simplelistitem')][starts-with(@content-desc,'"+eventId+"')]").getAttribute("content-desc").replace(eventId, "");
		Assert.assertTrue(eventStatus.trim().equalsIgnoreCase(actualStatus.trim()),
				"Status is not as expected for event id :" + eventId);
	}
}
