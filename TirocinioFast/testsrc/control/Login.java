package control;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/Mario Greco/Desktop/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://www.katalon.com/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("http://localhost:8080/TirocinioFast/index.jsp");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("grecia");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("atene");
    driver.findElement(By.id("login")).submit();
  }
  
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception{
	  driver.quit();
  }
}
