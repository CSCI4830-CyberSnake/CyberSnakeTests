package test.connection;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCreateAccountPageConnection {
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
  public void testCreateAccountPageConnection() throws Exception {
    driver.get("http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/CreateAccountForm.jsp");
    driver.manage().window().maximize();
    assertEquals(driver.getTitle(), "Create Account Page");
    assertEquals(driver.getCurrentUrl(),"http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/CreateAccountForm.jsp");
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