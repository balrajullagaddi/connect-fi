package com.northgateps.cm.platform.api;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.testng.CucumberExceptionWrapper;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.TestNgReporter;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime. RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import gherkin.formatter.Formatter;
// CALLED FROM CUSTOMABSTRACT TESTNGCUCUMBERTESTS
public class CustomTestNGCucumberRunner {
    private Runtime runtime;
    private RuntimeOptions runtimeOptions;
    private ResourceLoader resourceLoader;
    private FeatureResultListener resultListener;
    private ClassLoader classLoader;
    private String newFeaturePath;

    /**
     * Bootstrap the cucumber runtime
     *
     * @param clazz Which has the cucumber.api.CucumberOptions and org.testng.annotations.Test annotations
     * @param mobileOS 
     * @param platform 
     */
    public CustomTestNGCucumberRunner(Class clazz, String cust, String platform, String mobileOS) {
        classLoader = clazz.getClassLoader();
        resourceLoader = new MultiLoader(classLoader);
        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
        runtimeOptions = runtimeOptionsFactory.create();
        try {
			loadConfig(cust);
			setPlatformType(platform);
			setMobileOSType(mobileOS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        newFeaturePath = updateFeaturePath(runtimeOptions.getFeaturePaths(), cust, ver);
        /*runtimeOptions.getFeaturePaths().clear();
        runtimeOptions.getFeaturePaths().add(newFeaturePath);*/
        TestNgReporter reporter = new TestNgReporter(System.out);
        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
        resultListener = new FeatureResultListener(runtimeOptions.reporter(classLoader), runtimeOptions.isStrict());
        runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
        
       
    }
    
    public void loadConfig(String cust) throws InterruptedException, Exception {
    	Utility.getConfigFileName(cust);
    	Utility.setTestEnvironment(cust);
    }
    
    public void setPlatformType(String platform) throws InterruptedException, Exception {
		Utility.setPlatformType(platform);
	}

	public void setMobileOSType(String mobileOS) throws InterruptedException, Exception {
		Utility.setMobileOSType(mobileOS);
	}
    
   
    /**
     * replace gherkin path as per version and client
     * @param oroginalFeatureList
     * @param cust
     * @param ver
     * @return
     */
    /*private String updateFeaturePath(List<String> oroginalFeatureList, String cust) {
    	String path = "";
    	path = oroginalFeatureList.get(0); 
    	path = path.replace("@", cust + "/" +  + "/");
    	return path;
    }
*/
    /**
     * Run the Cucumber features
     */
    public void runCukes() {
        for (CucumberFeature cucumberFeature : getFeatures()) {
            cucumberFeature.run(
                    runtimeOptions.formatter(classLoader),
                    resultListener,
                    runtime);
        }
        finish();
        if (!resultListener.isPassed()) {
            throw new CucumberException(resultListener.getFirstError());
        }
    }

    public void runCucumber(CucumberFeature cucumberFeature) {
        resultListener.startFeature();
        cucumberFeature.run(
                runtimeOptions.formatter(classLoader),
                resultListener,
                runtime);

        if (!resultListener.isPassed()) {
            throw new CucumberException(resultListener.getFirstError());
        }
    }

    public void finish() {
        Formatter formatter = runtimeOptions.formatter(classLoader);

        formatter.done();
        formatter.close();
        runtime.printSummary();
    }

    /**
     * @return List of detected cucumber features
     */
    public List<CucumberFeature> getFeatures() {
        return runtimeOptions.cucumberFeatures(resourceLoader);
    }

    /**
     * @return returns the cucumber features as a two dimensional array of
     * {@link CucumberFeatureWrapper} objects.
     */
    
    public Object[][] provideFeatures() {
        try {
            List<CucumberFeature> features = getFeatures();
            List<Object[]> featuresList = new ArrayList<Object[]>(features.size());
            for (CucumberFeature feature : features) {
                featuresList.add(new Object[]{new CucumberFeatureWrapperImpl(feature)});
            }
            return featuresList.toArray(new Object[][]{});
        } catch (CucumberException e) {
            return new Object[][]{new Object[]{new CucumberExceptionWrapper(e)}};
        }
    }
}
