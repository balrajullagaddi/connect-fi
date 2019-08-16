package com.northgateps.cm.platform.api;

//Common  like Click button. Actions , Add Text.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.northgateps.cm.threads.AppiumThread;
import com.northgateps.cm.threads.EmulatorThread;

//import com.northgateps.cm.threads.AppiumThread;
//import com.northgateps.cm.threads.EmulatorThread;
//import com.northgateps.cm.windowsPowerShell.AppInstaller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Utility {

	static WebDriverWait wait;
	static Properties properties;
	public static String configFileName = "";
	public static String[][] testData;
	public static String[][] testDataCards;

	public static AppiumThread aThread = null;
	public static EmulatorThread eThread = null;

	public static String platform = "";
	public static String mobileOS = "";
	public static String testEnvironment = "";
	private static Logger Log = Logger.getLogger(Utility.class.getName());

	public Utility() throws InterruptedException, Exception {
		DOMConfigurator.configure("src/main/resources/configs/log4j.xml");
	}

	public static void getConfigFileName(String Config) throws Exception {
		String jenkinsConfig = System.getProperty("jenkinsConfig");
		if (jenkinsConfig == null)
			configFileName = Config;
		else
			configFileName = jenkinsConfig;
	}

	public WebDriver getDriver() {
		return ConnectMobilePageHelper.driver;
	}

	public WebDriverWait getWait(WebDriver driver) {
		wait = new WebDriverWait(driver, 200);
		return wait;

	}

	public static Properties loadProperties() throws Exception {
		properties = getProperties();
		return properties;
	}

	public static Properties getProperties() {
		try {
			properties = new Properties();
			InputStream input = null;
			input = new FileInputStream("src/main/resources/configs/Config" + configFileName + ".properties");
			properties.load(input);
		} catch (Exception e) {
			Log.error("Unable to load Properties" + e);
		}
		return properties;
	}

	/*
	 * Purpose: Function to click on CheckBox Created Date : 18/6/2018 Inputs
	 * Parameter: Output Parameter: Written By : Manali Parab
	 */
	public void click_checkboxes(WebDriver driver, String locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		WebElement ChckElement = driver.findElement(By.xpath(locator));
		ChckElement.click();
	}

	public static void enterText(String value, String element, WebDriver driver) {
		try {
			WebElement txtBox = driver.findElement(By.name(element));
			if (txtBox.isEnabled()) {
				if (txtBox.isDisplayed()) {
					txtBox.sendKeys(value);
				}
			} else {
				// cannot enter text as textbox is disabled
			}
		} catch (Exception e) {
			// Log.error("Unable to sendkeys into TextBox", e);
			e.printStackTrace();
		}
	}

	public void clickButton(WebDriver driver, String textToCompare) {
		Actions action = new Actions(driver);
		WebElement btn = null;
		WebElement footer = null;

		try {
			Thread.sleep(2000);

			try {
				footer = driver.findElement(By.cssSelector("div[id='ext-conm-cards-type-objectFooter-1']"));
			} catch (Exception e) {
				footer = driver.findElement(By.cssSelector("div[id='ext-conm-cards-type-objectFooter-2']"));
			}

			List<WebElement> Nodes = footer.findElements(By.tagName("div"));
			for (WebElement ChildNode : Nodes) {
				if (ChildNode.getText().equalsIgnoreCase(textToCompare)) {
					btn = ChildNode;
				}
			}

			action.moveToElement(btn).click().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickRadioButton(WebDriver driver, String element, String selectedValue) {
		try {
			WebElement radioBtn = driver.findElement(By.name(element));
			if (radioBtn.isEnabled() && !radioBtn.isSelected()) {
				radioBtn.click();
			} else {
				// Radio Button is disabled so cannot click on it
			}
		} catch (Exception e) {
			// Log.error("Unable to select Radio button", e);
			e.printStackTrace();
		}
	}

	public static boolean isRadioButtonSelected(WebDriver driver, String element) {
		boolean isSelected = false;
		try {
			WebElement radioBtn = driver.findElement(By.name(element));
			if (radioBtn.isEnabled()) {
				isSelected = radioBtn.isSelected();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSelected;
	}

	public static void clickCheckBox(WebDriver driver, String element) {
		try {
			WebElement chkBox = driver.findElement(By.name(element));
			if (chkBox.isEnabled() && !chkBox.isSelected()) {
				chkBox.click();
			} else {
				// Checkbox is disabled so cannot click on it
			}
		} catch (Exception e) {
			Log.error("Unable to select checkbox", e);
		}
	}

	public static boolean isCheckboxSelected(WebDriver driver, String element) {
		boolean isSelected = false;
		try {
			WebElement checkBox = driver.findElement(By.name(element));
			if (checkBox.isEnabled()) {
				isSelected = checkBox.isSelected();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSelected;
	}

	public static void selectByVisibleText(String text, String element, WebDriver driver) {
		try {
			Select dropDown = new Select(driver.findElement(By.name(element)));
			dropDown.selectByVisibleText(text);
		} catch (Exception e) {
			// Log.error("Unable to select by visible text", e);
			e.printStackTrace();
		}
	}

	public static void selectValueDropDown(String value, String element, WebDriver driver) {
		try {
			WebElement dropDown = driver.findElement(By.name(element));
			if (dropDown.isEnabled()) {
				dropDown.sendKeys(value);
			} else {
				// drop down is disabled so cannot click on it
			}
		} catch (Exception e) {
			Log.error("Unable to select Drop down value", e);
		}
	}

	public static void selectByIndex(WebDriver driver, int index, String element) {
		try {
			WebElement selectElement = driver.findElement(By.name(element));
			if (selectElement.isEnabled()) {
				Select dropdown = new Select(selectElement);
				dropdown.deselectAll();
				dropdown.selectByIndex(index);
			} else {

			}
		} catch (Exception e) {
			Log.error("Unable to select by Index", e);
		}
	}

	public static void buttonClick(WebDriver driver, String element) {
		try {
			WebElement button = driver.findElement(By.name(element));
			if (button.isEnabled()) {
				button.click();
			} else {
				// Button is disabled so cannot click on it
			}
		} catch (Exception e) {
			Log.error("Unable to click on button " + e);
		}
	}

	public static void enterDateTime(String value, String element, WebDriver driver) {
		try {
			WebElement date = driver.findElement(By.name(element));
			if (date.isDisplayed() && date.isEnabled()) {
				date.sendKeys(value);
			} else {
				// date is disabled so cannot enter value in it
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void verifyPageTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (Exception e) {
			Log.error("Unable to verify Page Title", e);
		}
	}

	public static void checkOnPage() {
		String expectedTitle = null;
		try {
			verifyPageTitle(ConnectMobilePageHelper.driver, expectedTitle);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void verifyLabel(String expectedLabel, String actualLabel) {
		try {
			Assert.assertEquals(actualLabel, expectedLabel);
		} catch (Exception e) {
			Log.error("Unable to verify Label" + e);
		}
	}

	public static void enterTextByInstance(String value, String element, WebDriver driver, int instance) {
		/*
		 * [Mukul]:This method enables user to provide which the instance where the text
		 * can be entered in case if the same name is repeated more than once
		 */
		// Actions action = new Actions(driver);
		try {
			WebElement txtBox = driver.findElements(By.name(element)).get(instance - 1);
			if (txtBox.isEnabled()) {
				txtBox.clear();
				txtBox.sendKeys(value);
			} else {
				// cannot enter text as textbox is disabled
			}
		} catch (Exception e) {
			Log.error("Unable to verify enter Text By Instance" + e);

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

	public static String generateRandomName(int length) {
		/*
		 * Mukul:This function generates random word based on the number of characters
		 * provided by the user
		 */
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String name = "";
		Random random = new Random();
		int i = 0;
		while (i < length) {

			char temp = chars.charAt(random.nextInt(chars.length() - 1));
			name = name + temp;
			i++;
		}

		return name;
	}

	public static String generateRandomNumber(int length) {

		String chars = "1234567890";
		String name = "";
		Random random = new Random();
		int i = 0;
		while (i < length) {

			char temp = chars.charAt(random.nextInt(chars.length() - 1));
			name = name + temp;
			i++;
		}

		return name;
	}

	public void closeBrowser(WebDriver driver) {
	
		driver.close();
		driver.quit();
		
	}

	public void Select_Button(WebDriver driver, String ButtonName) throws InterruptedException {
		// This is for ANY button on screen - fixes the Java dynamic names
		Thread.sleep(5000L);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", findButton(driver, ButtonName));
		Thread.sleep(5000L);
	}

	private WebElement findButton(WebDriver driver, String nameOfButton) {
		// This is used to find the Button by Caption
		wait = new WebDriverWait(driver, 120);
		List<WebElement> buttonElements = wait
				.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName("button"))));
		for (WebElement webElement : buttonElements) {
			if (webElement.getText().trim().equalsIgnoreCase(nameOfButton)) {
				return webElement;
			}
		}
		return null;
	}

	public void DumpStackTrace(String ArchiveFilePath, String TestName, String TestEnv, Throwable ExceptionVal)
			throws IOException, Exception {
		// This function takes a screenshot on the local machine and then copies it to
		// the network folder.

		// // Grab StackTrace
		// StringWriter sw = new StringWriter();
		// ExceptionVal.printStackTrace(new PrintWriter(sw));
		// String exceptionAsString = sw.toString();

		// Create ExecutionDate is a format that can be appended to file name.
		Date TodayDate = new Date();
		String ExecutionDate = "";
		ExecutionDate = FormatDateTime(TodayDate, ExecutionDate);

		// Create New StackTrace.txt file
		FileWriter write = new FileWriter(
				ArchiveFilePath + "\\" + TestName + "_" + TestEnv + "_" + ExecutionDate + "_STACKTRACE.txt", false);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf(ExceptionVal.toString());
		print_line.close();
	}

	public String FormatDateTime(Date date, String FormatDate) {
		String DATE_FORMAT = "ddMMMyyyy_HH.mm";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return FormatDate = sdf.format(date);
	}

	public WebElement getDisplayedElement(List<WebElement> elements) {
		try {
			for (WebElement element : elements) {
				if (element.isDisplayed()) {
					return element;
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return null;
	}

	public List<WebElement> getDisplayedElements(List<WebElement> elements) {
		List<WebElement> displayedWebElements = new ArrayList<WebElement>();
		try {
			for (WebElement element : elements) {
				if (element.isDisplayed()) {
					displayedWebElements.add(element);
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return displayedWebElements;
	}

	public WebElement getClickableDiv(List<WebElement> elements) {
		try {
			for (WebElement element : elements) {
				if (element.isDisplayed() && (element.getAttribute("onclick") != null)) {
					return element;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Upasna 110218
	public WebElement waitForElementToBe(By locator, String expectedCondition, WebDriver driver) {
		By element = locator;
		try {
			getWait(driver);
			wait.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			switch (expectedCondition) {
			case ("PRESENCE"):
				wait.until(ExpectedConditions.presenceOfElementLocated(element));
				break;
			case ("CLICKABLE"):
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			case ("VISIBLE"):
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				break;
			case ("SELECTED"):
				wait.until(ExpectedConditions.elementToBeSelected(element));
				break;
			case ("INVISIBLE"):
				wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
				break;
			}

		} catch (Exception e) {
			Log.error("Error while processing request in waitForElementToBe " + e);
			return null;
		}
		return driver.findElement(element);
	}

	public List<WebElement> waitForElementToBe(By locator, String expectedCondition, WebDriver driver,
			int valueOfDuration) {
		By element = locator;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(valueOfDuration))
					.pollingEvery(Duration.ofSeconds(1));

			switch (expectedCondition) {
			case ("PRESENCE"):
				wait.until(ExpectedConditions.presenceOfElementLocated(element));
				break;
			case ("CLICKABLE"):
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			case ("VISIBLE"):
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				break;
			case ("SELECTED"):
				wait.until(ExpectedConditions.elementToBeSelected(element));
				break;
			case ("INVISIBLE"):
				wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
				break;
			}

		} catch (NoSuchElementException e) {
			return null;
		} catch (Exception e) {
			Log.error("Error while processing request in waitForElementToBe " + e);
			return null;
		}
		return driver.findElements(element);
	}

	// Upasna 110218
	public void clickElementByActionsClass(WebDriver driver, By locator) throws InterruptedException {
		Thread.sleep(500);
		WebElement el = waitForElementToBe(locator, "CLICKABLE", driver);
		// WebElement el = driver.findElement(locator);
		Actions actClick = new Actions(driver);
		actClick.click(el).build().perform();
	}

	// Upasna 110218
	public void clickElement(By locator, WebDriver driver) {
		try {
//			Thread.sleep(500);
			getWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
		} catch (Exception e) {
			Log.error("Unable to click element" + e);
			e.printStackTrace();
		}
	}

	public boolean selectDropDownByValue(By locator, String value, WebDriver driver) {
		try {
			waitForElementToBe(locator, "VISIBLE", driver);
			Select select = new Select(driver.findElement(locator));
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// Upasna 110218
	public boolean waitForElementStateToBe(By locator, String expectedCondition, WebDriver driver) {
		try {
			By element = locator;
			WebElement webElement = null;
			boolean flag = false;
			getWait(driver);
			wait.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			switch (expectedCondition) {
			case ("PRESENCE"):
				webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
				if (webElement != null)
					flag = true;
				break;
			case ("CLICKABLE"):
				webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
				if (webElement != null)
					flag = true;
				break;
			case ("VISIBLE"):
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				if (webElement != null)
					flag = true;
				break;
			case ("SELECTED"):
				flag = wait.until(ExpectedConditions.elementToBeSelected(element));
				break;
			case ("INVISIBLE"):
				flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
				break;
			}
			if (flag) {
//				Log.info("Element is :" + expectedCondition);
				return true;
			} else {
//				Log.info("Element is NOT :" + expectedCondition);
				return false;
			}
		} catch (Exception e) {
			Log.error("Error while processing request in waitForElementToBe " + e);
			return false;
		}
	}

	public boolean selectDropDownByVisibleText(By locator, String text, WebDriver driver) {
		try {
			Assert.assertTrue(waitForElementStateToBe(locator, "VISIBLE", driver),
					"Dropdown is not displayed :" + locator);
			Select select = new Select(driver.findElement(locator));
			select.selectByVisibleText(text);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void clearTextField(By locator, WebDriver driver) {
		try {
			Assert.assertTrue(waitForElementStateToBe(locator, "VISIBLE", driver),
					"Element is not displayed :" + locator);
			driver.findElement(locator).clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void readExcel(String fileName, String sheetName) throws IOException {
		String tdFileName = properties.getProperty(fileName);

		// Create an object of File class to open xlsx file
		File file = new File("src/main/resources/TestDataFiles/" + tdFileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new HSSFWorkbook(inputStream);

		// Read sheet inside the workbook by its name
		Sheet sheet = wb.getSheet(sheetName);

		// To get the last row of the sheet
		int firstRow = sheet.getFirstRowNum();
		int lstRow = sheet.getLastRowNum();
		DataFormatter formatter = new DataFormatter();
		int num = 0;
		for (num = 0; num <= lstRow; num++) {
			String val = formatter.formatCellValue(sheet.getRow(num).getCell(0));
			if (val.trim().length() == 0)
				break;
		}
		lstRow = num;

		// Find number of rows in excel file and setting up the array size
		int rowCount = lstRow - firstRow;
		testData = new String[lstRow][sheet.getRow(sheet.getFirstRowNum()).getLastCellNum()];

		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Store data in array
				if (formatter.formatCellValue(row.getCell(j)).length() != 0)
					testData[i][j] = formatter.formatCellValue(row.getCell(j)).trim();
				// System.out.print(testData[i][j] + " , ");
			}
			// System.out.println();
		}
	}

	public void readExcelCards(String fileName, String sheetName) throws IOException {
		String tdFileName = properties.getProperty(fileName);

		// Create an object of File class to open xlsx file
		File file = new File("src/main/resources/TestDataFiles/" + tdFileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new HSSFWorkbook(inputStream);

		// Read sheet inside the workbook by its name
		Sheet sheet = wb.getSheet(sheetName);

		// To get the last row of the sheet
		int firstRow = sheet.getFirstRowNum();
		int lstRow = sheet.getLastRowNum();
		int num = 0;
		for (num = 0; num <= lstRow; num++) {
			if (sheet.getRow(num).getCell(0).getStringCellValue().trim().length() == 0)
				break;
		}
		lstRow = num;

		// Find number of rows in excel file and setting up the array size
		int rowCount = lstRow - firstRow;
		testDataCards = new String[lstRow][sheet.getRow(sheet.getFirstRowNum()).getLastCellNum()];

		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Store data in array
				if (row.getCell(j).getStringCellValue().length() != 0)
					testDataCards[i][j] = row.getCell(j).getStringCellValue().trim();
				// System.out.print(testDataCards[i][j] + " , ");
			}
			// System.out.println();
		}
	}

	public void checkPageIsReady(WebDriver driver, int timeOutSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		for (int i = 0; i < timeOutSeconds; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public List<WebElement> getWebElementsList(By locator, WebDriver driver) {
		try {
			List<WebElement> weList = null;
			Boolean isDisplayed = waitForElementStateToBe(locator, "VISIBLE", driver);
			if (isDisplayed) {
				weList = driver.findElements(locator);
				return weList;
			} else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	public void clickUsingJavaScript(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element, "VISIBLE", driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFieldAttribute(By locator, WebDriver driver, String attribute) {
		try {
			Assert.assertTrue(waitForElementStateToBe(locator, "VISIBLE", driver), "Element not Visible :" + locator);
			return driver.findElement(locator).getAttribute(attribute).toString().trim();
		} catch (Exception e) {
			Log.error("Unable to verify element state :" + e.getMessage());
			return "";
		}
	}

	public AppiumDriver<MobileElement> getMobileDriver() {
		return ConnectMobilePageHelper.appiumDriver;
	}

	public AppiumDriver<WebElement> getWindowsDriver() {
		return ConnectMobilePageHelper.winDriver;
	}

	public static void setPlatformType(String strPlatform) throws Exception {
		String jenkinsPlatform = System.getProperty("jenkinsPlatform");
		if (jenkinsPlatform == null)
			platform = strPlatform;
		else
			platform = jenkinsPlatform;

		Log.info("We are running test in :" + platform);
	}

	public static void setMobileOSType(String strMobileOS) throws Exception {
		String jenkinsMobileOS = System.getProperty("jenkinsMobileOS");
		if (jenkinsMobileOS == null) {
			mobileOS = strMobileOS;
		} else {
			mobileOS = jenkinsMobileOS;
		}
		if (platform.equalsIgnoreCase("mobile"))
			startThreadsForMobile();
		Log.info("We are running test in :" + mobileOS);

	}

	private static void startThreadsForMobile() throws Exception {

		//	if (mobileOS.equalsIgnoreCase("windows")) {
		//AppInstaller.installWindowsApp();
		//} else {

			//EmulatorThread.setLocationOfSDK();
		//AppiumThread.setLocationOfNPM();

			if (mobileOS.contains("emulator")) {
				//	eThread = new EmulatorThread();
				//eThread.start();
				// sleep added to make sure that the thread does not start before starting the
				// emulator
				Thread.sleep(20000);
			}

			//aThread = new AppiumThread("0.0.0.0", "4724");
			//aThread.start();
			// sleep added to make sure that the thread does not start before starting the
			// appium
			Thread.sleep(10000);
		}

	//}

	public static void setTestEnvironment(String strTestEnvironment) throws Exception {
		testEnvironment = strTestEnvironment;
		Log.info("We are running test in :" + testEnvironment);
	}

	public String returnFieldValue(String fieldValue) throws Exception {
		try {
			switch (fieldValue) {

			case "TodayDate":
				fieldValue = DateFunctions.GetTodayDate();
				break;

			case "TDMinus1":
				fieldValue = DateFunctions.GetAdjustedDate(-1);
				break;

			case "TDMinus7":
				fieldValue = DateFunctions.GetAdjustedDate(-7);
				break;

			case "TDMinus17":
				fieldValue = DateFunctions.GetAdjustedDate(-17);
				break;

			case "TDMinus30Y":
				fieldValue = DateFunctions.GetAdjustedDate_Years(-30);
				break;

			case "TDMinus5Y":
				fieldValue = DateFunctions.GetAdjustedDate_Years(-5);
				break;

			case "TDPlus5Y":
				fieldValue = DateFunctions.GetAdjustedDate_Years(+5);
				break;

			case "TDPlus1":
				fieldValue = DateFunctions.GetAdjustedDate(+1);
				break;

			case "CurrentTime":
				fieldValue = DateFunctions.getCurrentTime();
				break;

			case "Autogenerated":
				fieldValue = Utility.generateRandomName(10);
				break;

			case "Force":
				fieldValue = properties.getProperty("Force");
				break;

			case "OtherForce":
				fieldValue = properties.getProperty("OtherForce");
				break;

			case "BCU":
				fieldValue = properties.getProperty("BCU");
				break;

			case "District":
				fieldValue = properties.getProperty("District");
				break;

			case "Ward":
				fieldValue = properties.getProperty("Ward");
				break;

			case "DefaultUser":
				fieldValue = properties.getProperty("UserID");
				break;

			case "DefaultUserName":
				fieldValue = properties.getProperty("LoggedInUserName");
				break;

			case "DefaultIntelUnit":
				fieldValue = properties.getProperty("DefaultIntelUnit");
				break;

			case "DefaultLinkingUnit":
				fieldValue = properties.getProperty("DefaultLinkingUnit");
				break;

			case "DefaultRequestUnit":
				fieldValue = properties.getProperty("DefaultRequestUnit");
				break;

			case "DefaultIMUUnit":
				fieldValue = properties.getProperty("DefaultIMUUnit");
				break;

			case "DefaultOwningUnit":
				fieldValue = properties.getProperty("DefaultOwningUnit");
				break;

			case "DefaultAssessmentUnit":
				fieldValue = properties.getProperty("DefaultAssessmentUnit");
				break;

			case "DifferentReviewUnit":
				fieldValue = properties.getProperty("DifferentReviewUnit");
				break;

			case "StaffMemberUserName":
				fieldValue = properties.getProperty("StaffMemberUserName");
				break;
			case "CaseCMTSgtUnit":
				fieldValue = properties.getProperty("CaseCMTSgtUnit");
				break;
			case "CaseSupervisoryUnit":
				fieldValue = properties.getProperty("CaseSupervisoryUnit");
				break;
			case "mobileUserName":
				fieldValue = properties.getProperty("mobileUserName");
				break;
			case "Blank":
				fieldValue = "";
				break;

			case "Supervisory Unit":
				fieldValue = properties.getProperty("DefaultIMUUnit");
				break;

			case "CMT Review Unit":
				fieldValue = properties.getProperty("DefaultCMTReviewUnit");
				break;

			case "Reviewing Unit":
				fieldValue = properties.getProperty("DefaultIMUUnit");
				break;

			case "RandomNumber":
				fieldValue = Utility.generateRandomNumber(6);
				break;
			// default:
			// System.out.println("Field Value - '"+fieldValue+"' not found in the list.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldValue;
	}

}