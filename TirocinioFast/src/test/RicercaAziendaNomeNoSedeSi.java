package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RicercaAziendaNomeNoSedeSi {
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
  public void testRicercaAziendaNomeNoSedeSi() throws Exception {
    driver.get("http://localhost:8080/TirocinioFastLocale/index.jsp");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("mario");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Unisalerno");
    driver.findElement(By.id("loginButton")).click();
    driver.findElement(By.linkText("Ricerca azienda")).click();
    driver.findElement(By.name("sedeAzienda")).click();
    driver.findElement(By.name("sedeAzienda")).clear();
    driver.findElement(By.name("sedeAzienda")).sendKeys("cor e mamm");
    driver.findElement(By.id("ricercaAziendaButton")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}
