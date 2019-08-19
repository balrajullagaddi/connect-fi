package com.northgateps.cm.testRunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentProperties;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.northgate.cm.utils.Constant;
import com.northgate.cm.utils.FileReaderManger;
import com.northgateps.cm.platform.api.CustomAbstractTestNGCucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@CucumberOptions(snippets = SnippetType.CAMELCASE, 
				plugin = {  
						"com.cucumber.listener.ExtentCucumberFormatter:",
						"json:target/JSON/Smoke_Test_Report.json"
						  }, 
				 glue = {
						 "com.northgateps.cm"
						}, 
				 monochrome = true, 
				 dryRun = false,
				 tags = {"@DEVINT2"},
				 features = {
						 //"resources/Features/SmokeTests/Intel_ST.feature",
						 //"resources/Features/SmokeTests/Source.feature",
						 "resources/Features/SmokeTests/Location.feature",
						//"resources/Features/SmokeTests/Incident_Location.feature",
						 //"resources/Features/SmokeTests/Vehicle.feature",
						 //"resources/Features/SmokeTests/Person.feature",
							}
				)

public class TestRunner_ST extends CustomAbstractTestNGCucumberTests {
	@BeforeClass
	public void setUp() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(Constant.REPORTPATH.replace(".html", "_ST.html"));
	}

	public void writeExtentReport() {
		FileReaderManger.getInstance();
	}
	
	@AfterSuite
	public static void generateReport() throws Exception { 
		try {
		String currentDirectory = System.getProperty("user.dir"); 
		String strFinalReport = currentDirectory + "//target//test-report//";
		String screenshotPath = "Screenshots/";
		String strJsonFile = currentDirectory + "//target//JSON//Smoke_Test_Report.json";

		//Below commented code is to get the overview of test results
//		CucumberResultsOverview results = new CucumberResultsOverview();
//		results.setOutputDirectory(strFinalReport);
//		results.setOutputName("SmokeTest");
//		results.setSourceFile(strJsonFile);
//		results.executeFeaturesOverviewReport();
		
		//Below code is to get the detailed report of tests executed
		CucumberDetailedResults results = new CucumberDetailedResults();
		results.setOutputDirectory(strFinalReport);
		results.setOutputName("SmokeTests");
		results.setSourceFile(strJsonFile);
		results.setScreenShotLocation(screenshotPath);
		results.execute(false);  // For html report
		//results.execute(true); // For pdf report
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
