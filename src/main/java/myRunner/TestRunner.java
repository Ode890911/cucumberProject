package myRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/main/java/features",//path to the feature file
				glue={"stepDefinition"},//or OrangeBDDFramework.stepDefinition// path to step definition
				monochrome = true, //display the console output in a proper readable format
				tags= {"~@FunctionalTest", "@LoginFunctionality"},// used to group cucumber scenarios in the feature file
				plugin= {"pretty","html:target/cucumber", // to generate report "pretty is to format correctly
						"json:target/cucumber.json", //html and jason report in the target folder
						"com.cucumber.listener.ExtentCucumberFormatter:target/extent.html"} //extent report
			//	listener.ExtentCucumberFormatter:output/report.html
		
)
public class TestRunner {
	
	
	public static ExtentReports extent;
	public ExtentTest extentTest;
	
	
	
	
	 @BeforeTest
	    public static void teardown() {
	        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	      //  Reporter.setSystemInfo("user", System.getProperty("user.name"));
	      //  Reporter.setSystemInfo("os", "Mac OSX");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	        
	        
	        extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Mariode Window");
	extent.addSystemInfo("User Name", "mariode");
	extent.addSystemInfo("Environment", "QA");
	    }

}

