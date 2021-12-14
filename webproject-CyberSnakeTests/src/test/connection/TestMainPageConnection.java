package test.connection;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMainPageConnection {
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
  public void testMainPage() throws Exception {
    driver.get("http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/");
    driver.manage().window().maximize();
    //Checks that the title of the page is correct.
    assertEquals(driver.getTitle(),"Main Page");
    
    //Checks that the Url itself is correct.
    assertEquals(driver.getCurrentUrl(), "http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/");
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
}