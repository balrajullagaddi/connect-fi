package com.northgateps.cm.platform.api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.testng.CucumberFeatureWrapper;
// ALL THE HOOKS FOR TESNG ARE WRITTEN HERE
// USED FOR INTEGRATION OF TESTNG AND CUCUMBER
public class CustomAbstractTestNGCucumberTests {
    private CustomTestNGCucumberRunner testNGCucumberRunner;
    
    @Parameters({ "config", "platform", "mobileOS" })
    @BeforeClass(alwaysRun = true)
    public void setUpClass(@Optional("MET") String cust, @Optional("web") String platform,
			@Optional("android") String mobileOS) throws Exception {
        testNGCucumberRunner = new CustomTestNGCucumberRunner(this.getClass(), cust, platform, mobileOS);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper} objects.
     */
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    
    
}
