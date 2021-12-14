package test.cancelregistrationpage;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCancelRegistrationPageCancelLink {
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
  public void testCancelRegistrationPageCancelLink() throws Exception {
    driver.get("http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/LoginForm.jsp");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//*[@id=\"block\"]/input")).sendKeys("testing");
    driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input")).sendKeys("password");
    driver.findElement(By.xpath("//input[@value='Log In']")).submit();
    
    driver.findElement(By.linkText("Cancel Registration")).click();
    driver.findElement(By.linkText("Cancel")).click();
    
    assertEquals(driver.getTitle(),"User Account");
	assertEquals(driver.getCurrentUrl(), ("http://elopezbanderas4830.ddns.net:8080/webproject-CyberSnake/UserAccount.jsp"));
    Thread.sleep(3000);
    
    
    
    
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