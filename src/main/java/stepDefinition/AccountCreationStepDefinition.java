package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AccountCreationStepDefinition {
	
	WebDriver driver;
	
	
	  @Before public void setUpChrome() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\mariode\\chromedriver.exe"); 
		 this.driver = new  ChromeDriver(); 
		 this.driver.manage().window().maximize();
		  this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		  this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		 
		  }
	
	/*@Before
	public void setUp_Firefox() {

		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		// In case of using the Firefox 53.x browsers you can explicitly set
		// "marionette" to true through DesiredCapabilities class which will
		// show the Marionette WARN logs as well e.g. WARN TLS certificate
		// errors will be ignored for this session

		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionette", true);
		this.driver = new FirefoxDriver(dc);

		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
*/
	@After
	public void tearDown() {
		if (driver != null) {

			this.driver.quit();
		}
	}
	
	
	
	
	@Then("^user click on My Account icon and select Sign up option$")
	public void user_click_on_My_Account_icon_and_select_Sign_up_option() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement MyAcctIcon = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
		js.executeScript("arguments[0].click();", MyAcctIcon);
		Thread.sleep(1 * 1000);

		WebElement SignUpBtn = driver.findElement(By.xpath("//*[@id='li_myaccount']/ul/li[2]/a"));		
		
		//WebElement SignUpBtn = driver.findElement(By.xpath("//a[@class='go-text-right' and contains(text(), 'Sign Up')]"));

		js.executeScript("arguments[0].click();", SignUpBtn);
		
		
	}
	@Then("^User land on Registration page$")
	public void user_land_on_Registration_page(){
		String Actualtitle = driver.getTitle();
		System.out.println("the website title after clicking submit button is: " + driver.getTitle());
		String expectedTitle = "Register";
		org.junit.Assert.assertEquals(expectedTitle, Actualtitle);
		
		
	}
	
	@Then("^User enters invalid Credentials to create account$")
	public void user_enters_invalid_Credentials_to_create_account(DataTable usercredentials) throws Throwable {
		 
		//Write the code to handle Data Table
		 // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		//Converts the table to a List of Map. The top row (header) is used as keys in the maps, and the rows below are used as values
		for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data.get("First_Name"));//get the value at header or key "first name
			Thread.sleep(1 * 1000);

			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data.get("Last_Name"));
			
			
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(data.get("Mobile_Number"));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("Email"));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("Password"));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(data.get("confirm_Password"));
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button.signupbtn.btn_full.btn.btn-action.btn-block.btn-lg")).click();
			Thread.sleep(1 * 1000);
		}
	}
	
	@Then("^Account creation is not  successfull$")
	public void account_creation_is_not_successfull(){
				System.out.println("the website title after clicking contains : " +  driver.getTitle());
				String Actualtitle = driver.getTitle();			

				driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
				List<WebElement> text = driver.findElements(By.tagName("p"));			
					for (int i = 0; i < text.size(); i++) { 
						String alert = text.get(i).getText();					

							System.out.println(alert);
							String expectedTitle = "Register";
							org.junit.Assert.assertEquals(expectedTitle, Actualtitle);	
							//Assert.assertTrue(driver.getTitle().contains("Account"), 
							//(alert + " Account not created-Invalid Credentiels!") );

								
							System.out.println(alert + " Account not created-Invalid Credentiels!");
							
							
					}
				}
	
	@Then("^User enters Valid Credentials to create account$")
	public void user_enters_Valid_Credentials_to_create_account(DataTable usercredentials) throws Throwable {
		 
		//Write the code to handle Data Table
		for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data.get("First_Name"));
			Thread.sleep(1 * 1000);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data.get("Last_Name"));				
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(data.get("Mobile_Number"));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("Email"));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("Password"));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(data.get("confirm_Password"));
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button.signupbtn.btn_full.btn.btn-action.btn-block.btn-lg")).click();
			Thread.sleep(1 * 1000);
		}
	}
	
		
	
	
	@Then("^Account creation is successfull$")
	public void account_creation_is_successfull(){
		System.out.println("the website title after clicking is: " +  driver.getTitle());
		String Actualtitle = driver.getTitle();
		String expectedTitle = "My Account";

		org.junit.Assert.assertEquals(expectedTitle, Actualtitle);
		System.out.println("Sign up successfull");		
		WebElement welcomeMsg= driver.findElement(By.xpath("//h3[@class='RTL']"));
		System.out.println(welcomeMsg.getText());
		//org.junit.Assert.assertTrue(welcomeMsg.getText().contains("Hi"));	

	
			}
		
	
	
	
	

}



/*public void loginTest(List<Credentials> usercredentials) throws InterruptedException {
//Write the code to handle Data Table
		for (Credentials credentials : usercredentials) {		
			
driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(credentials.getFirst_Name());
Thread.sleep(1 * 1000);

driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(credentials.getLast_Name());


Thread.sleep(500);
driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(credentials.getMobile_Number());
Thread.sleep(500);
driver.findElement(By.xpath("//input[@name='email']")).sendKeys(credentials.getEmail());
Thread.sleep(500);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(credentials.getPassword());
Thread.sleep(500);
driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(credentials.getConfirm_Password());
Thread.sleep(500);
		}
}*/

