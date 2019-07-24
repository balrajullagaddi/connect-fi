
package com.northgateps.cm.platform.api;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.northgateps.cm.threads.AppiumThread;

import cucumber.api.Scenario;
import edu.emory.mathcs.backport.java.util.Arrays;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobilePageHelper extends Utility {

	public static AppiumDriver<MobileElement> appiumDriver = null;
	static Properties properties;
	static String values;
	static final String noReset = "false";
	static final String fullReset = "true";
	static final int mobileImplicitWait = 1000;
	static WebDriverWait mobileWait;
	private static String contentDesc = "";
	
	private static String SERVERURL = null;
	String url, driverPath;
	private static Logger Log = Logger.getLogger(MobilePageHelper.class.getName());
	private Scenario scenario;
	
	private static String clearSystemFiles = "true";

	public MobilePageHelper() throws Exception {
		super();
		properties = Utility.loadProperties();
	}

	public static void setSERVERURL(String sERVERURL) {
		SERVERURL = sERVERURL;
	}

	public static AppiumDriver<MobileElement> setAndroidDriver() throws Exception {
		properties = Utility.loadProperties();
		DesiredCapabilities desiredCapabilities = null;
		File app = null;

		app = new File("src/main/resources/mobile_apps/apks/" + Utility.testEnvironment + ".apk");
		desiredCapabilities = new DesiredCapabilities();
//			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		desiredCapabilities.setCapability("noReset", noReset);
//			desiredCapabilities.setCapability("fullReset", fullReset);
		desiredCapabilities.setCapability("deviceName", AppiumThread.DeviceName);
		desiredCapabilities.setCapability("deviceId", AppiumThread.DeviceID);
			desiredCapabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		desiredCapabilities.setCapability("automationName", "UIAutomator2");
		desiredCapabilities.setCapability("platformName", Utility.platform);
		desiredCapabilities.setCapability("app", app.getAbsolutePath());
		desiredCapabilities.setCapability("clearSystemFiles", clearSystemFiles);
		appiumDriver = new AndroidDriver<MobileElement>(new URL(SERVERURL), desiredCapabilities);
		appiumDriver.manage().timeouts().implicitlyWait(mobileImplicitWait, TimeUnit.SECONDS);

		appiumDriver.rotate(ScreenOrientation.PORTRAIT);
		setContentDesc();
		return appiumDriver;
	}

	public static void setContentDesc() {
		MobileElement app =  appiumDriver.findElementByXPath("//android.webkit.WebView/android.webkit.WebView");
		if (app.getAttribute("content-desc") != null && app.getAttribute("content-desc").equals("ConM")) {
			contentDesc = "content-desc";
		}
		else if (app.getAttribute("text") != null && app.getAttribute("text").equals("ConM")) {
			contentDesc = "text";
		}
	}
	
	private String getXpathOfElementWithText(String text) {
		return "//android.view.View[@" + contentDesc + "='" + text + "']";
	}

	private String getXpathOfElementWithPartialText(String text) {
		return "//android.view.View[contains(@" + contentDesc + ",'" + text + "')]";
	}

	private String getXpathOfParentAtLevelWithText(String text, int level) {
		String xpath = "android.view.View[@" + contentDesc + "='" + text + "']";
		for (int i = 0; i < level; i++) {
			xpath = "*[" + xpath + "]";
		}
		return "//" + xpath;
	}

	private String getXpathOfParentAtLevelWithPartialText(String text, int level) {
		String xpath = "android.view.View[contains(@" + contentDesc + ",'" + text + "')]";
		for (int i = 0; i < level; i++) {
			xpath = "*[" + xpath + "]";
		}
		return "//" + xpath;
	}

	public static void setImplicitWait(long time) {
		try {
			appiumDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.error("Failed to set implicit wait");
		}
	}

	public void inputElement(AppiumDriver<MobileElement> driver, String label, String fieldValue) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		List<MobileElement> elements = driver
				.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2) + "//android.widget.EditText");

		Thread.sleep(1000);

		boolean elementIsEmpty = (elements.get(0).getText().contains(label)) || (elements.get(0).getText().equals(""));
		if (!elementIsEmpty) {
			clearField(driver, label);
		}

		elements.get(0).click();
		elements.get(0).sendKeys(fieldValue);
		MobileElement parentElement = driver.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2)).get(0);
		swipeUp(parentElement.getSize().height);
		Thread.sleep(1000);
	}

	public void inputElement2(AppiumDriver<MobileElement> driver, String label, String fieldValue) throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		List<MobileElement> elements = driver
				.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2) + "//android.widget.EditText");

		Thread.sleep(1000);

		boolean elementIsEmpty = (elements.get(1).getText().contains(label)) || (elements.get(1).getText().equals(""));
		if (!elementIsEmpty) {
			clearField2(driver, label);
		}
		elements.get(1).click();
		elements.get(1).sendKeys(fieldValue);
	}

	public void clearField(AppiumDriver<MobileElement> driver, String label) {
		List<MobileElement> elements = driver.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2)
				+ "//android.view.View[starts-with(@resource-id,'ext-cleartrigger')]");

		elements.get(0).click();
	}

	public void expandField(AppiumDriver<MobileElement> driver, String label) {
		List<MobileElement> elements = driver.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2)
				+ "//android.view.View[starts-with(@resource-id,'ext-expandtrigger')]");

		elements.get(0).click();
	}

	public void clearField2(AppiumDriver<MobileElement> driver, String label) {
		List<MobileElement> elements = driver.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2)
				+ "//android.view.View[starts-with(@resource-id,'ext-cleartrigger')]");

		elements.get(1).click();

	}

	public void clickOnButtonEventObjectSaveReturn() throws InterruptedException {
		clickButton(appiumDriver, "Save & Return");

	}

	public void clickOnEventCardName(String cardName) {
		System.out.println(appiumDriver.toString());
		appiumDriver.findElementByXPath("//*[@class='android.view.View' and @text='" + cardName
				+ "']/parent::android.view.View/parent::android.view.View/parent::android.view.View/preceding-sibling::android.view.View/android.widget.Button")
				.click();
	}

	public void clickElementByAccessibilityId(AppiumDriver<MobileElement> driver, String accID)
			throws InterruptedException {
		try {
			Thread.sleep(2000);
			MobileElement me = driver.findElementByXPath("//android.webkit.WebView[@" + contentDesc + "='ConM']");
			MobileElement mobileElement = me
					.findElementByXPath("//android.view.View[@" + contentDesc + "='" + accID + "']");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			mobileElement.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickButton(AppiumDriver<MobileElement> driver, String button) throws InterruptedException {
		MobileElement element = driver
				.findElementByXPath(getXpathOfParentAtLevelWithText(button, 3) + "//android.widget.Button");
		Thread.sleep(500);
		if (element.isDisplayed())
			element.click();
	}

	public void clickIcon(AppiumDriver<MobileElement> driver, String iconText) {

		List<MobileElement> elementList = driver.findElementsByXPath(getXpathOfElementWithPartialText(iconText));
		elementList.get(elementList.size() - 1).click();
	}

	public void selectLookupUnit(AppiumDriver<MobileElement> driver, String label, String unit) throws Exception {

		MobileElement element = driver
				.findElementByXPath(getXpathOfParentAtLevelWithText(label, 3) + "//android.widget.Button");
		Thread.sleep(1000);

		element.click();
		Thread.sleep(1000);
		unit = returnFieldValue(unit);
//			MobileElement ddlElement = driver.findElementByXPath(
//					"//android.view.View[@resource-id='ext-global-floatWrap']//android.view.View[starts-with(@resource-id,'ext-conm-dropdownfield')]");
//			MobileElement editTextElement = ddlElement.findElementByXPath("//android.widget.EditText");
//			Thread.sleep(1000);

//			editTextElement.sendKeys(Keys.END);
//			editTextElement.sendKeys(Keys.END);
//			editTextElement.sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.DELETE));
//			editTextElement.sendKeys(returnFieldValue("Force"));

		// Click on filter button
		clickElementByAccessibilityId(driver, "Filter");

		// Click on Apply Filter button
		clickElementByAccessibilityId(driver, "Apply Filters");

		// Select unit value from list
		Thread.sleep(5000);
		List<MobileElement> units = driver
				.findElementsByXPath("//android.view.View[starts-with(@resource-id,'ext-simplelistitem')]");
		for (MobileElement i : units) {
			if (i.getAttribute("" + contentDesc + "").contains(unit)) {
				i.click();
				break;
			}
		}

		// Click on Apply button
		clickElementByAccessibilityId(driver, "Apply");
		swipeUp(driver.findElementByXPath(getXpathOfParentAtLevelWithText(label, 5)).getSize().height);
	}

	public void clickYesNoButton(AppiumDriver<MobileElement> driver, String label, String button) throws Exception {

		MobileElement element = driver.findElementByXPath(
				getXpathOfParentAtLevelWithPartialText(label, 2) + getXpathOfElementWithText(button));

		element.click();
		Thread.sleep(100);
		swipeUp(driver.findElementByXPath(getXpathOfParentAtLevelWithPartialText(label, 2)).getSize().height);
	}

	public void clickYesNoCardRequiredButton(AppiumDriver<MobileElement> driver, String button) throws Exception {

		String buttonText = "";
		if (button.equalsIgnoreCase("No"))
			buttonText = "No, card not required";
		else if (button.equalsIgnoreCase("Yes"))
			buttonText = "Yes, card required";
		clickButton(driver, buttonText);

	}

	public String getURN(AppiumDriver<MobileElement> driver, String year) {
		MobileElement element = driver.findElementByXPath("//android.view.View[@resource-id='ext-messagebox-floatWrap']"
				+ getXpathOfElementWithPartialText("/" + year));
		String urn = element.getAttribute("" + contentDesc + "");
		return urn;
	}

	public void selectValueFromDropDown(AppiumDriver<MobileElement> driver, String label, String fieldValue)
			throws Exception {
		fieldValue = returnFieldValue(fieldValue);
		List<MobileElement> elements;
		if (!fieldValue.isEmpty()) {
			elements = driver
					.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2) + "//android.widget.EditText");

			Thread.sleep(1000);
			boolean elementIsEmpty = (elements.get(0).getText().contains(label))
					|| (elements.get(0).getText().equals(""));
			if (!elementIsEmpty) {
				clearField(driver, label);
			}
			MobileElement textbox = elements.get(0);
			textbox.sendKeys(fieldValue);
//		expandField(driver, label);
//		expandField(driver, label);

			MobileElement dropdownValue = driver.findElementByXPath(
					"//android.view.View[starts-with(@resource-id,'ext-boundlist')]//android.view.View[starts-with(@resource-id,'ext-simplelistitem')]//android.view.View[starts-with(@"
							+ contentDesc + ",'" + fieldValue + "')]");
			new TouchAction<>(appiumDriver)
					.press(PointOption.point(dropdownValue.getCenter().getX(), dropdownValue.getCenter().getY()))
					.release().perform();
		}
		swipeUp(driver.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2)).get(0).getSize().height);
	}

	public String getCardStatus(AppiumDriver<MobileElement> driver, String cardName, String linkReason) {
		if (!linkReason.equals(""))
			cardName = cardName + " (" + linkReason + ")";
		MobileElement status = driver.findElementByXPath("//android.view.View[@resource-id='ext-conm-cards-index-1']"
				+ getXpathOfParentAtLevelWithText(cardName, 1)
				+ "/following-sibling::android.view.View/android.view.View[last()]");
		return status.getAttribute("" + contentDesc + "");

	}

	public String getCardName(String card, String linkReason) {
		if (!linkReason.equals(""))
			return card + " (" + linkReason + ")";
		else
			return card;
	}

	public void clickOnbuttonStaticObjectSaveReturn(String card, String linkReason) throws InterruptedException {
		Thread.sleep(500);
		clickButton(appiumDriver, "Next");
		Thread.sleep(5000);
		MobileElement button = appiumDriver.findElementByXPath(
				"//android.view.View[starts-with(@resource-id,'ext-conm-cards-type-objectFooter')]/android.view.View/android.view.View[2]/*/*/android.view.View");
		if (button.getAttribute("" + contentDesc + "").contains("None of these")) {
			appiumDriver.findElementByXPath(
					"//android.view.View[starts-with(@resource-id,'ext-conm-cards-type-objectFooter')]/android.view.View/android.view.View[2]/android.widget.Button")
					.click();
		}

	}

	public void logout() throws Exception {
		// no feature developed yet
//		eThread.close();
//		aThread.close();
		appiumDriver.closeApp();
	}

	public String getTypeOfField(AppiumDriver<MobileElement> appiumDriver, String label, int levelOfCall) {
		MobileElement editor = appiumDriver
				.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-conm-cards-editor-')]");
		List<MobileElement> rootElements = editor.findElementsByXPath(getXpathOfParentAtLevelWithText(label, 2));

		String resourceID = rootElements.get(levelOfCall - 1).getAttribute("resource-id");
		if (resourceID.contains("textareafield")) {
			return "TEXTAREA";
		} else if (resourceID.contains("textfield")) {
			return "TEXTFIELD";
		} else if (resourceID.contains("datetime-fieldpanel")) {
			return "DATETIME";
		} else if (resourceID.contains("dropdownfield")) {
			return "DROPDOWN";
		} else if (resourceID.contains("datewidget")) {
			return "DATE";
		} else if (resourceID.contains("boolean")) {
			return "BOOLEAN";
		} else if (resourceID.contains("enumerated-validation-list")) {
			return "ENUM_VALID_LIST";
		} else if (resourceID.contains("numberfield")) {
			return "NUMBERFIELD";
		}

		else {
			MobileElement rootElement = editor.findElementByXPath(getXpathOfParentAtLevelWithText(label, 5));

			resourceID = rootElement.getAttribute("resource-id");
			if (resourceID.contains("repeating-group")) {
				return "REPEATING_GROUP";
			} else if (resourceID.contains("lookupUnit")) {
				return "LOOKUPUNIT";
			}

			else {
				rootElement = editor.findElementByXPath(getXpathOfParentAtLevelWithText(label, 8));
				resourceID = rootElement.getAttribute("resource-id");
				if (resourceID.contains("field-employee-iteration-lookup")) {
					return "EMPLOYEELOOKUP";
				}

			}

		}
		return null;
	}

	public void swipeUp(int magnitude) {
		int initposition = 35;
		Dimension size = appiumDriver.manage().window().getSize();
		// calculate coordinates for verical swipe
		int endVerticalY = (int) (size.height * 0.01 * initposition) + magnitude;
		int startVerticalY = (int) (size.height * 0.01 * initposition);
		int VerticalX = (int) (size.width * 0.80);
		new TouchAction<>(appiumDriver).press(PointOption.point(VerticalX, endVerticalY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(VerticalX, startVerticalY)).release().perform();

	}

	public void swipeTabsLeft(MobileElement tab) throws Exception {
		MobileElement tabBar = appiumDriver
				.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-tabbar')]");

		Dimension size = tab.getSize();
		// calculate coordinates for horizontal swipe
		int VerticalY = tabBar.getLocation().getY() + (int) (size.height * 0.5);
		int startVerticalX = tabBar.getLocation().getX() + (int) (size.width * 0.50);
		int endVerticalX = tab.getLocation().getX() + (int) (size.width * 0.50);

		new TouchAction<>(appiumDriver).press(PointOption.point(endVerticalX, VerticalY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(startVerticalX, VerticalY)).release().perform();

	}

	public void swipeTabsRight() throws Exception {
		MobileElement tabBar = appiumDriver
				.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-tabbar')]");
		tabBar.getLocation().getX();
		Dimension size = tabBar.getSize();
		// calculate coordinates for vertical swipe
		int VerticalY = tabBar.getLocation().getY() + (int) (size.height * 0.5);
		int endVerticalX = tabBar.getLocation().getX() + (int) (size.width * 0.21);
		int startVerticalX = tabBar.getLocation().getX() + (int) (size.width * 0.80);

		new TouchAction<>(appiumDriver).press(PointOption.point(endVerticalX, VerticalY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(startVerticalX, VerticalY)).release().perform();

	}

	public void swipeDown() {
		Dimension size = appiumDriver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.23);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width * 0.80);
		try {
			new TouchAction<>(appiumDriver).press(PointOption.point(startVerticalX, endVerticalY))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(startVerticalX, startVerticalY)).release().perform();

		} catch (Exception e) {
			System.out.println("unable to swipe");
		}
	}

	public void clickBackButton() {

		appiumDriver.findElementByXPath(
				"//android.view.View[starts-with(@resource-id,'ext-conm-main-header')]//android.view.View[starts-with(@resource-id,'ext-conm-button')]")
				.click();

	}

	public String getEventName() {
		String eventName = appiumDriver
				.findElementsByXPath("//android.view.View[starts-with(@resource-id,'ext-conm-cards-header')]"
						+ getXpathOfElementWithPartialText("Type"))
				.get(0).getAttribute("" + contentDesc + "");
		return eventName.replace("Type: ", "");
	}

	public String getActionName() {
		String actionName = appiumDriver
				.findElementsByXPath("//android.view.View[starts-with(@resource-id,'ext-conm-cards-header')]"
						+ getXpathOfElementWithPartialText("Action"))
				.get(1).getAttribute("" + contentDesc + "");
		return actionName.replace("Action: ", "");
	}

	public void clickOnSubmitButton() {

		MobileElement submitIntelButton = appiumDriver
				.findElementByXPath("//android.view.View[@resource-id='ext-global-floatWrap']//android.view.View[@"
						+ contentDesc + "='Submit']/../../..//android.widget.Button");
		submitIntelButton.click();
		Log.info("submit button clicked");
	}

	public void clickOnTabByName(String tabName) throws Exception {

		MobileElement tab = appiumDriver
				.findElementByXPath("//android.view.View[contains(@resource-id,'ext-tabbar')]//android.view.View[@"
						+ contentDesc + "='" + tabName + "']/../../..");
		tab.click();
		swipeTabsLeft(tab);
		Log.info("Tab " + tabName + " selected");
	}

	public void logInToAppAsUser(String username, String password, String eventRoles) throws Exception {
		// Select User
		username = properties.getProperty("mobile" + username);
		selectValueFromDropDown(appiumDriver, "Select User", username);
		Thread.sleep(1000);
		password = properties.getProperty(password);
		if(Utility.mobileOS.contains("emulator")) {
		swipeAndSelectEventRoles(eventRoles);	
		}
		else {
		swipeToBottom();
		// Select Roles
		selectEventRoles(eventRoles);
		}
		Thread.sleep(1000);
		clickElementByAccessibilityId(appiumDriver, "Log In");
		clickElementByAccessibilityId(appiumDriver, "Continue");
		clickElementByAccessibilityId(appiumDriver, "Continue");
		Thread.sleep(1000);
		Log.info("User " + username + " logged in successfully.");
	}

	private void swipeAndSelectEventRoles(String eventRoles) {
		String reqdRoles = properties.getProperty(eventRoles);
		
		Dimension size = appiumDriver.manage().window().getSize();
		// calculate coordinates for verical swipe
		int endVerticalY = (int) (size.height * 0.8);
		int startVerticalY = (int) (size.height * 0.2);
		int VerticalX = (int) (size.width * 0.50);
		
		for (int i = 0; i < 4; i++) {
			if (!reqdRoles.isEmpty()) {
			List<String> roles = Arrays.asList(reqdRoles.split(","));
			List<MobileElement> checkboxes = appiumDriver.findElementsByXPath("//android.widget.CheckBox");
			for (MobileElement checkbox:checkboxes) {
				if(roles.contains(checkbox.getAttribute(contentDesc)) && checkbox.getAttribute("checked").equalsIgnoreCase("false")){
					checkbox.click();
				}
			}
			}
			new TouchAction<>(appiumDriver).press(PointOption.point(VerticalX, endVerticalY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(VerticalX, startVerticalY)).release().perform();

		}
			
		
	}

	public void swipeToBottom() {
		Dimension size = appiumDriver.manage().window().getSize();
		// calculate coordinates for verical swipe
		int endVerticalY = (int) (size.height * 0.8);
		int startVerticalY = (int) (size.height * 0.2);
		int VerticalX = (int) (size.width * 0.50);
		
		for (int i = 0; i < 6; i++)
			new TouchAction<>(appiumDriver).press(PointOption.point(VerticalX, endVerticalY))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(PointOption.point(VerticalX, startVerticalY)).release().perform();

	}

	private void selectEventRoles(String eventRoles) throws Exception {
		String reqdRoles = properties.getProperty(eventRoles);
		if (!reqdRoles.isEmpty()) {
			
		String[] listRoles = reqdRoles.split(",");
			for (String role : listRoles) {
				MobileElement checkbox = appiumDriver.findElementByXPath("//android.widget.CheckBox[@"+contentDesc+"='"+role+"']");
				
				if(checkbox.getAttribute("checked").equalsIgnoreCase("false")) {
					checkbox.click();
				}
			}
		}
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
		// Close Browser
		appiumDriver.closeApp();
		org.testng.Assert.fail("This needs to be set as a Fail");

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

	public void clickOnCard(String accID) throws Exception {

		MobileElement me = appiumDriver
				.findElementByXPath("//android.view.View[@resource-id='ext-conm-cards-index-1']");
		List<MobileElement> card = me.findElementsByXPath("//android.view.View[@" + contentDesc + "='" + accID + "']");
		if (card.isEmpty())
			clickOnAddtionalCard(accID);
		else
			card.get(0).click();

	}

	public void userSetsTheCardAsApplicable(String cardName) throws Exception {
		if (!cardName.equalsIgnoreCase("Defendant") && !cardName.equalsIgnoreCase("Seizure Location")
				&& !cardName.equalsIgnoreCase("Property Item (Seized / Detained)"))
			clickYesNoCardRequiredButton(appiumDriver, "Yes");

	}

	public void clickOnAddtionalCard(String cardName) throws Exception {
		MobileElement element = appiumDriver.findElementByXPath(
				getXpathOfParentAtLevelWithText("Add / Remove Cards", 4) + "//android.widget.Button");
		if (element.isDisplayed())
			element.click();
		MobileElement me = appiumDriver
				.findElementByXPath("//android.view.View[@resource-id='ext-conm-cards-index-2']");
		MobileElement card = me.findElementByXPath(
				"//android.view.View[starts-with(@resource-id,'ext-conm-cards-thumbnail')][contains(@" + contentDesc
						+ ",'" + cardName + "')]");

		card.findElementByXPath("//android.view.View[@" + contentDesc + "='Add']/../../../android.widget.Button")
				.click();
		clickButton(appiumDriver, "Back");
		clickOnCard(cardName);
	}

	public void swipeCardsUp(String cardName) {
		MobileElement tab = appiumDriver.findElementByXPath(
				"//android.view.View[starts-with(@resource-id,'ext-conm-cards-index')]//android.view.View[starts-with(@resource-id,'ext-conm-cards-thumbnail')][contains(@"
						+ contentDesc + ",'" + cardName + "')]");
		swipeUp(tab.getSize().height);
	}

	public void selectEmployeeIterationLookup(String fieldLabel, String fieldValue) {
		MobileElement parentElement = appiumDriver.findElementByXPath(getXpathOfParentAtLevelWithText(fieldLabel, 8));
		MobileElement checkbox = parentElement.findElementByXPath("//android.widget.CheckBox");
		checkbox.click();
	}

//	
//	public void fillElement(String label, String value) {
//		MobileElement prevElement = null;
//		List<MobileElement> allFormElements = getAllTheFormElementsOnTheForm();
////		System.out.println(allFormElements.size());
//		for (MobileElement i : allFormElements) {
//			
//			if (i.getAttribute("bounds").equals("[0,0][0,0]")) {
//				if (prevElement.getAttribute("bounds").equals("[0,0][0,0]")) {
//					scrolldown("form");
//				} else {
//					scrollup("form");
//				}
//			}
//			fillFieldsBasedOnType(i, label, value);
//			prevElement = i;
//		}
//	}
////	.//android.view.View[starts-with(@resource-id,'ext-fieldset')]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View
//	private void fillFieldsBasedOnType(MobileElement i, String label, String value) {
//		String typeOffield = i.getAttribute("resource-id");
//		
//		if (typeOffield.contains("dropdownfield")) {
//			fillDropDownField(i, label, value);
//		} else if (typeOffield.contains("textfield")) {
//			fillInputElement(i, label, value);
//		} else if (typeOffield.contains("textareafield")) {
//			fillInputElement(i, label, value);
//		} else if (typeOffield.contains("datetime-fieldpanel")) {
//			fillDateTimeField(i, label, value);
//		} else if (typeOffield.contains("repeating-group")) {
//			fillRepeatingGroup(i, label, value);
//		} else if (typeOffield.contains("employee-iteration-lookup")) {
//			fillOfficerName(i, label, value);
//		} else if (typeOffield.contains("datewidget")) {
//			fillInputElement(i, label, value);
//		} else if (typeOffield.contains("boolean")) {
//			fillBoolean(i,label,value);
//		}
//	}
//
//	private void fillRepeatingGroup(MobileElement i, String label, String value) {
//		String labels[] = label.split(" => ");
//		if(labels[0].substring(0,1) == " ") {
//			i.findElementByXPath(getXpathOfElementWithText("Add New"+labels[0])).click();
//		}
//		String labelHeadingRepeatingGroup = i.findElementByXPath(".//android.view.View[starts-with(@resource-id,'ext-label')]/android.view.View").getAttribute(""+contentDesc+"");
//		if(labelHeadingRepeatingGroup.equalsIgnoreCase(labels[0].trim())){
//			 MobileElement LabelTextBox = i.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-fieldset')]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View");
//			 fillFieldsBasedOnType(LabelTextBox, labels[labels.length-1], value);
//		}
//	}
//
//	private void fillBoolean(MobileElement i, String label, String value) {
//		MobileElement labelElement = i.findElementByXPath("./android.view.View/android.view.View");
//		if (labelElement.getAttribute(""+contentDesc+"").equalsIgnoreCase(label)) {
//			i.findElementByXPath("./android.view.View[@resource-id='"+label+"']").click();
//		}
//		
//	}
//
//	private void fillOfficerName(MobileElement i, String label, String value) {
//		MobileElement labelElement = i.findElementByXPath(
//				"//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View");
//		if (labelElement.getAttribute(""+contentDesc+"").equalsIgnoreCase(label)) {
//			MobileElement checkboxElement = i.findElementByXPath("//android.widget.CheckBox");
//			checkboxElement.click();
//			MobileElement editBox = i.findElementByXPath("./android.widget.EditText");
//			editBox.click();
//			if (!editBox.getText().equals("") && !editBox.getText().equalsIgnoreCase(label))
//				clearField(i);
//			editBox.sendKeys(value);
//		}
//	}
//
//	private void fillDateTimeField(MobileElement i, String label, String value) {
//		String[] values = value.split(" => ");
//		MobileElement labelElement = i.findElementByXPath(".//android.view.View/android.view.View");
//		if (labelElement.getAttribute(""+contentDesc+"").equalsIgnoreCase(label)) {
//			List<MobileElement> editBoxes = i.findElementsByXPath(".//android.widget.EditText");
//			editBoxes.get(0).click();
//			if (!editBoxes.get(0).getText().equals("") && !editBoxes.get(0).getText().equalsIgnoreCase(label))
//				clearField(i);
//			editBoxes.get(0).sendKeys(values[0]);
//			if (values.length > 1) {
//				scrollleft(i);
//				editBoxes.get(1).click();
//				if (!editBoxes.get(1).getText().equals("") && !editBoxes.get(1).getText().equalsIgnoreCase(label))
//					clearField2(i);
//				editBoxes.get(1).sendKeys(values[1]);
//				scrollright(i);
//			}
//		}
//	}
//
//	private void fillInputElement(MobileElement i, String label, String value) {
//		MobileElement labelElement = i.findElementByXPath(".//android.view.View/android.view.View");
//		if (labelElement.getAttribute(""+contentDesc+"").equalsIgnoreCase(label)) {
//			MobileElement editBox = i.findElementByXPath(".//android.widget.EditText");
//			if (!editBox.getText().equals("") && !editBox.getText().equalsIgnoreCase(label))
//				clearField(i);
//			i.findElementByXPath(".//android.widget.EditText").sendKeys(value);
//
//		}
//	}
//
//	private void fillDropDownField(MobileElement i, String label, String value) {
//		MobileElement labelElement = i.findElementByXPath(".//android.view.View/android.view.View");
//		if (labelElement.getAttribute(""+contentDesc+"").equalsIgnoreCase(label)) {
//			MobileElement editBox = i.findElementByXPath(".//android.widget.EditText");
//			editBox.click();
//			if (!editBox.getText().equals("") && !editBox.getText().equalsIgnoreCase(label))
//				clearField(i);
//			i.findElementByXPath(".//android.widget.EditText").sendKeys(value);
//
//		}
//	}
//
//	private void clearField(MobileElement parentElement) {
//		parentElement.findElementsByXPath(".//android.view.View[starts-with(@resource-id,'ext-cleartrigger')]").get(0)
//				.click();
//
//	}
//
//	private void clearField2(MobileElement parentElement) {
//		parentElement.findElementsByXPath(".//android.view.View[starts-with(@resource-id,'ext-cleartrigger')]").get(1)
//				.click();
//
//	}
//	
//	private void swipeTillElementIsVisible(MobileElement element) {
//	try {
//		mobileWait.until(ExpectedConditions.visibilityOf(element));
//	} catch (Exception e) {
//		swipeUp();
//		try {
//			mobileWait.until(ExpectedConditions.visibilityOf(element));
//		} catch (Exception e1) {
//			swipeDown();
//		}
//	}
//}
//	
//	public List<MobileElement> getAllTheFormElementsOnTheForm() {
//	MobileElement form = appiumDriver
//			.findElementByXPath("//android.view.View[starts-with(@resource-id,'ext-conm-cards-editor')]");
//
//	List<MobileElement> forms = form
//			.findElementsByXPath(".//android.view.View[starts-with(@resource-id,'ext-conm-cards-form')]");
//	return forms.get(forms.size() - 1).findElementsByXPath(
//			".//android.view.View[starts-with(@resource-id,'ext-conm-cards-form')]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View");
//}
//
//public void selectCard(String cardName) {
//	for (MobileElement i : getAllTheCardsInTheEvent()) {
//		MobileElement tabText = i.findElementByXPath(
//				".//android.view.View[starts-with(@resource-id,'ext-label')]/android.view.View");
//		if (tabText.getAttribute(""+contentDesc+"").equalsIgnoreCase(cardName)) {
//			i.click();
//			return;
//
//		}
//	}
//
//}
//
//private List<MobileElement> getAllTheCardsInTheEvent() {
//	MobileElement cardsIndex = appiumDriver
//			.findElementByXPath(".//android.view.View[starts-with(@resource-id,'ext-conm-cards-index')]");
//	return cardsIndex.findElementsByXPath("ext-conm-cards-thumbnail-");
//}// ext-conm-cards-editor
//
//private List<MobileElement> getAllTabsOnCard() {
//	MobileElement tabBar = appiumDriver
//			.findElementByXPath(".//android.view.View[starts-with(@resource-id,'ext-tabbar')]");
//	return tabBar.findElementsByXPath(".//android.view.View[starts-with(@resource-id,'ext-tab-')]");
//}// ext-conm-cards-editor
//
//public void clickOnTab(String tabName) {
//	MobileElement prevTabText = null;
//	for (MobileElement i : getAllTabsOnCard()) {
//		MobileElement tabText = i.findElementByXPath(".//android.view.View/android.view.View/android.view.View");
//		if (tabText.getAttribute(""+contentDesc+"").equalsIgnoreCase(tabName)) {
//			if (tabText.getAttribute("bounds").equals("[0,0][0,0]")) {
//				if (prevTabText.getAttribute("bounds").equals("[0,0][0,0]")) {
//					MobileElement tabBar = appiumDriver
//							.findElementByXPath(".//android.view.View[starts-with(@resource-id,'ext-tabbar')]");
//
//					scrollright(tabBar);
//				} else {
//					MobileElement tabBar = appiumDriver
//							.findElementByXPath(".//android.view.View[starts-with(@resource-id,'ext-tabbar')]");
//					scrollleft(tabBar);
//				}
//			} else
//				i.click();
//			break;
//		}
//		prevTabText = tabText;
//	}
//}

}
