package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class LoginStepDefinition  {
	public LoginStepDefinition() {
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	 @Before public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\mariode\\chromedriver.exe"); 
		  this.driver = new ChromeDriver(); this.driver.manage().window().maximize();
		 this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		 
		 }
	
	 
	/*@Before
	public void setUp_Firefox() {

		//System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		// In case of using the Firefox 53.x browsers you can explicitly set
		// "marionette" to true through DesiredCapabilities class which will
		// show the Marionette WARN logs as well e.g. WARN TLS certificate
		// errors will be ignored for this session
		
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		 dc.setCapability("marionette", true); this.driver= new
		 FirefoxDriver(dc);
		 
		this.driver = new FirefoxDriver();

		// FirefoxOptions FF_options= new FirefoxOptions();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}*/

	@After
	public void tearDown() {
		if (driver != null) {

			this.driver.quit();
		}
	}
	@Given("^User navigate to Php webpage$")
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
	
	
	

	@Then("^user click on My Account icon and select Login option$")
	public void user_click_on_My_Account_icon_and_select_Login_option() throws InterruptedException {

		WebElement invisibleElem2 = driver.findElement(By.xpath("//*[@id='li_myaccount']/ul/li[1]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", invisibleElem2);

	}

	@Then("^user enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" and click login button$")
	public void user_enter_Username_as_and_Password_as_and_click_login_button(String username, String password) throws InterruptedException {
		driver.get("http://www.phptravels.net/login");
		Thread.sleep(1 * 1000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		Thread.sleep(1 * 1000);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(1 * 1000);
		driver.findElement(By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']")).click();
		Thread.sleep(1 * 1000);

	}



	@Then("^user is on homepage$")
	public void user_is_on_homepage() {
		String Actualtitle = driver.getTitle();
		System.out.println("the website title after clicking submit button is: " + driver.getTitle());
		String expectedTitle = "Account";
		org.junit.Assert.assertEquals(expectedTitle, Actualtitle);
	

		System.out.println("Page title verified. user is able to login successfully");

			// Assert.assertEquals(driver.getTitle().contains("Account"),
		// driver.getTitle().contains("Login"));
		// Assert.assertEquals(!driver.getTitle().contains("Login"),
		// driver.getTitle().contains("Account"));

	}

	@Then("^error message is thrown$")
	public void error_message_is_thrown() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login";

		System.out.println("the website title after clicking submit button is: " + driver.getTitle());
		WebElement text = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		String errorMsg = text.getText();
		org.junit.Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(errorMsg + ": user is not able to login-Invalid Credentiels");

			// Assert.assertEquals(!driver.getTitle().contains("Account"),
		// driver.getTitle().contains("Login"));
		// Assert.assertEquals(!driver.getTitle().contains("Login"),
		// driver.getTitle().contains("Login"));

	}

}
