package com.northgateps.cm.common;
 
// handling the popups
import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

public class Message {
	private static ConnectMobilePageHelper cmPageHelper;
	static Properties properties;
	private static Logger Log = Logger.getLogger(ConnectMobilePageHelper.class.getName());

	public Message() throws InterruptedException, Exception {
		super();
		cmPageHelper = new ConnectMobilePageHelper();
		properties = Utility.loadProperties();
	}
	
	public void clickOnMessageIcon() {
		cmPageHelper.clickIcon("Messages");
	}
	
	
	public void selectNotification(WebDriver driver, String subjectName,String userName) throws InterruptedException {
		List<WebElement> notificationMsgList = driver.findElements(By.xpath("//div[contains(@id,'notificationMessageGrid')]/table//tr/td[1]"));
		List<WebElement> notificationUserList = driver.findElements(By.xpath("//div[contains(@id,'notificationMessageGrid')]/table//tr/td[2]"));
		for(int i=0;i<notificationMsgList.size();i++){
					if ((notificationMsgList.get(i).getText().equals(subjectName)) & (notificationUserList.get(i).getText().contains(userName))) {
		            System.out.println("Yes we have got mail with subjectName " + subjectName);
		            notificationMsgList.get(i).click();
		            Thread.sleep(1500);
		    		WebElement notificationView=driver.findElement(By.xpath("//Button[contains(text(),'View')]"));
		    		notificationView.click();
		            break;
		        }
		   	}
		    
		}
	
	
	

	public void clickOnButtonClose(WebDriver driver) {
		WebElement btnClose = driver.findElement(By.xpath("//div[contains(@class,'close')]"));
		assertNotNull(btnClose);
		btnClose.click();
	}
	
	
	public void verifyMessageRecieved(WebDriver driver, String subjectName,String userName) throws InterruptedException {
		List<WebElement> notificationMsgList = driver.findElements(By.xpath("//div[contains(@id,'notificationMessageGrid')]/table//tr/td[1]"));
		List<WebElement> notificationUserList = driver.findElements(By.xpath("//div[contains(@id,'notificationMessageGrid')]/table//tr/td[2]"));
		for(int i=0;i<notificationMsgList.size();i++){
					if ((notificationMsgList.get(i).getText().equals(subjectName)) & (notificationUserList.get(i).getText().contains(userName))) {
		            System.out.println("Yes we have got mail with subjectName " + subjectName);
		            notificationMsgList.get(i).click();
		            Thread.sleep(1500);
		    		WebElement notificationView=driver.findElement(By.xpath("//Button[contains(text(),'View')]"));
		    		notificationView.click();
		            break;
		        }
		   	}
		    
		}
	
	

	public void validateFromFieldInNotificationMsg(WebDriver driver, String fromRecipient,String userName) {
		try {   
			 boolean Verify_User = false;
            String NotifiedUser=driver.findElement(By.cssSelector("textarea[id^='"+fromRecipient+"']")).getAttribute("value");
            if ((NotifiedUser.contains(userName))){
            	Verify_User = true;
            	Assert.assertTrue("Notification message is recieved for notified user", Verify_User);
            }
            else {
            	Verify_User = false;
            	Assert.assertTrue("Notification message is not recieved for notified user", Verify_User);
            }
             } catch (Exception e) {
            	 throw e;
            }
	}
	
	
	
	/*
	 * Method : Validates the pre populated text from message tab with excel test data.
	 */
	public void validateFieldsOnMessageCard(String strOperation, String strCard)
			throws Exception {
		try {
			for (int i = 0; i < Utility.testData.length; i++) {
				String xlCardName = Utility.testData[i][0];
				if (Utility.testData[i][1].contains("|")) {
					String[] xlForm = Utility.testData[i][1].split("\\|");
					String xlFormName = xlForm[0].toString().trim();
					String xlOperationName = xlForm[1].toString().trim();
					if (xlCardName.equalsIgnoreCase(strCard) && (xlOperationName.equalsIgnoreCase(strOperation))) {
						String fieldLabel = Utility.testData[i][2];
						String fieldValue = cmPageHelper.returnFieldValue(Utility.testData[i][3]).trim();
						
						switch (strOperation) {
						case "Pre populated":
							cmPageHelper.validatePrePopulatedValueInMsgTab(fieldLabel, fieldValue);
										break;
						}

					}
				}
			}
		} catch (Exception e) {
			Log.info("Unable to perform operation");
		}
	}
	
	
}
