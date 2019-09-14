package smoke_test;

import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SmokeTest {
	public String email = "SmithViran@gmail.com";
	public String password = "P@$$word123";
	public String emailRegister = "Samkum@gmail.com";
	public String passwordRegister = "test1234";
	public String registerEmailText = "Verification code has been sent to Sa***m@gmail.com. Please enter it below.";
	public WebElement signInloginId;
	public WebElement signInPassword;
	public String expectedProfileText = "Hi Smith!";
	ChromeDriver driver;
	Actions action;

	@Before
	public void setUp() throws InterruptedException {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Rachita\\Workspace1\\Trip_uk_phase\\src\\test\\resources\\chromedriver.exe"
		 * );
		 */
		URL url = ClassLoader.getSystemResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.navigate().to("https://uk.trip.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	 @After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	// TestCase_UkTrip_02:- Register to WWW.trip.com.//input[@id='txtPassword']

	 @Test
	public void verfiyRegistrationSuccessfullTest() throws InterruptedException {

		WebElement accountButtonElement = driver
				.findElement(By.xpath(".//a[@class='mc-hd__account-btn js-hd-dropdown-cur']"));
		accountButtonElement.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='hd_menu_account']//following-sibling::a[@class='mc-hd__register']"))
				.click();
		WebElement registerText = driver.findElement(By.xpath(".//div[@class='inner']/h1[@class='tit']"));
		String actualResultRegisterText = registerText.getText();
		System.out.println(actualResultRegisterText);

		Assert.assertEquals("Register", actualResultRegisterText);

		WebElement registerEmailElement = driver.findElement(By.id("inputEmail"));
		registerEmailElement.sendKeys(emailRegister);

		WebElement registerPasswordElement = driver.findElement(By.id("inputPassword"));
		registerPasswordElement.sendKeys(passwordRegister);

		WebElement registerButton = driver.findElement(By.xpath(".//input[@id='btnSubmitSt']"));
		registerButton.click();
		Thread.sleep(3000);

		WebElement emailVerficationText = driver
				.findElement(By.xpath(".//li[@class='info-field-item']/p[@class='reset-tip']"));
		String actualResultsText = emailVerficationText.getText();
		System.out.println(actualResultsText);
		Assert.assertEquals(registerEmailText, actualResultsText);
	}

	// TestCase_UkTrip_01:- Login to Trip.com
	/*
	 * TestCase_UkTrip_01 :- Login to www.Trip.com
	 * 
	 * a. Enter url "www.Trip.uk b. Click on the account button in the header ,
	 * verify that two option "Sign-in" and "Register" is displayed. c. Click on
	 * "Sign-in" button.verify that two text fields for enterering username and
	 * password are displayed. d. Enter username and password and click on sign-in ,
	 * verify that user is successfully logged in our not.
	 */
	
	@Test
	public void verifySuccessfullSignInTest() throws InterruptedException {
		WebElement accountButtonElement = driver
				.findElement(By.xpath(".//a[@class='mc-hd__account-btn js-hd-dropdown-cur']"));
		accountButtonElement.click();
		Thread.sleep(3000);

		WebElement signIn = driver.findElement(By.id("a_login"));
		signIn.click();

		Thread.sleep(3000);

		// WebElement
		// infoField=driver.findElement(By.xpath(".//li[@class='info-field-item' and
		// @style='z-index: 3']"));
		// infoField.click();

		signInloginId = driver.findElement(By.xpath(".//li[@class='info-field-item' and @style='z-index: 3']"));
		signInloginId.click();

		WebElement dragElement = driver.findElement(By.xpath(".//span[@class='cpt-info-board']"));
		String dragText = dragElement.getText();
		if (!dragElement.isDisplayed()) {
			Thread.sleep(2000);
			WebElement singInButton = driver.findElement(By.id("btnSubmitData"));
			singInButton.click();
			WebElement loginText = driver
					.findElement(By.xpath(".//input[@class='c-ipt ipt-name ipt-error' and @id='userName']"));
			loginText.click();
			loginText.sendKeys(email);
			loginText.sendKeys(Keys.TAB);
			loginText.sendKeys(Keys.ENTER);

			Thread.sleep(2000);

			WebElement signInPassword = driver.findElement(By.xpath(".//input[@class='c-ipt ipt-pass ipt-error']"));
			signInPassword.click();

			signInPassword.sendKeys(password);

			WebElement signIn1 = driver.findElement(By.xpath(".//input[@id='btnSubmitData']"));
			signIn1.click();

			Thread.sleep(3000);

			WebElement profileName = driver.findElement(By
					.xpath(".//div[@id='hd_menu_account']//following-sibling::span[@class='mc-hd__account-username']"));

			String profileNameText = profileName.getText();
			System.out.println(profileNameText);
			Assert.assertEquals(expectedProfileText, profileNameText);
		} else {
			WebElement dragToRightElement = driver.findElement(By.xpath(".//div[@class='cpt-img-double-right-outer']"));
			String test1 = dragToRightElement.getText();
		}
	}

	/*
	 * TestCase_UkTrip_03:- Verify that on selecting "one way" option the return
	 * date textbox /field is not displayed. a. Enter url "www.Trip.uk b. Click on
	 * the Flight menue from the header, Click on the "One-Way" verify that "Return"
	 * date field is not displayed.
	 */
	@Test
	public void verifyForOneWayReturnDateOptionTest() {
		WebElement headerMenuFlight= driver.findElement(By.xpath(".//a[@id='header_action_nav_flights']"));
		headerMenuFlight.click();
		
		WebElement flightSearch=driver.findElement(By.xpath(".//h1[text()='Search Flights']"));
		String flightSearchText=flightSearch.getText();
		Assert.assertEquals("Search Flights", flightSearchText);
		
		
		WebElement returnDateElement=driver.findElement(By.xpath(".//label[text()='Return']"));
			String retrunDateLabel=returnDateElement.getText();
			
		WebElement oneWayFlightsElement=driver.findElement(By.xpath(".//div[@id='SearchBoxTabSwitch']//following-sibling::a[@class='tab']"));
		oneWayFlightsElement.click();
		
				
		Assert.assertTrue(!returnDateElement.isDisplayed());
		
	}
		

		
		
		/*TestCase_UkTrip_04:- Verify that on selecting "Return" option the return date textbox /field is displayed.
				a. Enter url "www.Trip.uk
				b. Click on the Flight menue from the header, Click on the "Return" option  verify that  "Return" date field is  displayed.	*/
	@Test
	public void verifyReturnDateOptionTest() {
		//click on Flights from the Header Menues
		WebElement headerMenuFlight= driver.findElement(By.xpath(".//a[@id='header_action_nav_flights']"));
		headerMenuFlight.click();
		
		WebElement flightSearch=driver.findElement(By.xpath(".//h1[text()='Search Flights']"));
		String flightSearchText=flightSearch.getText();
		Assert.assertEquals("Search Flights", flightSearchText);
		
		WebElement oneWayFlightsElement=driver.findElement(By.xpath(".//div[@id='SearchBoxTabSwitch']//following-sibling::a[@class='tab active']"));
		oneWayFlightsElement.click();
		
		WebElement returnDateElement1=driver.findElement(By.xpath(".//label[text()='Return']"));
		String retrunDateLabel1=returnDateElement1.getText();
		
		if (returnDateElement1.isDisplayed()) {
			System.out.println("Return date is displayed");
			
		}else {
			System.out.println("Return date is not displayed");
		}
		
		
	}
		
		
		
		
		
	}

