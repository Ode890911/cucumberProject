package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class Background_Steps {
	public Background_Steps() {
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	
	/*@Given("^User navigate to Php webpage$")
	public void user_Navigate_To_PhpWebpage() {
		
		driver.get("http://www.phptravels.net");

	}

	@Given("^title is php\\.com$")
	public void title_is_php_com() {
		String Actualtitle = driver.getTitle();
		System.out.println("the website title is :" + Actualtitle);
		String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
		org.junit.Assert.assertEquals(expectedTitle, Actualtitle);
	}
	
	*/

}
