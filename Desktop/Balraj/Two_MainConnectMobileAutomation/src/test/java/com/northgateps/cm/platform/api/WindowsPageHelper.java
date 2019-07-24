package com.northgateps.cm.platform.api;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.northgateps.cm.cases.common.CaseUtility;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;

public class WindowsPageHelper extends Utility {

	public static AppiumDriver<WebElement> appiumDriver = null;
	static Properties properties;
	static String values;
	static final String noReset = "false";
	static final String fullReset = "true";
	static final int mobileImplicitWait = 40;
	static WebDriverWait mobileWait;
	private static final String SERVERURL = "http://127.0.0.1:4723";
	String url, driverPath;
	private Scenario scenario;

	public static final String WINDOWS_PLATFORM_NAME = "windows";
	public static final String WINDOWS_DEVICE_NAME = "WindowsPC";
	public static String WINDOWS_APP_PACKAGE_NAME ;// Application
	private static Logger Log = Logger.getLogger(WindowsPageHelper.class.getName());
	
	public WindowsPageHelper() throws Exception {
		super();
		properties = Utility.loadProperties();
	}

	public static AppiumDriver<WebElement> setWindowsDriver() throws Exception {

		System.out.println(WINDOWS_APP_PACKAGE_NAME + " running on machine");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", WINDOWS_APP_PACKAGE_NAME);
		capabilities.setCapability("deviceName", WINDOWS_DEVICE_NAME);
		capabilities.setCapability("platformName", WINDOWS_PLATFORM_NAME);

		appiumDriver = new WindowsDriver<WebElement>(new URL(SERVERURL), capabilities);
		appiumDriver.manage().timeouts().implicitlyWait(mobileImplicitWait, TimeUnit.SECONDS);
		return appiumDriver;
	}

	private void clickElementGroupWithName(String name) {

		appiumDriver.findElementByXPath("//*[@Name='" + name + "']/parent::Group").click();
	}
	
	private void clickElementGroupWithPartialName(String name) {

		appiumDriver.findElementByXPath("//*[contains(@Name,'" + name + "')]/parent::Group").click();
	}

	public void clickElementByAccessibilityId(AppiumDriver<WebElement> driver, String id) {
		driver.findElementByAccessibilityId(id).click();
	}

	public void clickElementByName(AppiumDriver<WebElement> driver, String name) {
		driver.findElementByName(name).click();
	}

	public void clickElementByXpath(AppiumDriver<WebElement> driver, String xpath) {
		driver.findElementByXPath(xpath).click();
	}

	public void clickIcon(String eventName) throws Exception {
		clickElementGroupWithPartialName(eventName);
		Thread.sleep(1000);
	}

	public void clickOnCard(String cardName) {
		appiumDriver.findElementByXPath("//Group[starts-with(@AutomationId,'ext-conm-cards-thumbnail')][Text[@Name='"
				+ cardName + "']]//Button").click();

	}

	public void inputElement(String fieldLabel, String fieldValue) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		WebElement Editbox = appiumDriver
				.findElementByXPath("//Text[@Name='" + fieldLabel + "']/parent::Text/following-sibling::Edit");
		Editbox.clear();
		Editbox.sendKeys(fieldValue);
		Editbox.sendKeys(Keys.TAB);
		Thread.sleep(100);
	}

	public void addARepeatingGroup(String fieldLabel) throws Exception {
		clickOnButtonWithText("Add New " + fieldLabel);
		Thread.sleep(500);
	}

	public void clickOnYesOrNoButton(String fieldLabel, String fieldValue) {
		appiumDriver.findElementByXPath("//Text[@Name='" + fieldLabel
				+ "']/parent::Text/following-sibling::Group[Text[@Name='" + fieldValue + "']]").click();

	}

	public void inputDateTime(String fieldLabel, String fieldValue) throws Exception {
		String[] dateTime = fieldValue.split(" => ");
		String date = dateTime[0];
		date = returnFieldValue(date);
		appiumDriver.findElementByXPath("//Text[@Name='" + fieldLabel + "']/parent::Text/following-sibling::Edit[1]")
				.sendKeys(date);
		if (dateTime.length > 1) {
			String time = dateTime[1];
			time = returnFieldValue(time);
			appiumDriver
					.findElementByXPath("//Text[@Name='" + fieldLabel + "']/parent::Text/following-sibling::Edit[2]")
					.sendKeys(time);
		}

	}

	private void clickOnButtonWithText(String text) {
		appiumDriver.findElementByXPath("//Text[@Name='" + text + "']/parent::Group/Button").click();
	}

	public void inputElementWithKthRepetition(String fieldLabel, String fieldValue, int k) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		WebElement Editbox = appiumDriver.findElementByXPath(
				"//Text[@Name='" + fieldLabel + "'][" + k + "]/parent::Text/following-sibling::Edit");
		Editbox.clear();
		Editbox.sendKeys(fieldValue);
		Editbox.sendKeys(Keys.TAB);

	}

	public void inputLookUp(String fieldLabel, String fieldValue) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		Thread.sleep(300);
		appiumDriver
				.findElementByXPath("//Text[@Name='" + fieldLabel + "']/parent::Text/following-sibling::Group/Button")
				.click();
		Thread.sleep(1000);
		clickOnButtonWithText("Filter");
		Thread.sleep(1000);
		clickOnButtonWithText("Apply Filters");
		Thread.sleep(1000);
		appiumDriver.findElementByXPath("//Text[@Name='" + fieldValue + "']/parent::Group").click();
		Thread.sleep(200);
		clickOnButtonWithText("Apply");
		Thread.sleep(1000);
	}

	public void userSavesCard(String string) throws Exception {
		Thread.sleep(500);
		clickOnButtonWithText("Save & Return");
	}

	public void clickOnTab(String tabName) {
		appiumDriver.findElementByXPath(
				"//Text[@Name='" + tabName + "']/parent::Group[starts-with(@AutomationId,'ext-tab')]").click();
	}

	public String getEventName() {
		return appiumDriver.findElementByXPath("//Text[@Name='Type:']/following-sibling::Text").getAttribute("Name");
	}

	public void userSetsTheCardAsNotApplicable(String cardName) throws Exception {
		Thread.sleep(500);
		clickOnButtonWithText("No, card not required");
		String openedScreen = appiumDriver.findElementByXPath("//Pane[@Name='ConM']/Group[2]/Text").getAttribute("Name");
		if (openedScreen.contains(cardName)) {
			clickOnBackButton();
		}
	}

	public String getCardStatus(String cardName, String linkReason) {
		cardName = getCompleteCardName(cardName, linkReason);
		String status = appiumDriver
				.findElementByXPath(
						"//Text[@Name='" + cardName + "']/parent::Group/Text[last()]/preceding-sibling::Text[1]")
				.getAttribute("Name");
		return status;
	}

	public String getCompleteCardName(String cardName, String linkReason) {
		if (!linkReason.equals(""))
			return cardName + " (" + linkReason + ")";
		else
			return cardName;
	}

	public void submitRecord() {
		clickOnButtonWithText("Submit");
		confirmSubmission();
	}

	private void confirmSubmission() {
		appiumDriver.findElementByXPath(
				"//Group[starts-with(@AutomationId,'ext-paneltool')]/following-sibling::Group[Text[@Name='Submit']]")
				.click();

	}

	public void clickOnDone(String urn) {
		appiumDriver.findElementByXPath("//Text[@Name='" + urn + "']/following-sibling::Group[Text[@Name='Done']]")
				.click();
	}

	public void userSetsTheCardAsApplicable(String cardName) throws Exception {
		Thread.sleep(500);
		if (!cardName.equalsIgnoreCase("Defendant") && !cardName.equalsIgnoreCase("Seizure Location")
				&& !cardName.equalsIgnoreCase("Property Item (Seized / Detained)")) {
			clickOnButtonWithText("Yes, card required");
		}

	}

	public void clickOnNext() {

		clickOnButtonWithText("Next");
	}

	public void clickOnNoneOfThesePresent() throws Exception {
		Thread.sleep(7000);
		String name = appiumDriver.findElementByXPath("//Pane[@Name='ConM']/Group[last()]/Text").getAttribute("Name");
		if (name.contains("None of these")) {
			appiumDriver.findElementByXPath("//Pane[@Name='ConM']/Group[last()]").click();
		}

	}

	public void clickOnBackButton() {

		appiumDriver.findElementByXPath("//Pane[@Name='ConM']/Group[1]").click();
	}

	public void clickOnNextForStaticObject() throws Exception {
		Thread.sleep(200);
		clickOnNext();
		clickOnNoneOfThesePresent();

	}

	public void selectFromDropdownWithKthRepetition(String fieldLabel, String fieldValue, int k) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		WebElement Editbox = appiumDriver.findElementByXPath(
				"//Text[@Name='" + fieldLabel + "'][" + k + "]/parent::Text/following-sibling::Edit");
		Editbox.clear();
		Editbox.sendKeys(fieldValue);
		Editbox.sendKeys(Keys.ENTER);

		Editbox.sendKeys(Keys.TAB);

	}

	public void selectFromDropdown(String fieldLabel, String fieldValue) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		WebElement Editbox = appiumDriver.findElementByXPath(
				"//Text[@Name='" + fieldLabel + "']/ancestor-or-self::Text/following-sibling::Edit");
		Editbox.clear();
		Editbox.sendKeys(fieldValue);
		Editbox.sendKeys(Keys.ENTER);

		Editbox.sendKeys(Keys.TAB);

	}

	public void CloseFailedTest(String LogFilePath, String ScreenShotFilePath, String TestStep, String TestName,
			String TestEnv, Throwable ExceptionVal) throws Exception {
		// Send Comment to Jenkins LogFile
		Log.error(TestStep + " - " + "Test execution has failed.  Screenshot will be taken and Browser closed.");

		// Take Screenshot
		TakeScreenShot(ScreenShotFilePath, TestName, TestEnv);

		// Grab StackTrace & write to textfile with same rules as Screenshot
		DumpStackTrace(ScreenShotFilePath, TestName, TestEnv, ExceptionVal);
		Log.error("Test failed due to this exception -- " + ExceptionVal.toString());
		// Close APP
		quitApp();
		Assert.fail("This needs to be set as a Fail");

	}

	private void TakeScreenShot(String screenShotFilePath, String testName, String testEnv) {
		Date TodayDate = new Date();
		String ExecutionDate = "";
		ExecutionDate = FormatDateTime(TodayDate, ExecutionDate);

		try {// Added due to issues with the screenshot taker on remote boxes.
			File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(
					screenShotFilePath + "\\" + testName + "_" + testEnv + "_" + ExecutionDate + "_SCREEN.jpg");
			FileUtils.copyFile(scrFile, targetFile);

			// To get the screenshot embed in cucumber report
			scenario.write("Scenario failed : Screenshot captured and embeded in report.");
//			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			byte[] fileContent = Files.readAllBytes(targetFile.toPath());
			scenario.embed(fileContent, "image/jpg");
		} catch (Exception ScreenShot) {
			Log.error("Screenshot capture ERROR!");
		}

	}

	public void logInWithRoles(String username, String password, String roles) throws Exception {
		username = properties.getProperty("mobile" + username);
		String usernameWords[] = username.split(" ");
		username = usernameWords[usernameWords.length - 1];
		password = properties.getProperty(password);
		WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("Edit")));
		inputElement("Select User", username);

		selectEventRoles(roles);
		clickElementGroupWithName("Log In");

		Thread.sleep(3000);
		clickElementGroupWithName("Continue");
		Thread.sleep(3000);
		clickElementGroupWithName("Continue");
		Thread.sleep(3000);

		Log.info("User login success");
	}

	private void selectEventRoles(String roles) {
		try {
			roles = properties.getProperty(roles);
			if (!roles.isEmpty()) {
				String[] allroles = roles.split(",");
				for (String i : allroles) {
					selectCheckboxForRoles(i);
				}
			}
		} catch (Exception e) {
			Log.info("unable to select roles");
		}
	}

	private void selectCheckboxForRoles(String i) {
		
		WebElement checkbox = appiumDriver.findElementByXPath("//Text[@Name='" + i + "']/parent::Text/following-sibling::CheckBox");
		if(!checkbox.isSelected())
			checkbox.click();
	}

	public void quitApp() throws Exception {
		Thread.sleep(300);
		appiumDriver.findElementByName("Close ConnectMobile").click();

	}

	public void inputOfficer(String fieldLabel, String fieldValue) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		WebElement ele = appiumDriver.findElementByXPath("//Text[@Name='" + fieldLabel + "']/following-sibling::Edit");
		ele.click();
		ele.sendKeys(fieldValue);
	}

	public void validateEventStatus(String caseURN, String expEventStatus) {
		WebElement ele = appiumDriver.findElementByXPath("//Text[@Name='" + caseURN + "']/parent::Group/Text[last()]");

		String actualCardStatus = ele.getAttribute("Name");
		assertTrue(expEventStatus.equalsIgnoreCase(actualCardStatus),
				"Case '" + caseURN + "' does not have expected status as '" + expEventStatus + "'.");
	}

	public void selectViewInTaskDashboardforEventRef(String view, String event, String URN) throws Exception {
		Thread.sleep(3000);
		WebElement ele = appiumDriver
				.findElementByXPath("//Text[@Name='View']/following-sibling::Group/Group[*[@Name='" + view + "']]");
		ele.click();
		Thread.sleep(1000);
		ele = appiumDriver.findElementByXPath(
				"//Text[@Name='" + view + "']/following-sibling::Group[2]/Group[*[contains(@Name,'" + event + "')]]");
		ele.click();
		ele = appiumDriver.findElementByXPath(
				"//Text[@Name='" + event + "']/following-sibling::Group[2]/Group[*[@Name='" + URN + "']]");
		// ele = appiumDriver.findElementByXPath("//Text[@Name='" + caseURN + "']");
		ele.click();
	}

	public void validateTaskHistoryEntry(String taskEntry) throws Exception{
		Thread.sleep(1000);
		List<WebElement> taskHistoryTableCells  = appiumDriver.findElementsByXPath("//Table[*[@Name='Task history']]/DataItem");
		for (WebElement i:taskHistoryTableCells) {
			if (i.getAttribute("Name").equalsIgnoreCase(taskEntry)) {
				assertTrue(i.getAttribute("Name").equalsIgnoreCase(taskEntry));
				return;
			}
		}
		throw new AssertionError("task history entry "+taskEntry+" not found");
	}

	public void validateTaskRaised(String exptask) {
		WebElement taskRaised = appiumDriver.findElementByXPath("//Pane[@Name='ConM']/Text[last()]");
		String actualTask = taskRaised.getAttribute("Name");
		assertTrue(actualTask.equalsIgnoreCase(exptask));
	}

	public void performTaskFromTaskDashboard(String task) {
		WebElement performButton = appiumDriver.findElementByXPath("//Pane[@Name='ConM']/Text[@Name='"+task+"']/following-sibling::Group[*[@Name='Perform']]/Button");
		performButton.click();
	}

	public String getURN(String event) {
		
			String message = "the Unique Reference Number (URN) is:";
			String urn = appiumDriver.findElementByXPath("//Text[contains(@Name,'"+message +"')]/following-sibling::Text").getAttribute("Name");
			CaseUtility.CaseRefNumber = urn;
			System.out.println(event+" Unique Reference Number: " + urn);
			Log.info("'"+event+"' with Reference "+urn+" generated");
			
			return urn;
	
	}


}
