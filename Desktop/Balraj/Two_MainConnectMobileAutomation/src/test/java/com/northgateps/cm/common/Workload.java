package com.northgateps.cm.common;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.northgateps.cm.platform.api.ConnectMobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

// TASKS SELECTION FROM WORKLOAD // WEB SPECIFIC

public class Workload {
	private static ConnectMobilePageHelper cmPageHelper;
	static Properties properties;
	private static Logger Log = Logger.getLogger(ConnectMobilePageHelper.class.getName());

	public Workload() throws InterruptedException, Exception {
		super();
		cmPageHelper = new ConnectMobilePageHelper();
		properties = Utility.loadProperties();
	}

	// Upasna 110218
	// Rajesh -- Implemented code to select default unit from Units dropdown
	public void clickWorkloadMyUnits(WebDriver driver, String unitName) {
		try {
			cmPageHelper.waitForElementToBe(By.xpath("//span[text()='My Units']/ancestor::a"), "VISIBLE", driver);
			driver.findElement(By.xpath("//span[text()='My Units']/ancestor::a")).click();
			cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
			WebElement unitsDropdown = cmPageHelper.getInputFromLabel(driver, "Units");
			// Thread.sleep(3000);
			unitsDropdown.click();
			unitsDropdown.sendKeys(Keys.ARROW_DOWN); // This opens the List
			List<WebElement> ddlBox = driver.findElements(By.cssSelector("ul li"));
			boolean found = false;
			for (WebElement elDDL : ddlBox) {
				String ddlValue = elDDL.getText();
				if (ddlValue.equals(unitName)) {
					Thread.sleep(500);
					elDDL.click();
					found = true;
//					cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
					break;
				}
			}
			if (!found)
				user_add_units_in_workload_tab(unitName.trim(), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Upasna 110218
	public void validateEventStatus(String eventStatus, String eventId, WebDriver driver) throws InterruptedException {
		int colNumber = cmPageHelper.getColumnNumber(driver, "Event Status");
		// Thread.sleep(1000);
		String actualStatus = driver.findElement(By.xpath(
				("//div[@class='x-grid-item-container']//table//td/div[contains(text(),'<eventId>')]//..//..//td["
						+ colNumber + "]").replace("<eventId>", eventId)))
				.getText().trim();
		Assert.assertTrue(eventStatus.trim().equalsIgnoreCase(actualStatus.trim()),
				"Status is not as expected for event id :" + eventId);
	}

	// Upasna 110218
	public void clickOnMyUnitsGraph(WebDriver driver) throws InterruptedException {
		cmPageHelper.clickElementByActionsClass(driver, By.xpath("//div[@id='chart-overlay']//canvas"));
//		WebElement el = (WebElement) cmPageHelper.waitForElementToBe(By.xpath("//div[@id='chart-overlay']//canvas"), "VISIBLE", driver, 10);
//		el.click();
		cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
		cmPageHelper.waitForPageLoadMsgToBeInvisible("Loading");
	}

	// Upasna : eventstatus
	public void clickOnWorkloadIcon() {
		cmPageHelper.clickIcon("Workload");
		// Thread.sleep(1000);
	}

	public void selectURN(WebDriver driver, String intelRefNumber, String eventName) throws InterruptedException {
		// Click on Workload Event tab
		clickOnWorkloadEventTab(driver, eventName);
		Thread.sleep(2000);
		// Deselect checkbox
		cmPageHelper.deselectCheckbox(driver);

		// Scroll to end of gridview
		WebElement scrollElement = cmPageHelper.getDisplayedElement(
				driver.findElements(By.cssSelector("div[id^='tasksByObjectResults-'] div[class='x-scroller-spacer'")));
		Actions act = new Actions(driver);
		act.moveToElement(scrollElement).sendKeys(Keys.chord(Keys.CONTROL, Keys.END)).build().perform();

		// Shiv - 08/05 - Commented to get the URN column number as we have different
		// column names for the events for e.g. Intel has 'URN' where as Case has 'Case
		// reference number'
		// Get Event Status column number
		// int colNumber = cmPageHelper.getColumnNumber(driver, "URN");

		List<WebElement> checkBoxURN = driver
				.findElements(By.xpath("//div[@class='x-grid-item-container']//table//td/div[contains(text(),'"
						+ intelRefNumber + "')]//..//..//td[2]"));
		Assert.assertTrue(checkBoxURN.size() > 0,
				"URN not found in workload tab, please check it manually in search screen :" + intelRefNumber);
		checkBoxURN.get(0).click();
		Thread.sleep(1500);

		// Please DON'T delete below code
		// List<WebElement> urnList = driver
		// .findElements(By.cssSelector("div[id^='tasksByObjectResults-']
		// div.x-grid-item-container table"));
		// String str = urnList.get(0).getAttribute("data-recordindex");
		// int recordIndex = Integer.parseInt(str);
		// while (recordIndex >= 0) {
		// WebElement webElement = driver.findElement(By.cssSelector(
		// "div[id^='tasksByObjectResults-'] div.x-grid-item-container
		// table[data-recordindex='"
		// + recordIndex + "'] tr td:nth-child(" + colNumber + ")"));
		//
		// if (webElement.getText().equals(intelRefNumber)) {
		// Thread.sleep(500);
		// webElement.click();
		// Thread.sleep(2000);
		// recordIndex = -1;
		// break;
		// } else {
		// webElement.click();
		// Thread.sleep(1000L);
		// ++recordIndex;
		// }
		// }
	}

	public void verifyTaskName(WebDriver driver, String taskEntry) throws InterruptedException {
		boolean taskFound = false;
		int column = 1;
		Thread.sleep(2000);
		// Code to select Full tab
		selectPVTab(driver, "Full");

		// Get Task name column number
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
			assertTrue("Task not found in Task history grid.", taskFound);
	}

	public void verifyIntelSubmitterTask(WebDriver driver, String task) {
		boolean taskFound = false;
		int column = 1;
		// Get Task name column number
		List<WebElement> taskColumnList = driver
				.findElements(By.cssSelector("div[id^='tasks-'] div.x-grid-header-ct div.x-column-header"));
		for (WebElement taskColumn : taskColumnList) {
			WebElement header = taskColumn.findElement(By.xpath("//span[text()='Task']"));
			if (header != null) {
				break;
			}
			column += 1;
		}

		// Get task name
		List<WebElement> columnList = driver.findElements(
				By.cssSelector("div[id^='tasks-'] div.x-panel-body table tr td:nth-child(" + column + ")"));
		for (WebElement columnElement : columnList) {
			if (columnElement.getText().equalsIgnoreCase(task)) {
				assertEquals(task.toLowerCase(), columnElement.getText().toLowerCase());
				taskFound = true;
				break;
			}
		}
		assertTrue("Task '" + task + "' not found in Intel Submitter Task grid.", taskFound);
	}

	// Naman
	public void clickLinkedActionsButton(WebDriver driver) throws Exception {
		try {
			Assert.assertNotNull(cmPageHelper.waitForElementToBe(By.xpath("//span[contains(text(),'Linked Actions')]"),
					"CLICKABLE", driver), "Check box is not clickable");
			cmPageHelper.clickElement(By.xpath("//span[contains(text(),'Linked Actions')]"), driver);
			// Thread.sleep(2000);
		} catch (Exception e) {
			throw e;
		}
	}

	// Naman
	public void selectLinkedAction(String action, WebDriver driver) throws Exception {
		try {
			// Thread.sleep(1000);
			WebElement elLinkedActionButton = driver.findElement(
					By.xpath("//div[@id='actionsGrid-body']//div[text()='" + action + "']//..//..//td[2]/div/div"));
			Actions act = new Actions(driver);
			act.moveToElement(elLinkedActionButton).click().build().perform();
			// Thread.sleep(2000);
			cmPageHelper.switch_To_ConnectMobileModule(driver);

			cmPageHelper.findEvent();
			cmPageHelper.findAction();
		} catch (Exception e) {
			throw e;
		}
	}

	// Naman
	public void enterActionTaken(String value, WebDriver driver) {
		try {
			Assert.assertTrue(false, "Method is un implemented due to application issue");
		} catch (Exception e) {
			throw e;
		}
	}

	// Naman
	public void enterRemarks(String value, WebDriver driver) {
		try {
			Assert.assertTrue(false, "Method is un implemented due to application issue");
		} catch (Exception e) {
			throw e;
		}
	}

	// Naman
	public void clickIntelSubmitterTask(WebDriver driver, String task) {
		int column = 1;
		// Get Task name column number
		List<WebElement> taskColumnList = driver
				.findElements(By.cssSelector("div[id^='tasks-'] div.x-grid-header-ct div.x-column-header"));
		for (WebElement taskColumn : taskColumnList) {
			WebElement header = taskColumn.findElement(By.xpath("//span[text()='Task']"));
			if (header != null) {
				break;
			}
			column += 1;
		}

		// Get task name
		List<WebElement> columnList = driver.findElements(
				By.cssSelector("div[id^='tasks-'] div.x-panel-body table tr td:nth-child(" + column + ")"));
		for (WebElement columnElement : columnList) {
			if (columnElement.getText().equalsIgnoreCase(task)) {
				assertEquals(task.toLowerCase(), columnElement.getText().toLowerCase());
				columnElement.click();
				break;
			}
		}
	}

	// Naman
	public void clickPerformButton(WebDriver driver) {
		try {
			Assert.assertTrue(cmPageHelper.waitForElementStateToBe(By.xpath("//a//span[starts-with(*,'Perform')]"),
					"CLICKABLE", driver), "Check box is not clickable");
			cmPageHelper.clickElement(By.xpath("//a//span[starts-with(*,'Perform')]"), driver);
		} catch (Exception e) {
			throw e;
		}
	}

	// Naman
	public void waitForCardToBeDisplayed(WebDriver driver, String cardName) throws InterruptedException {
		// Switch to connect mobile framework
		cmPageHelper.switch_To_ConnectMobileModule(driver);
		// Thread.sleep(2000);
		WebElement Element = null;
		List<WebElement> Nodes = cmPageHelper.waitForElementToBe(
				By.cssSelector("div[id^='ext-conm-cards-index-'] div[id^='ext-conm-cards-thumbnail-']"), "VISIBLE",
				driver, 60);
		for (WebElement ChildNode : Nodes) {
			if (ChildNode.getText().contains(cardName)) {
				Element = ChildNode;
				break;
			}
		}
		assertNotNull(Element);

		cmPageHelper.findEvent();
		cmPageHelper.findAction();
	}

	public void clickOnWorkloadEventTab(WebDriver driver, String event) throws InterruptedException {
		List<WebElement> elList = cmPageHelper.getWebElementsList(
				By.cssSelector("div[id^='tasksByObjectTabs-'] div[id^='tasksByObjectTabs-'] div.x-tab-bar a"), driver);

		int size = elList.size();
		for (int i = 0; i < size; i++) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			if (elList.get(i).getText().isEmpty()) {
				String tab = (String) executor.executeScript("return arguments[0].text;", elList.get(i));
				if (tab.contains(event)) {
					executor.executeScript("arguments[0].click();", elList.get(i));
					break;
				}
			} else if (elList.get(i).getText().contains(event)) {
				elList.get(i).click();
				break;
			}
		}
	}

	public void clickOnWorkloadEventTab(WebDriver driver, String event, int j) throws InterruptedException {
		List<WebElement> elList = null;
		elList = cmPageHelper.waitForElementToBe(
				By.cssSelector("div[id^='tasksByObjectTabs-'] div[id^='tasksByObjectTabs-'] div.x-tab-bar a"),
				"PRESENCE", driver, 10);

		int size = elList.size();

		mainloop: for (int i = j; i <= size; i++) {
			if (!elList.get(i).getText().isEmpty()) {
				if (elList.get(i).getText().contains(event)) {
					String id = elList.get(i).getAttribute("id");
					driver.findElement(By.cssSelector("a[id='" + id + "']")).click();
					break;
				}
			} else {
				WebElement rightScrollBar = driver.findElement(By.cssSelector(
						"div[id^='tasksByObjectTabs-'] div[id^='tasksByObjectTabs-'] div.x-tab-bar div.x-box-scroller-right"));
				for (int m = 1; m <= 4; m++)
					rightScrollBar.click();
				clickOnWorkloadEventTab(driver, event, i);
				break mainloop;
			}
		}
	}

	public void verifyIntelReportsLinking() {
		Assert.assertTrue(false);
	}

	// Naman
	// Shiv - 11/12 - Changed to get the 'My View' from 'My Team' section
	public void clickWorkloadMyView(WebDriver driver, String TeamName) throws InterruptedException {
		Thread.sleep(500);
		cmPageHelper.clickElement(By.xpath("//span[contains(text(),'My Team')]"), driver);
		cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
		WebElement unitsDropdown = cmPageHelper.getInputFromLabel(driver, "Team Members");
		Thread.sleep(500);
		unitsDropdown.click();
		cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
		Thread.sleep(500L);
		unitsDropdown.sendKeys(Keys.ARROW_DOWN); // This opens the List
		Thread.sleep(1000L);
		List<WebElement> ddlBox = driver.findElements(By.cssSelector("ul li"));

		for (WebElement elDDL : ddlBox) {
			if (elDDL.getText().equals(TeamName)) {
				elDDL.click();
				cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
				break;
			}
		}
	}

	// Naman
	public void selectTabInMyView(String tab, WebDriver driver) {
		// a//span[contains(text(),'Intelligence Report')]
		try {
			String xpath = "//span[contains(text(),'" + tab + "')]/ancestor::a";
			switch (tab) {
			case "Case":
				cmPageHelper.clickElement(By.xpath(xpath), driver);
				break;
			case "Intelligence Report":
				cmPageHelper.clickElement(By.xpath(xpath), driver);
				break;
			case "Incident":
				cmPageHelper.clickElement(By.xpath(xpath), driver);
				break;
			}

			Thread.sleep(2000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectURNViewTab(WebDriver driver, String intelRefNumber) {
		try {
			cmPageHelper.deselectCheckbox(driver);
			int colNumber = cmPageHelper.getColumnNumber(driver, "URN");
			WebElement checkBoxURN = driver
					.findElement(By.xpath("//div[@class='x-grid-item-container']//table//td/div[contains(text(),'"
							+ intelRefNumber + "')]//..//..//td[" + colNumber + "]"));
			assertNotNull(checkBoxURN);
			Thread.sleep(1000);
			checkBoxURN.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Naman
	public void selectActionGroup(String group, WebDriver driver) throws Exception {
		String css = "div[id^='linkedactions-'][id$='-innerCt'] input";
		WebElement elActionGroup = driver.findElement(By.cssSelector(css));
		cmPageHelper.clearField(elActionGroup);
		elActionGroup.sendKeys(group);
		elActionGroup.sendKeys(Keys.TAB);
	}

	public void validateEventStatusNotLiveOrLiveSensitive(String eventStatus, String eventId, WebDriver driver) {
		try {
			int colNumber = cmPageHelper.getColumnNumber(driver, "Event Status");

			String actualStatus = driver.findElement(By.xpath(
					("//div[@class='x-grid-item-container']//table//td/div[contains(text(),'<eventId>')]//..//..//td["
							+ colNumber + "]").replace("<eventId>", eventId)))
					.getText().trim();
			Assert.assertFalse(eventStatus.trim().equalsIgnoreCase(actualStatus.trim()),
					"Status is not as expected for event id :" + eventId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickMyViewTab(WebDriver driver) {
		try {
			cmPageHelper.waitForElementStateToBe(By.xpath("//span[contains(text(),'My View')]"), "CLICKABLE", driver);
			cmPageHelper.clickElement(By.xpath("//span[contains(text(),'My View')]"), driver);
		} catch (Exception e) {
			throw e;
		}
	}

	public String captureInformationText(WebDriver driver) {
		try {
			Assert.assertTrue(cmPageHelper.waitForElementStateToBe(
					By.xpath("//td/p/span[contains(text(),'Information text')]/../../following-sibling::td"), "VISIBLE",
					driver), "Information Text is not loaded");
			return driver
					.findElement(
							By.xpath("//td/p/span[contains(text(),'Information text')]/../../following-sibling::td"))
					.getText().trim();
		} catch (Exception e) {
			throw e;
		}
	}

	public void validateFieldValueInDashboardTab(String field, String value, WebDriver driver) {
		try {
			WebElement tabElement = driver.findElement(By.xpath("//span[text()='Dashboard']"));
			tabElement.click();
			String xpath = "//td/p/span[contains(text(),'" + field + "')]/../../following-sibling::td";
			WebElement we = cmPageHelper.waitForElementToBe(By.xpath(xpath), "VISIBLE", driver);
			assertNotNull(we);
			Assert.assertTrue(we.getText().trim().equalsIgnoreCase(value.trim()), "Field value doesnt match :" + field);
			Log.info("Field value is matching for field :" + field);
		} catch (Exception e) {
			throw e;
		}

	}

	private void selectPVTab(WebDriver driver, String tabName) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean tabNameFound = false;
		List<WebElement> elAllTabs = driver.findElements(By.cssSelector("div.pv-rhs-panel a.x-tab"));

		// To click on right scroll button
		try {
			WebElement elRightScroll = cmPageHelper.getDisplayedElement(driver.findElements(By.cssSelector("div.pv-rhs-panel div.x-box-scroller-right")));
			if(elRightScroll!=null) {
				for (int i = 0; i <= elAllTabs.size() * 2; i++) {
					elRightScroll.click();
				}
			}
		} catch (ElementNotVisibleException elNotVisible) {
			Log.info("Right scroll button is not visible on workload's pole viewer screen.");
		}

		// To select the pole viewer tab
		for (WebElement tab : elAllTabs) {
			String actualTabName = tab.getText();
			if (actualTabName.equalsIgnoreCase(tabName)) {
				tab.click();
				tabNameFound = true;
				break;
			}
		}
		if (!tabNameFound) {
			Log.error("Tab name '" + tabName + "' not found on the screen.");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void validateInvestigationType(String type, String eventId, WebDriver driver) throws InterruptedException {
		int colNumber = cmPageHelper.getColumnNumber(driver, "Investigation Type");
		// Thread.sleep(1000);
		String actualType = driver.findElement(By.xpath(
				("//div[@class='x-grid-item-container']//table//td/div[contains(text(),'<eventId>')]//..//..//td["
						+ colNumber + "]").replace("<eventId>", eventId)))
				.getText().trim();
		Assert.assertTrue(type.trim().equalsIgnoreCase(actualType.trim()),
				"Investigation Type is not as expected for event id :" + eventId);
	}

	public void clickMyViewTab(WebDriver driver, String workloadTab) {
		try {
			cmPageHelper.waitForElementStateToBe(By.xpath("//span[text()='" + workloadTab + "']/ancestor::a"),
					"CLICKABLE", driver);
			cmPageHelper.clickElement(By.xpath("//span[text()='" + workloadTab + "']/ancestor::a"), driver);
			cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
			cmPageHelper.waitForPageLoadMsgToBeInvisible("Loading");
		} catch (Exception e) {
			throw e;
		}
	}

	public String getValueForOIC(WebDriver driver, String oic, int oicColumnId, boolean click)
			throws InterruptedException {
		boolean oicFound = false;
		int staffColumn = 1;
		// Code to select Full tab
		if (click)
			selectPVTab(driver, "Full");
		// Get Task name column number
		List<WebElement> staffColumnValue = driver.findElements(By.cssSelector(
				"div.entity-type-incidentOfficerInCase div[id^='pole-gridpanel-'] div[class^='x-panel-body'] table tr td:nth-child("
						+ staffColumn + ")"));
		List<WebElement> oicColumnValue = driver.findElements(By.cssSelector(
				"div.entity-type-incidentOfficerInCase div[id^='pole-gridpanel-'] div[class^='x-panel-body'] table tr td:nth-child("
						+ oicColumnId + ")"));
		int row = 0;
		for (WebElement columnElement : staffColumnValue) {
			String oicName = columnElement.getText();
			String colValue = oicColumnValue.get(row).getText();
			if (oicName.equalsIgnoreCase(oic)) {
				oicFound = true;
				return colValue;
			}
			row++;
		}
		return null;
	}

	public void user_add_units_in_workload_tab(String unitToBeAdded, WebDriver driver) throws Exception {
		List<WebElement> we = driver.findElements(By.xpath("//a//span[contains(text(),'Add/Remove Unit(s)')]"));
		if (we.size() != 0)
			we.get(0).click();
		cmPageHelper.switch_To_Default(driver);
		boolean foundFlag = false;
		// Get initial list of Available units
		List<WebElement> initialList = driver.findElements(By.xpath(
				"//div[@id='roleLookupRolesGrid']//div[contains(@class,'-body')]//table//td[contains(@class,'unitName')]"));
		for (WebElement unit : initialList) {
			String currentUnit = unit.getText().trim();
			if (currentUnit.equalsIgnoreCase(unitToBeAdded)) {
				unit.click();
				foundFlag = true;
				break;
			}
		}
		String firstUnit = "";
		while (foundFlag != true) {
			firstUnit = initialList.get(initialList.size() - 1).getText().trim();
			initialList.get(initialList.size() - 1).click();
			// initialList.get(initialList.size() - 1).sendKeys(Keys.ARROW_DOWN);
			initialList = driver.findElements(By.xpath(
					"//div[@id='roleLookupRolesGrid']//div[contains(@class,'-body')]//table//td[contains(@class,'unitName')]"));
			String currentUnit = initialList.get(initialList.size() - 1).getText();
			if (currentUnit.equalsIgnoreCase(unitToBeAdded)) {
				foundFlag = true;
				initialList.get(initialList.size() - 1).click();
				break;
			}
			if (firstUnit.equalsIgnoreCase(currentUnit)) {
				break;
			}
		}

		if (foundFlag) {
			driver.findElement(By.xpath("//button[text()='Add']")).click();
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			cmPageHelper.switch_To_Default(driver);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='WorkloadModule-']")));
			// cmPageHelper.switch_To_WorkloadModule(driver);
			Thread.sleep(5000);
			cmPageHelper.waitForPageLoadMsgToBeInvisible("Processing");
			clickWorkloadMyUnits(driver, unitToBeAdded);
		}

	}

	public void selectEventFromUnits(WebDriver driver, String unit, String eventId, String eventType) throws Exception {
		String unitName = null;
		cmPageHelper.switch_To_LaunchPadModule(driver);
		Assert.assertTrue(eventId.length() > 0, "Event reference number is not captured");
		clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		if (unit.equalsIgnoreCase("assessment units")) {
			unitName = properties.getProperty("DefaultAssessmentUnit");
		} else if (unit.equalsIgnoreCase("reviewing units")) {
			unitName = properties.getProperty("DifferentReviewUnit");
		} else if (unit.equalsIgnoreCase("default IMU units")) {
			unitName = properties.getProperty("DefaultIMUUnit");
		} else if (unit.equalsIgnoreCase("default owning units")) {
			unitName = properties.getProperty("DefaultOwningUnit");
		} else if (unit.equalsIgnoreCase("CMT Sgt Unit")) {
			unitName = properties.getProperty("CaseCMTSgtUnit");
		} else if (unit.equalsIgnoreCase("Supervisory Unit")) {
			unitName = properties.getProperty("CaseSupervisoryUnit");
		} else {
			unitName = properties.getProperty(unit);
		}

		Thread.sleep(1000);
		clickWorkloadMyUnits(driver, unitName);
		clickOnMyUnitsGraph(driver);
		selectURN(driver, eventId, eventType);
		Log.info("Event record selected in workload tab");
	}

	public void selectEventForUser(WebDriver driver, String user, String eventId, String eventType) throws Exception {
		cmPageHelper.switch_To_LaunchPadModule(driver);
		Assert.assertTrue(eventId.length() > 0, "Event reference number is not captured");
		clickOnWorkloadIcon();
		cmPageHelper.switch_To_WorkloadModule(driver);
		Thread.sleep(1000);
		clickWorkloadMyView(driver, properties.getProperty(user));
		clickOnMyUnitsGraph(driver);
		selectURN(driver, eventId, eventType);
		Log.info("Event record selected in workload tab");
	}
	
}
