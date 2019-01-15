package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RichiestaAttivitTirocinioTestAAno {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/decic/Desktop/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRichiestaAttivitTirocinioTestAAno() throws Exception {
    driver.get("http://localhost:8080/TirocinioFastLocale/index.jsp");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("mario");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Unisalerno");
    driver.findElement(By.id("loginButton")).click();
    driver.findElement(By.linkText("Ricerca azienda")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cerca azienda per nome e/o sede'])[1]/following::h3[1]")).click();
    driver.findElement(By.id("inoltraRichiestaTirocinioButton")).click();
    driver.findElement(By.name("annoAccademico")).click();
    driver.findElement(By.name("annoAccademico")).clear();
    driver.findElement(By.name("annoAccademico")).sendKeys("6");
    driver.findElement(By.id("richiestaTirocinioButton")).click();
    driver.findElement(By.linkText("Torna alla home.")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}
