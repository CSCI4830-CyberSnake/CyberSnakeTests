package test.mainpage;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMainPageCreateAccountLink {

	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
  
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", //
    		  "lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void testMainPageCreateAccountLink() throws Exception {
		driver.get("http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Log In")).click();
		assertEquals(driver.getTitle(),"Login Page");
		assertEquals(driver.getCurrentUrl(), ("http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/LoginForm.jsp"));
		Thread.sleep(2500);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }
	  }
	
	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	
	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}