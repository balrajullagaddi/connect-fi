package com.northgateps.cm.platform.api;
// HELPER FUNCTIONS 
// UTILITY ONLY FOR WEB
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.northgate.cm.utils.Constant;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConnectMobilePageHelper extends Utility {
	private CardUtility crdUtility;

	public static RemoteWebDriver driver;
	public static Scenario scenario;
	public static AppiumDriver<MobileElement> appiumDriver = null;
	public static String currentCard = "";
	public static AppiumDriver<WebElement> winDriver = null;

	private static Properties properties;
	private static Logger Log = Logger.getLogger(ConnectMobilePageHelper.class.getName());

	public ConnectMobilePageHelper() throws Exception {
		super();
		properties = Utility.loadProperties();
		crdUtility = new CardUtility();

	}

	@Before
	public void setScenario(Scenario scenario) {
		ConnectMobilePageHelper.scenario = scenario;
		Log.info("Scenario Execution started: " + scenario.getName());
	}

	/*
	 * Purpose: Function to open browser and open default link Created Date :
	 * 23/10/2017 Inputs Parameter: Output Parameter: Written By : Saurav Anand
	 * Modified By:Manali Parab
	 */

	public static RemoteWebDriver setUpClient() throws Exception {

		if (Utility.platform.equalsIgnoreCase("mobile")) {
			switch (Utility.mobileOS) {
			case "android":
				//appiumDriver = MobilePageHelper.setAndroidDriver();
				break;
			case "android emulator":
				//appiumDriver = MobilePageHelper.setAndroidDriver();
				break;
			case "windows":
				//winDriver = WindowsPageHelper.setWindowsDriver();
				break;
			case "ios":
				break;
			}
		} else {
			// String driverPath = "";
			String browserType = "";
			browserType = properties.getProperty("Browser");
			switch (browserType) {
			case "Chrome":
				driver = setChromeDriver();
				break;
			case "FireFox":
				driver = setFireFoxDriver();
				break;
			case "IE":
				driver = setIEDriver();
				break;
			}
		}
		return driver;
	}

	private static RemoteWebDriver setChromeDriver() throws Exception {
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
		} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
		}
		String rmDriver = System.getProperty("rmDriver");
		if (rmDriver != null && rmDriver.equalsIgnoreCase("true")) {
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://10.100.150.161:4444/wd/hub"), capability);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("start-maximized");
			options.addArguments("window-size=1280x1024");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	@SuppressWarnings("deprecation")
	private static RemoteWebDriver setFireFoxDriver() throws Exception {
		Dimension d;
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.WIN).setup();
		}else if (System.getProperty("os.name").toLowerCase().contains("linux"))
		{
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
		}
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		d = new Dimension(1280, 1024);
		driver.manage().window().setSize(d);
		driver.manage().window().maximize();
		return driver;
	}

	private static RemoteWebDriver setIEDriver() throws Exception {
		Dimension d;
		loadJSONForIE();
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			WebDriverManager.iedriver().operatingSystem(OperatingSystem.WIN).setup();
		}
		driver = new InternetExplorerDriver();
		d = new Dimension(1280, 1024);
		driver.manage().window().setSize(d);
		driver.manage().window().maximize();
		return driver;
	}

	public static void loadJSONForIE() {
		try {
			WebDriver wd = null;
			String result = "";
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			wd = new ChromeDriver(options);
			Assert.assertTrue(wd != null);

			String cardDefURL = properties.getProperty("cardDefURL");
			String a = "window.open('about:blank','_blank');";
			((JavascriptExecutor) wd).executeScript(a);
			wd.get(properties.getProperty("URL"));
			Thread.sleep(2000);
			Set<String> customerWindow = wd.getWindowHandles();
			String customerSiteHandle = ((String) customerWindow.toArray()[1]);
			wd.switchTo().window(customerSiteHandle);
			wd.get(cardDefURL); /// connectmobile/develop/api/card_definitions?
			Thread.sleep(5000);
			WebElement jsonElement = wd.findElement(By.tagName("pre"));
			result = jsonElement.getText();
			Thread.sleep(10000);
			stringToFile(result, CardUtility.FILENAME);
			wd.close();
			wd.switchTo().window((String) customerWindow.toArray()[0]);
			wd.close();
			wd.quit();
			wd = null;
		} catch (Exception e) {
			Log.error("Unable to Set Up Browser" + e);
		}
	}

	public static void login(String username, String password) throws InterruptedException, Exception {
		try {
			WebElement DrpdwnSelectUser = driver.findElement(By.name("username"));
			Select selectUserName = new Select(DrpdwnSelectUser);
			selectUserName.selectByVisibleText(username);
			WebElement WebElementPassword = driver.findElement(By.name("password"));
			WebElementPassword.sendKeys(password);

		} catch (Exception e) {
			Log.error("Unable to Login" + e);
		}
	}

	public void eventRoles(String eventRole) throws InterruptedException, Exception {
		try {
			if (!properties.getProperty(eventRole).isEmpty()) {
				String enviornmentValue = properties.getProperty(eventRole);
				String[] listRoles = enviornmentValue.split(",");
				for (String role : listRoles) {
					click_checkboxes(driver, "//input[@type='checkbox'][@value='" + role + "']");
				}
			}

			// Clicking on Submit Button
			WebElement BtnSubmit = driver.findElement(By.xpath("//input[@type='submit'][@value='Submit']"));
			assertNotNull(BtnSubmit);
			BtnSubmit.click();

			Thread.sleep(5000);

			// Code to delete older log files
			String currentDirectory = System.getProperty("user.dir");
			File file = new File(currentDirectory + "/target");
			deleteFiles(file);

			// Call FetchJson function to get latest json
			if (!properties.getProperty("Browser").equalsIgnoreCase("IE")) {
				FetchJson();
			}

			// Clicking on Accept Button
			Select_Button(driver, "Accept");

			// Clicking on Select Button
			Select_Button(driver, "Select");

			// Fetch json and store it in global object
			getJsonObject();
		} catch (Exception e) {
			Log.error("Unable to select event roles" + e);
		}
	}

	private void getJsonObject() {
		Object obj = null;
		try {
			JSONParser parser = new JSONParser();
			FileReader filereader = new FileReader(CardUtility.FILENAME);
			obj = parser.parse(filereader);
			Thread.sleep(5000);
			crdUtility.setJsonOject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickIcon(String iconNameValue) {
		try {
			Thread.sleep(2000);
			WebElement iconName = ConnectMobilePageHelper.getElementBasedOnTag("div", iconNameValue);
			assertNotNull(iconName);
			iconName.click();
		} catch (Exception e) {
			Log.error("Unable to click on Icon" + iconNameValue + ":" + e);
		}
	}

	public WebElement verifyIconPresent(String iconNameValue) {
		try {
			WebElement iconName = ConnectMobilePageHelper.getElementBasedOnTag("div", iconNameValue);
			return iconName;
		} catch (Exception e) {
			Log.error("Unable to click on Icon" + iconNameValue + ":" + e);
			return null;
		}
	}

	// Purpose : Killing if required browser is opened
	public static void killProcess(String browserName) {
		try {
			Runtime.getRuntime().exec("sudo killall " + browserName);
			Thread.sleep(500);
			Runtime.getRuntime().exec("R@ve1234");
		} catch (Exception e) {
			Log.error("Unable to Kill Process" + e);
		}
	}

	public static String getOsName() {
		String OS = null;
		if (OS == null) {
			OS = System.getProperty("os.name").toLowerCase();
		}
		return OS;
	}

	/*
	 * Purpose: Function to get card status based on card Name Created Date :
	 * 05-05-2018 Inputs Parameter: Output Parameter: Written By : Manali Parab
	 * Modified By:
	 */
	public static void cardNameStatus(WebDriver driver, String tag, String cardName, String cardStatus)
			throws Exception {
		try {
			Thread.sleep(1000);
			WebElement Element = null;
			List<WebElement> Nodes = driver.findElements(By.tagName(tag));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(cardName)) {
					Element = ChildNode;
					break;
				}
			}
			Thread.sleep(1000);
			WebElement cardStatusValue = Element
					.findElement(By.xpath("//div[text()='" + cardName + "']//following::div"));
			assertNotNull(cardStatusValue);
			assertEquals(cardStatusValue.getText(), cardStatus);
			System.out.println("---------Verified Actual Card Status :'" + cardStatus + "'and Expected Card Status:'"
					+ cardStatusValue.getText() + "'---------");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Temporary being used only in story CON-42561 to solve array index exception
	// problem
	public static void cardNameStatuss(WebDriver driver, String tag, String cardName, String cardStatus)
			throws Exception {
		try {

			WebElement Element = null;
			List<WebElement> Nodes = driver.findElements(By.tagName(tag));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(cardName)) {
					Element = ChildNode;
					break;
				}
			}
			Thread.sleep(1000);

			WebElement cardStatusValue = Element
					.findElement(By.xpath("//div[text()='" + cardName + "']//following::div"));
			assertNotNull(cardStatusValue);
			assertEquals(cardStatusValue.getText(), cardStatus);
			System.out.println("---------Verified Actual Card Status :'" + cardStatus + "'and Expected Card Status:'"
					+ cardStatusValue.getText() + "'---------");

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	// Folowing code will return status of card
	// Input Paramters: Webdriver driver,tagname of web element i.e div and card
	// name of it
	// Output Parameter: Card Status of Card
	public static String getCardStatus(WebDriver driver, String tag, String cardName) {
		String cardStatus = "";

		try {
			WebElement Element = null;
			List<WebElement> Nodes = driver.findElements(By.tagName(tag));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(cardName)) {
					Element = ChildNode;
					break;
				}
			}
			Thread.sleep(1000);

			WebElement eleStatus = Element.findElement(By.xpath("//div[text()='" + cardName + "']//following::div"));
			cardStatus = eleStatus.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return cardStatus;
	}

	// Function does: To enter value in specfic field in textbox
	// Input Parameters are WebDriver driver, String tagname
	// String fieldName : eg Report Title ,String value : eg Value to enter in
	// textbox
	public WebElement enterValueSpecificField(WebDriver driver, String tag, String fieldName, String value)
			throws Exception {
		WebElement cardFieldSelect = null;
		try {
			driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(1));
			Thread.sleep(1000);
			WebElement Element = null;
			List<WebElement> Nodes = driver.findElements(By.tagName(tag));
			Thread.sleep(500);
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(fieldName)) {
					Element = ChildNode;
					break;
				}
			}
			Thread.sleep(1000);
			cardFieldSelect = Element.findElement(By.xpath("//span[text()='" + fieldName + "']//following::div[2]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(cardFieldSelect).click().perform();
			actions.sendKeys(value).perform();
			driver.switchTo().defaultContent();
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return cardFieldSelect;

	}

	public void clickOnCardNoRequiredButton(WebDriver driver) {
		try {
			waitForElementToBe(By.xpath("//button[@name='btn_nocardrequired']//.."), "PRESENCE", driver, 10);
			waitForElementStateToBe(By.xpath("//button[@name='btn_nocardrequired']//.."), "CLICKABLE", driver);
			WebElement cardNotRequiredBtn = driver.findElement(By.xpath("//button[@name='btn_nocardrequired']//.."));
			assertNotNull(cardNotRequiredBtn);
			cardNotRequiredBtn.click();
		} catch (Exception e) {
			Log.error(e);
			e.printStackTrace();
		}
	}

	public void clickOnCardNotRequiredButton(WebDriver driver) {
		try {
			waitForElementToBe(By.xpath("//button[@name='btn_cardNoRequriedBtn']//.."), "PRESENCE", driver, 10);
			waitForElementStateToBe(By.xpath("//button[@name='btn_cardNoRequriedBtn']//.."), "CLICKABLE", driver);
			WebElement cardNotRequiredBtn = driver.findElement(By.xpath("//button[@name='btn_cardNoRequriedBtn']//.."));
			assertNotNull(cardNotRequiredBtn);
			cardNotRequiredBtn.click();
		} catch (Exception e) {
			Log.error(e);
		}
	}

	public void clickOnLookupButton(WebDriver driver, String label) {
		try {
			WebElement panel = driver.findElement(By.xpath("//span[text()='" + label + "']//..//..//..//button"));
			String id = panel.getAttribute("id");
			WebElement elButton = driver.findElement(By.id(id));
			elButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickThisIsTheObjectButton(WebDriver driver) {
		try {
			WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
			List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='btn_next']//.."));
			for (WebElement button : buttons) {
				if (button.getText().contains("This is the ")) {
					button.click();
					break;
				}
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCardName(String card, String LinkReason, String event) {
		try {
			Thread.sleep(500);
			String elName = getNameForCard(card, LinkReason, event);
			setGlobalCardObject(elName, CardUtility.globalEventType);

			if (crdUtility.cardMode(elName).equalsIgnoreCase(CardUtility.AVAILABLE)) {
				loadAvailableCard(card, LinkReason);
			}

			WebElement webElementCardName = null;
			waitForElementToBe((By.cssSelector("div[id^='ext-conm-cards-index-']")), "PRESENCE", driver, 10);
			// waitForElementToBe((By.cssSelector("div[id^='ext-conm-cards-index-']")),
			// "CLICKABLE", driver, 10);
			WebElement docker = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-index-']"));
			List<WebElement> Nodes = docker.findElements(By.tagName("div"));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(elName)) {
					webElementCardName = ChildNode;
					break;
				}
			}
			assertNotNull(webElementCardName);
			webElementCardName.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setGlobalCardObject(String elName, String globalEventType) {
		try {
			elName = CardUtility.getNameWithoutSpace(elName);
			CardUtility.globalCardPageObject = CardUtility.getListOfCardPageObject(elName, globalEventType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnEventCardName(String cardName) {
		String LinkReason = "";
		try {
			setGlobalCardObject(cardName, CardUtility.globalEventType);

			if (crdUtility.cardMode(cardName).equalsIgnoreCase(CardUtility.AVAILABLE)) {
				loadAvailableCard(cardName, LinkReason);
			}

			WebElement Element = null;
//			waitForElementToBe((By.cssSelector("div[id^='ext-conm-cards-index-']")), "PRESENCE", driver, 20);
//			waitForElementToBe((By.cssSelector("div[id^='ext-conm-cards-index-']")), "CLICKABLE", driver);
			WebElement docker = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-index-']"));
			List<WebElement> Nodes = docker.findElements(By.tagName("div"));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(cardName)) {
					Element = ChildNode;
					break;
				}
			}
			assertNotNull(Element);
			Element.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This returns the Label of a card
	public String getNameForCard(String poleObjTyp, String LinkReason, String event) throws InterruptedException {
		String elmenetLable = "";
		List<String> cardList = null;
		try {
			cardList = crdUtility.getCardList(event);

			for (String cardNm : cardList) {
				String[] strArray = cardNm.split(",");
				poleObjTyp = CardUtility.getNameWithoutSpace(poleObjTyp);
				if (!LinkReason.equals("")) {
					if (strArray[0].equalsIgnoreCase(poleObjTyp) && strArray[1].equalsIgnoreCase(LinkReason)) {
						elmenetLable = strArray[2];
						break;
					}
				} else if (CardUtility.getNameWithoutSpace(strArray[2]).equals(poleObjTyp)) {
					elmenetLable = strArray[2];
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return elmenetLable;
	}

	// This returns the actual JSON Name of card
	public String getJSONNameForCard(String poleObjTyp, String LinkReason, String event) throws InterruptedException {
		String elmenetLable = "";
		List<String> cardList = null;
		try {
			cardList = crdUtility.getCardList(event);

			for (String cardNm : cardList) {
				String[] strArray = cardNm.split(",");
				poleObjTyp = CardUtility.getNameWithoutSpace(poleObjTyp);
				if (!LinkReason.equals("")) {
					if (strArray[0].equalsIgnoreCase(poleObjTyp) && strArray[1].equalsIgnoreCase(LinkReason)) {
						elmenetLable = strArray[3];
						break;
					}
				} else if (CardUtility.getNameWithoutSpace(strArray[2]).equals(poleObjTyp)) {
					elmenetLable = strArray[3];
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return elmenetLable;
	}

	// for timimng added which doesnt swtch to default content
	public void clickOnCardNameWithoutSwitch(WebDriver driver, String cardName) {
		try {
			WebElement Element = null;
			WebElement docker = driver.findElement(By.cssSelector("div[id='ext-conm-cards-index-1']"));
			List<WebElement> Nodes = docker.findElements(By.tagName("div"));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(cardName)) {
					Element = ChildNode;
					break;
				}
			}
			assertNotNull(Element);
			Element.click();
		} catch (Exception e) {
			Log.error(e);
		}
	}

	/*
	 * Purpose: Function to open browser and open default link Created Date :
	 * 23/10/2017 Inputs Parameter: Output Parameter: Written By : Saurav Anand
	 * Modified By:Manali Parab
	 */
	public static void openUrl(WebDriver driver) throws InterruptedException, Exception {
		try {
			// properties.get
			String EnviornmentValue = properties.getProperty("URL");
			driver.navigate().to(EnviornmentValue);
			// Thread.sleep(10000);

		} catch (Exception e) {
			Log.error("Unable to Open Browser" + e);
		}
	}

	/*
	 * Purpose: Function to get Elements based on tag Created Date : 05-05-2018
	 * Inputs Parameter: Output Parameter: Written By : Manali Parab Modified By:
	 */
	public static WebElement getElementBasedOnTag(String tag, String findText) throws Exception {

		WebElement Element = null;
		Thread.sleep(1000);
		List<WebElement> Nodes = driver.findElements(By.tagName(tag));
		for (WebElement ChildNode : Nodes) {
			if (ChildNode.getText().equalsIgnoreCase(findText)) {
				Thread.sleep(500);
				Element = ChildNode;
				break;
			}
		}
		return Element;
	}

	public static List<WebElement> getChildElementsBasedOnTag(WebDriver driver, String tag, String findText)
			throws Exception {
		List<WebElement> Nodes = driver.findElements(By.tagName(tag));
		for (WebElement ChildNode : Nodes) {
			if (ChildNode.getText().equalsIgnoreCase(findText)) {
				System.out.println(ChildNode.getText());
				break;
			}
		}
		return Nodes;

	}

	/*
	 * Purpose: Function verify Logo Image Created Date : 02/11/2017 Inputs
	 * Parameter: Output Parameter: Written By : Manali Parab Modified By:
	 */
	public void verifyLogoPresent(String ImageName, WebElement ImgLogo) {
		if (ImgLogo != null) {
			// extest.log(LogStatus.PASS, "'"+ImageName+"' is verified
			// sucessfully." + "
			// Image captured :"
			// +extest.addScreenCapture(CommonPageHelper.takeScreenshot(driver)));
		} else {
			// extest.log(LogStatus.FAIL, "'"+ImageName+"' is not verified,
			// hence failed to
			// verify it. " + " Image captured:"
			// +extest.addScreenCapture(CommonPageHelper.takeScreenshot(driver)));

		}
	}

	public String getCardStatus(String cardName) {
		/* Mukul: This card returns the card status on the card index page */
		String cardStatus = "";
		waitForElementToBe(By.xpath("//div[starts-with(@id,'ext-conm-cards-thumbnail')]"), "VISIBLE", driver, 20);
		List<WebElement> cards = driver.findElements(By.xpath("//div[starts-with(@id,'ext-conm-cards-thumbnail')]"));

		for (WebElement card : cards) {
			String Cardtext = card.getText();
			String[] cardDetails = Cardtext.split("\n");

			int len = cardDetails.length;
			if (cardDetails[len - 2].equals(cardName)) {
				cardStatus = cardDetails[len - 1];
				break;
			}
		}
		return cardStatus;
	}

	public void pickDDLValueByInstance(String value, String element, WebDriver driver, int instance) {
		/*
		 * [Mukul]:This method enables user to open the dropdown list and select a value
		 * based on the instance
		 */
		Actions action = new Actions(driver);
		String IconXpath = "//input[@name='" + element + "']/parent::*/div[2]/div[2]/div";
		String ValueXpath = "//span[text()='" + value + "']";
		try {
			WebElement dropdownField = driver.findElements(By.name(element)).get(instance - 1);
			WebElement dropdownIcon = driver.findElements(By.xpath(IconXpath)).get(instance - 1);
			if (dropdownField.isEnabled()) {
				dropdownField.clear();
				dropdownIcon.click();
				Thread.sleep(5000);
				WebElement dropDownValue = driver.findElement(By.xpath(ValueXpath));
				action.moveToElement(dropDownValue).click().perform();
			} else {
				// cannot enter text as textbox is disabled
			}
		} catch (Exception e) {
			// Log.error("Unable to sendkeys into TextBox", e);
			e.printStackTrace();
		}
	}

	/*
	 * logout function : Written by : Shivmohan Yadav
	 */
	public void logOut(WebDriver driver) throws InterruptedException {
		try {
			// Switch to default content
			switch_To_Default(driver);

			// To click on drop down button
			click_HomeDropdownArrowMenu(driver);

			// To select logout button
			WebElement elLogOut = driver.findElement(By.cssSelector("div#x-menu-el-logoutMenuItemId"));
			elLogOut.click();

			WebElement yesButton = waitForElementToBe(By.xpath(".//*[@id='yes']/tbody/tr[2]/td[2]/em/button"),
					"VISIBLE", driver);
			yesButton.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * To get the drop down on home page : Written by : Shivmohan Yadav
	 */
	private void click_HomeDropdownArrowMenu(WebDriver driver) throws InterruptedException {
		WebElement elMenuDownArrowButton = driver.findElement(By.cssSelector("table#menuButtonId em.x-btn-split"));
		Actions act = new Actions(driver);
		act.moveToElement(elMenuDownArrowButton, elMenuDownArrowButton.getSize().width,
				elMenuDownArrowButton.getSize().height).click().build().perform();
	}

	/*
	 * Switch functions : Written by : Shivmohan Yadav
	 */

	public void switch_To_Default(WebDriver driver) throws InterruptedException {
		driver.switchTo().defaultContent();
	}

	public void switch_To_ConnectMobileModule(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);
		waitForElementToBe(By.cssSelector("iframe[id^='ConnectMobileModule-']"), "PRESENCE", driver, 10);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='ConnectMobileModule-']")));
	}

	public void switch_To_LaunchPadModule(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);
		if (waitForElementToBe(By.cssSelector("iframe[id^='LaunchpadModule-']"), "PRESENCE", driver, 10) == null) {
			driver.findElement(By.xpath("//table[@id='fontIcon_homeMessage']")).click();
		}
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='LaunchpadModule-']")));
	}

	public void switch_To_WorkloadModule(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='WorkloadModule-']")));
		refreshWorklodScreen();
		collapseViewsPan(driver);
		expandViewsPan(driver);
	}
	
	public void switch_To_Custody(WebDriver driver) throws InterruptedException
	{
		switch_To_Default(driver);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='CustodyModule']"))); 
	}
	
	public void switch_To_PoleQueryModule(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);
		waitForElementToBe(By.cssSelector("iframe[id^='PoleQueryModule-']"), "PRESENCE", driver, 10);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='PoleQueryModule-']")));
	}
	
	public void switch_To_LinkingPoleQueryModule(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);
		waitForElementToBe(By.cssSelector("iframe[id^='LinkingPoleQueryModule-']"), "PRESENCE", driver, 10);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='LinkingPoleQueryModule-']")));
	}

	public void switch_To_PoleViewerModule(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);
		waitForElementToBe(By.cssSelector("iframe[id^='PoleViewerModule-']"), "PRESENCE", driver, 10);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='PoleViewerModule-']")));
	}

	// Naman
	public void switch_To_WorkloadLinkedActions(WebDriver driver) throws InterruptedException {
		switch_To_Default(driver);
		waitForElementToBe(By.cssSelector("iframe[id^='EventActionsOverlayModule-']"), "VISIBLE", driver);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='EventActionsOverlayModule-']")));
		waitForPageLoadMsgToBeInvisible("Loading Event Actions...");
	}

	/*
	 * Switch functions
	 */

	// A function that determines if the given field is emplty
	public boolean verifyFieldIsEmpty(WebDriver driver, String card, String LinkReason, String event,
			String FieldName) {
		try {
			card = getNameForCard(card, LinkReason, event);
			String fieldReporttile = crdUtility.getElementName(card, null, event, FieldName);
			WebElement txReportTitle = driver.findElement(By.name(fieldReporttile));
			String classNametxtReportTitle = txReportTitle.getAttribute("class");
			if (classNametxtReportTitle.contains("x-empty")) {
				System.out.println("Field '" + FieldName + "' is empty.");
				return true;
			} else {
				System.out.println("Field '" + FieldName + "' is not empty.");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// A function that determines whether field exists
	public void verifyFieldExists(String card, String LinkReason, String event, String FieldLabel)
			throws InterruptedException {
		WebElement elField = null;
		card = getNameForCard(card, LinkReason, event);
		String strFieldName = crdUtility.getElementName(card, null, event, FieldLabel);
		elField = driver.findElement(By.name(strFieldName));
		assertNotNull(elField);
		assertTrue(elField.isDisplayed());
	}

	// A function that determines the number of cards available
	public String numberOfCardsAvailable() {
		try {
			WebElement Counter_cardAvailableButton = driver
					.findElement(By.xpath("//button[contains(@name,'btn_cardavailable')]/preceding-sibling::div[1]"));
			String actualNoofCards = Counter_cardAvailableButton.getText();
			return actualNoofCards;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// A function that determines the search result exists for object
	public void verifySearchResultExists(WebDriver driver, String InputVal) {
		try {
			wait = new WebDriverWait(driver, 120);
			WebElement searchResults = waitForElementToBe(By.cssSelector("div[id^='ext-conm-common-search-result-']"),
					"VISIBLE", driver);
			WebElement searchResultHeader = searchResults.findElement(By.cssSelector("div.mainHeading div"));
			assertEquals(searchResultHeader.getText().toLowerCase(), InputVal.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A function selects first search result from the results available
	public void selectFirstSearchResult(WebDriver driver) throws InterruptedException {
		WebElement firstSearchEl = driver.findElement(By.xpath("//div[@class='result-search-angle']/../.."));
		firstSearchEl.click();
		Thread.sleep(5000);
	}

	// A function selects saved result from the results available
	public void selectFirstSavedResult(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		WebElement firstSearchEl = driver.findElement(By.xpath("//div[@class='object-result-angle']/../.."));
		firstSearchEl.click();
		Thread.sleep(5000);
	}

	// A function determines if object editor form is displayed
	public void verifyObjectEditorForm(WebDriver driver, String ObjectName) {
		try {

			WebElement personObjectEditor = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-formtabs-']"));
			assertTrue(personObjectEditor.isDisplayed(), ObjectName + " object editor not displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findAction() {
		String str = "";
		try {
			switch_To_ConnectMobileModule(driver);
			// waitForElementToBe(By.cssSelector("div.x-label.action-text"), "PRESENCE",
			// driver,50);
			WebElement elAction = driver.findElement(By.cssSelector("div.x-label.action-text"));
			str = elAction.getText();
			str = str.replace("Action: ", "");
			crdUtility.setAction(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findEvent() {
		String str = "";
		try {
			WebElement typeElement = driver.findElement(By.cssSelector("div.x-label.type-lbl-text"));
			str = typeElement.getText();
			str = str.replace("Type: ", "");
			crdUtility.setEventType(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A fucntion verifies the message on max number of objects
	public void verifyMessageOnAddingMaxObjects(WebDriver driver, String Message) {
		try {
			Thread.sleep(2000);
			WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
			assertNotNull(WarnPopupWindow);
			WebElement msgCardOption = WarnPopupWindow.findElement(By.cssSelector("div.x-innerhtml"));
			assertNotNull(msgCardOption);
			assertEquals(Message, msgCardOption.getText());

		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}

	// A fucntion verifies the message on cards option
	public void verifyMessageOnCardOptionForm(WebDriver driver, String Message) {
		try {
			Thread.sleep(2000);
			WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-optional-']"));
			WebElement msgCardOption = WarnPopupWindow.findElement(By.cssSelector("div.x-innerhtml"));
			assertEquals(Message, msgCardOption.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --error message capture
	public void captureValidationMessage(WebDriver driver, String field_name, String Message) {
		try {
			Thread.sleep(1000);
			WebElement parentEl = driver.findElement(
					By.xpath("//*[@name='" + field_name + "']//ancestor::div[contains(@class, 'x-field')]"));
			String id = parentEl.getAttribute("id");
			Thread.sleep(500);
			WebElement elValidator = driver.findElement(By.xpath("//*[@id='" + id + "']/div/div[2]"));
			Thread.sleep(500);
			String validationErrorMsg = elValidator.getText();
			Thread.sleep(500);
			assertEquals(Message.trim(), validationErrorMsg.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A function verifies availability of connect cards
	public void verifyConnectCradsAvailable(WebDriver driver) {
		try {
			WebElement TabConnectcards = driver.findElement(
					By.xpath("//span[contains(@class,'x-tab-strip-text')][contains(text(),'CONNECT Cards')]"));
			assertNotNull(TabConnectcards);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isObjectEditorFormDisplayed(WebDriver driver, String ObjectName) {
		boolean editorDisplayed = true;
		try {
			List<WebElement> Nodes = driver.findElements(By.tagName("div"));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().contains(("Select the " + ObjectName.toLowerCase()))) {
					Thread.sleep(500);
					editorDisplayed = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editorDisplayed;
	}

	public boolean isObjectLinked(WebDriver driver) {
		boolean objectLinked = false;
		try {
			List<WebElement> object = driver.findElements(By.cssSelector("div[class='x-dataview-item  x-dirty']"));
			if (object != null && !object.isEmpty()) {
				objectLinked = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectLinked;
	}

	// To verify the message displayed for card addition
	public void verifyMessageCardRequired(String poleObjTyp, String LinkReason, String event) {
		try {
			String cardName = "";
			if (!poleObjTyp.equals(""))
				cardName = getNameForCard(poleObjTyp, LinkReason, event);

			WebElement optionalCardPage = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-optional-']"));
			String actualText = optionalCardPage.findElement(By.cssSelector("div.x-innerhtml")).getText();
			if (!poleObjTyp.equals(""))
				assertEquals("Are there any " + cardName + "(s) involved?", actualText);
			else
				assertTrue(actualText.contains("Are there any ") && actualText.contains("(s) involved?"),
						"Message doesn't appeared correctly.");

			Log.info("Verified Message on card : '" + actualText + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// MANDATORY FIELD CHECK-
	public boolean mandatoryFieldCheck(WebDriver driver, String tag) throws Exception {
		boolean isExists = false;
		List<WebElement> Nodes = driver.findElements(By.cssSelector("//div[contains(@class, 'x-required']"));

		for (WebElement ChildNode : Nodes) {
			if (ChildNode.getText().equals(tag)) {
				Thread.sleep(500);
				isExists = true;
				break;
			}
		}

		return isExists;
	}

	// Clear field - web element
	public void clearField(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
			WebElement parentElement = element.findElement(By.xpath(".."));
			WebElement clearElmenet = parentElement.findElement(By.cssSelector("div.x-cleartrigger"));
			if (clearElmenet.isDisplayed())
				clearElmenet.click();
			element.click();
			element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (NoSuchElementException e) {
			element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (ElementNotVisibleException e) {
			element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	// To fetch the value for a field from object display page
	public String fetchValueForField(WebDriver driver, String FieldName) throws InterruptedException {
		String fieldValue = "";

		Thread.sleep(2000);
		WebElement displayPage = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-objectViewer-']"));
		List<WebElement> rows = displayPage.findElements(By.cssSelector("tbody > tr"));

		for (WebElement row : rows) {

			List<WebElement> cols = row.findElements(By.tagName("td"));

			Iterator<WebElement> iter = cols.iterator();

			while (iter.hasNext()) {
				WebElement el = iter.next();
				if (el.getText().equalsIgnoreCase(FieldName)) {
					WebElement elNxt = iter.next();
					fieldValue = elNxt.getText();
				}

			}
		}
		return fieldValue;
	}

	public static void Add_Remove_Popup(WebDriver driver) throws InterruptedException {
		// press the Lookup Button
		Select_Button_From_Add_Remove_Popup(driver, "btn_add");
		Thread.sleep(5000L);
	}

	private static void Select_Button_From_Add_Remove_Popup(WebDriver driver, String ButtonName)
			throws InterruptedException {

		findButton_On_Popup_window(driver, ButtonName).click();
		Thread.sleep(2000L);
	}

	private static WebElement findButton_On_Popup_window(WebDriver driver, String nameOfButton) {
		WebElement Add_Remove_PopupWindow = driver.findElement(By.cssSelector("div[id='ext-availablecardspanel-1']"));
		List<WebElement> buttonElements = Add_Remove_PopupWindow.findElements(By.cssSelector("button[name='btn_add']"));
		System.out.println("SizeOfButton->>" + buttonElements.size());
		for (WebElement webElement : buttonElements) {
			System.out.println("Test" + webElement.getText().trim());
			if (webElement.getAttribute("name").equalsIgnoreCase(nameOfButton)) {
				System.out.println("webElement--" + webElement.getAttribute("name"));
				return webElement;
			}
		}
		return null;
	}

	public static void getScreenshot(WebDriver driver, String path) {

		/* Mukul: This function takes screenshots and saves in the mentioned path */
		try {

			DateFormat dateFormat = new SimpleDateFormat("ddMMM HH.mm");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String fileName = path + date1 + ".png";
			// Taking screenshot
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // takes screenshot in bytes
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isEditable(WebElement Element, String value) {

		// Mukul: Verify if an element is editable
		try {
			Element.clear();
			Element.sendKeys(value + Keys.TAB);
			if (Element.getAttribute("value").equals(value)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public WebElement addRemoveCardsButton(WebDriver driver) {
		WebElement addRemoveCardBtn = waitForElementToBe(By.cssSelector("div.addRemoveCards"), "CLICKABLE", driver);
		return addRemoveCardBtn;
	}

	public WebElement addRemoveCardsAddButton(WebDriver driver, String label) {
		WebElement PopupWindow = driver.findElement(By.cssSelector("div[id='ext-availablecardspanel-1']"));
		WebElement addCardbtn = PopupWindow.findElement(By.xpath(
				"//div[text()='" + label + "']//..//..//..//following-sibling::div//button[@name='btn_add']//.."));
		String elID = addCardbtn.getAttribute("id");
		WebElement addCardbutton = driver.findElement(By.id(elID));
		return addCardbutton;
	}

	public WebElement addRemoveCardsAddButton(WebDriver driver) {
		WebElement PopupWindow = driver.findElement(By.cssSelector("div[id='ext-availablecardspanel-1']"));
		WebElement addCardbtn = PopupWindow.findElement(By.cssSelector("button[name='btn_add']"));
		return addCardbtn;
	}

	public WebElement addRemoveCardsRemoveButton(WebDriver driver) {
		WebElement PopupWindow = driver.findElement(By.cssSelector("div[id='ext-availablecardspanel-1']"));
		WebElement removeCardbtn = PopupWindow.findElement(By.xpath("//button[@name='btn_remove']//.."));
		return removeCardbtn;
	}

	public WebElement addRemoveCardsDoneButton(WebDriver driver) {
		WebElement PopupWindow = driver.findElement(By.cssSelector("div[id='ext-availablecardspanel-1']"));
		WebElement doneCardbtn = PopupWindow.findElement(By.xpath("//button[@name='btn_done']//.."));
		return doneCardbtn;
	}

	public void closeAddRemoveCardsScreen(WebDriver driver) {
		WebElement PopupWindow = driver.findElement(By.cssSelector("div[id='ext-availablecardspanel-1']"));
		WebElement exitPopUp = PopupWindow.findElement(By.className("x-tool-type-close"));
		exitPopUp.click();
	}

	public String messageWarningMsgBox(WebDriver driver) throws InterruptedException {
		System.out.println(driver);
		Thread.sleep(2000);
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		System.out.println(WarnPopupWindow);
		WebElement warningmsg = WarnPopupWindow.findElement(By.cssSelector("div.x-messagebox-text"));
		return warningmsg.getText();
	}

	public String titleWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		WebElement warningTitle = WarnPopupWindow.findElement(By.cssSelector("div.x-messageboxtitle"));
		return warningTitle.getText();
	}

	public void clickOnYesWarningMsgBox(WebDriver driver) {
		try {
			WebElement addedCardName = ConnectMobilePageHelper.getElementBasedOnTag("div", "Yes");
			addedCardName.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnYesRemoveWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		List<WebElement> ButtonsWarningMsg = WarnPopupWindow
				.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
		for (WebElement yesBtnWarningMsg : ButtonsWarningMsg) {
			if (yesBtnWarningMsg.getText().equals("Yes, remove")) {
				yesBtnWarningMsg.click();
				break;
			}
		}
	}

	public void clickOnNoCancelWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		List<WebElement> ButtonsWarningMsg = WarnPopupWindow
				.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
		for (WebElement yesBtnWarningMsg : ButtonsWarningMsg) {
			if (yesBtnWarningMsg.getText().equals("No, cancel")) {
				yesBtnWarningMsg.click();
				break;
			}
		}
	}

	public void clickOnNoWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		List<WebElement> ButtonsWarningMsg = WarnPopupWindow
				.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
		for (WebElement noBtnWarningMsg : ButtonsWarningMsg) {
			if (noBtnWarningMsg.getText().equals("No")) {
				noBtnWarningMsg.click();
				break;
			}
		}
	}

	public void clickOnRemoveWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		List<WebElement> ButtonsWarningMsg = WarnPopupWindow
				.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
		for (WebElement removeBtnWarningMsg : ButtonsWarningMsg) {
			if (removeBtnWarningMsg.getText().equals("Remove")) {
				removeBtnWarningMsg.click();
				break;
			}
		}
	}

	public void clickOnCancelWarningMsgBox(WebDriver driver) {
		try {
			Thread.sleep(500);
			WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
			List<WebElement> ButtonsWarningMsg = WarnPopupWindow
					.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
			for (WebElement cancelBtnWarningMsg : ButtonsWarningMsg) {
				if (cancelBtnWarningMsg.getText().equals("Cancel")) {
					cancelBtnWarningMsg.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSaveForLaterWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		List<WebElement> ButtonsWarningMsg = WarnPopupWindow
				.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
		for (WebElement cancelBtnWarningMsg : ButtonsWarningMsg) {
			if (cancelBtnWarningMsg.getText().equals("Save For Later")) {
				cancelBtnWarningMsg.click();
				break;
			}
		}
	}

	public void clickOnExitWithoutSavingWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		List<WebElement> ButtonsWarningMsg = WarnPopupWindow
				.findElements(By.xpath("//div[@id='ext-messagebox']//button//.."));
		for (WebElement cancelBtnWarningMsg : ButtonsWarningMsg) {
			if (cancelBtnWarningMsg.getText().equals("Exit Without Saving")) {
				cancelBtnWarningMsg.click();
				waitForConnectCardLoadMsgToBeInvisible();
				break;
			}
		}
	}

	public void clickOnOKAlertMsgBox(WebDriver driver) {
		try {
			WebElement ButtonWarningMsg = driver.findElement(By.xpath("//div[@id='ext-messagebox']//button/.."));
			ButtonWarningMsg.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCheckboxLoggedUser(WebDriver driver, String LoggedUser) throws InterruptedException {
		try {
			WebElement panel = getDisplayedElement(
					driver.findElements(By.xpath("//div[starts-with(@data-componentid,'ext-container-')]")));
			assertNotNull(panel);
			List<WebElement> buttons = panel.findElements(By.xpath("//input[@name='useCurrentUserCheckbox']"));
			for (WebElement button : buttons) {
				button.click();
				break;
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSaveOnChangeForce(WebDriver driver) {
		try {
			Thread.sleep(1000);
			WebElement Save = getDisplayedElement(driver.findElements(By.xpath(
					"//div[starts-with(@id,'ext-toolbar-')]//following-sibling::button[@name='changeForceSaveBtn']//..")));
			assertNotNull(Save);
			Save.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ScrollToElementVisible(WebDriver driver, WebElement Element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This will scroll the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", Element);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickCancelOnChangeForce(WebDriver driver) {
		try {
			WebElement Cancel = getDisplayedElement(
					driver.findElements(By.xpath("//div[text()='Cancel']//..//..//..")));
			assertNotNull(Cancel);
			Cancel.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCloseButtonWarningMsgBox(WebDriver driver) {
		WebElement WarnPopupWindow = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
		WebElement closeButtonWarningMsg = WarnPopupWindow.findElement(By.cssSelector("div.x-tool-type-close"));
		closeButtonWarningMsg.click();
	}

	public void clickOnButtonCancel(WebDriver driver) {
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-footer-']"));
		assertNotNull(panel);
		WebElement btnCancel = panel.findElement(By.xpath("//button[@name='btn_cancel']//.."));
		assertNotNull(btnCancel);
		btnCancel.click();
	}

	public void clickOnButtonSubmit(WebDriver driver) {
		try {
			List<WebElement> panel = driver.findElements(By.cssSelector("div[id^='ext-conm-cards-footer-']"));
			Assert.assertTrue(panel.size() > 0);
			WebElement button = panel.get(0).findElement(By.xpath("//button[@name='btn_backtocard']//.."));
			if (button.isDisplayed()) {
				button.click();
			}
			Thread.sleep(1000);
			WebElement btnSubmit = panel.get(0).findElement(By.xpath("//button[@name='btn_submit']//.."));
			assertNotNull(btnSubmit);
			btnSubmit.click();
			waitForConnectCardLoadMsgToBeInvisible();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnButtonSaveForLater(WebDriver driver) {
		try {
			Thread.sleep(500);
			WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-footer-']"));
			assertNotNull(panel);
			// Now to click the Save for later buton...
			WebElement btnSubmit = panel.findElement(By.xpath("//button[@name='btn_savelater']//.."));
			assertNotNull(btnSubmit);
			btnSubmit.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnDeleteContextualLink(WebDriver driver) {
		try {
			Thread.sleep(500);
			WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-footer-']"));
			assertNotNull(panel);
			// Now to click the Delete contextual link buton...
			WebElement deleteContextutalLinkButton = panel
					.findElement(By.xpath("//button[@name='btn_deleteContextualLink']//.."));
			assertNotNull(deleteContextutalLinkButton);
			deleteContextutalLinkButton.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnButtonSubmitConfirmationMessage(WebDriver driver) {
		try {
			WebElement btnSubmit = null;
			// Verifying Dialog box with Save for later and Submit button
			WebElement txtDlgboxSubmit = driver.findElement(By.cssSelector("div.submitAlert"));
			assertTrue(txtDlgboxSubmit.getText().contains("Are you sure you want to submit this"),
					"Alert message did not displayed correctly.");

			btnSubmit = driver
					.findElement(By.xpath("//div[contains(@class, 'x-dialog')]//div[text()='Submit']//..//..//.."));
			btnSubmit.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnButtonSubmitDone(WebDriver driver) throws Exception {
		WebElement btnDone = null;

		waitForElementToBe(By.xpath("//div[@id='ext-messagebox']//div[text()='Done']/../../.."), "CLICKABLE", driver,
				10);
		btnDone = driver.findElement(By.xpath("//div[@id='ext-messagebox']//div[text()='Done']/../../.."));
		btnDone.click();
		Thread.sleep(2000);
	}

	public void clickOnButtonYesCardRequired(WebDriver driver) throws Exception {
		waitForElementToBe(By.xpath("//button[@name='btn_yescardrequired']//.."), "VISIBLE", driver, 10);
		WebElement btnYesCardReq = driver.findElement(By.xpath("//button[@name='btn_yescardrequired']//.."));
		assertNotNull(btnYesCardReq);
		if (btnYesCardReq.isDisplayed())
			btnYesCardReq.click();
	}

	public void clickOnButtonNoCardRequired(WebDriver driver) throws InterruptedException {
		Thread.sleep(500);
		waitForElementToBe(By.xpath("//button[@name='btn_nocardrequired']//.."), "CLICKABLE", driver, 20);
		WebElement btnNoCardReq = driver.findElement(By.xpath("//button[@name='btn_nocardrequired']//.."));
		assertNotNull(btnNoCardReq);
		btnNoCardReq.click();
	}

	public void clickOnButtonStaticObjectSaveReturn(WebDriver driver) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> btnSave = null;
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
		assertNotNull(panel);
		// Now to click the Save & Return buton...
		btnSave = panel.findElements(By.xpath("//button[@name='btn_save']//.."));
		assertNotNull(btnSave);
		btnSave.get(0).click();
		Thread.sleep(500);
		driver.findElement(By.name("btn_backtocard")).click();
	}

	// Verify Submission Error Dialog
	public WebElement verifySubmissionErrorDialog(WebDriver driver) {
		WebElement DlgSubmissionError = null;
		try {
			switch_To_ConnectMobileModule(driver);
			DlgSubmissionError = driver.findElement(By.xpath(
					"//div[starts-with(@id,'ext-incompletecardspanel-')]//div[starts-with(@data-componentid, 'ext-paneltitle-')]"));
			assertNotNull(DlgSubmissionError);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DlgSubmissionError;
	}

	// Clicking on Cancel Button on Submission error popup
	public void clickOnCancelOnSubmissionError(WebDriver driver) {
		try {
			WebElement Cancel = driver.findElement(
					By.xpath("//div[starts-with(@id,'ext-incompletecardspanel-')]//button[@name='btn_cancel']"));
			assertNotNull(Cancel);
			Cancel.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnButtonEventObjectSaveReturn(WebDriver driver) {
		waitForElementToBe(By.cssSelector("div[id^='ext-conm-cards-type-dataFooter-']"), "VISIBLE", driver, 10);
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-dataFooter-']"));
		assertNotNull(panel);
		assertNotNull(panel);
		// Now to click the Save buton...
		WebElement btnSave = panel.findElement(By.xpath("//button[@name='btn_Save']//.."));
		assertNotNull(btnSave);
		btnSave.click();
	}

	public void clickOnIndexButton(WebDriver driver) throws InterruptedException {
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-footer-']"));
		assertNotNull(panel);
		WebElement button = panel.findElement(By.xpath("//button[@name='btn_backtocard']//.."));
		button.click();
	}

	public void clickOnChangeForce(WebDriver driver) throws InterruptedException {
		WebElement panel = getDisplayedElement(
				driver.findElements(By.xpath("//div[starts-with(@id,'ext-conm-field-employee-iteration-lookup-')]")));
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='showChangeForceDialogBtn']//.."));
		for (WebElement button : buttons) {
			if (button.getText().equals("Change Force")) {
				button.click();
				break;
			}
		}
		Thread.sleep(5000);
	}

	public void selectForce(WebDriver driver, String ForceName) throws InterruptedException {
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-fieldpanel-']"));
		assertNotNull(panel);
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//label[text()='ForceName']//.."));
		for (WebElement button : buttons) {
			if (button.getText().equals("ForceName")) {
				button.click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	public void clickOnNextButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='btn_next']//.."));
		for (WebElement button : buttons) {
			if (button.getText().equals("Next")) {
				button.click();
				break;
			}
		}
		waitForSearchLoadMsgToBeInvisible();
	}

	public void clickOnBackButton(WebDriver driver) throws InterruptedException {
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='btn_back']//.."));
		for (WebElement button : buttons) {
			if (button.getText().contains("This is not the")) {
				button.click();
				break;
			}
		}
		Thread.sleep(500);
	}

	public void clickOnDeleteButton(WebDriver driver) throws InterruptedException {
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='btn_delete']//.."));
		for (WebElement button : buttons) {
			if (button.getText().contains("Delete")) {
				button.click();
				break;
			}
		}
		Thread.sleep(500);
	}

	public void clickOnNoneOfTheseButton(WebDriver driver) throws InterruptedException {
		waitForElementToBe(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"), "VISIBLE", driver, 20);
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='btn_noneofthese']//.."));
		for (WebElement button : buttons) {
			if (button.getText().contains("None of these")) {
				button.click();
				break;
			}
		}
	}

	public void clickOnFirstAssociationsAdded(WebDriver driver) throws InterruptedException {
		WebElement panel = driver.findElement(By.cssSelector("div[class^='object-search-result-main-container']"));
		assertNotNull(panel);
		WebElement angleClick = panel.findElement(By.cssSelector("div[class^='object-result-angle'] i"));
		angleClick.click();
		Thread.sleep(500);
	}

	public void clickOnSearchResultCancelButton(WebDriver driver) throws InterruptedException {
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter-']"));
		assertNotNull(panel);
		List<WebElement> buttons = panel.findElements(By.xpath("//button[@name='btn_cancel']//.."));
		for (WebElement button : buttons) {
			if (button.getText().contains("Cancel")) {
				button.click();
				break;
			}
		}
		Thread.sleep(500);
	}

	public void clickOnAddNewInstanceButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(500L);
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-objectInstances-']"));
		assertNotNull(panel);
		WebElement button = panel.findElement(By.xpath("//button[@name='btn_addnewinstance']//.."));
		button.click();
		Thread.sleep(500);
	}

	public String getURNNumber(WebDriver driver) {
		String URNNo = null;
		try {
			waitForElementToBe(By.cssSelector("div[id='ext-messagebox']"), "VISIBLE", driver, 10);
			WebElement popupWindowWarning = driver.findElement(By.cssSelector("div[id='ext-messagebox']"));
			WebElement txtDlgboxURN = popupWindowWarning.findElement(By.className("urnNo"));
			URNNo = txtDlgboxURN.getText();
			scenario.write("Unique Reference Number - " + URNNo);
		} catch (Exception e) {
			Log.error("Error while fetching URN - \n" + e.getMessage());
		}
		return URNNo;
	}

	public void clickOnTab(WebDriver driver, String tabName) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> tabs = getDisplayedElements(
				driver.findElements(By.xpath("//div[contains(@data-componentid, 'ext-tab-')]")));
		
		int size = tabs.size();
		
		for (int i = 0; i < size; i++) {
			if (!tabs.get(i).getText().isEmpty()) {
				if (tabs.get(i).getText().contains(tabName)) {
					String id = tabs.get(i).getAttribute("id");
					driver.findElement(By.cssSelector("div[id='" + id + "']")).click();
					break;
				}
			} else {
				WebElement rightScrollBar = driver.findElement(By.cssSelector("div.x-tabbar div.x-tool-type-scroll-right"));
				for (int m = 1; m <= 4; m++)
					rightScrollBar.click();
				clickOnTab(driver, tabName, i);
			}
		}
	}
	
	public void clickOnTab(WebDriver driver, String tabName, int j) throws InterruptedException {
		List<WebElement> tabs = getDisplayedElements(
				driver.findElements(By.xpath("//div[contains(@data-componentid, 'ext-tab-')]")));
		
		int size = tabs.size();

		mainloop: for (int i = j; i <= size; i++) {
			if (!tabs.get(i).getText().isEmpty()) {
				if (tabs.get(i).getText().contains(tabName)) {
					String id = tabs.get(i).getAttribute("id");
					driver.findElement(By.cssSelector("div[id='" + id + "']")).click();
					break;
				}
			} else {
				WebElement rightScrollBar = driver.findElement(By.cssSelector("div.x-tabbar div.x-tool-type-scroll-right"));
				for (int m = 1; m <= 4; m++)
					rightScrollBar.click();
				clickOnTab(driver, tabName, i);
				break mainloop;
			}
		}
	}

	public void clickOnYesOrNoButton(WebDriver driver, String label, String button) throws InterruptedException {
		Thread.sleep(500);
		WebElement panel = getDisplayedElement(driver.findElements(By.xpath("//span[contains(text(),'" + label
				+ "')]/../..//div[contains(@class, 'x-segmentedbutton')]//div[contains(text(), '" + button
				+ "')]/../../..")));
		String id = panel.getAttribute("id");
		WebElement elButton = driver.findElement(By.id(id));
		elButton.click();
	}

	// Function to enter value in input field
	public void inputFieldValue(WebDriver driver, WebElement elField, String value) throws InterruptedException {
		if (!value.isEmpty() && elField.getAttribute("readonly") == null) {
			try {
				elField.click();
				Thread.sleep(500);
				elField.click(); // Sometime single clicks doesn't work - e.g. Date of birth field
				clearField(elField);
				elField.sendKeys(value);
				elField.sendKeys(Keys.TAB);
			} catch (ElementNotVisibleException e) {
				elField.sendKeys(value);
				elField.sendKeys(Keys.TAB);
			} catch (Exception e) {
				e.printStackTrace();
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
		closeBrowser(driver);
		org.testng.Assert.fail("Test Failed due to this exception : " + ExceptionVal.toString());

	}

	private void TakeScreenShot(String ArchiveFilePath, String TestName, String TestEnv) throws IOException {
		// This function takes a screenshot on the local machine and then copies it to
		// the network folder.

		// Create ExecutionDate is a format that can be appended to file name.
		Date TodayDate = new Date();
		String ExecutionDate = "";
		ExecutionDate = FormatDateTime(TodayDate, ExecutionDate);

		try {// Added due to issues with the screenshot taker on remote boxes.
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(
					ArchiveFilePath + "\\" + TestName + "_" + TestEnv + "_" + ExecutionDate + "_SCREEN.jpg");
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

	// This function is used to Pick a value from drop down.
	public void selectValueFromDropDown(WebDriver driver, WebElement elField, String InputVal)
			throws InterruptedException {
		if (!InputVal.isEmpty()) {
			try {
				elField.click();
				Thread.sleep(500L);
				elField.click(); // clicking second time to get the focus for repeating group
				elField.sendKeys(Keys.ARROW_DOWN); // This opens the List
				elField.sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME)); // This takes to the first record

				List<WebElement> ddlBox = driver
						.findElements(By.xpath("//div[starts-with(@id, 'ext-simplelistitem-')]//span"));

				for (WebElement elDDL : ddlBox) {
					if (elDDL.isDisplayed()) {
						elField.sendKeys(Keys.ARROW_DOWN);
						if (elDDL.getText().equals(InputVal)) {
							elDDL.findElement(By.xpath("..//..//..//..")).click();
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void FetchJson() {
		String result = "";
		try {
			properties = Utility.loadProperties();
			String cardDefURL = properties.getProperty("cardDefURL");

			String a = "window.open('about:blank','_blank');";
			((JavascriptExecutor) driver).executeScript(a);
			Set<String> customerWindow = driver.getWindowHandles();
			String customerSiteHandle = ((String) customerWindow.toArray()[1]);
			driver.switchTo().window(customerSiteHandle);
			driver.get(cardDefURL); /// connectmobile/develop/api/card_definitions?
			Thread.sleep(5000);
			// Firefox json gets open in json tab, need to click on Raw Data to open it in
			// json format.
			if (properties.getProperty("Browser").equalsIgnoreCase("FireFox")) {
				clickElement(By.xpath("//a[@title='Raw Data']"), driver);
			}
			WebElement jsonElement = driver.findElement(By.tagName("pre"));
			result = jsonElement.getText();
			Thread.sleep(10000);
			stringToFile(result, CardUtility.FILENAME);
			driver.close();
			driver.switchTo().window((String) customerWindow.toArray()[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void stringToFile(String text, String fileName) {
		try {
			File file = new File(fileName);

			// Delete file if exist then create new one
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();
			System.out.println("Done writing to " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void selectLookupValue(WebDriver driver, WebElement elField, String force, String bcu, String ward,
			String district, String fieldValue) {
		try {
			Thread.sleep(500);

			// Clear force field
			WebElement forceElement = getDisplayedElement(
					driver.findElements(By.cssSelector("input[conmuniqueidentifier='forceField']")));
			assertNotNull(forceElement);
			inputFieldValue(driver, forceElement, force);
			Thread.sleep(500);

			// Click on Filter button
			WebElement filterButton = getClickableDiv(
					driver.findElements(By.xpath("//div[text()='Filter']//..//..//..")));
			assertNotNull(filterButton);
			filterButton.click();
			if (!bcu.isEmpty()) {
				Thread.sleep(500);
				// Input value in BCU, Ward and District
				WebElement bcuElement = getDisplayedElement(
						driver.findElements(By.cssSelector("input[conmuniqueidentifier='bcuField']")));
				assertNotNull(bcuElement);
				inputFieldValue(driver, bcuElement, bcu);
			}

			if (!ward.isEmpty()) {
				Thread.sleep(500);
				WebElement wardElement = getDisplayedElement(
						driver.findElements(By.cssSelector("input[conmuniqueidentifier='wardField']")));
				assertNotNull(wardElement);
				inputFieldValue(driver, wardElement, ward);
			}

			if (!district.isEmpty()) {
				Thread.sleep(500);
				WebElement districtElement = getDisplayedElement(
						driver.findElements(By.cssSelector("input[conmuniqueidentifier='districtField']")));
				assertNotNull(districtElement);
				inputFieldValue(driver, districtElement, district);
			}

			Thread.sleep(500);
			// Click on Apply Filter button
			WebElement applyFilterButton = getDisplayedElement(
					driver.findElements(By.xpath("//div[text()='Apply Filters']//..//..//..")));
			assertNotNull(applyFilterButton);
			applyFilterButton.click();

			Thread.sleep(1500);
			WebElement search = getDisplayedElement(
					driver.findElements(By.cssSelector("input[conmuniqueidentifier='searchField']")));
			assertNotNull(search);
			inputFieldValue(driver, search, fieldValue);

			Thread.sleep(1500);
			// Select an item from list
			WebElement dialog = getDisplayedElement(driver.findElements(By.cssSelector("div[id^='ext-list-']")));
			List<WebElement> dialogList = dialog.findElements(By.cssSelector("div[id^='ext-simplelistitem-']"));
			List<WebElement> items = getDisplayedElements(dialogList);
			assertNotNull(items);
			for (WebElement elItem : items) {
				if (elItem.getText().equals(fieldValue)) {
					elItem.click();
					break;
				}
			}
			Thread.sleep(500);

			// Click on Apply button
			WebElement applyButton = getDisplayedElement(
					driver.findElements(By.xpath("//div[text()='Apply']//..//..//..")));
			assertNotNull(applyButton);
			applyButton.click();
			Thread.sleep(500);

			elField.sendKeys(Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFormValues(WebDriver driver, WebElement elField, String fieldLabel, String fieldValue)
			throws Exception {
//		if (elField.getAttribute("data-componentid").contains("ext-conm-dropdownfield")) {
//			selectValueFromDropDown(driver, elField, fieldValue);
//		} else 
		if (elField.getAttribute("conmuniqueidentifier") != null) {
			clickOnLookupButton(driver, fieldLabel);
			// Pass values for fields in lookup popup
			String force = properties.getProperty("Force");
			String bcu = properties.getProperty("BCU");
			String ward = properties.getProperty("Ward");
			String district = properties.getProperty("District");
			selectLookupValue(driver, elField, force, bcu, ward, district, fieldValue);
		} else if (elField.getAttribute("data-componentid").contains("timefield")) {
			setTimeAs(driver, elField, fieldValue);
		} else {
			inputFieldValue(driver, elField, fieldValue);
		}
	}

	public void deleteFiles(File file) throws IOException {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				if (fileExtension(f).equals("txt") || fileExtension(f).equals("jpg")) {
					f.delete();
				}
			}
		}
	}

	public String fileExtension(File file) throws IOException {
		if (file == null) {
			return "";
		}
		String name = file.getName();
		int i = name.lastIndexOf('.');
		String ext = i > 0 ? name.substring(i + 1) : "";
		return ext;
	}

	public WebElement getInputFromLabel(WebDriver driver, String label) {
		WebElement el = null;
		try {
			WebElement unitsLabelEl = driver.findElement(By.xpath("//span[text()='" + label + "']"));
			String id = unitsLabelEl.getAttribute("id");
			id = id.replace("labelTextEl", "inputEl");
			el = driver.findElement(By.cssSelector("input[id='" + id + "']"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return el;
	}

	public void deselectCheckbox(WebDriver driver) {
		try {
			WebElement element = getDisplayedElement(
					driver.findElements(By.cssSelector("span[class='x-column-header-checkbox']")));
			assertNotNull(element);
			Thread.sleep(500);
			element.click();
			Thread.sleep(500);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getColumnNumber(WebDriver driver, String column) throws InterruptedException {
		int colNumber = 2; // ColNumber starting from 2 because first element is hidden
		Thread.sleep(500);
		try {
			List<WebElement> headerColumnList = getDisplayedElements(driver.findElements(
					By.cssSelector("div[id^='tasksByObjectResults'] div.x-grid-header-ct span[id$='-textInnerEl']")));
			for (WebElement headerColumn : headerColumnList) {
				if (headerColumn.getText().equalsIgnoreCase(column)) {
					break;
				}
				colNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colNumber;
	}

	public WebElement clickRemoveCardsRemoveButton(WebDriver driver, String label) {
		WebElement removeCardbtn = driver.findElement(By.xpath("//div[@id='ext-availablecardspanel-1']//div[text()='"
				+ label + "']//..//..//..//following-sibling::div//button[@name='btn_remove']//.."));
		String elID = removeCardbtn.getAttribute("id");
		WebElement addCardbutton = driver.findElement(By.id(elID));
		return addCardbutton;
	}

	public boolean verifyText(WebDriver driver, String cardName, String string2, String eventName, String FieldName,
			String expectedText) {
		Boolean Status = false;
		try {
			String fieldElementName = crdUtility.getElementName(cardName, null, eventName, FieldName);
			WebElement txReportTitle = driver.findElement(By.name(fieldElementName));
			String actualText = txReportTitle.getAttribute("Value");
			if (actualText.equalsIgnoreCase(expectedText)) {
				Status = true;
			}
			return Status;
		} catch (Exception e) {
			return Status;
		}

	}

	/**
	 * Generate final test report
	 */

	/*
	 * @After public static void generateReport() { DateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date date = new Date(); String
	 * currentDirectory = System.getProperty("user.dir"); String strFinalReport =
	 * currentDirectory + "/target/jenkins-report/"; String strJsonFile =
	 * currentDirectory + "/target/JSON/";
	 * 
	 * try { if (new File(strFinalReport + "FinalReport").exists())
	 * FileUtils.rename(new File(strFinalReport + "FinalReport"), new
	 * File(strFinalReport + "FinalReport " + dateFormat.format(date))); } catch
	 * (IOException e) { Log.error("Report generation failed due to: " +
	 * e.getMessage()); } Configuration config = new Configuration(new
	 * File(strFinalReport + "FinalReport"), "AutomationTest-BDD");
	 * 
	 * List<String> jsonFiles = new ArrayList<String>(); File[] files = new
	 * File(strJsonFile).listFiles();
	 * 
	 * for (int i = 0; i < files.length; i++) {
	 * if(files[i].getAbsolutePath().endsWith(".json") && !files[i].isDirectory()) {
	 * jsonFiles.add(files[i].getAbsolutePath()); } } ReportBuilder build = new
	 * ReportBuilder(jsonFiles, config); build.generateReports(); }
	 */

	/*
	 * Get field value from Excel for a field Name
	 */
	public String getFieldValue(String cardName, String formName, String fieldName) throws Exception {
		String fieldValue = null;
		try {
			for (int i = 0; i < Utility.testData.length; i++) {
				for (int j = 0; j < Utility.testData[i].length - 1;) {
					String xlCardName = Utility.testData[i][0];
					if (xlCardName.equals(cardName)) {
						String xlFormName = Utility.testData[i][1];
						String xlFieldName = Utility.testData[i][2];
						if (formName.length() != 0) {
							if (xlFormName.equals(formName) && xlFieldName.equals(fieldName)) {
								fieldValue = Utility.testData[i][j + 3];
								fieldValue = returnFieldValue(fieldValue);
								break;
							} else
								break;
						} else if (xlFieldName.equals(fieldName)) {
							fieldValue = Utility.testData[i][3];
							fieldValue = returnFieldValue(fieldValue);
							break;
						} else
							break;
					} else
						break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldValue;
	}

	public boolean isSearchResultDisplayed(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector("div[id^='ext-conm-common-search-result-'] div.mainHeading div"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isResultsDisplayed(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector("div[id^='ext-conm-cards-objectInstances'] div[id^='ext-dataview']"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickOnRepeatingGroupButton(WebDriver driver, String btnName) {
		try {
			List<WebElement> elAddNewButtonArray = driver.findElements(By.cssSelector("div.repeatingGroupAddBtn"));
			for (WebElement elAddNewButton : elAddNewButtonArray) {
				if (elAddNewButton.getText().equals(btnName)) {
					elAddNewButton.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForPageLoadMsgToBeInvisible(String Message) {
		Assert.assertTrue(waitForElementStateToBe(By.xpath("//div[@class='x-mask-msg-text'][text()='" + Message + "']"),
				"INVISIBLE", driver), "Requested page is not loaded");
	}

	public void waitForPageLoadMsgToBeVisible() {
		try {
			Assert.assertTrue(waitForElementStateToBe(By.xpath("//div[@class='x-mask-msg-text']"), "VISIBLE", driver),
					"Requested page is not loaded");
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

	public void waitForConnectCardLoadMsgToBeInvisible() {
//		Assert.assertTrue(
//				waitForElementStateToBe(By.xpath("//div[@class='x-loading-spinner-outer']"), "INVISIBLE", driver),
//				"Requested card screen is not loaded");
		Assert.assertNotNull(
				waitForElementToBe(By.xpath("//div[@class='x-loading-spinner-outer']"), "INVISIBLE", driver, 40),
				"Requested card screen is not loaded");
	}

	public void waitForConnectCardLoadMsgToBeVisible() {
		Assert.assertTrue(
				waitForElementStateToBe(By.xpath("//div[@class='x-loading-spinner-outer']"), "VISIBLE", driver),
				"Requested card screen is not loaded");
	}

	public void waitForSearchLoadMsgToBeInvisible() {
		Assert.assertTrue(waitForElementStateToBe(By.cssSelector("div[id^='ext-mask-']"), "INVISIBLE", driver),
				"Requested search result screen is not loaded");
	}

	// Refresh workload tray
	public void refreshWorklodScreen() {
		try {
			// getWait(driver);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#refreshTool")));
			driver.findElement(By.cssSelector("div#refreshTool")).click();
			waitForPageLoadMsgToBeInvisible("Processing");
			// Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadAvailableCard(String cardName, String linkReason) {
		try {
			// Click on Add/Remove button
			WebElement addRemoveCardBtn = addRemoveCardsButton(driver);
			assertNotNull(addRemoveCardBtn);
			addRemoveCardBtn.click();
			// Thread.sleep(500L);

			// Click on Add button against given card
			cardName = getNameForCard(cardName, linkReason, CardUtility.globalEventType);
			WebElement addCardbtn = addRemoveCardsAddButton(driver, cardName);
			assertNotNull(addCardbtn);
			Actions act = new Actions(driver);
			act.moveToElement(addCardbtn).click().build().perform();
			if (addCardbtn.isDisplayed())
				addCardbtn.click();

			// Click on Done button
			// Thread.sleep(1000);
			WebElement donebtn = addRemoveCardsDoneButton(driver);
			donebtn.click();

			// Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectValueFromDropDownList(WebDriver driver, WebElement elField, String InputVal)
			throws InterruptedException {
		try {
			elField.clear();
			elField.sendKeys(InputVal);
			Thread.sleep(2000);
			String xpath = "//div[starts-with(@id, 'ext-simplelistitem-')]//span[contains(text(),'" + InputVal + "')]";
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(xpath)));
			actions.click();
			actions.build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			selectValueFromDropDown(driver, elField, InputVal);
		}
	}

	public void captureScreenShot(Scenario scenario) {
		String screenShotName = scenario.getName().replaceAll(" ", "_");
		try {
			final String dest = Constant.SCREENSHOT_PATH + "/" + screenShotName + Constant.SCREENSHOT_EXTENTION;
			final TakesScreenshot screenshot = (TakesScreenshot) driver;
			final File sourcePath = screenshot.getScreenshotAs(OutputType.FILE);
			final File destination = new File(dest);
			FileUtils.copyFile(sourcePath, destination);
			Reporter.addScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + "/" + dest.toString());
		} catch (Exception e) {
			Log.error("Unable to capture screenshot");
		}
	}

	// @After
	// public void tearDown(Scenario scenario) {
	// if (scenario.isFailed()) {
	// captureScreenShot(scenario);
	// }
	// driver.quit();
	//
	// }

	public void fillAssociationForm(String card, String LinkReason) {
		try {
			clickOnTab(driver, "Association");
			Thread.sleep(2000);
			clickAddNewAssociationDisplayed(driver);
			Thread.sleep(2000);
			int j = 1;
			for (int i = 0; i < Utility.testData.length; i++) {
				String xlCardName = Utility.testData[i][0];
				String xlFormName = Utility.testData[i][1];
				String objectXpath = "//div[contains(@class,'contextualGridItem')]//div[contains(text(),'is the')]/../../../preceding-sibling::div//input";
				String relationshipXpath = "//div[contains(@class,'contextualGridItem')]//div[contains(text(),'is the')]/../../../following-sibling::div//input";
				List<WebElement> objects = null;
				List<WebElement> relationships = null;
				if (xlCardName.contains(card) && xlFormName.equals("Association")) {
					if (j > 1) {
						clickAddAssociationDisplayed(driver);
					}
					String fieldLabel = Utility.testData[i][2];
					String fieldValue = returnFieldValue(Utility.testData[i][3]);
					if (fieldLabel.contains("Object")) {
						objects = driver.findElements(By.xpath(objectXpath));
						if (objects != null) {
							selectValueFromDropDownList(driver, objects.get(objects.size() - 1), fieldValue);
						}
					}
					if (fieldLabel.contains("Relationship")) {
						relationships = driver.findElements(By.xpath(relationshipXpath));
						if (relationships != null) {
							selectValueFromDropDownList(driver, relationships.get(relationships.size() - 1),
									fieldValue);
						}
						j++;
					}
				}
			}
		} catch (Exception e) {
			// cmPageHelper.CloseFailedTest(driver, LogFilePath, LogFilePath, "", TestName,
			// EnvName, e);
		} catch (AssertionError e) {
			// cmPageHelper.CloseFailedTest(driver, LogFilePath, LogFilePath, "", TestName,
			// EnvName, e.fillInStackTrace());
		}
	}

	public boolean clickAddNewAssociationDisplayed(WebDriver driver) {
		try {
			WebElement button = driver.findElement(By.xpath("//button[@name='btn_addnewassociation']"));
			button.click();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean clickAddAssociationDisplayed(WebDriver driver) {
		try {
			List<WebElement> button = driver.findElements(By.xpath("//button[@name='btn_addnewassociation']"));
			button.get(1).click();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void waitForTabToBeActive(WebDriver driver, String tabName) {
		try {
			Assert.assertTrue(waitForElementStateToBe(By.xpath(
					"//div[contains(@data-componentid, 'ext-tab-') and contains(@class,'x-active')]//div[contains(text(),'"
							+ tabName.trim() + "')]"),
					"VISIBLE", driver));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isElementMandatory(String name) {
		try {
			Assert.assertTrue(
					waitForElementStateToBe(By.xpath("//*[contains(@class,'x-required')]//*[@name='" + name + "']"),
							"VISIBLE", driver),
					"Element not Mandatory :" + name);
			Log.info("Element is mandatory :" + name);
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}

	}

	public void isElementnonMandatory(String name) {
		try {
			Assert.assertTrue(
					waitForElementStateToBe(By.xpath("//*[contains(@class,'x-readonly')]//*[@name='" + name + "']"),
							"VISIBLE", driver),
					"Element is Mandatory :" + name);
			Log.info("Element not mandatory :" + name);
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}

	}

	public void validateFieldsOnCard(String strOperation, String strForm, String strCard, String strLinkReason)
			throws Exception {
		try {
			String cardFormName = "";
			String cardName = getNameForCard(strCard, strLinkReason, CardUtility.globalEventType);
			if (strLinkReason.trim().isEmpty()) {
				strLinkReason = cardName;
			}
			if (strForm.trim().isEmpty()) {
				cardFormName = cardName;
			} else {
				clickOnTab(driver, strForm);
				waitForTabToBeActive(driver, strForm);
				cardFormName = strForm;
			}
			for (int i = 0; i < Utility.testData.length; i++) {
				String xlCardName = Utility.testData[i][0];
				if (Utility.testData[i][1].contains("|")) {
					String[] xlForm = Utility.testData[i][1].split("\\|");
					String xlFormName = xlForm[0].toString().trim();
					String xlOperationName = xlForm[1].toString().trim();

					if (xlCardName.equals(strCard) && xlCardName.contains(strLinkReason)
							&& xlOperationName.equalsIgnoreCase(strOperation) && xlFormName.contains(cardFormName)) {
						String fieldLabel = Utility.testData[i][2];
						String fieldValue = returnFieldValue(Utility.testData[i][3]).trim();
						String fieldName = crdUtility.getElementName(cardName, null, CardUtility.globalEventType,
								fieldLabel);
						assertNotNull(fieldName, "Error while reading json file for field :" + fieldLabel);

						String groupName = crdUtility.getGroupName(cardName, null, CardUtility.globalEventType, fieldLabel);
						if (groupName != null) {
							List<WebElement> elList = waitForElementToBe(By.name(fieldName), "VISIBLE", driver, 2);
							if (elList == null) {
								clickOnRepeatingGroupButton(driver, "Add New " + groupName);
							} else if (elList != null) {
								WebElement el = elList.get(elList.size() - 1);
								if (!el.getText().isEmpty() || !el.getAttribute("value").isEmpty())
									clickOnRepeatingGroupButton(driver, "Add New " + groupName);
							}
						}

						switch (strOperation) {
						case "Pre populated":
							validatePrePopulatedValue(fieldName, fieldLabel, fieldValue);
							break;
						case "Disabled":
							validateDisabledFieldsOnCard(fieldName, fieldLabel, fieldValue);
							break;
						case "Available":
							fieldIsAvailableOnCard(fieldName, fieldLabel, fieldValue);
							break;
						case "Enabled":
							fieldIsEnabledOnCard(fieldName, fieldLabel, fieldValue);
							break;
						case "Mandatory":
							elementIsMandatory(fieldName, fieldLabel);
							break;
						case "Non Mandatory":
							elementIsNotMandatory(fieldName, fieldLabel);
							break;
						}

					}
				}
			}
		} catch (Exception e) {
			Log.info("Unable to perform operation");
		}
	}

	public void validatePrePopulatedValue(String fieldName, String fieldLabel, String fieldValue) {
		try {
			if (fieldValue.equalsIgnoreCase("<blank>") || fieldValue.equalsIgnoreCase("null")) {
				fieldValue = "";
			}
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")) {
				By xpath = By.xpath("//div[starts-with(@id, 'ext-conm-boolean-')]//span[text()='" + fieldLabel
						+ "']//..//..//button//..//div[text()='" + fieldValue
						+ "']//ancestor::div[contains(@class, 'x-pressed')]");
				Assert.assertTrue(waitForElementStateToBe(xpath, "VISIBLE", driver), "Button is not clicked");
			} else {
				Assert.assertTrue(waitForElementStateToBe(By.name(fieldName), "VISIBLE", driver),
						"Field is not visible :" + fieldLabel);
				String txt = driver.findElement(By.name(fieldName)).getAttribute("value").trim();
				Assert.assertTrue(txt.equalsIgnoreCase(fieldValue), "Field value doesnt match with UI :" + fieldLabel);
			}
		} catch (Exception e) {
			Log.info("Unable to perform operation");
			throw e;
		}
	}

	public void validateDisabledFieldsOnCard(String fieldName, String fieldLabel, String fieldValue) {
		boolean flag = false;
		try {
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")) {
				By xpath = By.xpath("//div[starts-with(@id, 'ext-conm-boolean-')]//span[text()='" + fieldLabel
						+ "']//..//..//button//..//div[text()='" + fieldValue
						+ "']//ancestor::div[contains(@class, 'x-disabled')]");
				flag = waitForElementStateToBe(xpath, "VISIBLE", driver);
			} else {
				WebElement elField = waitForElementToBe(By.name(fieldName), "VISIBLE", driver);
				if (elField.getAttribute("readonly") != null
						&& elField.getAttribute("readonly").toString().equalsIgnoreCase("true"))
					flag = true;
				else if (elField.getAttribute("disabled") != null
						&& elField.getAttribute("disabled").toString().equalsIgnoreCase("true"))
					flag = true;
			}

			Assert.assertTrue(flag, "Element is not disabled :" + fieldLabel);
		} catch (NoSuchElementException e) {
			throw e;
		} catch (Exception e) {
			Log.info("Unable to perform operation");
			throw e;
		}
	}

	public void fieldIsAvailableOnCard(String fieldName, String fieldLabel, String fieldValue) {
		try {
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")) {
				By xpath = By.xpath("//div[starts-with(@id, 'ext-conm-boolean-')]//span[text()='" + fieldLabel
						+ "']//..//..//button//..//div[text()='" + fieldValue
						+ "']//ancestor::div[contains(@class, 'x-button')]");
				Assert.assertTrue(waitForElementStateToBe(xpath, "VISIBLE", driver), "Button is not clicked");
			} else {
				Assert.assertTrue(waitForElementStateToBe(By.name(fieldName), "VISIBLE", driver),
						"Field is not visible :" + fieldLabel);
			}
		} catch (Exception e) {
			Log.info("Unable to perform operation");
			throw e;
		}
	}

	public void fieldIsEnabledOnCard(String fieldName, String fieldLabel, String fieldValue) {
		try {
			WebElement we = null;
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")) {
				By xpath = By.xpath("//div[starts-with(@id, 'ext-conm-boolean-')]//span[text()='" + fieldLabel
						+ "']//..//..//button//..//div[text()='" + fieldValue
						+ "']//ancestor::div[contains(@class, 'x-button')]");
				we = waitForElementToBe(xpath, "VISIBLE", driver);
				Assert.assertTrue(we.isEnabled(), "Fields is not Enabled :" + fieldLabel);
			} else {
				we = waitForElementToBe(By.name(fieldName), "VISIBLE", driver);
				Assert.assertTrue(we.isEnabled(), "Fields is not Enabled :" + fieldLabel);
			}
		} catch (Exception e) {
			Log.info("Unable to perform operation");
			throw e;
		}
	}

	public void elementIsMandatory(String fieldName, String fieldLabel) {
		try {
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")) {
				By xpath = By.xpath("//*[contains(@class,'x-required')]//span[text()='" + fieldLabel + "']");
				Assert.assertTrue(waitForElementStateToBe(xpath, "VISIBLE", driver),
						"Element not Mandatory :" + fieldLabel);
			} else {
				Assert.assertTrue(waitForElementStateToBe(
						By.xpath("//*[contains(@class,'x-required')]//*[@name='" + fieldName + "']"), "VISIBLE",
						driver), "Element not Mandatory :" + fieldLabel);
			}

		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
			throw e;
		}
	}

	public void elementIsNotMandatory(String fieldName, String fieldLabel) {
		try {
			if (fieldLabel.equalsIgnoreCase(fieldName) && !fieldName.toUpperCase().contains("DATE")) {
				String xpathYes = "//div[starts-with(@id, 'ext-conm-boolean-') and not(contains(@class,'x-required')) ]//span[text()='"
						+ fieldLabel
						+ "']//..//..//button//..//div[text()='Yes']//ancestor::div[contains(@class, 'x-button')]";
				String xpathNo = "//div[starts-with(@id, 'ext-conm-boolean-') and not(contains(@class,'x-required')) ]//span[text()='"
						+ fieldLabel
						+ "']//..//..//button//..//div[text()='No']//ancestor::div[contains(@class, 'x-button')]";
				List<WebElement> button = null;
				WebElement elButton = null;
				String id = "";
				// Checking non mandatory field by validating Yes is clickable
				button = waitForElementToBe(By.xpath(xpathYes), "VISIBLE", driver, 20);
				assertNotNull(button, "Element is mandatory or Not displayed :" + fieldLabel);
				id = button.get(0).getAttribute("id");
				elButton = driver.findElement(By.id(id));
				Assert.assertNull(elButton.getAttribute("readonly"),
						"Failed to validate Non mandatory field as Field is Disabled :" + fieldLabel);
				Assert.assertNull(elButton.getAttribute("disabled"),
						"Failed to validate Non mandatory field as Field is Disabled :" + fieldLabel);

				// Checking non mandatory field by validating No is clickable
				button = waitForElementToBe(By.xpath(xpathNo), "VISIBLE", driver, 20);
				assertNotNull(button, "Element is mandatory or Not displayed :" + fieldLabel);
				id = button.get(0).getAttribute("id");
				elButton = driver.findElement(By.id(id));
				Assert.assertNull(elButton.getAttribute("readonly"),
						"Failed to validate Non mandatory field as Field is Disabled :" + fieldLabel);
				Assert.assertNull(elButton.getAttribute("disabled"),
						"Failed to validate Non mandatory field as Field is Disabled :" + fieldLabel);

			} else {
				String xpath = "//div[contains(@class,'x-field x-component') and not(contains(@class,'x-required'))]//*[@name='"
						+ fieldName + "']";
				List<WebElement> we = waitForElementToBe(By.xpath(xpath), "VISIBLE", driver, 20);
				assertNotNull(we, "Element is mandatory or Not displayed :" + fieldLabel);
				Assert.assertNull(we.get(0).getAttribute("readonly"),
						"Failed to validate Non mandatory field as Field is Disabled :" + fieldLabel);
				Assert.assertNull(we.get(0).getAttribute("disabled"),
						"Failed to validate Non mandatory field as Field is Disabled :" + fieldLabel);
			}

		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
			throw e;
		}
	}

	public void collapseViewsPan(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//*[contains(@class,'collapse-left')]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",
					waitForElementToBe(By.xpath("//*[contains(@class,'collapse-left')]/.."), "VISIBLE", driver));
		} catch (Exception e) {
			throw e;
		}
	}

	public void expandViewsPan(WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",
					waitForElementToBe(By.xpath("//*[contains(@class,'expand-right')]/.."), "VISIBLE", driver));
		} catch (Exception e) {
			throw e;
		}
	}

	public void ReadValueForButton(WebDriver driver, String label, String button) throws InterruptedException {
		Thread.sleep(200);
		String buttonValue = driver.findElement(By.xpath("//div[starts-with(@id, 'ext-conm-boolean-')]//span[text()='"
				+ label + "']//..//..//button//..//div[text()='" + button
				+ "']//ancestor::div[contains(@class, 'x-pressed')]")).getText();
		Assert.assertTrue(buttonValue.trim().equalsIgnoreCase(button.trim()), "Value is same" + button);

	}

	public void ValidationMsgDisplayedForMandtoryFields(String name) {
		try {
			String errorMsg = driver
					.findElement(By.xpath("//*[@name='" + name + "']/../../../div[2]/div[@class='x-error-message-el']"))
					.getAttribute("value");
			Assert.assertTrue(errorMsg.trim().equalsIgnoreCase("This field is required"),
					"Error message is displayed" + errorMsg);
			Log.info("Error message is displayed:" + errorMsg);
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}
	}

	public void ValidationMsgDisplayedForMandtoryDateFields(String name) {
		try {
			String errorMsg = driver
					.findElement(By.xpath("//*[@name='" + name
							+ "']/../../../../../../../../div[2]//div[contains(@class,'x-error-message-el')]"))
					.getText();
			Assert.assertTrue(errorMsg.trim().equalsIgnoreCase("This field is required"),
					"Error message is displayed" + errorMsg);
			Log.info("Error message is displayed:" + errorMsg);
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}
	}

	public void readValuesFrTextFields(String fieldLabel, String fieldName, String fieldValue) {
		try {
			WebElement elField = null;
			elField = waitForElementToBe(By.name(fieldName), "VISIBLE", getDriver());
			Assert.assertTrue(elField != null);
			String value = driver.findElement(By.name(fieldName)).getAttribute("value").trim();
			if (fieldLabel.equalsIgnoreCase("Log time")) {
				value = timeConverter(value);
				value = value.substring(0, 2);
			}
			Assert.assertTrue(fieldValue.trim().contains(value.trim()), "Value is same" + value);
			Log.info("Element is mandatory :" + fieldName);
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}
	}

	public void sensitiveEntryOnIntelligence(String label, String Value) {
		try {
			String LabelValue = driver
					.findElement(By.xpath("//td/p/span[contains(text(),'" + label + "')]/../../following-sibling::td"))
					.getText();
			Assert.assertTrue(LabelValue.trim().equalsIgnoreCase(Value.trim()),
					"Sensitive entry status is displayed" + Value);
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}

	}

	public String timeConverter(String _24HourTime) {
		SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
		SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
		Date _24HourDt = null;
		try {
			_24HourDt = _24HourSDF.parse(_24HourTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return _12HourSDF.format(_24HourDt);
	}

	public void clickOnHomeButton() {
		try {
			switch_To_Default(driver);
			WebElement homeButton = driver
					.findElement(By.xpath("//*[contains(@class,' x-btn x-fontbtn sel-fontIcon_homeMessage')]"));
			homeButton.click();
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
		}
	}

	public void setTimeAs(WebDriver driver, WebElement el, String timeValue) throws InterruptedException {
		el.clear();
		Thread.sleep(1000L);
//		el.sendKeys("a"+timeValue);
		Actions act = new Actions(driver);
		act.sendKeys(el, timeValue).build().perform();
		el.sendKeys(Keys.TAB);
	}

	/**
	 * @param fieldLabel
	 * @param fieldValue Validated message text from message notification recieved
	 *                   in Message tab
	 */
	public void validatePrePopulatedValueInMsgTab(String fieldLabel, String fieldValue) {
		try {
			if (fieldValue.equalsIgnoreCase("<blank>") || fieldValue.equalsIgnoreCase("null")) {
				fieldValue = "";
			} else {
				String msgValiation = driver
						.findElement(By.xpath("//*[contains(@id,'" + fieldLabel + "TextField-input')]"))
						.getAttribute("value");
				if (fieldValue.contains(msgValiation))
					Assert.assertTrue(true, "message found");
			}
		} catch (Exception e) {
			Log.info("Unable to perform operation");
			throw e;
		}
	}

	public void setCurrentCard(String currentCard) {
		ConnectMobilePageHelper.currentCard = currentCard;
	}

	public void clickOnCurrentUserCheckBox() {
		driver.findElement(By.name("useCurrentUserCheckbox")).click();
	}
	
	public void SelectsAllThePropertyItems(WebDriver driver) throws InterruptedException {
		Thread.sleep(500L);
		WebElement panel = driver.findElement(By.cssSelector("div[id^='ext-conm-cards-type-objectFooter']"));
		assertNotNull(panel);
		WebElement selectAllCheckBox = panel.findElement(By.xpath("//label[text()='Select all']"));
		selectAllCheckBox.click();
		Thread.sleep(500);
		WebElement updateButton=driver.findElement(By.xpath("//div[text()='Update']/../../..//button"));
		updateButton.click();
	}
	
	
	public void clickOnSaveButton(WebDriver driver) {
		WebElement btnSave = driver.findElement(By.xpath("//div[text()='Save']/../../..//button"));
		assertNotNull(btnSave);
		btnSave.click();
	}
	
	
}