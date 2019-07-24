package com.northgateps.cm.poleviewer.common;
// USED FOR VIEW FUNCTIONALITY AFTER SEARCHING A SAVED RECORD
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

public class PoleViewer {
	private static ConnectMobilePageHelper cmPageHelper;
	public static String CaseRefNumber = "";
	private static Logger Log = Logger.getLogger(PoleViewer.class);

 	public PoleViewer() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
		cmPageHelper = new ConnectMobilePageHelper();
	}
 	
 	public void clickPoleViewerTab(WebDriver driver, String tab) throws InterruptedException {
 		List<WebElement> elList = cmPageHelper.getWebElementsList(By.cssSelector("div.x-panel.views-tabpanel div.x-tab-bar a"), driver);

 		int size = elList.size();

 		for (int i = 0; i < size; i++) {
 			if (!elList.get(i).getText().isEmpty()) {
 				if (elList.get(i).getText().contains(tab)) {
 					String id = elList.get(i).getAttribute("id");
 					driver.findElement(By.cssSelector("a[id='" + id + "']")).click();
 					break;
 				}
 			} else {
 				WebElement rightScrollBar = driver.findElement(By.cssSelector("div.x-panel.views-tabpanel div.x-tab-bar div.x-box-scroller-right"));
 				for (int m = 1; m <= 4; m++)
 					rightScrollBar.click();
 				clickPoleViewerTab(driver, tab, i);
 			}
 		}
 	}

	public void clickPoleViewerTab(WebDriver driver, String tab, int j) throws InterruptedException {
		List<WebElement> elList = null;
		elList = cmPageHelper.waitForElementToBe(By.cssSelector("div.x-panel.views-tabpanel div.x-tab-bar a"), "PRESENCE", driver, 10);
	
		int size = elList.size();
	
		mainloop: for (int i = j; i <= size; i++) {
			if (!elList.get(i).getText().isEmpty()) {
				if (elList.get(i).getText().contains(tab)) {
					String id = elList.get(i).getAttribute("id");
					driver.findElement(By.cssSelector("a[id='" + id + "']")).click();
					break;
				}
			} else {
				WebElement rightScrollBar = driver.findElement(By.cssSelector("div.x-panel.views-tabpanel div.x-tab-bar div.x-box-scroller-right"));
				for (int m = 1; m <= 4; m++)
					rightScrollBar.click();
				clickPoleViewerTab(driver, tab, i);
				break mainloop;
			}
		}
	}

	public String getPoleViewerValue(WebDriver driver, String field) throws InterruptedException {
		try {
		String idForField = getIDForPoleViewerField(driver, field);
		WebElement el = driver.findElement(By.id(idForField));
		return el.getText().trim();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void validateTaskHistoryPoleViewer(WebDriver driver, String taskEntry) throws Exception {
		boolean taskFound = false;
		int column = 1;
		Thread.sleep(2000);
		List<WebElement> headerPanelList = driver.findElements(By.cssSelector(
				"div.entity-type-gemTaskHistory div[id^='pole-gridpanel-'] div.x-grid-header-ct div.x-column-header"));
		for (WebElement headerPanel : headerPanelList) {
			WebElement header = headerPanel.findElement(By.xpath("//span[text()='Task name']"));
			if (header != null) {
				break;
			}
			column += 1;
		}

		// Get task name
		List<WebElement> columnList = driver.findElements(By.cssSelector(
				"div.entity-type-gemTaskHistory div[id^='pole-gridpanel-'] div[class^='x-panel-body'] table tr td:nth-child("
						+ column + ")"));
		List<String> taskList = new ArrayList<String>();
		for (WebElement columnElement : columnList) {
			String task = columnElement.getText();
			taskList.add(task);
			if (columnElement.getText().equalsIgnoreCase(taskEntry)) {
				assertEquals(taskEntry.toLowerCase(), columnElement.getText().toLowerCase());
				taskFound = true;
				break;
			}
		}
		if (!taskFound)
			Log.error("Task :" + taskEntry + " not found in Task history grid.---" + taskList.toString());
		else
			Assert.assertTrue(taskFound, "Task not found in Task history grid.");
	}
	
	private String getIDForPoleViewerField(WebDriver driver, String fieldName) throws InterruptedException {
		cmPageHelper.switch_To_PoleViewerModule(driver);
		String fieldID = "";
		WebElement pvField = driver.findElement(By.xpath("//label/span/span[text()='"+fieldName+"']"));
		String id = pvField.getAttribute("id");
		fieldID = id.replace("-labelTextEl", "-bodyEl");
		return fieldID;
	}

	public void userVerifiesForInTransactionLog(String field, String object, String recordNum, WebDriver driver) throws Exception {
		boolean transcationFound = false;
		int column = 1;
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + object + "')]"));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		Thread.sleep(1000);
		WebElement elements = driver.findElement(By.xpath(
				"//table[tbody//span[contains(.,' Property items')]]/following-sibling::table/tbody/tr[contains(@class,'x-grid-tree-node-expanded')][1]"));

		elements.click();
		clickPoleViewerTab(driver, "Full");
		Thread.sleep(2000);
		List<WebElement> headerPanelList = driver.findElements(By.cssSelector(
				"div.entity-type-propertyTransactionLog div[id^='pole-gridpanel-'] div.x-grid-header-ct div.x-column-header "));
		for (WebElement headerPanel : headerPanelList) {
			WebElement header = headerPanel.findElement(By.xpath("//span[text()='" + field + "']"));
			if (header != null) {
				break;
			}
			column += 1;
		}

		if (!transcationFound)
			Log.error("Seal Number not found in Transaction history grid.---");
		else
			Assert.assertTrue(transcationFound, "Transaction not found in Transaction history grid.");

		WebElement e = driver.findElement(By.cssSelector(
				"div.entity-type-propertyTransactionLog div[id^='pole-gridpanel-'] div[class^='x-panel-body'] table tr td:nth-child(4)"));
		for (int j = 0; j < Utility.testData.length; j++) {

			if (Utility.testData[j][2].equalsIgnoreCase(field)) {
				String actualsealno = e.getText();
				// String actualsealno = e.get(Integer.parseInt(Record)).getText();
				System.out.println(actualsealno);
				System.out.println(Utility.testData[j][2]);
				String expsealno = Utility.testData[j][3];
				System.out.println(expsealno);
				Assert.assertEquals(actualsealno, expsealno);
				break;
			}
		}
	}

}
